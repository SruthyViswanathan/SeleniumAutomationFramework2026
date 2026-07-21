package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest {
	@Test
	public void testValidlogin() {
		Log.info("Starting login test...");
		test = ExtentReportManager.createTest("Login Test - ");
		test.info("Navigating to URL");
		LoginPage loginPage = new LoginPage(driver);
		test.info("Adding Credentails");
		loginPage.enterUsername("admin@yourstore.com");
		loginPage.enterPassword("admin");
		test.info("Clicking on Login button");
		loginPage.clickLoginButton();
		Log.info(driver.getTitle()+ "is the title of the page");
		test.info("Verifying page title");
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
		test.pass("Login Successful");
	}
	@Test
	public void testLoginWithInvalidCredentials() {

		Log.info("Starting login test...");
		test = ExtentReportManager.createTest("Login Test with Invalid Credentials");

		test.info("Navigating to URL");
		LoginPage loginPage = new LoginPage(driver);

		Log.info("Adding credentials");
		test.info("Adding Credentails");
		loginPage.enterUsername("admin1234@yourstore.com");
		loginPage.enterPassword("admin123");
		test.info("Clicking on Login button");
		loginPage.clickLoginButton();

		System.out.println("Title of the page is : " + driver.getTitle());
		Log.info("Verifying page title");
		test.info("Verifying page title");
		Assert.assertEquals(driver.getTitle(), "Just a moment...123");

		test.pass("Login Successful");

	}

	
}
