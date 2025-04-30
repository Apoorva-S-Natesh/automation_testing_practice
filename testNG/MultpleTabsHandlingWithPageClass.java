package locator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class MultpleTabsHandlingWithPageClass {
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.globalsqa.com");
			Thread.sleep(4000);
			
			
			SocialMediaLinkPage socailMediaLinks = new SocialMediaLinkPage(driver);
			
			socailMediaLinks.clickFacebookLink();
			socailMediaLinks.clickGoogleLink();
			socailMediaLinks.clickTwitteLink();
			socailMediaLinks.clickPinterest();
			socailMediaLinks.clickLinkedInLink();
			
			//Assert.assertTrue(false, "This test failed"); // If it fails, the errors and message will be shown
			Assert.assertTrue(true, "This test failed"); // assert.assertTrue(condition) - test case will pass only if the condition is true
			Assert.assertFalse(true, "This test failed"); // assert.assertFalse(condition) - test case will pass only if the condition is false

//			driver.findElement(By.className("header_soc_pinterest")).click();
//			
//			driver.findElement(By.className("header_soc_linkedin")).click();
//			
//			driver.findElement(By.className("header_soc_google")).click();
//			
//			
//			driver.findElement(By.className("header_soc_facebook")).click();
//		
//			
//			driver.findElement(By.className("header_soc_twitter")).click();

			Thread.sleep(4000);
			driver.quit();
	}
}

