package parameterization;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestingParameterization {
	@Test
	@Parameters("username")
	public void loginTest(String username) {
		System.out.println("Logging in with username: " + username);
	}
	
	@Test
	@Parameters({"stagingBusinessURL", "usernameStudent"})
	public void loginToApplication(String appURL, String usernameStudent) {
		System.out.println("Navigating to: " + appURL);
		System.out.println("Logging in with username: " + usernameStudent);
	}
}
