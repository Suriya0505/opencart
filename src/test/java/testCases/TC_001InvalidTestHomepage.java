package testCases;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.MyAccountPage;
import pageObjects.RegistrationPageObjects;
import testBase.BaseClass;

public class TC_001InvalidTestHomepage extends BaseClass {

	
	@Test(groups = {"Sanity", "Master"})
	public void login_In_With_Valid_Email_And_Password() {
		
	
		try {
			
			logger.info("=====Started TC_001InvalidTestHomepage=====");
			
			HomePageObjects hp = new HomePageObjects(driver);
			
			hp.clickMyAccount();
			hp.clickLogin();
			
			logger.info("Clicked on Login Button");
			
			LoginPageObjects lp = new LoginPageObjects(driver);
			
			lp.setEmailid("durga@gmail.com");
			lp.setPassword("Suriya@123");
			logger.info("Login Credentials entered successfully");
			
			lp.clickLoginBtn();
			
			
			MyAccountPage mp = new MyAccountPage(driver);
			
			boolean status = mp.checkMyAccount();
			
			Assert.assertEquals(status, true);
			
			logger.info("Logged in Successfully");
			
		} catch (Exception e) {
			
			Assert.fail();
		}
	
		
		
	}
	
}
