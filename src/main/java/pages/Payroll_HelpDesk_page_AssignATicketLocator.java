package pages;

import TestUtil.Constants;
import TestUtil.GenericUtil;
import TestUtil.HighlightElement;
import base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import testcase.payrollHelpDesk.PayrollHelpDesk_CreateTicketPageTests;

public class Payroll_HelpDesk_page_AssignATicketLocator extends TestBase {

    public static WebDriverWait wait;
    public static GenericUtil genericUtil;
    public static Payroll_HelpDesk_page_GenericLocator objGenericLocator;
    public static Payroll_HelpDesk_page_LoginLocator objLoginPage;
    public static Payroll_HelpDesk_page_CreateTicketLocator objCreateTicketLocator;
    public static PayrollHelpDesk_CreateTicketPageTests objCreateTicketTestPage;

    public Payroll_HelpDesk_page_AssignATicketLocator(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    @FindBy(xpath = "//span[contains(text(),'Assign A Ticket')]")
    public WebElement link_assignATicket;

    @FindBy(xpath = "//div[@id='assignMe_div']")
    public WebElement link_AssignMe;

    @FindBy(xpath = "//h1[contains(text(),'Pending Ticket Assign To User')]")
    public WebElement sectionTitleAssignATicket;

    @FindBy(xpath = "//button[@title=\"Assign\"]")
    public WebElement buttonPencilIcon_AssignTicket;

    @FindBy(xpath = "//select[@id='ddlGroup']")
    public WebElement group;

    @FindBy(xpath = "//select[@id='ddlUser']")
    public WebElement users;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    public WebElement SaveButton;

    @FindBy(xpath = "//div[@id='dtpTargetCompletion']")
    public WebElement targetCompletionDate;

    @FindBy(xpath = "//div[contains(text(),'User Assigned to Ticket Successfully!')]")
    public WebElement SuccessAssignATicket;

    /**
     * TESTCASE METHOD: pendingTicketAssignToUser
     * @param strGroup = GroupOption
     * @param strUsers = UserOption
     */
    public void pendingTicketAssignToUser(String strGroup, String strUsers) {
        //Init GenericUtil object with driver instance
        genericUtil = new GenericUtil();
        objGenericLocator = new Payroll_HelpDesk_page_GenericLocator(driver);
        objCreateTicketLocator = new Payroll_HelpDesk_page_CreateTicketLocator(driver);

        //init Create Ticket Test Page
        objCreateTicketTestPage = new PayrollHelpDesk_CreateTicketPageTests();
        objCreateTicketTestPage.createTicket();

        try {
            HighlightElement.highlightElement(objGenericLocator.link_Dashboard);
            genericUtil.clickWithPause(objGenericLocator.link_Dashboard,2000);

            HighlightElement.highlightElement(objCreateTicketLocator.link_Ticket);
            genericUtil.clickWithPause(objCreateTicketLocator.link_Ticket,2000);

            HighlightElement.highlightElement(link_assignATicket);
            genericUtil.clickWithPause(link_assignATicket,2000);

            Assert.assertEquals(sectionTitleAssignATicket.getText(), "Pending Ticket Assign To User");
            System.out.println("---------Assign A ticket Page-Section Title :--------- " + sectionTitleAssignATicket.getText());

            Assert.assertEquals(driver.getCurrentUrl(), Constants.BASEURL + "Ticket/TicketAssignListing");
            System.out.println("---------Assign A ticket Page URL is :--------- " + driver.getCurrentUrl());

            Assert.assertEquals(driver.getTitle(), "TicketAssignListing - HelpDeskTicketing");
            System.out.println("---------Assign A ticket Page Title is :--------- " + driver.getTitle());

            HighlightElement.highlightElement(objGenericLocator.searchBar);
            objGenericLocator.searchBar.clear();
            genericUtil.pause(2000);

            objGenericLocator.searchBar.sendKeys(Constants.strDate);
            System.out.println("TODAY'S DATE: " + Constants.strDate);
            genericUtil.pause(3000);

            HighlightElement.highlightElement(buttonPencilIcon_AssignTicket);
            buttonPencilIcon_AssignTicket.click();
            genericUtil.pause(3000);

            HighlightElement.highlightElement(group);
            group.click();
            Select selectGroup = new Select(group);
            selectGroup.selectByVisibleText(strGroup);
            genericUtil.pause(2000);

            HighlightElement.highlightElement(users);
            users.click();
            Select selectUsers = new Select(users);
            selectUsers.selectByVisibleText(strUsers);
            genericUtil.pause(3000);

            HighlightElement.highlightElement(targetCompletionDate);
            targetCompletionDate.click();
            genericUtil.pause(3000);

            HighlightElement.highlightElement(SaveButton);
            genericUtil.clickWithPause(SaveButton,3000);
            wait.until(ExpectedConditions.textToBePresentInElement(SuccessAssignATicket, "User Assigned to Ticket Successfully!"));

            genericUtil.assertEqualsWithPause(SuccessAssignATicket.getText(), "User Assigned to Ticket Successfully!",4000);
            System.out.println("---------Success Assign A ticket  :--------- " + SuccessAssignATicket.getText());

//            Assert.assertEquals(SuccessAssignATicket.getText(), "User Assigned to Ticket Successfully!");
//            System.out.println("---------Success Assign A ticket  :--------- " + SuccessAssignATicket.getText());
//            genericUtil.pause(4000);

            HighlightElement.highlightElement(objGenericLocator.usernameTitle);
            genericUtil.clickWithPause(objGenericLocator.usernameTitle,2000);

            HighlightElement.highlightElement(objGenericLocator.buttonLogout);
            wait.until(ExpectedConditions.visibilityOf(objGenericLocator.buttonLogout));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", objGenericLocator.buttonLogout);
            genericUtil.pause(3000);

            verifyPendingTicketAssignToUser();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void verifyPendingTicketAssignToUser() {
        try {
            objLoginPage = new Payroll_HelpDesk_page_LoginLocator(driver);
            objLoginPage.validateLogin(Constants.NORMALUSERNAME, Constants.VALIDPASSWORD);

            HighlightElement.highlightElement(objGenericLocator.link_Dashboard);
            genericUtil.clickWithPause(objGenericLocator.link_Dashboard,2000);

            HighlightElement.highlightElement(link_AssignMe);
            genericUtil.clickWithPause(link_AssignMe,2000);

            HighlightElement.highlightElement(objGenericLocator.searchBar);
            genericUtil.clearWithPause(objGenericLocator.searchBar,2000);
            genericUtil.writeTextWithPause(objGenericLocator.searchBar,Constants.strDate,3000);
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }
}