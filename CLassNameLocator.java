package locator;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CLassNameLocator {

	public static void main(String[] args) throws InterruptedException{

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		
		//locate and click on each hyperlink using className locator
		WebElement pinterestLink = driver.findElement(By.className("header_soc_pinterest"));
		WebElement twitterLink = driver.findElement(By.className("header_soc_twitter"));
		WebElement linkedinLink = driver.findElement(By.className("header_soc_linkedin"));
		WebElement facebookLink = driver.findElement(By.className("header_soc_google"));
		WebElement googlePlusLink = driver.findElement(By.className("header_soc_facebook"));
		
		//click on each link
		pinterestLink.click();
		twitterLink.click();
		linkedinLink.click();
		googlePlusLink.click();
		facebookLink.click();
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("Number of Open Windows/Tabs " +allWindowHandles.size());
		System.out.println("All WIndow Handles: " + allWindowHandles);

		driver.quit();
	}

}
