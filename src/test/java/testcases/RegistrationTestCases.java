package testcases;
import java.io.IOException;
import org.testng.annotations.Test;
import com.Resources.baseClass;
import com.Resources.commonMethods;
import com.Resources.constants;

import PageObjectModel.HomePageObject;
import PageObjectModel.RegistrationPageObject;


public class RegistrationTestCases extends baseClass
{
	public static String randomemailid="";		//we created this variable so that it can be used in different class--->(using in logintestcases page)
	@Test
	public void verifyRegisterationWithBlankData() throws IOException, InterruptedException {

		//Thread.sleep(3000);//remove this as we have created explicit wait code in commonMEthod()

		HomePageObject hpo = new HomePageObject(driver);
		
		commonMethods.putExplicitWait(driver, 10, hpo.clickonMyAccount());			//explicit wait
		hpo.clickonMyAccount().click();
		hpo.clickonregister().click();

		RegistrationPageObject rop=new RegistrationPageObject(driver);

		rop.enterfirstname().clear();
		rop.enterfirstname().sendKeys("");
		
		rop.enterlastname().clear();
		rop.enterlastname().sendKeys("");

		rop.enteremail().clear();
		rop.enteremail().sendKeys("");
		
		rop.EnterTelephone().sendKeys("");
		
		rop.EnterPassword().sendKeys("");
		
		rop.EnterPasswordConfirm().sendKeys("");
		
		rop.ClickOnSubscribe().click();
		
		rop.AcceptPrivacyPolicy().click();
		
		rop.ClickOnContinueButton().click();

		
		//SoftAssert sa = new SoftAssert();
		//String firstNameErrorMsg = constants.firstNameErrorMsg;					//(step 30)
		//String lastNameErrorMsg =constants.lastNameErrorMsg;
		//sa.assertEquals(rop.CaptureFirstNameErrorMsg().getText(), firstNameErrorMsg);
		//sa.assertEquals(rop.CaptureLastNameErrorMsg().getText(), lastNameErrorMsg);
		//sa.assertAll();
		
		commonMethods.handleAssertions(rop.CaptureFirstNameErrorMsg().getText(), constants.firstNameErrorMsg);
		commonMethods.handleAssertions(rop.CaptureLastNameErrorMsg().getText(), constants.lastNameErrorMsg);


	}
	
	/*
	 * public String generateRandomEmail() { return
	 * System.currentTimeMillis()+"@gmail.com"; }
	 */

	/*
	 * @Test public void verifyRegistration() throws IOException
	 * 
	 * { //initializeDriver() ;
	 * 
	 * //we are not getting any error for "driver" because we are extending the
	 * baseclass //driver.get(
	 * "https://naveenautomationlabs.com/opencart/index.php?route=account/register")
	 * ;
	 * 
	 * //calling the page in test cases RegistrationPageObject rop=new
	 * RegistrationPageObject(driver);
	 * 
	 * rop.enterfirstname().clear(); rop.enterfirstname().sendKeys("sneha");
	 * 
	 * rop.enterlastname().clear(); rop.enterlastname().sendKeys("dhumal");
	 * 
	 * rop.enteremail().clear(); rop.enteremail().sendKeys("abc@gmail.com"); }
	 */
	@Test
	public void verifyRegisterationWithValidData() throws IOException, InterruptedException {

		//Thread.sleep(3000);
		randomemailid=generateRandomEmail();					//initialization of the global variable
		
		RegistrationPageObject rop=new RegistrationPageObject(driver);
		commonMethods.putExplicitWait(driver, 10,rop.enterfirstname());			//explicit wait

		rop.enterfirstname().sendKeys(constants.firstname);
		rop.enterlastname().sendKeys(constants.lastname);
		rop.enteremail().sendKeys(randomemailid);
		rop.EnterTelephone().sendKeys(constants.telephone);
		rop.EnterPassword().sendKeys(constants.password);
		rop.EnterPasswordConfirm().sendKeys(constants.confirmpassword);
		
		rop.ClickOnSubscribe().click();
		
		//rop.AcceptPrivacyPolicy().click();
		
		rop.ClickOnContinueButton().click();
		
		
		//SoftAssert sa = new SoftAssert();							//this code is present in commonMethod.java
		//String successURL=constants.successURL;
		//sa.assertEquals(driver.getCurrentUrl(), successURL);
		//sa.assertAll();*/

		commonMethods.handleAssertions(driver.getCurrentUrl(), constants.successURL);
	}
	
}
