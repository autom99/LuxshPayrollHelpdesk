package testcase.payrollHelpDesk;

import TestUtil.CaptureScreenshot;
import base.TestBase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Payroll_HelpDesk_page_AssignATicketLocator;
import pages.Payroll_HelpDesk_page_LoginLocator;

public class PayrollHelpDesk_AssignATicketTests  extends TestBase{

    Payroll_HelpDesk_page_LoginLocator objLoginPage;
    Payroll_HelpDesk_page_AssignATicketLocator objAssignATicketPage;

    @BeforeTest
    public void initialBrowserDriver() {
//        driver = TestBase.testBase();
//        objLoginPage= new Payroll_HelpDesk_page_LoginLocator(driver);
//        objLoginPage.validateLogin(Constants.ADMINUSERNAME, Constants.VALIDPASSWORD);
    }

    @Test(priority = 1)
    public void assignPendingTickets() {
        objAssignATicketPage = new Payroll_HelpDesk_page_AssignATicketLocator(driver);
        objAssignATicketPage.pendingTicketAssignToUser("LuxshQA","Test User");
    }

    @AfterMethod
    public void captureScreenShot(ITestResult result){
        CaptureScreenshot.captureScreenshotForFailedTests(driver,result);
        CaptureScreenshot.captureScreenshotPassedTests(driver,result);
    }
}
