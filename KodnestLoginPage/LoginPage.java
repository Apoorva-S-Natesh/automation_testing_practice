package kodNestPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By emailField = By.id("email-input");
	By passwordField = By.id("password-input");
	By loginButton = By.id("login-submit-button");
	By emailRequiredError = By.id("email-error");
	By passwordRequiredError = By.id("password-error");
	By invalidEmailError = By.id("email-error");
	By userNotFound = By.xpath("//div[@data-title= '' and text()= 'User not found with this email address']");
	By incorrectCredentialError = By.xpath("//div[@data-title= '' and text()= 'Incorrect Credentials']");
	
	public void clickLogin() {
		driver.findElement(loginButton).click();
	}
	
	public void enterEmail(String email) {
		driver.findElement(emailField).sendKeys(email);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public String getActualEmailRequiredError() {
		return driver.findElement(emailRequiredError).getText();
	}
	
	public String getActualPasswordRequiredError() {
		return driver.findElement(passwordRequiredError).getText();
	}
	
	public String getActualInvalidEmailError() {
		return driver.findElement(invalidEmailError).getText();
	}
	
	public String getActualUserNotFoundError() {
		return driver.findElement(userNotFound).getText();
	}
	
	public String getActualIncorrectCredentialsError() {
		return driver.findElement(incorrectCredentialError).getText();
	}
}
