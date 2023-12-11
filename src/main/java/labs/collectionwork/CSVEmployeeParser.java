package labs.collectionwork;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

public class CSVEmployeeParser {

	public static class EmployeeCSVBuilder {
		public static enum EmployeeCSVInfo {
			ID, NAME, GENDER, BIRTHDAY, DIVISION, SALARY
		}

		public static int employeeInfoAmount = 6;

		// id;name;gender;BirtDate;Division;Salary
		// TODO: test!
		public static EmployeeCSVInfo buildInfo(String info) {
			switch (info) {
			case "id":
				return EmployeeCSVInfo.ID;
			case "name":
				return EmployeeCSVInfo.NAME;
			case "gender":
				return EmployeeCSVInfo.GENDER;
			case "BirtDate":
				return EmployeeCSVInfo.BIRTHDAY;
			case "Division":
				return EmployeeCSVInfo.DIVISION;
			case "Salary":
				return EmployeeCSVInfo.SALARY;
			default:
				return null;
			}
		}

		public EmployeeCSVBuilder(String[] info) {
			super();
			if (info.length != employeeInfoAmount) {
				throw new IllegalArgumentException("Incorrent amount of csv employee information");
			}
			for (int i = 0; i < order.length; i++) {
				order[i] = buildInfo(info[i]);
			}
			currentInfo = 0;
		}

		public Employee build(String[] info) {
			Employee emp = new Employee();
			for (String currentInfo : info) {
				setNextProperty(emp, currentInfo);
			}
			return emp;
		}

		public boolean hasNextProperty() {
			return currentInfo < order.length;
		}

		// should check currentInfo
		private void setNextProperty(Employee employee, String property) {
			if (currentInfo >= order.length) {
				throw new IndexOutOfBoundsException();
			}

			switch (order[currentInfo]) {
			case ID:
				employee.setId(Employee.castId(property));
				break;
			case BIRTHDAY:
				employee.setDayOfBirth(Employee.castDayOfBirth(property));
				break;
			case DIVISION:
				employee.setDivision(Employee.castDivision(property));
				break;
			case GENDER:
				employee.setGender(Employee.castGender(property));
				break;
			case NAME:
				employee.setName(property);
				break;
			case SALARY:
				employee.setSalary(Employee.castSalary(property));
				break;
			}
			currentInfo++;
		}

		private EmployeeCSVInfo[] order = new EmployeeCSVInfo[employeeInfoAmount];
		private int currentInfo = -1;
	}

	public CSVEmployeeParser(String filePath) throws FileNotFoundException {
		super();
		reader = new CSVReaderBuilder(new FileReader(filePath))
				.withCSVParser(new CSVParserBuilder().withSeparator(separator).build()).build();
		// TODO: check if null
		try {
			csvBuilder = new EmployeeCSVBuilder(reader.readNext());
		} catch (CsvValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Employee> getEmployees() throws CsvValidationException, IOException {
		Employee emp;
		List<Employee> list = new LinkedList<>();
		while ((emp = readNext()) != null) {
			list.add(emp);
		}
		return list;
	}

	private Employee readNext() throws CsvValidationException, IOException {
		String[] nextLine = reader.readNext();
		if (nextLine == null) {
			return null;
		}
		return csvBuilder.build(nextLine);
	}

	private final char separator = ';';
	private CSVReader reader;
	private EmployeeCSVBuilder csvBuilder;
}
