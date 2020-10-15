package testcase.payrollHelpDesk;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Payroll_HelpDesk_page_AdminSetting_GroupLocator;
import pages.Payroll_HelpDesk_page_LoginLocator;
import pages.Payroll_HelpDesk_page_UserLocator;
import utility.CaptureScreenshot;
import utility.Constants;

public class PayrollHelpDesk_Add_UserPageTests {

	public static WebDriver driver;

	Payroll_HelpDesk_page_LoginLocator objLoginPage;
	Payroll_HelpDesk_page_UserLocator objUserPage;
	
	@BeforeTest
	public void initialBrowserDriver() {
		driver = TestBase.testBase();
	}

	/**
	 * TESTCASE METHOD-1 : ADD USER
	 */
	@Test(priority = 1)
	public void createUser() {
		objLoginPage= new Payroll_HelpDesk_page_LoginLocator(driver);
		objLoginPage.verifyAdminLogin(Constants.ADMINUSERNAME, Constants.VALIDPASSWORD);
		
		objUserPage = new Payroll_HelpDesk_page_UserLocator(driver);
		objUserPage.createUser("test group name", "testTempEmpCode" + Constants.date.getTime(), "testTempEmpName" 
								+ Constants.date.getTime(), "Admin", "test" + "@" + Constants.date.getTime(), "12345678");
	}
	
	/**
	 * TESTCASE METHOD-2 : EDIT or MODIFY USER
	 */
	@Test(priority = 2)
	public void editUser() {
		try {
			objUserPage = new Payroll_HelpDesk_page_UserLocator(driver);
			objUserPage.editUser("test group name", "Updated testTempEmpCode" + Constants.date.getTime(),
					"Updated testTempEmpName" + Constants.date.getTime(), "Employee", "Updatedtest" + "@" + Constants.date.getTime());
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
		driver.close();
	}

	@AfterMethod
	public void screenShot(ITestResult result){
		CaptureScreenshot.captureScreenshotForFailedTests(driver,result);
	}
}
