package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.Log;


public class BaseTest {
	protected WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		Log.info("web driver is starting.......");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://admin-demo.nopcommerce.com/login");
		Log.info("web driver is started");
	}
	@AfterMethod
	public void tearDown() {
		if(driver != null) {
			driver.quit();
			Log.info("web driver is closed");
		}
		
	}
}
