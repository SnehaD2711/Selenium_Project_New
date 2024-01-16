package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Resources.baseClass;
import com.Resources.constants;

import PageObjectModel.HomePageObject;
import PageObjectModel.LoginPageObject;

public class LoginTestCases extends baseClass
{
	
	
	@Test
	public void verifyLogin() throws IOException
	{
		HomePageObject hpo=new HomePageObject(driver);
		hpo.clickonMyAccount().click();
		hpo.clickonLogin().click();
		
		//initializeDriver();
		//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		LoginPageObject lpo=new LoginPageObject(driver);
		lpo.enteremail1().sendKeys(RegistrationTestCases.randomemailid);		//to send random email which is getting generated in RegistrationTestCases
		lpo.enterpassword().sendKeys(constants.password);
		lpo.enterloginbutton().click();
		
		
	}
	
}
