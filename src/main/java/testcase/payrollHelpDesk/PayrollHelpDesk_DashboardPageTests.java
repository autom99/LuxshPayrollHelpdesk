package testcase.payrollHelpDesk;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PayrollHelpDesk.test.Payroll_HelpDesk_page_DashboardLocator;
import PayrollHelpDesk.test.Payroll_HelpDesk_page_LoginLocator;
import base.TestBase;
import utility.Constants;

public class PayrollHelpDesk_DashboardPageTests {

	public WebDriver driver;

	Payroll_HelpDesk_page_LoginLocator objLoginPage;
	PayrollHelpDesk_LoginPageTests objLoginTestpage;
	Payroll_HelpDesk_page_DashboardLocator objDashboardPage;

	@BeforeTest
	public void initialBrowserDriver() throws InterruptedException {
		driver = TestBase.testBase();
	}
	
	/**
	 * TESTCASE METHOD : DASHBOARD FUNCTIONALITY
	 */
	@Test(priority = 1)
	public void dashboardNavigationAllFunctionality() {
		objLoginPage= new Payroll_HelpDesk_page_LoginLocator(driver);
		objLoginPage.verifyAdminLogin(Constants.ADMINUSERNAME, Constants.VALIDPASSWORD);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String exp_URL =  Constants.BASEURL + "Home/Index";
		String act_URL = driver.getCurrentUrl();
		Assert.assertEquals(act_URL, exp_URL);

		Reporter.log("Welcome to the PAYROLL HELPDESK SYSTEM..!", true);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		objDashboardPage = new Payroll_HelpDesk_page_DashboardLocator(driver);
		objDashboardPage.dashboardOperations();	
	}
}
