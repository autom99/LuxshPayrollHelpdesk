package testcase.payrollHelpDesk;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PayrollHelpDesk.test.Payroll_HelpDesk_page_AdminSetting_GroupLocator;
import PayrollHelpDesk.test.Payroll_HelpDesk_page_LoginLocator;
import PayrollHelpDesk.test.Payroll_HelpDesk_page_UserLocator;
import base.TestBase;
import utility.Constants;

public class PayrollHelpDesk_Add_UserPageTests {

	public WebDriver driver;

	Payroll_HelpDesk_page_LoginLocator objLoginPage;
	Payroll_HelpDesk_page_AdminSetting_GroupLocator objGroupPage;
	Payroll_HelpDesk_page_UserLocator objUserPage;
	
	@BeforeTest
	public void initialBrowserDriver() throws InterruptedException {
		driver = TestBase.testBase();
	}

	/**
	 * TESTCASE METHOD-1 : ADD USER
	 */
	@Test(priority = 1)
	public void createUser() {
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

		Reporter.log("====Successfully login====", true);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		objUserPage = new Payroll_HelpDesk_page_UserLocator(driver);
		objUserPage.createUser("test group name", "testTempEmpCode" + Constants.date.getTime(), "testTempEmpName" 
								+ Constants.date.getTime(), "Admin", "test" + "@" + Constants.date.getTime(), "12345678");
	}
	
	/**
	 * TESTCASE METHOD-2 : EDIT or MODIFY USER
	 */
	@Test(priority = 2)
	public void editUser() {
		objUserPage = new Payroll_HelpDesk_page_UserLocator(driver);
		objUserPage.editUser("test group name", "Updated testTempEmpCode" + Constants.date.getTime(),
				"Updated testTempEmpName" + Constants.date.getTime(), "Employee", "Updatedtest" + "@" + Constants.date.getTime());
	}

}
