package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollExample {
	public static void main(String[] args) throws InterruptedException {		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.kodnest.com/");
		
		//Find the target element
		WebElement youtubeLink = driver.findElement(By.xpath("//a[@href = 'https://www.youtube.com/c/KodNest']"));
		
		//Cast WebDriver to JavaScriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//Scrolling until element is visible
		
		// arguments[0] - represents target element
		//js.executeScript("arguments[0].scrollIntoView(true);", youtubeLink);
		//Thread.sleep(2000); // Cannot click while scrolling
		//youtubeLink.click();
		
		//can add click() to the js script itself, without scrolling
		js.executeScript("arguments[0].click();", youtubeLink);

		//Confirm scrolling
		System.out.println("Scrolled to element: " + youtubeLink.isDisplayed());
	}
}
