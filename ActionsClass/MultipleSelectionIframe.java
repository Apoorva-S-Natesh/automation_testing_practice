package iframe;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultipleSelectionIframe {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/selectable/");
		
		//Switch to the iframe that contains the selectable items
		WebElement iframeElement = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(iframeElement);
		
		//Locate all selectable items
		List<WebElement> selectableItems = driver.findElements(By.cssSelector("#selectable li"));
		
		//initialize Action class
		Actions actions = new Actions(driver);
		
		//HOld control key and select multiple items
		actions.keyDown(Keys.CONTROL)
			.click(selectableItems.get(0))
			.click(selectableItems.get(2))
			.click(selectableItems.get(4))
			.keyUp(Keys.CONTROL)
			.build()
			.perform();
		
		//Thread.sleep(3000);
		//Switch back to main content
		driver.switchTo().defaultContent();
		
		//Close the driver
		driver.quit();
	}
}
