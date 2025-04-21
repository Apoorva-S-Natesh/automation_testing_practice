package browser_automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/*
 * Explicit wait allows to specify certain conditions before interacting with an element. 
 * It checks for a particular state of an element rather than just its presence in the DOM.
 * 
 * Explicit wait can be used with different conditions.
 * 1. PresenceOfElementLocated
 * 2. VisibilityOfELementLocated
 * 3. elementToBeClickable  - waits until the element is both visible and interactable
 * */

public class ExplicitWait {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		driver.findElement(By.xpath("//button[text()='Start']")).click(); //Find element checks the presence in the DOM (not visibility)
		//Thread.sleep(3000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//WebElement helloText = driver.findElement(By.xpath("//div[@id = 'finish']/h4"));
		//System.out.println("Welcome text after 3 seconds: " +helloText.getText()); //No text will be displayed, since text took 6 seconds to load.
		
		//Using explicit wait
//		WebElement helloText = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));
//		System.out.println("Text after waiting explicitly: " + helloText.getText()); //returns empty string. The element was present so selenium didnt wait, so getText returns empty
		
		WebElement helloText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
		System.out.println("Text after waiting explicitly: " + helloText.getText()); //returns Hello text since the wait was for visibility ,so after 5 secs element is visible and hence getText can get text
		
		driver.quit();
	}

}
