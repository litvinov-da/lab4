package labs.collectionwork.unitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.Test.None;

import labs.collectionwork.CSVEmployeeParser;
import labs.collectionwork.CSVEmployeeParser.EmployeeCSVBuilder;
import labs.collectionwork.Employee;

public class EmployeeCSVBuilderTests {
	
	@Before
	public void initializeValidInformation() {
		csvInformation[0] = "id";
		csvInformation[1] = "name";
		csvInformation[2] = "gender";
		csvInformation[3] = "BirtDate";
		csvInformation[4] = "Division";
		csvInformation[5] = "Salary";
		
		// should be in the same order as csvInformation!
		propertyInformation[0] = "2241";
		propertyInformation[1] = "Danya";
		propertyInformation[2] = "Male";
		propertyInformation[3] = "20.03.2003";
		propertyInformation[4] = "A";
		propertyInformation[5] = "200000";
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructor_invalidAmountOfArguments_IllegalArgumentExceptionThrown() {
		String[] invalidArgument = new String[7];
		new CSVEmployeeParser.EmployeeCSVBuilder(invalidArgument);
	}
	
	@Test
	public void constructor_whenCalled_hasNextProperty() {
		assertTrue(new EmployeeCSVBuilder(csvInformation).hasNextProperty());
	}
	
	@Test
	public void build_whenCalled_hasNoNextProperty() {
		EmployeeCSVBuilder builder = new EmployeeCSVBuilder(csvInformation);
		builder.build(propertyInformation);
		assertFalse(builder.hasNextProperty());
	}
	
	@Test(expected = None.class)
	public void constructor_differentOrderOfCsvInfo_normalExecution() {
		csvInformation[0] = "gender";
		csvInformation[1] = "id";
		csvInformation[2] = "BirtDate";
		csvInformation[3] = "name";
		csvInformation[4] = "Salary";
		csvInformation[5] = "Division";
		
		new EmployeeCSVBuilder(csvInformation);
	}
	
	@Test
	public void build_differentOrderOfInformation_validEmployee() {
		csvInformation[0] = "gender";
		csvInformation[1] = "id";
		csvInformation[2] = "BirtDate";
		csvInformation[3] = "name";
		csvInformation[4] = "Salary";
		csvInformation[5] = "Division";
		
		// should be in the same order as csvInformation!
		propertyInformation[0] = "Male";
		propertyInformation[1] = "2241";
		propertyInformation[2] = "20.03.2003";
		propertyInformation[3] = "Danya";
		propertyInformation[4] = "200000";
		propertyInformation[5] = "A";
		
		EmployeeCSVBuilder builder = new EmployeeCSVBuilder(csvInformation);
		Employee employee = builder.build(propertyInformation);
		
		assertEquals(employee.getGender(), Employee.castGender(propertyInformation[0]));
		assertEquals(employee.getId(), Employee.castId(propertyInformation[1]));
		assertEquals(employee.getDayOfBirth(), Employee.castDayOfBirth(propertyInformation[2]));
		assertEquals(employee.getName(), propertyInformation[3]);
		assertEquals(employee.getSalary(), Employee.castSalary(propertyInformation[4]));
		assertEquals(employee.getDivision().getName(), propertyInformation[5]);
	}
	
	String[] csvInformation = new String[EmployeeCSVBuilder.employeeInfoAmount];
	String[] propertyInformation = new String[EmployeeCSVBuilder.employeeInfoAmount];
}
