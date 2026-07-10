package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	@Test
	public void testValidlogin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername("admin@yourstore.com");
		loginPage.enterPassword("admin");
		loginPage.clickLoginButton();
		System.out.println(driver.getTitle()+ "is the title of the page");
		Assert.assertEquals(driver.getTitle(), "Dashboard");
	}

	
}
