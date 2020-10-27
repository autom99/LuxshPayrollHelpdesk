package testcase.payrollHelpDesk;

import TestUtil.CaptureScreenshot;
import TestUtil.Constants;
import base.TestBase;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Payroll_HelpDesk_page_LoginLocator;

public class PayrollHelpDesk_LoginPageTests extends TestBase {

	Payroll_HelpDesk_page_LoginLocator objLoginPage;
	
	@BeforeTest
	public void initialBrowserDriver() {
		driver = TestBase.testBase();
	}

	//POSITIVE TESTCASE-1	:Login Page: verify Admin User type
	@Test(priority = 1)
	public void verifyAdminLogin() {
		try {
			objLoginPage = new Payroll_HelpDesk_page_LoginLocator(driver);
			objLoginPage.verifyAdminLogin(Constants.ADMINUSERNAME, Constants.VALIDPASSWORD);

			Reporter.log("POSITIVE TESTCASE-1	:Login Page: verify Admin User type", true);
			Thread.sleep(4000);
		}
		catch (Exception e) {
			e.printStackTrace(); 
		}
	}

	//POSITIVE TESTCASE-2	:Login Page: verify Employee User type
	@Test(priority = 2)
	public void verifyEmployeeLogin() {
		try {
			objLoginPage = new Payroll_HelpDesk_page_LoginLocator(driver);
			objLoginPage.verifyEmployeeUser(Constants.EMPLOYEEUSERNAME, Constants.VALIDPASSWORD);

			Reporter.log("POSITIVE TESTCASE-2	:Login Page: verify Employee User type", true);
			Thread.sleep(4000);
		}
		catch (Exception e) {
			e.printStackTrace(); 
		}
	}

	//POSITIVE TESTCASE-3	:Login Page: verify Normal User type
	@Test(priority = 3)	
	public void verifyUserLogin() {
		try {
			objLoginPage = new Payroll_HelpDesk_page_LoginLocator(driver);
			objLoginPage.verifyNormalUser(Constants.NORMALUSERNAME, Constants.VALIDPASSWORD);

			Reporter.log("POSITIVE TESTCASE-3	:Login Page: verify Normal User type", true);
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace(); 
		}
	}

	/*	
	@Test
	public void validateAllUsersLogin() {
		objLoginPage = new Payroll_HelpDesk_page_LoginLocator(driver);		

		try {
			FileInputStream fis = new FileInputStream("D:\\HARDIK\\LuxshHrUkSystem-master\\config.properties");
			ps = new Properties();
			ps.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}

		String userType = ps.getProperty("UserAdmin");		
		objLoginPage.validateLogin(userType,  "12345678");
		if (userType.equals("UserAdmin")) {
			objLoginPage.validateLogin(userType, "12345678");
		}


		Reporter.log("====Employee USER LoginPage Test====", true);

		try { 
			Thread.sleep(4000); 
		} 
		catch (InterruptedException e) {
			e.printStackTrace(); 
		} 

		String exp_URL = "http://209.97.130.115:8011/Home/Index";
		String act_URL = driver.getCurrentUrl(); Assert.assertEquals(act_URL,exp_URL);
		Reporter.log("====Employee USER Successfully login====", true);
	}

	 */

	@Test(priority = 4)
	public void EmptyUsernameEmptyPassword() {
		try {
			objLoginPage = new Payroll_HelpDesk_page_LoginLocator(driver);
			objLoginPage.validateEmptyUsernameEmptyPassword(Constants.EMPTYDATA, Constants.EMPTYDATA);

			Reporter.log("NEGATIVE TESTCASE-1	:Login Page: Empty Username & Password!", true);
			Thread.sleep(2000); 
		} 
		catch (InterruptedException e) {
			e.printStackTrace(); 
		}
	}
	
