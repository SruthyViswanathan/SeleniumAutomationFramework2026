package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest {
	/*
	 * 01:17 STEP 1 - Add Apache POI Dependency to pom.xml Update maven project mvn
	 * clean install
	 * 03:44 STEP 2 - Create an Excel File TestData.xlsx Add test data
	 * 08:19 STEP 3 - Create ExcelUtils.java to Read Data
	 * 22:23 STEP 4 - Modify LoginTest.java to Use Data from Excel
	 * 36:05 STEP 5 - Run tests and check reports
	 */
	@DataProvider(name="LoginData")
	public Object[][] getLoginData() throws IOException{
		
		String filePath = System.getProperty("user.dir")+"/testdata/TestData.xlsx";
		ExcelUtils.loadExcel(filePath, "Sheet1");
		int rowCount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount-1][2];
		
		for(int i=1; i<rowCount; i++) {
			
			data[i-1][0] = ExcelUtils.getCellData(i, 0);	// Username
			data[i-1][1] = ExcelUtils.getCellData(i, 1);	// Password
		}
		ExcelUtils.closeExcel();
		return data;
	}
	
	
	@DataProvider(name="LoginData2")
	public Object[][] getData(){
		
		return new Object[][] {
			{"user1","pass1"},
			{"user2","pass2"},
			{"user3","pass3"}
		};
	}

	/*
	 * How to get data from a data provider method STEP 1 - Create a data provider
	 * method and annotate with @DataProvider(name = "LoginData") STEP 2 - Annotate
	 * the test function to use this data provider
	 */
//	@Test(dataProvider = "LoginData2")
	/*
	 * 45:50 How to get data from testng.xml
	 * 47:21 STEP 1 - Modify testng.xml to Pass Parameters
	 * 49:58 STEP 2 - Use @Parameters in LoginTest.java
	 */
	@Test
	@Parameters({"username","password"})
//	@Test
	public void testValidlogin(String username, String password) {
		Log.info("Starting login test...");
		test = ExtentReportManager.createTest("Login Test - "+username);
		test.info("Navigating to URL");
		LoginPage loginPage = new LoginPage(driver);
		test.info("Adding Credentails");
//		loginPage.enterUsername("admin@yourstore.com");
//		loginPage.enterPassword("admin");
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		test.info("Clicking on Login button");
		loginPage.clickLoginButton();
		Log.info(driver.getTitle()+ "is the title of the page");
		test.info("Verifying page title");
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
		test.pass("Login Successful");
	}
//	@Test
//	public void testLoginWithInvalidCredentials() {
//
//		Log.info("Starting login test...");
//		test = ExtentReportManager.createTest("Login Test with Invalid Credentials");
//
//		test.info("Navigating to URL");
//		LoginPage loginPage = new LoginPage(driver);
//
//		Log.info("Adding credentials");
//		test.info("Adding Credentails");
//		loginPage.enterUsername("admin1234@yourstore.com");
//		loginPage.enterPassword("admin123");
//		test.info("Clicking on Login button");
//		loginPage.clickLoginButton();
//
//		System.out.println("Title of the page is : " + driver.getTitle());
//		Log.info("Verifying page title");
//		test.info("Verifying page title");
//		Assert.assertEquals(driver.getTitle(), "Just a moment...123");
//
//		test.pass("Login Successful");
//
//	}

	
}
