package browser_automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getTitle());
		driver.manage().window().minimize();
		System.out.println(driver.getPageSource());
		System.out.println("Window Size: " +driver.manage().window().getSize());
		//driver.close(); // Closes only the current tab, not the whole window or session
		driver.quit(); //-close all browser windows and terminates webDriver Session
		}
}
