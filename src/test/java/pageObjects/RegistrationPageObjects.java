package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class RegistrationPageObjects extends BasePage {

	
	public RegistrationPageObjects(WebDriver driver) {
		super(driver);
	}
	
	
//	Elements
	
	@FindBy(name = "firstname")
	WebElement textFirstname;
	
	@FindBy(name = "lastname")
	WebElement textLastname;
	
	@FindBy(name = "email")
	WebElement textEmail;
	
	@FindBy(name = "password")
	WebElement textPassword;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkboxAgree;
	
	@FindBy(xpath = "//button[normalize-space()='Continue']")
	WebElement btnContinue;
	
//	Action Methods
	
	public void setFname(String fname) {
		textFirstname.sendKeys(fname);
	}
	
	public void setLname(String lname) {
		textLastname.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		textEmail.sendKeys(email);
	}
	
	
	public void setPassword(String password) {
		textPassword.sendKeys(password);
	}
	
	public void clickAgree() {
		Actions act = new Actions(driver);
		act.moveToElement(chkboxAgree).click().build().perform();
	}
	
	public void clickContinueBtn() {
		btnContinue.click();
	}
	
	
	
	
	
	
	
}
