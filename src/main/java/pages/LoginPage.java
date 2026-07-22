package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Log;

public class LoginPage {
	private WebDriver driver;
//	private By userNameTextBox = By.id("Email");
//    private By passwordTextBox = By.id("Password");
//    private By loginButton = By.xpath("//*[@id=\"main\"]/div/section/div/div[2]/div[1]/div/form/div[3]/button");
    
    @FindBy(id="Email")
	WebElement usernameTextbox;
	
	@FindBy(id="Password")
	WebElement passwordTextbox;
	
	@FindBy(xpath="//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	WebElement loginButton;
    
    public LoginPage(WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
    public void enterUsername(String userName) {
//    	driver.findElement(userNameTextBox).clear();
//    	driver.findElement(userNameTextBox).sendKeys(userName);
    	usernameTextbox.clear();
		usernameTextbox.sendKeys(userName);
    }
    public void enterPassword(String password) {
//    	driver.findElement(passwordTextBox).clear();
//    	driver.findElement(passwordTextBox).sendKeys(password);
    	passwordTextbox.clear();
		passwordTextbox.sendKeys(password);
    }
    public void clickLoginButton() {
//    	driver.findElement(loginButton).click();
    	Log.info("Clicking login button..");
		loginButton.click();
    }
}
