package dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");

		
		WebElement ideDropdown = driver.findElement(By.id("ide"));
		
		//Creating an object for Select Class
		Select dropdown = new Select(ideDropdown);
		
		//Verifying if the dropdown supports multiple selections
		if (dropdown.isMultiple())
		{
			System.out.println("The dropdown allows multiple selctions.");
			
			//Selecting multiple options
			dropdown.selectByIndex(0); //Select "Eclipse"
			Thread.sleep(2000);
			
			dropdown.selectByValue("ij"); //select "IntelliJ Idea"
			Thread.sleep(2000);
			
			dropdown.selectByVisibleText("Visual Studio");
			Thread.sleep(2000);
			
			//get all selected options and print them
			List<WebElement> selectedOptions = dropdown.getAllSelectedOptions();
			System.out.println("Selected IDEs: ");
			for(WebElement option: selectedOptions)
			{
				System.out.print(option.getText() + ", ");
			}
			
			System.out.println();
			System.out.println(selectedOptions); //Print WEbElement references
			Thread.sleep(2000);
			
			//Deselect each option one by one
			dropdown.deselectByIndex(0);
			System.out.println("Deselected eclipse by index");
			Thread.sleep(2000);
			
			dropdown.deselectByValue("ij");
			System.out.println("Deselected IntelliJ IDEA by value.");
			Thread.sleep(2000);
			
			dropdown.deselectByVisibleText("Visual Studio");
			System.out.println("Deselected Visual Studio by visual text");
			Thread.sleep(2000);
			
			//select all options using loop
			for (WebElement option: dropdown.getOptions())
			{
				dropdown.selectByVisibleText(option.getText());
				Thread.sleep(2000);
			}
			
			System.out.println("All options selected.");
			Thread.sleep(2000);
			
			dropdown.deselectAll();
			System.out.println("All options are deselected.");
			Thread.sleep(2000);
		}
		else
		{
			System.out.println("The dropdown does not support multiple selections");
		}
		
		driver.quit();
	}

}
