package TestingLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class KodLoginTests {
	
	// https://app.kodnest.in/login
	// email field - id="email-input"
	// password field: id="password-input"
	// login button: id="login-submit-button"
	WebDriver driver;
	String baseUrl = "https://app.kodnest.in/login";
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}
	
	//Test1: blank email and blank password 
		/*
		 * id="password-error"
		 * id="email-error"
		 * */
	@Test (priority = 1)
	public void BlankEmailAndPassword() {
		driver.findElement(By.id("login-submit-button")).click();
		String actualBlankEmailError = driver.findElement(By.id("email-error")).getText(); // For every error message the id should be different
		Assert.assertEquals(actualBlankEmailError, "Email is required");
		String actualBlankPasswordError = driver.findElement(By.id("password-error")).getText();
		Assert.assertEquals(actualBlankPasswordError, "Please enter your password");
	}
	
	//Test2: Invalid email format
	@Test
	(priority = 2)
	public void invalidEmailFormat() {
		WebElement emailInput =  driver.findElement(By.id("email-input"));
		emailInput.sendKeys("apoorva.com"); // @ is missing
		driver.findElement(By.id("login-submit-button")).click();
		String actualInvalidEmailError =driver.findElement(By.id("email-error")).getText();
		Assert.assertEquals(actualInvalidEmailError, "Invalid email format");
	}
	
	//Test3: Unregistered User
	@Test
	(priority = 3)
	public void unregisteredEmail() throws InterruptedException {
		WebElement emailInput =  driver.findElement(By.id("email-input"));
		emailInput.sendKeys("apoorva12345@gmail.com"); // not registered id
		WebElement passwordInput =  driver.findElement(By.id("password-input"));
		passwordInput.sendKeys("apoo123");
		driver.findElement(By.id("login-submit-button")).click();
		Thread.sleep(2000);
		String unregisteredEmailError =driver.findElement(By.xpath("//div[@data-title= '' and text()= 'User not found with this email address']")).getText();
		Assert.assertEquals(unregisteredEmailError, "User not found with this email address");
	}
	
	//Test4: Invalid credentials, valid,registered email - invalid password
	@Test
	(priority = 4)
	public void invalidCredentials() throws InterruptedException {
		WebElement emailInput = driver.findElement(By.id("email-input"));
		emailInput.sendKeys("apoorva1326@gmail.com");
		WebElement passwordInput =  driver.findElement(By.id("password-input"));
		passwordInput.sendKeys("apoo123");
		driver.findElement(By.id("login-submit-button")).click();
		Thread.sleep(2000);
		String actualIncorrectCredentialsError = driver.findElement(By.xpath("//div[@data-title= '' and text()= 'Incorrect Credentials']")).getText();
		Assert.assertEquals(actualIncorrectCredentialsError, "Incorrect Credentials");
	}

	//Test5: Correct email and password
	@Test
	(priority = 5)
	public void validCredentials() {
		WebElement emailInput =  driver.findElement(By.id("email-input"));
		emailInput.sendKeys("correctemail");
		WebElement passwordInput =  driver.findElement(By.id("email-input"));
		passwordInput.sendKeys("correctpassword");
		driver.findElement(By.id("login-submit-button")).click();
		System.out.println("Dashboard Loaded successfully");
	}
	
	//Refresh browser to clear the keys after every test 
	@AfterMethod
	public void refresh() {
		driver.navigate().refresh();
	}
}

/*
 https://docs.google.com/document/d/17k_q6m6sCB4mwaUxUuDt4PH9SodT-oo5nn_aVZBfVdw/edit?tab=t.0
 
 https://docs.google.com/document/d/1jy7IdMSUvDLSTLJPvTCbSNbEne7wIocoR22YzOuOuBU/edit?tab=t.0
  */
