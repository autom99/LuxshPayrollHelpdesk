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

import java.util.concurrent.TimeUnit;

public class Payroll_HelpDesk_page_TicketListingLocator extends TestBase {

    public static WebDriverWait wait;
    public static Payroll_HelpDesk_page_GenericLocator objGenericLocator;
    public static GenericUtil genericUtil;

    public Payroll_HelpDesk_page_TicketListingLocator(WebDriver driver) {
        TestBase.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    @FindBy(xpath = "//span[contains(text(),'Dashboard')]")
    public WebElement link_Dashboard;

    @FindBy(xpath = "//li[@id=\"link-Ticket\"]")
    public WebElement link_Ticket;

    @FindBy(xpath = "//li[@id='link-TicketListing']//a[contains(@class,'nav-link')]")
    public WebElement link_TicketListing;

    @FindBy(xpath = "//select[@id='status_type']")
    public WebElement filter_status_type;

    @FindBy(xpath = "//input[@class='form-control input-sm input-small input-inline']")
    public WebElement searchBar;

    @FindBy(xpath = "//input[contains(@class,'btn-sm')]")
    public WebElement buttonSearch;

    //------------------------------------------------------------------------------------------------------------------
    @FindBy(xpath = "//a[@href ='/Home/Index']")
    public WebElement logo_img;

    @FindBy(xpath = "//ul[@class =\"pagination\"]")
    public WebElement pagination;

    @FindBy(xpath = "//div[@id='tblticket_paginate']")
    public WebElement paginationTicketListingPage;

    @FindBy(xpath = "//a[@title =\"Next\"]")
    public WebElement buttonNext_PageNumber;

    @FindBy(xpath = "//a[@title =\"Prev\"]")
    public WebElement buttonPrev_PageNumber;

    @FindBy(xpath = "//li[@class=\"prev disabled\"]")
    public WebElement buttonPrev_disabled;

    @FindBy(xpath = "//li[@class='next disabled']")
    public WebElement buttonNext_disabled;

    @FindBy(xpath = "//li[@class=\"active\"]")
    public WebElement buttonActive_SelectedPageNumber;

    @FindBy(xpath = "//a[contains(text(),'2')]")
    public WebElement PageNumber;

    @FindBy(xpath = "//select[contains(@name,'tblticket')]")
    public WebElement NumberOfRecordsPerPage;

    //---------------------------------View Ticket----------------------------------------------------------------------
    @FindBy(xpath = "//button[@title=\"View Ticket History\"]")
    public WebElement buttonEye_viewTicket;

    @FindBy(xpath = "//select[@id='ticketStatus']")
    public WebElement buttonEye_viewTicket_SelectStatus;

    @FindBy(xpath = "//textarea[@id='comments']")
    public WebElement comments;

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    public WebElement buttonSubmit;

    @FindBy(xpath = "//button[contains(text(),'Back')]")
    public WebElement buttonBack;

    @FindBy(xpath = "//div[contains(text(),'Ticket ReOpen Successfully !')]")
    public WebElement ViewMsgViewTicket;

//    //-----------------------------------Edit Ticket--------------------------------------------------------------------
//    @FindBy(xpath = "//button[@title=\"Edit\"]")
//    public WebElement buttonPencil_editTicket;
//
//    @FindBy(xpath = "//button[contains(text(),'Save')]")
//    public WebElement editSaveButton;
//
//    @FindBy(xpath = "//div[contains(text(),'Ticket Updated Successfully !')]")
//    public WebElement UpdateMsgEditTicket;
//

    //-----------------------------------Download Ticket----------------------------------------------------------------
    @FindBy(xpath = "//button[@title=\"Download\"]")
    public WebElement buttonDownload_downloadTicket;

    @FindBy(xpath = "//td[contains(text(),'No data available in table')]")
    public WebElement noDataAvailable;

    //----------------------------------Delete Ticket-------------------------------------------------------------------
    @FindBy(xpath = "//button[@onclick=\"deleteTicket(); return false;\"]")
    public WebElement delete_YesButton;

    @FindBy(xpath = "//button[@title=\"Remove\"]")
    public WebElement buttonDustbin_deleteTicket;

    @FindBy(xpath = "//div[contains(text(),'File not available.')]")
    WebElement validationFileUpload;

    @FindBy(xpath = "//h4[@id='deleteTicketNumber']")
    public WebElement PopUpMsgDeleteTicket;

    @FindBy(xpath = "//div[contains(text(),'We have successfully delete your selected ticket.')]")
    public WebElement SuccessMsgDeleteTicket;
    //------------------------------------------------------------------------------------------------------------------

    /**
     * TESTCASE MEHOD-1: searchByStatusTicketListing
     *
     * @param searchText: searchText
     */
    public void searchByStatusTicketListing(String searchText) {

        link_Ticket.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        link_TicketListing.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        filter_status_type.click();
        Select selectfilter_status_type = new Select(filter_status_type);
        selectfilter_status_type.selectByVisibleText(searchText);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        buttonSearch.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Pagination
        if (pagination.isDisplayed()) {
            NumberOfRecordsPerPage.click();
            Select selectNumberOfPages = new Select(NumberOfRecordsPerPage);
            selectNumberOfPages.selectByVisibleText("25");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            buttonNext_PageNumber.click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            buttonNext_PageNumber.click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//				buttonActive_SelectedPageNumber.click();
//				Thread.sleep(2000);

            buttonPrev_PageNumber.click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Navigate to the Dashboard Page
            logo_img.click();
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * TESTCASE MEHOD-2: VIEW TICKET
     *
     */
    public void viewTicket(String status, String strComments) throws InterruptedException {
//        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        HighlightElement.highlightElement(link_Ticket);
        link_Ticket.click();
        Thread.sleep(1000);

        HighlightElement.highlightElement(link_TicketListing);
        link_TicketListing.click();
        Thread.sleep(1000);

        HighlightElement.highlightElement(searchBar);
        searchBar.clear();
        searchBar.sendKeys(Constants.strDate);
        Thread.sleep(3000);

        HighlightElement.highlightElement(buttonEye_viewTicket);
        buttonEye_viewTicket.click();
        Thread.sleep(3000);

        HighlightElement.highlightElement(buttonEye_viewTicket_SelectStatus);
        buttonEye_viewTicket_SelectStatus.click();
        Select selectStatus = new Select(buttonEye_viewTicket_SelectStatus);
        selectStatus.selectByVisibleText(status);
        Thread.sleep(1000);

        HighlightElement.highlightElement(comments);
        comments.clear();
        comments.sendKeys(strComments);
        Thread.sleep(1000);

        HighlightElement.highlightElement(buttonSubmit);
        buttonSubmit.click();
        Thread.sleep(3000);
    }

    /**
     * TESTCASE MEHOD-3: DELETE TICKET
     *
     */
    public void deleteTicket() throws InterruptedException {
        HighlightElement.highlightElement(link_Ticket);
        link_Ticket.click();
        Thread.sleep(1000);

        HighlightElement.highlightElement(link_TicketListing);
        link_TicketListing.click();
        Thread.sleep(1000);

        HighlightElement.highlightElement(searchBar);
        searchBar.clear();
        searchBar.sendKeys(Constants.strDate);
        Thread.sleep(3000);

        HighlightElement.highlightElement(buttonDustbin_deleteTicket);
        buttonDustbin_deleteTicket.click();
        Thread.sleep(3000);

        HighlightElement.highlightElement(delete_YesButton);
        delete_YesButton.click();
        Thread.sleep(3000);

//        wait.until(ExpectedConditions.visibilityOf(PopUpMsgDeleteTicket));
        if (PopUpMsgDeleteTicket.isDisplayed()){
            Assert.assertEquals(SuccessMsgDeleteTicket.getText(),"We have successfully delete your selected ticket.");
        }
    }

    /**
     * TESTCASE MEHOD-4: DOWNLOAD TICKET
     *
     */
    public void downloadAttachment() throws InterruptedException {
        //Init GenericUtil object with driver instance
        genericUtil = new GenericUtil();
        objGenericLocator = new Payroll_HelpDesk_page_GenericLocator(driver);

        HighlightElement.highlightElement(link_Ticket);
        link_Ticket.click();
        Thread.sleep(1000);

        HighlightElement.highlightElement(link_TicketListing);
        link_TicketListing.click();
        Thread.sleep(1000);

        HighlightElement.highlightElement(objGenericLocator.searchBar);
        objGenericLocator.searchBar.clear();
        objGenericLocator.searchBar.sendKeys(Constants.strDate);
        Thread.sleep(3000);

        try {
            if (buttonDownload_downloadTicket.isDisplayed() && buttonDownload_downloadTicket.isEnabled()) {
                HighlightElement.highlightElement(buttonDownload_downloadTicket);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonDownload_downloadTicket);
//                Thread.sleep(4000);
                driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

                if (validationFileUpload.isDisplayed()) {
                    String warnMessage = validationFileUpload.getText();
                    if (warnMessage.equalsIgnoreCase("File not available.")){
                        System.out.println("WARNING:Uploaded File is not available/supported.");
                    }
                } else {
                    System.out.println("SUCCESS:Uploaded File is downloaded successfully.");
                }
            } else {
                if (noDataAvailable.isDisplayed()) {
                    Assert.assertEquals(noDataAvailable.getText(),"No data available in table");
                    System.out.println("No data available in table");
                } else {
                    System.out.println("Error while capturing data..No data available in table..");
                }
            }
            HighlightElement.highlightElement(objGenericLocator.searchBar);
            objGenericLocator.searchBar.clear();
            objGenericLocator.searchBar.sendKeys(Constants.strDate);
            Thread.sleep(3000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}