package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_001LoginDDT extends BaseClass {

	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void LoginDDt(String email, String password, String result) {
		
		
		logger.info("***Execution Started***");
		
		try {
			

			
			HomePageObjects hp =new HomePageObjects(driver);
			
			hp.clickMyAccount();
			hp.clickLogin();
			
			
			LoginPageObjects lp = new LoginPageObjects(driver);
			lp.setEmailid(email);
			lp.setPassword(password);
			lp.clickLoginBtn();
			
			MyAccountPage mp = new MyAccountPage(driver);
			boolean myacctext = mp.checkMyAccount();
			
			if (result.equals("Valid")) {
				if (myacctext == true) {
					mp.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (result.equals("Invalid")) {
				if (myacctext == true) {
					MyAccountPage myaccpage = new MyAccountPage(driver);
					myaccpage.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
			

			
		} catch (Exception e) {
			
			Assert.fail();
		}	
	
	
		
	}
	
	
	
}
