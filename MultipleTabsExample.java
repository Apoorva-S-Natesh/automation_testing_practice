package locator;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleTabsExample {

	public static void main(String[] args) throws InterruptedException{

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com");
		Thread.sleep(5000);
		
		//Locating hyperlink and clicking on each
		WebElement pinterestLink = driver.findElement(By.linkText("pinterest"));
		WebElement twitterLink = driver.findElement(By.linkText("twitter"));
		WebElement linkedinLink = driver.findElement(By.linkText("linkedin"));
		WebElement googleLink = driver.findElement(By.linkText("google"));
		WebElement facebookLink = driver.findElement(By.linkText("facebook"));
	
		//print and click on each link
		System.out.println("Hyperlink Text: " + pinterestLink.getText());
		pinterestLink.click();
		Thread.sleep(1000);
		
		System.out.println("Hyperlin Text: " + twitterLink.getText());
		twitterLink.click();
		Thread.sleep(1000);
		
		System.out.println("Hyperlin Text: " + linkedinLink.getText());
		linkedinLink.click();
		Thread.sleep(1000);
		
		System.out.println("Hyperlin Text: " + googleLink.getText());
		googleLink.click();
		Thread.sleep(1000);
		
		System.out.println("Hyperlin Text: " + facebookLink.getText());
		facebookLink.click();
		Thread.sleep(1000);
		
		//Retrieving and printing all window handles
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("Number of Open Windows/Tabs " +allWindowHandles.size());
		System.out.println("All WIndow Handles: " + allWindowHandles);
		
		driver.quit();
	}
}
