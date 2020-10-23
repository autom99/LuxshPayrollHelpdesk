package testcase.payrollHelpDesk;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Payroll_HelpDesk_page_AdminSetting_GroupLocator;
import pages.Payroll_HelpDesk_page_LoginLocator;
import TestUtil.CaptureScreenshot;
import TestUtil.Constants;

public class PayrollHelpDesk_AdminSettings_GroupPageTests extends TestBase {

    public WebDriver driver;

    Payroll_HelpDesk_page_LoginLocator objLoginPage;
    Payroll_HelpDesk_page_AdminSetting_GroupLocator objGroupPage;

    @BeforeTest
    public void initialBrowserDriver() {
        driver = TestBase.testBase();

        objLoginPage = new Payroll_HelpDesk_page_LoginLocator(driver);
        objLoginPage.verifyAdminLogin(Constants.ADMINUSERNAME, Constants.VALIDPASSWORD);
    }

    @Test(priority = 1)
    public void createGroup() {
        objGroupPage = new Payroll_HelpDesk_page_AdminSetting_GroupLocator(driver);
        objGroupPage.createGroup("test group code" + Constants.date.getTime(),
                "test group name" + Constants.date.getTime(),
                "test note created on " + Constants.date.getTime());
    }

    @Test(priority = 2)
    public void editGroup() {
        try {
            objGroupPage = new Payroll_HelpDesk_page_AdminSetting_GroupLocator(driver);
            objGroupPage.editGroup("Updated test group code" + Constants.strDate + "_" + Constants.date.getTime(),
                    "Updated test group name" + Constants.strDate + "_" + Constants.date.getTime(),
                    "Updated test note created on " + Constants.strDate + "_" + Constants.date.getTime());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        driver.close();
    }

//	@AfterMethod
//	public void captureScreenShot(ITestResult result){
//		CaptureScreenshot.captureScreenshotForFailedTests(driver,result);
//		CaptureScreenshot.captureScreenshotAllTests(driver,result);
//	}

}
