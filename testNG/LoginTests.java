package testng.tutorial;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTests {
	//Test cases are run in alphabetical order
	@BeforeTest //folder level :executes once before all test cases in the test folder(not the class). Not counted in total test cases executed.
	public void setup() {
		System.out.println("Initializing WebDriver and setting up test prerequisites -@BeforeTst");
	}
	
	@BeforeClass //class level: Only once per class
	public void BrowsetSetUp() {
		System.out.println("Launching browser...");
	}
	
	@BeforeMethod //Method level: Before every single test case(method) in a class
	public void loginSetup() {
		System.out.println("Opening browser and navigating to the login page.");
	}
	
	@Test(groups = "smoke")
	//(priority = 1)
	public void testValidLogin() {
		System.out.println("Validate that a registered user is able to login with correct credentials.");	
	}
	
	@Test(groups = "smoke")
	//(priority = 2)
	public void testUnregisteredUserLogin() {
			System.out.println("Validate that an unregistered user gets the correct error message when trying to login in.");
	}
	
	@Test(groups ="regeression")
	//(priority = 3)
	public void testInvalidEmailFormat() {
		System.out.println("Validate that user gets the correct error message when entering invalid email ID.");
	}
	
	@Test (groups = {"smoke", "regression"})
	//(priority = 4)
	public void testInvalidPassword() {
		System.out.println("Validate that user gets the correct error message when entering the wrong password.");
	}
	
	@Test (groups = "regression")
	//(priority = 5) 
	public void testBlankEMailPassword() {
		System.out.println("Validate that user gets the correct error message when both email and password fields are left blank.");
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Clearing session.");
	}
	
	@AfterClass
	public void BrowserTeardown() {
		System.out.println("Closing browser and ending session...");
	}
	
	@AfterSuite
	public void closeDatabaseConnection() {
		System.out.println("The Database Conection is closed.");
	}
}
