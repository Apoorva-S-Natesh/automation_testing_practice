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
		//driver.manage().window().maximize();
		
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
		//Clearing any previous text 
		searchBox.clear();
		searchBox.sendKeys(searchText);
		Thread.sleep(2000); //so that suggestions appear
		
		//Capture all the dynamically suggested options
		List <WebElement> suggestions = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/div"));
		
		//should check if any suggestions are available
		if(suggestions.isEmpty()) {
			System.out.println("No suggestions available for input: "+searchText);
		} else {
			System.out.println("Suggestions available: ");
			for (WebElement suggestion : suggestions) {
				System.out.println(" - " + suggestion.getText());
			}
		} //Iterate over suggestions and select based on partial match(ignoring  case)
		boolean matchFound = false;
		for(WebElement suggestion: suggestions) {
			String suggestionText = suggestion.getText();
			//Performing case-insensitive and partial match
			if(suggestionText.toLowerCase().contains(expectedText.toLowerCase())) {
				suggestion.click();
				//Click on the matched option
				matchFound = true;
				System.out.println("Selected: " +suggestionText);
				break;
			}
		}
		//Case where the expected selection is not found
		if (!matchFound) {
			System.out.println("No matching suggestion found for: " + expectedText);
		}
		Thread.sleep(3000);
		driver.quit();
	}
}
