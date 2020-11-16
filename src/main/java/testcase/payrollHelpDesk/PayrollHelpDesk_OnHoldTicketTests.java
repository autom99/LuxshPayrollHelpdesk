package testcase.payrollHelpDesk;

import TestUtil.Constants;
import base.TestBase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Payroll_HelpDesk_page_LoginLocator;
import pages.Payroll_HelpDesk_page_OnHoldTicketLocator;

public class PayrollHelpDesk_OnHoldTicketTests extends TestBase {

    public  static Payroll_HelpDesk_page_OnHoldTicketLocator objOnHoldTicketLocator;
    public  static Payroll_HelpDesk_page_LoginLocator objLoginPage;

    @BeforeTest
    public void initialBrowserDriver() {
//        driver = TestBase.testBase();
//        objLoginPage = new Payroll_HelpDesk_page_LoginLocator(driver);
//        objLoginPage.validateLogin(Constants.ADMINUSERNAME, Constants.VALIDPASSWORD);
    }

    @Test
    public void onHoldTicket(){
        objOnHoldTicketLocator = new Payroll_HelpDesk_page_OnHoldTicketLocator(driver);
        objOnHoldTicketLocator.verifyOnHoldTicket();
    }
}
