package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoard {
	
	WebDriver driver;
	
	public DashBoard(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	private WebElement backPack;
	
	@FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
	private WebElement tshirt;
	
	@FindBy(id = "add-to-cart-sauce-labs-bike-light")
	private WebElement bike;

	public void addToCartBackPack() {
		backPack.click();
	}
	
	public void addToCartBackTshirt() {
		tshirt.click();
	}
	
	public void addToCartBackBike() {
		bike.click();
	}
}
