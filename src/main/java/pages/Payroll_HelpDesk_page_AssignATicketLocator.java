package pages;

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
import TestUtil.Constants;
import org.testng.Assert;
import testcase.payrollHelpDesk.PayrollHelpDesk_CreateTicketPageTests;

public class Payroll_HelpDesk_page_AssignATicketLocator extends TestBase {

    public static WebDriverWait wait;
    public static GenericUtil genericUtil;
    public static Payroll_HelpDesk_page_GenericLocator objGenericLocator;
    public static Payroll_HelpDesk_page_LoginLocator objLoginPage;
    public static PayrollHelpDesk_CreateTicketPageTests objCreateTicketTestPage;

    public Payroll_HelpDesk_page_AssignATicketLocator(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    @FindBy(xpath = "//li[@id=\"link-Ticket\"]")
    public WebElement link_Ticket;

    @FindBy(xpath = "//span[contains(text(),'Assign A Ticket')]")
    public WebElement link_assignATicket;

    @FindBy(xpath = "//div[@id='assignMe_div']")
    public WebElement link_AssignMe;

    @FindBy(xpath = "//h1[contains(text(),'Pending Ticket Assign To User')]")
    public WebElement sectionTitleAssignATicket;

    @FindBy(xpath = "//input[@class='form-control input-sm input-small input-inline']")
    public WebElement searchBar;

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

    @FindBy(xpath = "//a[@href ='/Account/SignOut']")
    public WebElement buttonLogout;

    public void pendingTicketAssignToUser(String strGroup, String strUsers) {
        genericUtil = new GenericUtil();
        objGenericLocator = new Payroll_HelpDesk_page_GenericLocator(driver);

        //Create Ticket Test Page
        objCreateTicketTestPage = new PayrollHelpDesk_CreateTicketPageTests();
        objCreateTicketTestPage.createTicket();

        try {
            HighlightElement.highlightElement(objGenericLocator.link_Dashboard);
            genericUtil.clickWithPause(objGenericLocator.link_Dashboard,1000);
////            link_Dashboard.click();
//            genericUtil.pause(1000);

            HighlightElement.highlightElement(link_Ticket);
            genericUtil.clickWithPause(link_Ticket,1000);
//            link_Ticket.click();
//            genericUtil.pause(1000);

            HighlightElement.highlightElement(link_assignATicket);
            genericUtil.clickWithPause(link_assignATicket,1000);
//            link_assignATicket.click();
//            genericUtil.pause(1000);

            Assert.assertEquals(sectionTitleAssignATicket.getText(), "Pending Ticket Assign To User");
            System.out.println("---------Assign A ticket Page-Section Title :--------- " + sectionTitleAssignATicket.getText());

            Assert.assertEquals(driver.getCurrentUrl(), Constants.BASEURL + "Ticket/TicketAssignListing");
            System.out.println("---------Assign A ticket Page URL is :--------- " + driver.getCurrentUrl());

            Assert.assertEquals(driver.getTitle(), "TicketAssignListing - HelpDeskTicketing");
            System.out.println("---------Assign A ticket Page Title is :--------- " + driver.getTitle());

            HighlightElement.highlightElement(searchBar);
            searchBar.clear();
            genericUtil.pause(1000);

            searchBar.sendKeys(Constants.strDate);
            System.out.println("TODAY'S DATE: " + Constants.strDate);
            genericUtil.pause(3000);

            HighlightElement.highlightElement(buttonPencilIcon_AssignTicket);
            genericUtil.clickWithPause(buttonPencilIcon_AssignTicket,3000);
//            buttonPencilIcon_AssignTicket.click();
//            genericUtil.pause(3000);

            HighlightElement.highlightElement(group);
            group.click();
            Select selectGroup = new Select(group);
            selectGroup.selectByVisibleText(strGroup);
            genericUtil.pause(1000);

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
//            SaveButton.click();
//            genericUtil.pause(3000);

            wait.until(ExpectedConditions.textToBePresentInElement(SuccessAssignATicket, "User Assigned to Ticket Successfully!"));
            genericUtil.assertEqualsWithPause(SuccessAssignATicket.getText(), "User Assigned to Ticket Successfully!",4000);
            System.out.println("---------Success Assign A ticket  :--------- " + SuccessAssignATicket.getText());
//            Assert.assertEquals(SuccessAssignATicket.getText(), "User Assigned to Ticket Successfully!");
//            System.out.println("---------Success Assign A ticket  :--------- " + SuccessAssignATicket.getText());
//            genericUtil.pause(4000);

            HighlightElement.highlightElement(buttonLogout);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonLogout);
            genericUtil.pause(3000);

//            Create Ticket Page
//            objCreateTicketPage = new Payroll_HelpDesk_page_CreateTicketLocator(driver);
//            objCreateTicketPage.createTicket("General Query", "General Query", "Medium", "Test Description-General Query");

            verifyPendingTicketAssignToUser();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void verifyPendingTicketAssignToUser() {
        try {
            //Login Page
            objLoginPage = new Payroll_HelpDesk_page_LoginLocator(driver);
            objLoginPage.validateLogin(Constants.NORMALUSERNAME, Constants.VALIDPASSWORD);

            HighlightElement.highlightElement(objGenericLocator.link_Dashboard);
            genericUtil.clickWithPause(objGenericLocator.link_Dashboard,1000);

            HighlightElement.highlightElement(link_AssignMe);
            genericUtil.clickWithPause(link_AssignMe,1000);

            HighlightElement.highlightElement(searchBar);
            genericUtil.clearWithPause(searchBar,1000);
            genericUtil.writeTextWithPause(searchBar,Constants.strDate,3000);

        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }
}