
package acme.rideshare.hr;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeCreateDto {

	public EmployeeCreateDto () {
	}
	public EmployeeCreateDto (
		String gender, 
		Integer employeeId, 
		String name, 
		Double salary, 
		Integer age, 
		String ssn) {
		this.gender = gender;
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.ssn = ssn;
	}


	private String gender;
	@JsonProperty("employee_id")
	private Integer employeeId;
	private String name;
	private Double salary;
	private Integer age;
	private String ssn;

	public String getGender() {
		return gender;
	}

	public EmployeeCreateDto setGender(String gender) {
		this.gender = gender;
		return this;
	}


	public Integer getEmployeeId() {
		return employeeId;
	}

	public EmployeeCreateDto setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
		return this;
	}


	public String getName() {
		return name;
	}

	public EmployeeCreateDto setName(String name) {
		this.name = name;
		return this;
	}


	public Double getSalary() {
		return salary;
	}

	public EmployeeCreateDto setSalary(Double salary) {
		this.salary = salary;
		return this;
	}


	public Integer getAge() {
		return age;
	}

	public EmployeeCreateDto setAge(Integer age) {
		this.age = age;
		return this;
	}


	public String getSsn() {
		return ssn;
	}

	public EmployeeCreateDto setSsn(String ssn) {
		this.ssn = ssn;
		return this;
	}


	public String toString() {
		return "EmployeeCreateDto ["
		+ " gender: " + gender
		+ " employeeId: " + employeeId
		+ " name: " + name
		+ " salary: " + salary
		+ " age: " + age
		+ " ssn: " + ssn
		+ " ]";
	}
}

