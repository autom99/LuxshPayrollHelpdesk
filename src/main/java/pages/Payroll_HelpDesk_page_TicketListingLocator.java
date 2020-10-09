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
	
	/**
	 * TESTCASE MEHOD-1: searchByStatusTicketListing
	 * @param searchText
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
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
