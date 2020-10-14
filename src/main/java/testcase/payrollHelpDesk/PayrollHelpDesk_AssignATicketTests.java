package testcase.payrollHelpDesk;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Payroll_HelpDesk_page_AssignATicketLocator;
import pages.Payroll_HelpDesk_page_LoginLocator;
import utility.Constants;

public class PayrollHelpDesk_AssignATicketTests {

    public WebDriver driver;

    Payroll_HelpDesk_page_LoginLocator objLoginPage;
    Payroll_HelpDesk_page_AssignATicketLocator objAssignATicketPage;

    @BeforeTest
    public void initialBrowserDriver() {
        driver = TestBase.testBase();
    }

    @Test
    public void assignPendingTickets(){
        objLoginPage= new Payroll_HelpDesk_page_LoginLocator(driver);
        objLoginPage.verifyAdminLogin(Constants.ADMINUSERNAME, Constants.VALIDPASSWORD);

        objAssignATicketPage = new Payroll_HelpDesk_page_AssignATicketLocator(driver);
        objAssignATicketPage.pendingTicketAssignToUser("","");
    }
}
