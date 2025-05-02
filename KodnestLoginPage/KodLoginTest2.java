package kodLoginTest2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import kodNestPages.LoginPage;

public class KodLoginTest2 {
	
	WebDriver driver;
	String baseUrl = "https://app.kodnest.in/login";
	LoginPage classPageLogin;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		classPageLogin = new LoginPage(driver);
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
		classPageLogin.enterEmail("apoorva@.com");
		classPageLogin.clickLogin();
		Assert.assertEquals(classPageLogin.getActualInvalidEmailError(), "Invalid email format");
	}
	
	//Test3: Unregistered User
	@Test
	(priority = 3)
	public void unregisteredEmail() throws InterruptedException {

		classPageLogin.enterEmail("apoorva12345@gmail.com");
		classPageLogin.enterPassword("apoo123");
		classPageLogin.clickLogin();
		Thread.sleep(2000);
		String unregisteredEmailError = classPageLogin.getActualUserNotFoundError();
		Assert.assertEquals(unregisteredEmailError, "User not found with this email address");
	}
	
	//Test4: Invalid credentials, valid,registered email - invalid password
	@Test
	(priority = 4)
	public void invalidCredentials() throws InterruptedException {
		classPageLogin.enterEmail("apoorva1236@gmail.com");
		classPageLogin.enterPassword("apoo123");
		classPageLogin.clickLogin();
		Thread.sleep(2000);
		String actualIncorrectCredentialsError = classPageLogin.getActualIncorrectCredentialsError();
		Assert.assertEquals(actualIncorrectCredentialsError, "Incorrect Credentials");
	}
	
	//Test5: Correct email and password
	@Test
	(priority = 5)
	public void validCredentials() {
		classPageLogin.enterEmail("apoorva1236@gmail.com");
		classPageLogin.enterPassword("Aj@080123");
		classPageLogin.clickLogin();
		System.out.println("Dashboard Loaded successfully");
	}
	
	//Refresh browser to clear the keys after every test 
	@AfterMethod
	public void refresh() {
		driver.navigate().refresh();
	}
}