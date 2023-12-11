package labs.collectionwork;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class Employee {

	public static enum Gender {
		MALE, FEMALE
	}

	public static Gender castGender(String gender) {
		switch (gender) {
		case "Male":
			return Gender.MALE;
		case "Female":
			return Gender.FEMALE;
		default:
			throw new IllegalArgumentException("Invalid string representing gender");
		}
	}
	
	public static int castId(String id) {
		if(!NumberUtils.isCreatable(id)) {
			throw new IllegalArgumentException("Invalid string representing id");
		}
		return Integer.parseInt(id);
	}
	
	public static Division castDivision(String division) {
		if(StringUtils.isNumeric(division)) {
			throw new IllegalArgumentException("Invalid string representing division");
		}
		
		Division d = new Division();
		d.setId(0);
		d.setName(division);
		return d;
	}

	public static BigDecimal castSalary(String salary) {
		if(!NumberUtils.isCreatable(salary)) {
			throw new IllegalArgumentException("Invalid string representing salary");
		}
		return NumberUtils.createBigDecimal(salary);
	}
	
	public static LocalDate castDayOfBirth(String dayOfBirth) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		LocalDate date = LocalDate.parse(dayOfBirth, formatter);
		return date;
	}
	
	public Employee() {
		super();
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

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setDayOfBirth(LocalDate dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}

	private int id;
	private String name;
	private Gender gender;
	private Division division;
	private BigDecimal salary;
	private LocalDate dayOfBirth;
}
