package locator;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleTabsHanding2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.globalsqa.com");
			Thread.sleep(4000);
			
			driver.findElement(By.className("header_soc_pinterest")).click();
			System.out.println(driver.getWindowHandles());
			Thread.sleep(2000);
			
			driver.findElement(By.className("header_soc_linkedin")).click();
			System.out.println(driver.getWindowHandles());
			Thread.sleep(2000);
			
			driver.findElement(By.className("header_soc_google")).click();
			System.out.println(driver.getWindowHandles());
			Thread.sleep(2000);
			
			driver.findElement(By.className("header_soc_facebook")).click();
			System.out.println(driver.getWindowHandles());
			Thread.sleep(2000);
			
			driver.findElement(By.className("header_soc_twitter")).click();
			System.out.println(driver.getWindowHandles());
			Thread.sleep(2000);
			
			//Get all window handles
			Set<String> currentHandles = driver.getWindowHandles();
			System.out.println(currentHandles);
			
			for(String handle:currentHandles) {
				System.out.println(handle);
				driver.switchTo().window(handle);
				System.out.println(driver.getTitle());
			}
			
			driver.quit();
	}
}
