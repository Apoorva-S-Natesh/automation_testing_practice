package dropdown;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class suggestiveDropDown {

	public static void main(String[] args) throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.globalsqa.com/demoSite/practice/autocomplete/combobox.html");
		
		//Taking user input for search and selection
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the text to search: ");
		String searchText = scanner.nextLine();
		
		System.out.println("Enter the expected suggestion to select:");
		String expectedText = scanner.nextLine();
		scanner.close();
		
		//Locating and interacting with input field
		WebElement searchBox = driver.findElement(By.className("custom-combobox-input"));
		searchBox.clear();
		searchBox.sendKeys(searchText);
		Thread.sleep(2000); //so that suggestions appear
		
		//Capture all the dynamically suggested options
		List <WebElement> suggestions = driver.findElements(By.xpath("//ul@[id-id-1'/'i/div))"))
		
		//should check if any suggestions are available
		if(suggestions.isEmpty()) {
			System.out.println("No suggestions available for input: "+searchText);
		} else {
			System.out.println("Suggestions available: ");
			for (WebElement suggestion : suggestions) {
				System.out.println(" - " + suggestion.getText());
			}
		} //Iterate over suggestions and select based n partial match
	}
}
