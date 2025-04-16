package actionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class IFrameInteraction {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		
		// Since draggable is inside an IFrame, executing this will give NoSuchElementException
		/*
		WebElement element = driver.findElement(By.id("draggable"));
		element.click();
		*/
		
		//driver.switchTo().frame(0); //Switch to iframe
		WebElement iframeElement = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(iframeElement);
		//driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		
//		try {
//			Thread.sleep(3000);
//		} catch(InterruptedException e) {
//			e.printStackTrace();
//		}
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();
		//actions.dragAndDropBy(source, 100, 50).perform(); // Move by x=100, y=50
		
		driver.switchTo().defaultContent(); //Switch back to main content		
	}
}
