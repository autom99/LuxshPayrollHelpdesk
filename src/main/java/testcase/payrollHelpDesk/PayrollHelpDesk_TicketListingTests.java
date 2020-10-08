package testcase.payrollHelpDesk;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PayrollHelpDesk.test.Payroll_HelpDesk_page_LoginLocator;
import PayrollHelpDesk.test.Payroll_HelpDesk_page_TicketListingLocator;
import base.TestBase;
import utility.Constants;

public class PayrollHelpDesk_TicketListingTests {

	public WebDriver driver;
	
	Payroll_HelpDesk_page_LoginLocator objLoginPage;
	Payroll_HelpDesk_page_TicketListingLocator objTicketListingPage;
	
	@BeforeTest
	public void initialBrowserDriver() throws InterruptedException {
		driver = TestBase.testBase();
	}
	
	/**
	 * TESTCASE-1: searchByStatusTicketListing
	 * @param searchText
	 */
	@Test(priority = 1)
	public void searchByStatusTicketListing() {
		
		objLoginPage= new Payroll_HelpDesk_page_LoginLocator(driver);
		objLoginPage.verifyAdminLogin(Constants.ADMINUSERNAME, Constants.PASSWORD);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String exp_URL =  Constants.BASEURL + "/Home/Index";
		String act_URL = driver.getCurrentUrl();
		Assert.assertEquals(act_URL, exp_URL);

		//Reporter.log("Successfully login by Admin User", true);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		objTicketListingPage = new Payroll_HelpDesk_page_TicketListingLocator(driver);
		objTicketListingPage.searchByStatusTicketListing("Pending");
	}
}
