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

public class Payroll_HelpDesk_page_ReOpenTicketLocator extends TestBase {

    public static WebDriverWait wait;
    public static Payroll_HelpDesk_page_GenericLocator objGenericLocator;
    public static GenericUtil genericUtil;
    public static Payroll_HelpDesk_page_DashboardLocator objDashboardPage;

    public Payroll_HelpDesk_page_ReOpenTicketLocator(WebDriver driver) {
        TestBase.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    @FindBy(xpath = "//li[@id='link-Ticket']")
    public WebElement link_Ticket;

    @FindBy(xpath = "//span[contains(text(),'Re-Open Ticket')]")
    public WebElement link_reOpenTicket;

    @FindBy(xpath = "//button[@class='btn text-primary btn-sm edit_btn mr-1'][1]")
    public WebElement editIconButton;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    public WebElement editSaveButton;

    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    public WebElement buttonCancel;

    @FindBy(xpath = "//div[contains(text(),'Ticket On-Hold Successfully!')]")
    public WebElement UpdateMsgEditTicket;

    @FindBy(xpath = "//h4[@id='editTicketNumber']")
    public WebElement title_reOpenTicket;

    @FindBy(xpath = "//input[@id='Description']")
    public WebElement title_Description;

    @FindBy(xpath = "//div[contains(text(),'Ticket ReOpened Successfully!')]")
    public WebElement successMsgReOpen;

    @FindBy(xpath = "//span[contains(text(),'Dashboard')]")
    public WebElement link_Dashboard;

    @FindBy(xpath = "//h1[contains(text(),'Ticket Re-Open')]")
    public WebElement verifyTitle_reOpenTicket;

    /**
     * TEST CASE: ReOpen Ticket
     */
    public void verifyReOpenTicket() {
        //Init GenericUtil object with driver instance
        genericUtil = new GenericUtil();
        objDashboardPage = new Payroll_HelpDesk_page_DashboardLocator(driver);
        objGenericLocator = new Payroll_HelpDesk_page_GenericLocator(driver);

        HighlightElement.highlightElement(link_Dashboard);
        genericUtil.clickWithPause(link_Dashboard, 2000);

        HighlightElement.highlightElement(link_Ticket);
        genericUtil.clickWithPause(link_Ticket, 2000);

        HighlightElement.highlightElement(link_reOpenTicket);
        genericUtil.clickWithPause(link_reOpenTicket, 2000);

        HighlightElement.highlightElement(link_reOpenTicket);
        genericUtil.clickWithPause(verifyTitle_reOpenTicket,2000);

        HighlightElement.highlightElement(objGenericLocator.searchBar);
        objGenericLocator.searchBar.clear();
        objGenericLocator.searchBar.sendKeys(Constants.strDate);
        genericUtil.pause(2000);

        HighlightElement.highlightElement(editIconButton);
        editIconButton.click();
        genericUtil.pause(2000);

        wait.until(ExpectedConditions.visibilityOf(title_reOpenTicket));
        wait.until(ExpectedConditions.visibilityOf(title_Description));

        genericUtil.clickWithPause(editSaveButton, 3000);
//        wait.until(ExpectedConditions.visibilityOf(successMsgReOpen));

        //Navigate to the ReOpen Ticket from Dashboard
        genericUtil.clickWithPause(link_Dashboard, 3000);
        Assert.assertEquals(driver.getCurrentUrl(), Constants.BASEURL + "Home/Index");

        objDashboardPage.navigateToReopenTickets();
    }
}
