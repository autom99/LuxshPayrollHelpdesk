package pages;

import TestUtil.GenericUtil;
import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import TestUtil.Constants;

public class Payroll_HelpDesk_page_DashboardLocator extends TestBase {

    public static WebDriverWait wait;
    public static GenericUtil genericUtil;

    public Payroll_HelpDesk_page_DashboardLocator(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    @FindBy(xpath = "//span[contains(text(),'Dashboard')]")
    public WebElement link_Dashboard;

    @FindBy(xpath = "//div[contains(text(),'All Tickets')]")
    public WebElement link_All_Tickets;

    @FindBy(xpath = "//div[@id='openTicket_div']")
    public WebElement link_Open_Tickets;

    @FindBy(xpath = "//div[@id='closeTicket_div']")
    public WebElement link_Closed_Tickets;

    @FindBy(xpath = "//div[@id='onholdTicket_div']")
    public WebElement link_Onhold_Tickets;

    @FindBy(xpath = "//div[@id='reopenTicket_div']")
    public WebElement link_Reopen_Tickets;

    @FindBy(xpath = "//div[@id='assignMe_div']")
    public WebElement link_AssignMe;

    @FindBy(xpath = "//a[contains(text(),'Assign to Group ....')]")
    public WebElement link_Assign_to_Group;

    @FindBy(xpath = "//div[@id='pendingTicket_div']")
    public WebElement link_Pending_Tickets;

    @FindBy(xpath = "//*[@id=\"id-218\"]")
    public WebElement link_chart_HighPriority;

    @FindBy(xpath = "//*[@id=\"id-253\"]")
    public WebElement link_chart_MediumPriority;

    @FindBy(xpath = "//*[@id=\"id-287\"]")
    public WebElement link_chart_LowPriority;

    //MODIFIED-	@FindBy(xpath = "(//*[contains(text(),'High')])[3]")
    @FindBy(xpath = "//*[@id=\"id-218\"]")
    public WebElement button_chart_HighPriority;

    //MODIFIED-	@FindBy(xpath = "(//*[contains(text(),'Medium')])[2]")
    @FindBy(xpath = "//*[@id=\"id-253\"]")
    public WebElement button_chart_MediumPriority;

    //MODIFIED-	@FindBy(xpath = "(//*[contains(text(),'Low')])[2]")
    @FindBy(xpath = "//*[@id=\"id-287\"]")
    public WebElement button_chart_LowPriority;

    @FindBy(xpath = "//a[@id='pnotification']")
    public WebElement icon_bell_Notification;

    @FindBy(xpath = "//a[@id='pnotification']/..//i[@class='icon-settings']")
    public WebElement icon_settings_Group;

    /**
     * TESTCASE METHOD : DASHBOARD FUNCTIONALITY
     */
    public void dashboardOperations() {
        try {
            //Init GenericUtil object with driver instance
            genericUtil = new GenericUtil();

            navigateToAllTickets();
            driver.navigate().back();
            genericUtil.pause(2000);

            navigateToOpenTickets();
            driver.navigate().back();
            genericUtil.pause(2000);

            navigateToClosedTickets();
            driver.navigate().back();
            genericUtil.pause(2000);

            navigateToOnholdTickets();
            driver.navigate().back();
            genericUtil.pause(2000);

            navigateToReopenTickets();
            driver.navigate().back();
            genericUtil.pause(2000);

            navigateToMyTickets();
            driver.navigate().back();
            genericUtil.pause(2000);

            navigateToPendingTickets();
            driver.navigate().back();
            genericUtil.pause(2000);

            navigateByUrlAssignToGroup();
            driver.navigate().back();
            genericUtil.pause(2000);

            navigateIconSettingsGroup();
            driver.navigate().back();
            genericUtil.pause(2000);

            navigateIconBellNotification();
            driver.navigate().back();
            genericUtil.pause(2000);

            navigateHighPriority();
            driver.navigate().back();
            genericUtil.pause(2000);

            navigateMediumPriority();
            driver.navigate().back();
            genericUtil.pause(2000);

            navigateLowPriority();
            driver.navigate().back();
            genericUtil.pause(2000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * TESTCASE METHOD-2 : NAVIAGTE to ALL TICKETS
     */
    public void navigateToAllTickets() {
        link_Dashboard.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        link_All_Tickets.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String exp_URL = Constants.BASEURL + "Ticket/TicketListing?status=all";
        String act_URL = driver.getCurrentUrl();
        Assert.assertEquals(act_URL, exp_URL);
    }

    /**
     * TESTCASE METHOD-3 : NAVIGATE to OPEN TICKETS
     */
    public void navigateToOpenTickets() {
        link_Open_Tickets.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String exp_URL = Constants.BASEURL + "Ticket/TicketListing?status=open";
        String act_URL = driver.getCurrentUrl();
        Assert.assertEquals(act_URL, exp_URL);

//        Reporter.log("Success: OPEN TICKETS", true);
    }

    /**
     * TESTCASE METHOD-4 : NAVIGATE to CLOSED TICKETS
     */
    public void navigateToClosedTickets() {
        link_Closed_Tickets.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String exp_URL = Constants.BASEURL + "Ticket/TicketListing?status=close";
        String act_URL = driver.getCurrentUrl();
        Assert.assertEquals(act_URL, exp_URL);

//        Reporter.log("Success: CLOSED TICKETS", true);
    }

    /**
     * TESTCASE METHOD-5 : NAVIGATE to ON-HOLD TICKETS
     */
    public void navigateToOnholdTickets() {

        link_Onhold_Tickets.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String exp_URL = Constants.BASEURL + "Ticket/TicketListing?status=hold";
        String act_URL = driver.getCurrentUrl();
        Assert.assertEquals(act_URL, exp_URL);

//        Reporter.log("Success: ON-HOLD TICKETS", true);
    }

    /**
     * TESTCASE METHOD-6 : NAVIGATE to RE-OPEN TICKETS
     */
    public void navigateToReopenTickets() {

        link_Reopen_Tickets.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String exp_URL = Constants.BASEURL + "Ticket/TicketListing?status=ReOpen";
        String act_URL = driver.getCurrentUrl();
        Assert.assertEquals(act_URL, exp_URL);

//        Reporter.log("Success: RE-OPEN TICKETS", true);
    }

    /**
     * TESTCASE METHOD-7 : NAVIGATE to MY TICKETS / ASSIGN-ME
     */
    public void navigateToMyTickets() {

        link_AssignMe.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String exp_URL = Constants.BASEURL + "Ticket/TicketListing?status=assigntome";
        String act_URL = driver.getCurrentUrl();
        Assert.assertEquals(act_URL, exp_URL);

//        Reporter.log("Success: MY TICKETS", true);
    }

    /**
     * TESTCASE METHOD-8 : NAVIGATE to PENDING TICKETS
     */
    public void navigateToPendingTickets() {
        link_Pending_Tickets.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String exp_URL = Constants.BASEURL + "Ticket/TicketListing?status=pending";
        String act_URL = driver.getCurrentUrl();
        Assert.assertEquals(act_URL, exp_URL);

//        Reporter.log("Success: PENDING TICKETS", true);
    }

    /**
     * TESTCASE METHOD-9 : NAVIGATE to ASSIGN-TO-GROUP
     */
    public void navigateByUrlAssignToGroup() {
        link_Assign_to_Group.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String exp_URL = Constants.BASEURL + "Ticket/TicketAssignListing";
        String act_URL = driver.getCurrentUrl();
        Assert.assertEquals(act_URL, exp_URL);

//        Reporter.log("Success: ASSIGN-TO-GROUP BY URL NAVIGATED", true);
    }

    /**
     * TESTCASE METHOD-10 : NAVIGATE to ICON-SETTINGS-CUSTOM-GROUP
     */
    public void navigateIconSettingsGroup() {
        icon_settings_Group.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String exp_URL = Constants.BASEURL + "CustomGroup/ViewCustomGroups";
        String act_URL = driver.getCurrentUrl();
        Assert.assertEquals(act_URL, exp_URL);

//        Reporter.log("Success: ICON-SETTINGS-CUSTOM-GROUP", true);
    }

    /**
     * TESTCASE METHOD-11 : NAVIGATE to ICON-BELL-NOTIFICATION
     */
    public void navigateIconBellNotification() {
        icon_bell_Notification.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String exp_URL = Constants.BASEURL + "Ticket/TicketListing?status=all";
        String act_URL = driver.getCurrentUrl();
        Assert.assertEquals(act_URL, exp_URL);

//        Reporter.log("Success: ICON-BELL-NOTIFICATION", true);
    }

    /**
     * TESTCASE METHOD-12 : NAVIGATE from CHART to HIGH-PRIORITY LISTING
     */
    public void navigateHighPriority() {
        wait.until(ExpectedConditions.visibilityOf(button_chart_HighPriority));
        button_chart_HighPriority.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String exp_URL = Constants.BASEURL + "Ticket/TicketPriorityListing?priority=High";
        String act_URL = driver.getCurrentUrl();
        Assert.assertEquals(act_URL, exp_URL);

//        Reporter.log("Success: ICON-BELL-NOTIFICATION", true);
    }

    /**
     * TESTCASE METHOD-13 : NAVIGATE from CHART to Medium-PRIORITY LISTING
     */
    public void navigateMediumPriority() {
        wait.until(ExpectedConditions.visibilityOf(button_chart_MediumPriority));
        button_chart_MediumPriority.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String exp_URL = Constants.BASEURL + "Ticket/TicketPriorityListing?priority=Medium";
        String act_URL = driver.getCurrentUrl();
        Assert.assertEquals(act_URL, exp_URL);
    }

    /**
     * TESTCASE METHOD-14 : NAVIGATE from CHART to Low-PRIORITY LISTING
     */
    public void navigateLowPriority() {
        wait.until(ExpectedConditions.visibilityOf(button_chart_LowPriority));
        button_chart_LowPriority.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String exp_URL = Constants.BASEURL + "Ticket/TicketPriorityListing?priority=Low";
        String act_URL = driver.getCurrentUrl();
        Assert.assertEquals(act_URL, exp_URL);

//        Reporter.log("Success: ICON-BELL-NOTIFICATION", true);
    }

}
