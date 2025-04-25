package testng.tutorial;

import org.testng.annotations.Test;

public class CartTests {
	@Test(priority = 1) // Specify the order of execution with priority
	public void testIncreaseProductquantity() {
		System.out.println("Validate that a registered user is able to increase the quantity of a product in the cart.");	
	}
	
	@Test(dependsOnMethods = "testIncreaseProductquantity")
	public void testDecreaseProductquantity() {
			System.out.println("Validate that a registered user is able to decrease the quantity of a product in the cart.");
	}
	
	@Test(dependsOnMethods = {"testIncreaseProductquantity", "testDecreaseProductquantity()"})
	public void testRemoveProductfromCart() {
		System.out.println("Validate that user gets is able to remove a product from the cart");
	}
	
	@Test(priority = 4)
	public void testCartRetainsProductsAfterLogout() {
		System.out.println("Validate that cart retains products even after the user logs out and logs in again.");
	}
	@Test(priority = 5)
	public void testCartDisplaysCorrectTotalAmount() {
		System.out.println("Validate that cart correctly displays the total amount for all added products.");
	}
	
	
}
