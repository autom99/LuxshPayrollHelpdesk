package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Payroll_HelpDesk_page_TicketListingLocator {
    WebDriver driver;
    WebDriverWait wait;

    public Payroll_HelpDesk_page_TicketListingLocator(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    @FindBy(xpath = "//li[@id=\"link-Ticket\"]")
    private WebElement link_Ticket;

    @FindBy(xpath = "//li[@id='link-TicketListing']//a[contains(@class,'nav-link')]")
    private WebElement link_TicketListing;

    @FindBy(xpath = "//select[@id='status_type']")
    private WebElement filter_status_type;

    @FindBy(xpath = "//input[@class='form-control input-sm input-small input-inline']")
    private WebElement searchBar;

    @FindBy(xpath = "//input[contains(@class,'btn-sm')]")
    private WebElement buttonSearch;

    //---------------------------------------------------------------------------------------------------------------------
    @FindBy(xpath = "//a[@href ='/Home/Index']")
    private WebElement logo_img;

    @FindBy(xpath = "//ul[@class =\"pagination\"]")
    private WebElement pagination;

    @FindBy(xpath = "//div[@id='tblticket_paginate']")
    private WebElement paginationTicketListingPage;

    @FindBy(xpath = "//a[@title =\"Next\"]")
    private WebElement buttonNext_PageNumber;

    @FindBy(xpath = "//a[@title =\"Prev\"]")
    private WebElement buttonPrev_PageNumber;

    @FindBy(xpath = "//li[@class=\"prev disabled\"]")
    private WebElement buttonPrev_disabled;

    @FindBy(xpath = "//li[@class='next disabled']")
    private WebElement buttonNext_disabled;

    @FindBy(xpath = "//li[@class=\"active\"]")
    private WebElement buttonActive_SelectedPageNumber;

    @FindBy(xpath = "//a[contains(text(),'2')]")
    private WebElement PageNumber;

    @FindBy(xpath = "//select[contains(@name,'tblticket')]")
    private WebElement NumberOfRecordsPerPage;

    //---------------------------------------------------------------------------------------------------------------------

    /**
     * TESTCASE MEHOD-1: searchByStatusTicketListing
     *
     * @param searchText: searchText
     */
    public void searchByStatusTicketListing(String searchText) {

        try {
            link_Ticket.click();
            Thread.sleep(1000);

            link_TicketListing.click();
            Thread.sleep(1000);

            filter_status_type.click();
            Select selectfilter_status_type = new Select(filter_status_type);
            selectfilter_status_type.selectByVisibleText(searchText);
            Thread.sleep(1000);

            buttonSearch.click();
            Thread.sleep(1000);

            //Pagination
            if (pagination.isDisplayed()) {
                NumberOfRecordsPerPage.click();
                Select selectNumberOfPages = new Select(NumberOfRecordsPerPage);
                selectNumberOfPages.selectByVisibleText("25");
                Thread.sleep(2000);

                buttonNext_PageNumber.click();
                Thread.sleep(2000);

                buttonNext_PageNumber.click();
                Thread.sleep(2000);

//				buttonActive_SelectedPageNumber.click();
//				Thread.sleep(2000);

                buttonPrev_PageNumber.click();
                Thread.sleep(2000);
                
                //Navigate to the Dashboard Page
                logo_img.click();
                Thread.sleep(4000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
