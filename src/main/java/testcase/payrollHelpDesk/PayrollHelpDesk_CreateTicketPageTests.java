package testcase.payrollHelpDesk;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Payroll_HelpDesk_page_CreateTicketLocator;
import pages.Payroll_HelpDesk_page_LoginLocator;
import TestUtil.CaptureScreenshot;
import TestUtil.Constants;

public class PayrollHelpDesk_CreateTicketPageTests extends TestBase{

	public static WebDriver driver;

	Payroll_HelpDesk_page_LoginLocator objLoginPage;
	Payroll_HelpDesk_page_CreateTicketLocator objCreatePage;

	@BeforeTest
	public void initialBrowserDriver()  {
		driver = TestBase.testBase();

		objLoginPage= new Payroll_HelpDesk_page_LoginLocator(driver);
		objLoginPage.validateLogin(Constants.ADMINUSERNAME, Constants.VALIDPASSWORD);
	}

	/**
	 * TESTCASE METHOD-1 : CREATE TICKET
	 */
	@Test(priority = 1)
	public void createTicket(){
		objCreatePage = new Payroll_HelpDesk_page_CreateTicketLocator(driver);
		objCreatePage.createTicket("General Query", "General Query", "Medium", "Test Description-General Query");
	}
	
	/**
	 * TESTCASE METHOD-2 : EDIT TICKET
	 */
	@Test(priority = 2)
	public void editTicket() {
		objCreatePage = new Payroll_HelpDesk_page_CreateTicketLocator(driver);
//		objCreatePage.ediTicket("Incorrect Pay", "Not Paid Correctly", "High", "Updated Test Description-Incorrect Pay-Not Paid Correctly");
		objCreatePage.ediTicket("Payslips", "Payslip Request", "High", "Updated Test Description-Payslips-Payslip Request");
		driver.close();
	}
	
//	@AfterMethod
//	public void captureScreenShot(ITestResult result){
//		CaptureScreenshot.captureScreenshotForFailedTests(driver,result);
//		CaptureScreenshot.captureScreenshotAllTests(driver,result);
//	}

}
