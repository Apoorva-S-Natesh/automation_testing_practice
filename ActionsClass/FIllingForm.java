package actionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FIllingForm {

	public static void main(String[] args) {
		
		// Setting up webDriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.kodnest.com/");
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		// Initialize Action class
		Actions actions = new Actions(driver);

		//Locate the Name field and store it in a variable
		WebElement namefield = driver.findElement(By.id("form-field-name"));
		
		//Perform actions to fill the form ste-by-step
		actions.click(namefield)
			.sendKeys("Aoorva")
			.sendKeys(Keys.TAB) // Move to Email Field
			.sendKeys("apoorva1326@gmail.com")
			.sendKeys(Keys.TAB) // Move to Phone Number Field
			.sendKeys("0000000090")
			.sendKeys(Keys.TAB) // Move to Graduation Year Dropdown
			.sendKeys(Keys.ENTER) // Open Dropdown
			.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN) // Move down 2 times to select 2024
			.sendKeys(Keys.ENTER) // Select the option
			.sendKeys(Keys.TAB) // Move to Language dropdown
			.sendKeys(Keys.ENTER) // Open dropdown
			.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN)
			.sendKeys(Keys.ENTER)
			.sendKeys(Keys.TAB) // Move to Referral code field
			.sendKeys("KOD1002")
			.sendKeys(Keys.TAB) // Move to Career Preference section
			.sendKeys(Keys.RIGHT) // Move selection to 'Testing'
			.sendKeys(Keys.TAB) // MOve to Register now button
			.sendKeys(Keys.ENTER) // Submit the form
			.build()
			.perform();
		
		
		try {
			Thread.sleep(4000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}
}
