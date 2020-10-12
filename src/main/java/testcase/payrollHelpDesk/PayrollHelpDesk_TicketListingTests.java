package testcase.payrollHelpDesk;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Payroll_HelpDesk_page_LoginLocator;
import pages.Payroll_HelpDesk_page_TicketListingLocator;
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
	 * TESTCASE-1: searchByAllStatusTicketListing
	 * @param searchText
	 */
	@Test(priority = 1)
	public void searchByAllStatusTicketListing() {
		objLoginPage= new Payroll_HelpDesk_page_LoginLocator(driver);
		objLoginPage.verifyAdminLogin(Constants.ADMINUSERNAME, Constants.VALIDPASSWORD);
		
		objTicketListingPage = new Payroll_HelpDesk_page_TicketListingLocator(driver);
		objTicketListingPage.searchByStatusTicketListing("All");
	}

	/*
	@Test(priority = 2)
	public void searchByOpenStatusTicketListing() {				
		objTicketListingPage = new Payroll_HelpDesk_page_TicketListingLocator(driver);
		objTicketListingPage.searchByStatusTicketListing("Open");
	}
	
	@Test(priority = 3)
	public void searchByClosedStatusTicketListing() {
		
		objTicketListingPage = new Payroll_HelpDesk_page_TicketListingLocator(driver);
		objTicketListingPage.searchByStatusTicketListing("Closed");
	}
	
	@Test(priority = 4)
	public void searchByPendingStatusTicketListing() {
		objTicketListingPage = new Payroll_HelpDesk_page_TicketListingLocator(driver);
		objTicketListingPage.searchByStatusTicketListing("Pending");
	}
	
	@Test(priority = 5)
	public void searchByOnHoldStatusTicketListing() {
		objTicketListingPage = new Payroll_HelpDesk_page_TicketListingLocator(driver);
		objTicketListingPage.searchByStatusTicketListing("On-Hold");
	}
	
	@Test(priority = 6)
	public void searchByReOpenStatusTicketListing() {
		objTicketListingPage = new Payroll_HelpDesk_page_TicketListingLocator(driver);
		objTicketListingPage.searchByStatusTicketListing("Re-Open");
	}
	
	@Test(priority = 7)
	public void searchByAssignToMeStatusTicketListing() {
		objTicketListingPage = new Payroll_HelpDesk_page_TicketListingLocator(driver);
		objTicketListingPage.searchByStatusTicketListing("Assign to me");
	}
	*/
	
}
