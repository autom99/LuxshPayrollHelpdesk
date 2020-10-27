package testcase.payrollHelpDesk;

import TestUtil.CaptureScreenshot;
import TestUtil.Constants;
import base.TestBase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Payroll_HelpDesk_page_AdminSetting_GroupLocator;
import pages.Payroll_HelpDesk_page_LoginLocator;

public class PayrollHelpDesk_AdminSettings_GroupPageTests extends TestBase {

    Payroll_HelpDesk_page_LoginLocator objLoginPage;
    Payroll_HelpDesk_page_AdminSetting_GroupLocator objGroupPage;

    @BeforeTest
    public void initialBrowserDriver() {
        driver = TestBase.testBase();

        objLoginPage = new Payroll_HelpDesk_page_LoginLocator(driver);
        objLoginPage.validateLogin(Constants.ADMINUSERNAME, Constants.VALIDPASSWORD);
    }

    @Test(priority = 1)
    public void createGroup() {
        try {
            Thread.sleep(15000);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        objGroupPage = new Payroll_HelpDesk_page_AdminSetting_GroupLocator(driver);
        objGroupPage.createGroup("test group code" + Constants.date.getTime(),
                "test group name" + Constants.date.getTime(),
                "test note created on " + Constants.date.getTime());
    }

    @Test(priority = 2)
    public void editGroup() {
        try {
            Thread.sleep(10000);
            objGroupPage = new Payroll_HelpDesk_page_AdminSetting_GroupLocator(driver);
            objGroupPage.editGroup("Updated test group code" + Constants.strDate + "_" + Constants.date.getTime(),
                    "Updated test group name" + Constants.strDate + "_" + Constants.date.getTime(),
                    "Updated test note created on " + Constants.strDate + "_" + Constants.date.getTime());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        driver.close();
    }

	@AfterMethod
	public void captureScreenShot(ITestResult result){
		CaptureScreenshot.captureScreenshotForFailedTests(driver,result);
		CaptureScreenshot.captureScreenshotPassedTests(driver,result);
	}

}
