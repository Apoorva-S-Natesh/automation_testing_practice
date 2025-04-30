package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SocialMediaLinkPage {
	
	private WebDriver driver;

	public SocialMediaLinkPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	By pinterestLocator = By.className("header_soc_pinterest");
	By twitterLocator = By.className("header_soc_twitter");
	
	public void clickTwitteLink() {
		driver.findElement(twitterLocator).click();
	}
	
	public void clickPinterest() {
		driver.findElement(pinterestLocator).click();
	}
	
	@FindBy (className = "header_soc_linkedin")
	WebElement linkedIn;
	@FindBy (className = "header_soc_google")
	WebElement google;
	@FindBy (className = "header_soc_facebook")
	WebElement facebook;
	
	public void clickGoogleLink() {
		google.click();
	}
	
	public void clickFacebookLink() {
		facebook.click();
	}
	
	public void clickLinkedInLink() {
		linkedIn.click();
	}
	
//	WebElement twitter = driver.findElement(By.className("header_soc_twitter"));
//	WebElement linkedIn = driver.findElement(By.className("header_soc_linkedin"));
//	WebElement google = driver.findElement(By.className("header_soc_google"));
//	WebElement pinterest = driver.findElement(By.className("header_soc_pinterest"));
//	WebElement facebook = driver.findElement(By.className("header_soc_facebook"));
	
	
}
