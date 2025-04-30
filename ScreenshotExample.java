package locator;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotExample {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		try {
			//Creating a TakesScreenshot Object
			TakesScreenshot ts = (TakesScreenshot) driver;
			//Typecasting WebDriver instance to TakesScreenshot so that it can take screenshot.
			//WEbdriver alone does not have a built-in method to capture screenshots
			
			//Capturing and storing the screenshot temporarily
			File sourceFile = ts.getScreenshotAs(OutputType.FILE); //sourceFile temporarily holds the screenshot
			//stores it as a file in memory
			
			//In downloads create a folder to store Screenshot
			//Saving the screenshot to a File
			File destinationFile = new File("C:\\Users\\dell\\Downloads\\SeleniumScreenshots\\googleScreenshot.png");
			
			//Copying the Screenshot to the folder
			//Add dependency - Apache Commons IO either in pom.xml for maven or add jar by build path
			FileUtils.copyFile(sourceFile, destinationFile);
			
			System.out.println("Screenshot saved successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		driver.quit();
	}
}