	@Test(priority = 5)
	public void EmptyUsernameValidPassword() {
		try {
			objLoginPage = new Payroll_HelpDesk_page_LoginLocator(driver);
			//objLoginPage.invalidLogin("", "12345678");
			objLoginPage.validateEmptyUsernameValidPassword(Constants.EMPTYDATA, Constants.PASSWORD);

			Reporter.log("NEGATIVE TESTCASE-2	:Login Page: Empty Username & valid Password", true);
			Thread.sleep(2000); 
		} 
		catch (InterruptedException e) {
			e.printStackTrace(); 
		}
	}
	
	@Test(priority = 6)
	public void ValidUsernameEmptyPassword() {
		try {
			objLoginPage = new Payroll_HelpDesk_page_LoginLocator(driver);
			//objLoginPage.invalidLogin("testAdmin", "");
			objLoginPage.verifyValidUsernameEmptyPassword(Constants.USERNAME, Constants.EMPTYDATA);

			Reporter.log("NEGATIVE TESTCASE-3	:Login Page: Valid Username & Empty Password", true);
			Thread.sleep(2000); 
		} 
		catch (InterruptedException e) {
			e.printStackTrace(); 
		}
	}

	//NEGATIVE TESTCASE-4	:Login Page: Invalid Username & valid Password
	@Test(priority = 7)
	public void InvalidUsernameValidPassword() {
		try {
			objLoginPage = new Payroll_HelpDesk_page_LoginLocator(driver);
			//objLoginPage.invalidLogin("!@$~&", "12345678");
			objLoginPage.verifyInvalidUsernameValidPassword(Constants.INVALIDUSERNAME, Constants.PASSWORD);

			Reporter.log("NEGATIVE TESTCASE-4	:Login Page: Invalid Username & valid Password", true);
			Thread.sleep(2000); 
		} 
		catch (InterruptedException e) {
			e.printStackTrace(); 
		}
	}

	//NEGATIVE TESTCASE-5	:Login Page: Valid Username & invalid Password
	@Test(priority = 8)
	public void ValidUsernameInvalidPassword() {
		try {
			objLoginPage = new Payroll_HelpDesk_page_LoginLocator(driver);
			//objLoginPage.invalidLogin("testAdmin", "!@$~&");
			objLoginPage.verifyValidUsernameInvalidPassword(Constants.USERNAME, Constants.INVALIDPASSWORD);

			Reporter.log("NEGATIVE TESTCASE-5	:Login Page: Valid Username & invalid Password", true);
			Thread.sleep(2000); 
		} 
		catch (InterruptedException e) {
			e.printStackTrace(); 
		}
	}

	//NEGATIVE TESTCASE-6	:Login Page: Invalid Username & invalid Password
	@Test(priority = 9)
	public void InvalidUsernameInvalidPassword() {
		try {
			objLoginPage = new Payroll_HelpDesk_page_LoginLocator(driver);
			//objLoginPage.invalidLogin("!@$~&", "!@$~&");
			objLoginPage.verifyInvalidUsernameInvalidPassword(Constants.INVALIDUSERNAME, Constants.INVALIDPASSWORD);

			Reporter.log("NEGATIVE TESTCASE-6	:Login Page: Invalid Username & invalid Password", true);
			Thread.sleep(2000);

			driver.close();
		} 
		catch (InterruptedException e) {
			e.printStackTrace(); 
		}
	}

//	@Test(priority = 10)
//	public void VerifyForgotPassword(){
//		try {
//			objLoginPage = new Payroll_HelpDesk_page_LoginLocator(driver);
//			objLoginPage.verifyForgotPassword(Constants.USERNAME);
//
//			driver.close();
//		}
//		catch (Exception ex){
//			ex.getMessage();
//		}
//	}

	@AfterMethod
	public void captureScreenShot(ITestResult result){
		CaptureScreenshot.captureScreenshotForFailedTests(driver,result);
		CaptureScreenshot.captureScreenshotPassedTests(driver,result);
	}

}
