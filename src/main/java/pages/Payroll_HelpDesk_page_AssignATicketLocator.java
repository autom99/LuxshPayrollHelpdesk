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

public class Payroll_HelpDesk_page_AssignATicketLocator extends TestBase {

    public static WebDriverWait wait;
    public static GenericUtil genericUtil;
    Payroll_HelpDesk_page_LoginLocator objLoginPage;

    public Payroll_HelpDesk_page_AssignATicketLocator(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    @FindBy(xpath = "//li[@id=\"link-Ticket\"]")
    public WebElement link_Ticket;

    @FindBy(xpath = "//span[contains(text(),'Assign A Ticket')]")
    public WebElement link_assignATicket;

    @FindBy(xpath = "//span[contains(text(),'Ticket Listing')]")
    public WebElement link_TicketListing;

    @FindBy(xpath = "//span[contains(text(),'Dashboard')]")
    private WebElement link_Dashboard;

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

    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    public WebElement CancelButton;

    @FindBy(xpath = "//div[@id='dtpTargetCompletion']")
    public WebElement targetCompletionDate;

    @FindBy(xpath = "//div[contains(text(),'User Assigned to Ticket Successfully!')]")
    public WebElement SuccessAssignATicket;

    @FindBy(xpath = "//a[@href ='/Account/SignOut']")
    public WebElement buttonLogout;

    public void pendingTicketAssignToUser(String strGroup, String strUsers) {
        genericUtil = new GenericUtil();
        try {
            HighlightElement.highlightElement(link_Ticket);
            link_Ticket.click();
            Thread.sleep(1000);

            HighlightElement.highlightElement(link_Ticket);
            link_assignATicket.click();
            Thread.sleep(1000);

            Assert.assertEquals(sectionTitleAssignATicket.getText(), "Pending Ticket Assign To User");
            System.out.println("---------Assign A ticket Page-Section Title :--------- " + sectionTitleAssignATicket.getText());
            Assert.assertEquals(driver.getCurrentUrl(), Constants.BASEURL + "Ticket/TicketAssignListing");
            System.out.println("---------Assign A ticket Page URL is :--------- " + driver.getCurrentUrl());
            Assert.assertEquals(driver.getTitle(), "TicketAssignListing - HelpDeskTicketing");
            System.out.println("---------Assign A ticket Page Title is :--------- " + driver.getTitle());

            HighlightElement.highlightElement(searchBar);
            searchBar.clear();
            Thread.sleep(1000);
            searchBar.sendKeys(Constants.strDate);
            System.out.println("TODAY'S DATE: " + Constants.strDate);
            Thread.sleep(3000);

            HighlightElement.highlightElement(buttonPencilIcon_AssignTicket);
            buttonPencilIcon_AssignTicket.click();
            Thread.sleep(3000);

            HighlightElement.highlightElement(group);
            group.click();
            Select selectGroup = new Select(group);
            selectGroup.selectByVisibleText(strGroup);
            Thread.sleep(1000);

            HighlightElement.highlightElement(users);
            users.click();
            Select selectUsers = new Select(users);
            selectUsers.selectByVisibleText(strUsers);
            Thread.sleep(1000);

            HighlightElement.highlightElement(targetCompletionDate);
            targetCompletionDate.click();
            Thread.sleep(1000);

            HighlightElement.highlightElement(SaveButton);
            SaveButton.click();
            Thread.sleep(2000);

            wait.until(ExpectedConditions.visibilityOf(SuccessAssignATicket));
            if (SuccessAssignATicket.isDisplayed()) {
                Assert.assertEquals(SuccessAssignATicket.getText(), "User Assigned to Ticket Successfully!");
                System.out.println("---------Success Assign A ticket  :--------- " + SuccessAssignATicket.getText());
            }
            Thread.sleep(4000);

            HighlightElement.highlightElement(buttonLogout);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonLogout);
            Thread.sleep(3000);

            verifyPendingTicketAssignToUser();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void verifyPendingTicketAssignToUser() throws InterruptedException {
        objLoginPage = new Payroll_HelpDesk_page_LoginLocator(driver);
        objLoginPage.validateLogin(Constants.NORMALUSERNAME, Constants.VALIDPASSWORD);

        HighlightElement.highlightElement(link_Dashboard);
        genericUtil.click(link_Dashboard);
        Thread.sleep(1000);

        HighlightElement.highlightElement(link_AssignMe);
        genericUtil.click(link_AssignMe);
        Thread.sleep(1000);

        HighlightElement.highlightElement(searchBar);
        searchBar.clear();
        Thread.sleep(1000);
        searchBar.sendKeys(Constants.strDate);
        System.out.println("TODAY'S DATE: " + Constants.strDate);
        Thread.sleep(3000);
    }
}
