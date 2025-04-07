package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelectors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get(" https://app.kodnest.in/login");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		
		//locating email address field using CSS Selector from https://app.kodnest.in/login
		//using id attribute available : input[id='email-input']
		WebElement emailLink= driver.findElement(By.cssSelector("input[id='email-input']"));
		emailLink.sendKeys("apoorva1326@gmail.com");
		
//		//using name attribute : input[name='email']
//		WebElement emailLink1= driver.findElement(By.cssSelector("input[name='email']"));
//		emailLink1.sendKeys("apoorva1326@gmail.com");
//		
//		//using placeholder attribute : input[placeholder='your-email@gmail.com']
//		WebElement emailLink2= driver.findElement(By.cssSelector("input[placeholder='your-email@gmail.com']"));
//		emailLink2.sendKeys("apoorva1326@gmail.com");
		
	}
}
