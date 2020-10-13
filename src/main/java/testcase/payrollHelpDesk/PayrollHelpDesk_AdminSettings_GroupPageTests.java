package testcase.payrollHelpDesk;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Payroll_HelpDesk_page_AdminSetting_GroupLocator;
import pages.Payroll_HelpDesk_page_LoginLocator;
import utility.Constants;

public class PayrollHelpDesk_AdminSettings_GroupPageTests {

	public WebDriver driver;

	Payroll_HelpDesk_page_LoginLocator objLoginPage;
	Payroll_HelpDesk_page_AdminSetting_GroupLocator objGroupPage;

	@BeforeTest
	public void initialBrowserDriver() {
		driver = TestBase.testBase();
	}

	@Test(priority = 1)
	public void createGroup() {
		objLoginPage= new Payroll_HelpDesk_page_LoginLocator(driver);
		objLoginPage.verifyAdminLogin(Constants.ADMINUSERNAME, Constants.VALIDPASSWORD);
		
		objGroupPage = new Payroll_HelpDesk_page_AdminSetting_GroupLocator(driver);
		objGroupPage.createGroup("test group code" + Constants.date.getTime(), "test group name" + Constants.date.getTime(), "test note created on " + Constants.date.getTime());				
	}
	
	@Test(priority = 2)
	public void editGroup() {
		objGroupPage = new Payroll_HelpDesk_page_AdminSetting_GroupLocator(driver);
		objGroupPage.editGroup("Updated test group code" + Constants.date.getTime(), 
				"Updated test group name" + Constants.date.getTime(), 
				"Updated test note created on " + Constants.date.getTime());				
	}
	
}
