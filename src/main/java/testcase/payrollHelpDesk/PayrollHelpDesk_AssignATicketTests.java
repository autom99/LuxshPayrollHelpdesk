package testcase.payrollHelpDesk;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Payroll_HelpDesk_page_AssignATicketLocator;
import pages.Payroll_HelpDesk_page_LoginLocator;
import TestUtil.CaptureScreenshot;
import TestUtil.Constants;

public class PayrollHelpDesk_AssignATicketTests {

    WebDriver driver;

    Payroll_HelpDesk_page_LoginLocator objLoginPage;
    Payroll_HelpDesk_page_AssignATicketLocator objAssignATicketPage;

    @BeforeTest
    public void initialBrowserDriver() {
        driver = TestBase.testBase();

        objLoginPage= new Payroll_HelpDesk_page_LoginLocator(driver);
        objLoginPage.verifyAdminLogin(Constants.ADMINUSERNAME, Constants.VALIDPASSWORD);
    }

    @Test
    public void assignPendingTickets() throws InterruptedException {
//        objLoginPage= new Payroll_HelpDesk_page_LoginLocator(driver);
//        objLoginPage.verifyAdminLogin(Constants.ADMINUSERNAME, Constants.VALIDPASSWORD);

        objAssignATicketPage = new Payroll_HelpDesk_page_AssignATicketLocator(driver);
        objAssignATicketPage.pendingTicketAssignToUser("Test","Test");
    }

//    @AfterMethod
//    public void captureScreenShot(ITestResult result){
//        CaptureScreenshot.captureScreenshotForFailedTests(driver,result);
//        CaptureScreenshot.captureScreenshotAllTests(driver,result);
//    }
}
