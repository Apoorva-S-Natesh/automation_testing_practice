package dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HyrStaticDropdown {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		WebElement courseDropdown = driver.findElement(By.id("course"));
		Select selectObject = new Select(courseDropdown);
		
		selectObject.selectByIndex(2);
		String selectedOption1 = selectObject.getFirstSelectedOption().getText();
		System.out.println("Selected Option by Index: " +selectedOption1);
		Thread.sleep(3000);
		
		selectObject.selectByValue("java");
		String selectedOption2 = selectObject.getFirstSelectedOption().getText();
		System.out.println("Selected Option by Value: " +selectedOption2);
		Thread.sleep(3000);
		
		selectObject.selectByVisibleText("Python");
		String selectedOption3 = selectObject.getFirstSelectedOption().getText();
		System.out.println("Selected Option by visible text: " +selectedOption3);
		
		driver.quit();
	}

}
