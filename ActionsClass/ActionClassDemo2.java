package actionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassDemo2 {

	public static void main(String[] args) throws Exception{
		
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.kodnest.com");
		Thread.sleep(4000);
		
		WebElement youtubeLink = driver.findElement(By.xpath("//a[@href='https://www.youtube.com/c/KodNest']"));
		WebElement githubLink = driver.findElement(By.xpath("//a[@aria-label='pixicon-github2']"));
		WebElement instagramLink = driver.findElement(By.xpath("//a[@aria-label='pixicon-instagram2']"));
		WebElement facebookLink = driver.findElement(By.xpath("//a[@aria-label='pixicon-facebook2']"));
		
		Actions action = new Actions(driver);
		// scrolls down to this element and performs the action, opens in the same window
		//action.moveToElement(contactUs).click().build().perform();
		
		//To scroll down and open the window in a new tab - ctrl + click
		action.moveToElement(youtubeLink).keyDown(Keys.CONTROL).click()
		.moveToElement(githubLink).click()
		.moveToElement(instagramLink).click()
		.moveToElement(facebookLink).click()
		.keyUp(Keys.CONTROL)
		.build().perform();
		
		Thread.sleep(3000);
		driver.quit();
	}
}
