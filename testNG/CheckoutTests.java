package testng.tutorial;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CheckoutTests {
	
	@BeforeSuite
	public void setupSuite() {
		System.out.println("Setting up the test suite: Initializing shared resources.");
	}
	
	@Test (groups = "smoke")
	//(priority = 1)
	public void testCheckoutWithCreditCard() {
		System.out.println("Validate that a user is able to succesfully complete checkout using a credit card.");	
	}
	
	@Test(groups = "regression")
	//(priority = 2)
	public void testcheckoutWithUPI() {
			System.out.println("Validate that a user is able to succesfully complete checkout using UPI.");
	}
	
	@Test (groups = "smoke")
	//(priority = 3)
	public void testcheckoutWithCashOnDElivery() {
		System.out.println("Validate that a user is able to select 'Cash on Delivery' as a payment option.");
	}
	
	@Test
	//(priority = 4)
	public void testcheckoutWithExpiredCard() {
		System.out.println("Validate that the system correctly displays an error message when an expired card is used for checkout.");
	}
	
	@Test
	//(priority = 5)
	public void testApplyingDiscountCode() {
		System.out.println("Validate that the user can successfully apply a avalid discount code at checkout");
	}
	
	// runs once after all the test cases in the test folder, not counted as a test case. Cannot have priority
	@AfterTest
	public void cleanup() {
		System.out.println("Logging out user and closing browser session -@AfterTest");
	}
}
