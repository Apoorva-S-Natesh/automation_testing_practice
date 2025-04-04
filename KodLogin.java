package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KodLogin {

	public static void main(String[] args) {


				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://app.kodnest.in/login");
				
				//driver.findElement(By.id("email-input")).sendKeys("apoorva1326@gmail.com"); //directly using interaction without storing the element
				WebElement emailField = driver.findElement(By.id("email-input"));
				emailField.sendKeys("apoorva@gmail.com");
				//driver.findElement(By.name("password"));
				WebElement passwordField = driver.findElement(By.name("password"));
				passwordField.sendKeys("1234");
				WebElement loginButton = driver.findElement(By.id("login-submit-button"));
				loginButton.click();
				
				/*
				driver.findElement(By.name(null));
				driver.findElements(By.className(null));
				driver.findElement(By.linkText(null));
				driver.findElement(By.partialLinkText(null));
				driver.findElement(By.xpath(null));
				driver.findElement(By.cssSelector(null));
				driver.findElement(By.tagName(null));
				*/

	}
}
