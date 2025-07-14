package SauceDemoTests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import DataProviders.JsonDataReader;
import Pages.LoginPage;
import pojos.Credentials;

public class SauceTest extends BaseTest{
	
	
	@Test(dataProvider = "JsonData",dataProviderClass = JsonDataReader.class)
	public void LoginTest(Credentials cred) {
		
		driver.get("https://www.saucedemo.com/");
		
		LoginPage page = new LoginPage(driver);
		page.enterUserName(cred.getUserName());
		page.enterPassword(cred.getPassword());
		page.clickLogin();
		
	}
	
	

}
