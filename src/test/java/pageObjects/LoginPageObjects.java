package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects extends BasePage {

	public LoginPageObjects(WebDriver driver) {
		super(driver);

	}



	//	Elements

	@FindBy(id = "input-email")
	WebElement txtEmailid;

	@FindBy(id = "input-password")
	WebElement txtPassword;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnLogin;

	@FindBy(xpath = "//span[.='My Account']")
	public WebElement linkMyAccount;


	//	Action Methods

	public void setEmailid(String email) {

		txtEmailid.sendKeys(email);
	}

	public void setPassword(String password) {

		txtPassword.sendKeys(password);
	}


	public void clickLoginBtn() {

		btnLogin.click();

	}
	
	
	public boolean myAcclinkPresent() {
		
		return linkMyAccount.isDisplayed();
		
	}


}
