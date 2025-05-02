package kodLoginTest3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import kodNestPages.LoginPage;

public class KodLoginTest3 {
	WebDriver driver;
	String baseUrl = "https://app.kodnest.in/login";
	LoginPage classPageLogin;
	
	String invalidEmail;
	String unregisteredEmail;
	String registeredEmail;
	String randomPassword;
	String wrongPassword;
	String correctPassword;
	
	@Parameters({"invalidEmail", "unregisteredEmail", "registeredEmail", "randomPassword", "wrongPassword", "correctPassword" })
	@BeforeClass
	public void setUp(String invalidEmail, String unregisteredEmail, String registeredEmail, String randomPassword, String wrongPassword, String correctPassword )
	{
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		classPageLogin = new LoginPage(driver);
		this.invalidEmail = invalidEmail;
		this.unregisteredEmail = unregisteredEmail;
		this.registeredEmail = registeredEmail;
		this.randomPassword = randomPassword;
		this.wrongPassword = wrongPassword;
		this.correctPassword = correctPassword;
	}
	
	@Test (priority = 1)
	public void BlankEmailAndPassword() {
		classPageLogin.clickLogin();
		Assert.assertEquals(classPageLogin.getActualEmailRequiredError(), "Email is required");
		Assert.assertEquals(classPageLogin.getActualPasswordRequiredError(), "Please enter your password");
	}
	
	//Test2: Invalid email format
	@Test
	(priority = 2)
	public void invalidEmailFormat() {
		classPageLogin.enterEmail(invalidEmail);
		classPageLogin.clickLogin();
		Assert.assertEquals(classPageLogin.getActualInvalidEmailError(), "Invalid email format");
	}
	
	//Test3: Unregistered User
	@Test
	(priority = 3)
	public void unregisteredEmail() throws InterruptedException {

		classPageLogin.enterEmail(unregisteredEmail);
		classPageLogin.enterPassword(randomPassword);
		classPageLogin.clickLogin();
		Thread.sleep(2000);
		String unregisteredEmailError = classPageLogin.getActualUserNotFoundError();
		Assert.assertEquals(unregisteredEmailError, "User not found with this email address");
	}
	
	//Test4: Invalid credentials, valid,registered email - invalid password
	@Test
	(priority = 4)
	public void invalidCredentials() throws InterruptedException {
		classPageLogin.enterEmail(registeredEmail);
		classPageLogin.enterPassword(wrongPassword);
		classPageLogin.clickLogin();
		Thread.sleep(2000);
		String actualIncorrectCredentialsError = classPageLogin.getActualIncorrectCredentialsError();
		Assert.assertEquals(actualIncorrectCredentialsError, "Incorrect Credentials");
	}

	//Test5: Correct email and password
	@Test
	(priority = 5)
	public void validCredentials() {
		classPageLogin.enterEmail(registeredEmail);
		classPageLogin.enterPassword(correctPassword);
		classPageLogin.clickLogin();
		System.out.println("Dashboard Loaded successfully");
	}
	
	//Refresh browser to clear the keys after every test 
	@AfterMethod
	public void refresh() {
		driver.navigate().refresh();
	}
}