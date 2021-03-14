
package acme.rideshare.hr;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeCreate {

	public EmployeeCreate () {
	}
	public EmployeeCreate (
		String gender, 
		Integer employeeId, 
		String name, 
		Double salary, 
		String birthDate, 
		Integer age, 
		String ssn) {
		this.gender = gender;
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
		this.birthDate = birthDate;
		this.age = age;
		this.ssn = ssn;
	}


	private String gender;
	@JsonProperty("employee_id")
	private Integer employeeId;
	private String name;
	private Double salary;
	private String birthDate;
	private Integer age;
	private String ssn;

	public String getGender() {
		return gender;
	}

	public EmployeeCreate setGender(String gender) {
		this.gender = gender;
		return this;
	}


	public Integer getEmployeeId() {
		return employeeId;
	}

	public EmployeeCreate setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
		return this;
	}


	public String getName() {
		return name;
	}

	public EmployeeCreate setName(String name) {
		this.name = name;
		return this;
	}


	public Double getSalary() {
		return salary;
	}

	public EmployeeCreate setSalary(Double salary) {
		this.salary = salary;
		return this;
	}


	public String getBirthDate() {
		return birthDate;
	}

	public EmployeeCreate setBirthDate(String birthDate) {
		this.birthDate = birthDate;
		return this;
	}


	public Integer getAge() {
		return age;
	}

	public EmployeeCreate setAge(Integer age) {
		this.age = age;
		return this;
	}


	public String getSsn() {
		return ssn;
	}

	public EmployeeCreate setSsn(String ssn) {
		this.ssn = ssn;
		return this;
	}


	public String toString() {
		return "EmployeeCreate ["
		+ " gender: " + gender
		+ " employeeId: " + employeeId
		+ " name: " + name
		+ " salary: " + salary
		+ " birthDate: " + birthDate
		+ " age: " + age
		+ " ssn: " + ssn
		+ " ]";
	}
}

