package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id ="user-name")
	private WebElement UserName;
	
	@FindBy(id ="password")
	private WebElement Password;
	
	@FindBy(id ="login-button")
	private WebElement login;
	
	public void enterUserName(String userName) {
		UserName.sendKeys(userName);
	}
	
	public void enterPassword(String pass) {
		Password.sendKeys(pass);
	}
	
	public void clickLogin() {
		login.click();
	}

}
