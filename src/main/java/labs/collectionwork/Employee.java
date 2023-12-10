package labs.collectionwork;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {

	public static enum Gender {
		MALE, FEMALE
	}

	public static Gender getGender(String string) {
		switch (string) {
		case "Male":
			return Gender.MALE;
		case "Female":
			return Gender.FEMALE;
		default:
			throw new IllegalArgumentException("Invalid string representing gender");
		}
	}

	public Employee(int id, String name, Gender gender, Division division, BigDecimal salary, LocalDate dayOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.division = division;
		this.salary = salary;
		this.dayOfBirth = dayOfBirth;
	}

	public Employee(int id, String name, Gender gender, LocalDate dayOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dayOfBirth = dayOfBirth;
	}

	public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Gender getGender() {
		return gender;
	}

	public LocalDate getDayOfBirth() {
		return dayOfBirth;
	}

	private final int id;
	private final String name;
	private final Gender gender;
	private Division division;
	private BigDecimal salary;
	private final LocalDate dayOfBirth;
}
