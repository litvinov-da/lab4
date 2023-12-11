package labs.collectionwork.unitTests;

import org.junit.Test;

import junit.framework.Assert;
import labs.collectionwork.Employee;

public class EmployeeGenderTests {

	@Test
	public void castGender_maleString_returnMale() {
		boolean returnMale = Employee.castGender("Male") == Employee.Gender.MALE;
		Assert.assertTrue(returnMale);
	}

	@Test
	public void castGender_femaleString_returnFemale() {
		boolean returnFemale = Employee.castGender("Female") == Employee.Gender.FEMALE;
		Assert.assertTrue(returnFemale);
	}

	@Test(expected = IllegalArgumentException.class)
	public void castGender_invalidString_IllegalArgumentExceptionThrown() {
		Employee.castGender("InvalidString");
	}
}
