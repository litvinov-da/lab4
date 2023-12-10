package labs.collectionwork.unitTests;

import static org.junit.Assert.assertThrows;

import org.junit.Test;

import junit.framework.Assert;
import labs.collectionwork.Employee;

public class EmployeeGenderTests {

	@Test
	public void getGender_maleString_returnMale() {
		boolean returnMale = Employee.buildGender("Male") == Employee.Gender.MALE;
		Assert.assertTrue(returnMale);
	}

	@Test
	public void getGender_femaleString_returnFemale() {
		boolean returnFemale = Employee.buildGender("Female") == Employee.Gender.FEMALE;
		Assert.assertTrue(returnFemale);
	}

	@Test
	public void getGender_invalidString_IllegalArgumentExceptionThrown() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			Employee.buildGender("InvalidString");
		});
		Assert.assertEquals("Invalid string representing gender", exception.getMessage());
	}
}
