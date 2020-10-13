package testcase.payrollHelpDesk;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Payroll_HelpDesk_page_DashboardLocator;
import pages.Payroll_HelpDesk_page_LoginLocator;
import utility.Constants;

public class PayrollHelpDesk_DashboardPageTests {

	public WebDriver driver;

	Payroll_HelpDesk_page_LoginLocator objLoginPage;
	Payroll_HelpDesk_page_DashboardLocator objDashboardPage;

	@BeforeTest
	public void initialBrowserDriver() {
		driver = TestBase.testBase();
	}
	
	/**
	 * TESTCASE METHOD : DASHBOARD FUNCTIONALITY
	 */
	@Test(priority = 1)
	public void dashboardNavigationAllFunctionality() {
		objLoginPage= new Payroll_HelpDesk_page_LoginLocator(driver);
		objLoginPage.verifyAdminLogin(Constants.ADMINUSERNAME, Constants.VALIDPASSWORD);
		
		objDashboardPage = new Payroll_HelpDesk_page_DashboardLocator(driver);
		objDashboardPage.dashboardOperations();	
	}
}