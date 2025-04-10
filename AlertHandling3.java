package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling3 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
		driver.manage().window().maximize();
		Thread.sleep(5000); //Pause to load the page and click consent
		
		//click on "clickme" button for the alert box
		driver.findElement(By.id("promptBox")).click();
		Thread.sleep(2000);
		
		//Switch to the alert and accept it
		Alert promptBox = driver.switchTo().alert();
		Thread.sleep(2000);
		promptBox.sendKeys("Apoo");
		Thread.sleep(2000);
		promptBox.accept(); //Clicks OK
		//promptBox.dismiss(); // Clicks cancel
		//close the browser
		driver.quit();
	}
}
