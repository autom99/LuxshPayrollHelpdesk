package testcase.payrollHelpDesk;

import TestUtil.Constants;
import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Payroll_HelpDesk_page_AssignATicketLocator;
import pages.Payroll_HelpDesk_page_LoginLocator;

public class PayrollHelpDesk_AssignATicketTests  extends TestBase{

    WebDriver driver;

    Payroll_HelpDesk_page_LoginLocator objLoginPage;
    Payroll_HelpDesk_page_AssignATicketLocator objAssignATicketPage;

    @BeforeTest
    public void initialBrowserDriver() {
        driver = TestBase.testBase();

        objLoginPage= new Payroll_HelpDesk_page_LoginLocator(driver);
        objLoginPage.validateLogin(Constants.ADMINUSERNAME, Constants.VALIDPASSWORD);
    }

    @Test
    public void assignPendingTickets() {
        objAssignATicketPage = new Payroll_HelpDesk_page_AssignATicketLocator(driver);
        objAssignATicketPage.pendingTicketAssignToUser("Test","Test");
    }

//    @AfterMethod
//    public void captureScreenShot(ITestResult result){
//        CaptureScreenshot.captureScreenshotForFailedTests(driver,result);
//        CaptureScreenshot.captureScreenshotAllTests(driver,result);
//    }
}
