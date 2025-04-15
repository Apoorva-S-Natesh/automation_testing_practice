package actionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassActions {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com");
		Thread.sleep(4000);
		
		WebElement contactUs = driver.findElement(By.xpath("//*[@id=\"post-34707\"]/div/div[4]/div/div/div/div/div/div/div/div/a"));
		
		Actions action = new Actions(driver);
		// scrolls down to this element and performs the action, opens in the same window
		//action.moveToElement(contactUs).click().build().perform();
		
		//To scroll down and open the window in a new tab - ctrl + click
		action.moveToElement(contactUs).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
	}
}
