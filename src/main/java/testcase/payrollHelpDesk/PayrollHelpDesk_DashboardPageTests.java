package testcase.payrollHelpDesk;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Payroll_HelpDesk_page_DashboardLocator;
import pages.Payroll_HelpDesk_page_LoginLocator;
import TestUtil.CaptureScreenshot;
import TestUtil.Constants;

public class PayrollHelpDesk_DashboardPageTests {

	public WebDriver driver;

	Payroll_HelpDesk_page_LoginLocator objLoginPage;
	Payroll_HelpDesk_page_DashboardLocator objDashboardPage;

	@BeforeTest
	public void initialBrowserDriver() {
		driver = TestBase.testBase();

		objLoginPage= new Payroll_HelpDesk_page_LoginLocator(driver);
		objLoginPage.verifyAdminLogin(Constants.ADMINUSERNAME, Constants.VALIDPASSWORD);
	}
	
	/**
	 * TESTCASE METHOD : DASHBOARD FUNCTIONALITY
	 */
	@Test(priority = 1)
	public void dashboardNavigationAllFunctionality() {
		try {
//			objLoginPage= new Payroll_HelpDesk_page_LoginLocator(driver);
//			objLoginPage.verifyAdminLogin(Constants.ADMINUSERNAME, Constants.VALIDPASSWORD);

			objDashboardPage = new Payroll_HelpDesk_page_DashboardLocator(driver);
			objDashboardPage.dashboardOperations();

			driver.close();
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
	}

//	@AfterMethod
//	public void captureScreenShot(ITestResult result){
//		CaptureScreenshot.captureScreenshotForFailedTests(driver,result);
//		CaptureScreenshot.captureScreenshotAllTests(driver,result);
//	}
}