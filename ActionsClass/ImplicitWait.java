package browser_automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/*Implicit wait is a mechanism that instructs the WedDriver to wait for a certain 
 * amount of time trying to locate an element before throwing a NoSuchElementException
 * It does not wait for visibility or interactability of an element - only for its presence in the DOM
 * 
 * Implicit wait is useful only for waiting for elements to be present in the DOM, 
 * but does not handle visibility or interactability issues.
 * */

public class ImplicitWait {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); // org.openqa.selenium.ElementNotInteractableException
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		driver.findElement(By.xpath("//button[text()='Start']")).click(); //Find element checks the presence in the DOM (not visibility)
		//Thread.sleep(3000);
		
		WebElement helloText = driver.findElement(By.xpath("//div[@id = 'finish']/h4"));
		//helloText.click(); //checks the visibility of the element
		System.out.println("Text after waiting implicitly: " + helloText.getText()); //Implicit wait does not apply to getText() because it only waits for element presence, not visibility.
		helloText.click(); //checks the visibility of the element
		//If click is before getText,can get text, if click is after getText then does get the text with less waiting period.
		driver.quit();
	}

}
