package browser_automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserNavigation {
	public static void main(String[] args) throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		Thread.sleep(3000); //try catch or throws InterruptedException for the method
		driver.get("https://www.amazon.com/");
		System.out.println(driver.getTitle());
		driver.navigate().back();
		try {
			Thread.sleep(3000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		driver.navigate().refresh();
		try {
			Thread.sleep(3000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}