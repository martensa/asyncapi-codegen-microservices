package acme.rideshare.hr;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.core.VaultTransitOperations;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;
import java.util.function.Supplier;


@SpringBootApplication
public class TransitConverterApplication {

	private static final Logger logger = LoggerFactory.getLogger(TransitConverterApplication.class);

	private static BlockingQueue<EmployeeCreateDto> queue = new LinkedBlockingQueue<EmployeeCreateDto>();

	@Autowired
	private VaultTemplate vaultTemplate;

	@Autowired
	private ModelMapper modelMapper;

	public static void main(String[] args) {
		SpringApplication.run(TransitConverterApplication.class);
	}

	@Bean
	public Consumer<EmployeeCreate> acmeRideshareHrEmployeeCreatedConsumer() {
		return EmployeeCreate -> {
			logger.info("EmployeeCreate event received: " + EmployeeCreate);

			//Calculate age from birth date
			LocalDate currentDate = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
			LocalDate birthDate = LocalDate.parse(EmployeeCreate.getBirthDate(), formatter);
			EmployeeCreate.setAge(Period.between(birthDate, currentDate).getYears());

			//Convert EmployeeCreate event to EmployeeCreateDto event
			EmployeeCreateDto employeeCreateDto = modelMapper.map(EmployeeCreate, EmployeeCreateDto.class);

			//Encrpyt name and ssn using transit secrets engine from HashiCorp Vault
			VaultTransitOperations vaultTransitOperations = vaultTemplate.opsForTransit();
			employeeCreateDto.setName(vaultTransitOperations.encrypt("employee", employeeCreateDto.getName()));
			employeeCreateDto.setSsn(vaultTransitOperations.encrypt("employee", employeeCreateDto.getSsn()));

			//Add final event to queue for publishing
			queue.add(employeeCreateDto);
		};
	}

	@Bean
	public Supplier<EmployeeCreateDto> acmeRideshareHrEmployeeCreatedDtoSupplier() {
		return () -> {
			EmployeeCreateDto employeeCreateDto = queue.poll();
			logger.info("EmployeeCreate event to send: " + employeeCreateDto);
			return employeeCreateDto;
		};
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}