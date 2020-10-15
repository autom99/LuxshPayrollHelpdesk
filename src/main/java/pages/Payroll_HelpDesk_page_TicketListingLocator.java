package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Constants;

public class Payroll_HelpDesk_page_TicketListingLocator {

	public  static WebDriver driver;
	public  static WebDriverWait wait;

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

    //------------------------------------------------------------------------------------------------------------------
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

    //---------------------------------View Ticket----------------------------------------------------------------------
	@FindBy(xpath = "//button[@title=\"View Ticket History\"]")
	private WebElement buttonEye_viewTicket;

	@FindBy(xpath = "//select[@id='ticketStatus']")
	private WebElement buttonEye_viewTicket_SelectStatus;

	@FindBy(xpath = "//textarea[@id='comments']")
	private WebElement comments;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement buttonSubmit;

	@FindBy(xpath = "//button[contains(text(),'Back')]")
	private WebElement buttonBack;

	//-----------------------------------Edit Ticket--------------------------------------------------------------------
	@FindBy(xpath = "//button[@title=\"Edit\"]")
	private WebElement buttonPencil_editTicket;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement editSaveButton;
	//-----------------------------------Download Ticket----------------------------------------------------------------
	@FindBy(xpath = "//button[@title=\"Download\"]")
	private WebElement buttonDownload_downloadTicket;

	//----------------------------------Delete Ticket-------------------------------------------------------------------
	@FindBy(xpath = "//button[@onclick=\"deleteTicket(); return false;\"]")
	private WebElement delete_YesButton;

	@FindBy(xpath = "//button[@title=\"Remove\"]")
	private WebElement buttonDustbin_deleteTicket;
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
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		buttonSearch.click();
		try {
			Thread.sleep(1000);
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
	 * @param searchText
	 */
	public void viewTicket(String searchText,String status,String strComments) throws InterruptedException {

		link_Ticket.click();
		Thread.sleep(1000);

		link_TicketListing.click();
		Thread.sleep(1000);

		searchBar.clear();
		searchBar.sendKeys(Constants.strDate);
//		System.out.println("TODAY'S DATE:	"+ Constants.strDate);
		Thread.sleep(3000);

		buttonEye_viewTicket.click();
		Thread.sleep(3000);

		buttonEye_viewTicket_SelectStatus.click();
		Select selectStatus = new Select(buttonEye_viewTicket_SelectStatus);
		selectStatus.selectByVisibleText(status);
		Thread.sleep(1000);

		comments.clear();
		comments.sendKeys(strComments);
		Thread.sleep(1000);

		buttonSubmit.click();
		Thread.sleep(3000);
	}

	/**
	 * TESTCASE MEHOD-3: DELETE TICKET
	 * @param searchText
	 */
	public void deleteTicket(String searchText) throws InterruptedException {

			link_Ticket.click();
			Thread.sleep(1000);

			link_TicketListing.click();
			Thread.sleep(1000);

			searchBar.clear();
			searchBar.sendKeys(Constants.strDate);
//			System.out.println("TODAY'S DATE:	"+ Constants.strDate);
			Thread.sleep(3000);

			buttonDustbin_deleteTicket.click();
			Thread.sleep(3000);

			delete_YesButton.click();
			Thread.sleep(3000);
	}

	/**
	 * TESTCASE MEHOD-4: DOWNLOAD TICKET
	 * @param searchText
	 */
	public void downloadTicket(String searchText) throws InterruptedException {

			link_Ticket.click();
			Thread.sleep(1000);

			link_TicketListing.click();
			Thread.sleep(1000);

			searchBar.clear();
			searchBar.sendKeys(Constants.strDate);
//			System.out.println("TODAY'S DATE:	"+ Constants.strDate);
			Thread.sleep(3000);

			buttonDownload_downloadTicket.click();
			Thread.sleep(3000);
	}
}