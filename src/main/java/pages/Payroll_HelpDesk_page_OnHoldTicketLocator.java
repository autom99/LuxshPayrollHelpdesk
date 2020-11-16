package pages;

import TestUtil.Constants;
import TestUtil.GenericUtil;
import TestUtil.HighlightElement;
import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Payroll_HelpDesk_page_OnHoldTicketLocator  extends TestBase{

    public static WebDriverWait wait;
    public static Payroll_HelpDesk_page_GenericLocator objGenericLocator;
    public static GenericUtil genericUtil;
    public static Payroll_HelpDesk_page_DashboardLocator objDashboardPage;

    public Payroll_HelpDesk_page_OnHoldTicketLocator(WebDriver driver){
        TestBase.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    @FindBy(xpath = "//li[@id='link-Ticket']")
    public WebElement link_Ticket;

    @FindBy(xpath = "//span[contains(text(),'Ticket On-Hold')]")
    public WebElement link_onHoldTicket;

    @FindBy(xpath = "//h1[contains(text(),'Ticket On-Hold')]")
    public WebElement verifyTitle_onHoldTicket;

    @FindBy(xpath = "//span[contains(text(),'Dashboard')]")
    public WebElement link_Dashboard;

    @FindBy(xpath = "//button[@class='btn text-primary btn-sm edit_btn mr-1'][1]")
    public WebElement editIconButton;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    public WebElement editSaveButton;

    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    public WebElement buttonCancel;

    @FindBy(xpath = "//h4[@id='editTicketNumber']")
    public WebElement title_onHoldTicket;

    @FindBy(xpath = "//input[@id='Description']")
    public WebElement title_Description;

    @FindBy(xpath = "//input[@id='optUnHold']")
    public WebElement option_Open;

    @FindBy(xpath = "//div[contains(text(),'Ticket On-Hold Successfully!')]")
    public WebElement successMsgOnHold;

    @FindBy(xpath = "//div[@id='openTicket_div']")
    public WebElement link_Open_Tickets;

    /**
     * TEST CASE: verifyOnHoldTicket method
     */
    public void verifyOnHoldTicket(){
        //Init GenericUtil object with driver instance
        genericUtil = new GenericUtil();
        objDashboardPage = new Payroll_HelpDesk_page_DashboardLocator(driver);
        objGenericLocator = new Payroll_HelpDesk_page_GenericLocator(driver);

        HighlightElement.highlightElement(link_Dashboard);
        genericUtil.clickWithPause(link_Dashboard, 2000);

        HighlightElement.highlightElement(link_Ticket);
        genericUtil.clickWithPause(link_Ticket, 2000);

        HighlightElement.highlightElement(link_onHoldTicket);
        genericUtil.clickWithPause(link_onHoldTicket, 2000);

        HighlightElement.highlightElement(verifyTitle_onHoldTicket);
        genericUtil.clickWithPause(verifyTitle_onHoldTicket,2000);

        HighlightElement.highlightElement(objGenericLocator.searchBar);
        objGenericLocator.searchBar.clear();
        objGenericLocator.searchBar.sendKeys(Constants.strDate);
        genericUtil.pause(2000);

        HighlightElement.highlightElement(editIconButton);
        editIconButton.click();
        genericUtil.pause(2000);

        wait.until(ExpectedConditions.visibilityOf(title_onHoldTicket));
        wait.until(ExpectedConditions.visibilityOf(title_Description));

        genericUtil.clickWithPause(option_Open,2000);
        genericUtil.clickWithPause(editSaveButton, 3000);
//        wait.until(ExpectedConditions.alertIsPresent());

        //Navigate to the Dashboard from OnHold Ticket
        genericUtil.clickWithPause(link_Dashboard, 3000);
        Assert.assertEquals(driver.getCurrentUrl(), Constants.BASEURL + "Home/Index");

        genericUtil.clickWithPause(link_Open_Tickets,4000);
        Assert.assertEquals(driver.getCurrentUrl(), Constants.BASEURL + "Ticket/TicketListing?status=open");

        //Navigate BACK to the Dashboard from OnHold Ticket
        genericUtil.clickWithPause(link_Dashboard, 3000);
        Assert.assertEquals(driver.getCurrentUrl(), Constants.BASEURL + "Home/Index");
    }
}
