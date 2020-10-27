package testcase.payrollHelpDesk;

import TestUtil.CaptureScreenshot;
import TestUtil.Constants;
import base.TestBase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Payroll_HelpDesk_page_LoginLocator;
import pages.Payroll_HelpDesk_page_UserLocator;

public class PayrollHelpDesk_UserPageTests extends TestBase {

	Payroll_HelpDesk_page_LoginLocator objLoginPage;
	Payroll_HelpDesk_page_UserLocator objUserPage;
	
	@BeforeTest
	public void initialBrowserDriver() {
		driver = TestBase.testBase();

		objLoginPage= new Payroll_HelpDesk_page_LoginLocator(driver);
		objLoginPage.validateLogin(Constants.ADMINUSERNAME, Constants.VALIDPASSWORD);
	}

	/**
	 * TESTCASE METHOD-1 : ADD USER
	 */
	@Test(priority = 1)
	public void createUser() {
		objUserPage = new Payroll_HelpDesk_page_UserLocator(driver);
		objUserPage.createUser("test group name",
				"test TempEmpCode" + Constants.strDate + "_" + Constants.date.getTime(),
				"test TempEmpName" + Constants.strDate + "_" + Constants.date.getTime(),
				"Employee",
				"test" + "@" + Constants.date.getTime(),
				"12345678");
	}
	
	/**
	 * TESTCASE METHOD-2 : EDIT or MODIFY USER
	 */
	@Test(priority = 2)
	public void editUser() {
		try {
			objUserPage = new Payroll_HelpDesk_page_UserLocator(driver);
			objUserPage.editUser("test group name",
					"Updated test TempEmpCode" + Constants.strDate + "_" + Constants.date.getTime(),
					"Updated test TempEmpName" + Constants.strDate + "_" + Constants.date.getTime(),
					"Admin",
					"Updated_test" + "@" + "mail" + Constants.date.getTime());
			Thread.sleep(2000);
			objLoginPage.logOut();
			Thread.sleep(2000);
			driver.close();
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
	}

	@AfterMethod
	public void captureScreenShot(ITestResult result){
		CaptureScreenshot.captureScreenshotForFailedTests(driver,result);
		CaptureScreenshot.captureScreenshotPassedTests(driver,result);
	}

}
