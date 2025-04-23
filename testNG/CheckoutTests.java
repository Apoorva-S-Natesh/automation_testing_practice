package testng.tutorial;

import org.testng.annotations.Test;

public class CheckoutTests {
	@Test(priority = 1)
	public void testCheckoutWithCreditCard() {
		System.out.println("Validate that a user is able to succesfully complete checkout using a credit card.");	
	}
	
	@Test(priority = 2)
	public void testcheckoutWithUPI() {
			System.out.println("Validate that a user is able to succesfully complete checkout using UPI.");
	}
	
	@Test(priority = 3)
	public void testcheckoutWithCashOnDElivery() {
		System.out.println("Validate that a user is able to select 'Cash on Delivery' as a payment option.");
	}
	
	@Test(priority = 4)
	public void testcheckoutWithExpiredCard() {
		System.out.println("Validate that the system correctly displays an error message when an expired card is used for checkout.");
	}
	
	@Test(priority = 5)
	public void testApplyingDiscountCode() {
		System.out.println("Validate that the user can successfully apply a avalid discount code at checkout");
	}
}
