package testcase.payrollHelpDesk;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PayrollHelpDesk.test.Payroll_HelpDesk_page_AdminSetting_GroupLocator;
import PayrollHelpDesk.test.Payroll_HelpDesk_page_LoginLocator;
import base.TestBase;
import utility.Constants;

public class PayrollHelpDesk_AdminSettings_GroupPageTests {

	public WebDriver driver;

	Payroll_HelpDesk_page_LoginLocator objLoginPage;
	PayrollHelpDesk_LoginPageTests objLoginTestpage;
	Payroll_HelpDesk_page_AdminSetting_GroupLocator objGroupPage;

	@BeforeTest
	public void initialBrowserDriver() throws InterruptedException {
		driver = TestBase.testBase();
	}

	@Test(priority = 1)
	public void createGroup() {
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

		Reporter.log("Successfully login by ADMIN User", true);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

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
