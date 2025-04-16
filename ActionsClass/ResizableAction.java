package actionClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ResizableAction {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/resizable/");
		
		// Locate the resizable box and its handle
		WebElement iframeElement = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(iframeElement);
		
		WebElement resizableHandle = driver.findElement(By.className("ui-resizable-se")); //bottom-right-corner (can be e or for east and south)
		
		// Perform the resize action
		Actions actions = new Actions(driver);
		actions.clickAndHold(resizableHandle).pause(Duration.ofSeconds(3)).moveByOffset(200, 50).release().perform(); //REsize by 50px width and height
		
		// Switch back to the main page
		driver.switchTo().defaultContent();
	}

}
