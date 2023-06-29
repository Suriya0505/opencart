package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObjects extends BasePage {

	public HomePageObjects(WebDriver driver) {
		super(driver);
	}
	
	
//	Elements
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement linkMyAccount;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement linkRegister;
	
	@FindBy(xpath = "//a[.='Login']")
	WebElement linkLogin;
	
	
//	Action Methods
	
	public void clickMyAccount() {
		
		linkMyAccount.click();
	}
	
	
	public void clickRegister() {
		
		linkRegister.click();
	}	
	
	public void clickLogin() {
		linkLogin.click();
	}
}
