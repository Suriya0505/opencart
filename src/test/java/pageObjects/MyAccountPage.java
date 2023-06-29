package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	
//	Elements
	
	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement txtMyAccount;
	
	
	@FindBy(linkText = "Logout")
	WebElement linkLogout;
	
	
//	Actions

	public boolean checkMyAccount() {
		
		try {
			return (txtMyAccount.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
		
	}
	
	public void clickLogout() {
		linkLogout.click();
	}
	
}
