package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.Log;

public class LoginTest extends BaseTest {
	@Test
	public void testValidlogin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername("admin@yourstore.com");
		loginPage.enterPassword("admin");
		loginPage.clickLoginButton();
		Log.info(driver.getTitle()+ "is the title of the page");
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
	}

	
}
