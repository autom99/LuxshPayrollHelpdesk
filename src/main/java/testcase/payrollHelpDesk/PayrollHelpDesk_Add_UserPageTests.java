package testcase.payrollHelpDesk;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Payroll_HelpDesk_page_LoginLocator;
import pages.Payroll_HelpDesk_page_UserLocator;
import TestUtil.CaptureScreenshot;
import TestUtil.Constants;

public class PayrollHelpDesk_Add_UserPageTests {

	public static WebDriver driver;

	Payroll_HelpDesk_page_LoginLocator objLoginPage;
	Payroll_HelpDesk_page_UserLocator objUserPage;
	
	@BeforeTest
	public void initialBrowserDriver() {
		driver = TestBase.testBase();

		objLoginPage= new Payroll_HelpDesk_page_LoginLocator(driver);
		objLoginPage.verifyAdminLogin(Constants.ADMINUSERNAME, Constants.VALIDPASSWORD);
	}

	/**
	 * TESTCASE METHOD-1 : ADD USER
	 */
	@Test(priority = 1)
	public void createUser() {
		objUserPage = new Payroll_HelpDesk_page_UserLocator(driver);
		objUserPage.createUser("test group name", "test TempEmpCode" + Constants.strDate + "_" + Constants.date.getTime(),
				"test TempEmpName" + Constants.strDate + "_" + Constants.date.getTime(), "Admin", "test" + "@" + Constants.date.getTime(),
				"12345678");
	}
	
	/**
	 * TESTCASE METHOD-2 : EDIT or MODIFY USER
	 */
	@Test(priority = 2)
	public void editUser() {
		try {
			objUserPage = new Payroll_HelpDesk_page_UserLocator(driver);
			objUserPage.editUser("test group name", "Updated test TempEmpCode" + Constants.strDate + "_" + Constants.date.getTime(),
					"Updated test TempEmpName" + Constants.strDate + "_" + Constants.date.getTime(),
					"Employee", "Updated_test" + "@" + "mail" + Constants.date.getTime());
			driver.close();
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
	}

//	@AfterMethod
//	public void captureScreenShot(ITestResult result){
//		CaptureScreenshot.captureScreenshotForFailedTests(driver,result.getName());
//        CaptureScreenshot.captureScreenshotAllTests(driver,result);
//	}
}
