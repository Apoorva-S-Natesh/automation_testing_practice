package testng.tutorial;

import org.testng.annotations.Test;

public class LoginTests {
	//Test cases are run in alphabetical order
	
	@Test(priority = 1)
	public void testValidLogin() {
		System.out.println("Validate that a registered user is able to login with correct credentials.");	
	}
	
	@Test(priority = 2)
	public void testUnregisteredUserLogin() {
			System.out.println("Validate that an unregistered user gets the correct error message when trying to login in.");
	}
	
	@Test(priority = 3)
	public void testInvalidEmailFormat() {
		System.out.println("Validate that user gets the correct error message when entering invalid email ID.");
	}
	
	@Test(priority = 4)
	public void testInvalidPassword() {
		System.out.println("Validate that user gets the correct error message when entering the wrong password.");
	}
	
	@Test(priority = 5)
	public void testBlankEMailPassword() {
		System.out.println("Validate that user gets the correct error message when both email and password fields are left blank.");
	}
}