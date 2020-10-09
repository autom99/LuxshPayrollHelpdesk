package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import utility.Constants;

public class Payroll_HelpDesk_page_DashboardLocator {
	WebDriver driver;
	WebDriverWait wait;

	public Payroll_HelpDesk_page_DashboardLocator(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);		
	}

	@FindBy(xpath = "//span[contains(text(),'Dashboard')]")
	private WebElement link_Dashboard;

	@FindBy(xpath = "//div[contains(text(),'All Tickets')]")
	private WebElement link_All_Tickets;

	@FindBy(xpath = "//div[@id='openTicket_div']")
	private WebElement link_Open_Tickets;

	@FindBy(xpath = "//div[@id='closeTicket_div']")
	private WebElement link_Closed_Tickets; 

	@FindBy(xpath = "//div[@id='onholdTicket_div']")
	private WebElement link_Onhold_Tickets;

	@FindBy(xpath = "//div[@id='reopenTicket_div']")
	private WebElement link_Reopen_Tickets;

	@FindBy(xpath = "//div[@id='assignMe_div']")
	private WebElement link_AssignMe;

	@FindBy(xpath = "//a[contains(text(),'Assign to Group ....')]")
	private WebElement link_Assign_to_Group;

	@FindBy(xpath = "//div[@id='pendingTicket_div']")
	private WebElement link_Pending_Tickets;

	@FindBy(xpath = "//*[@id=\"id-218\"]") 
	private WebElement link_chart_HighPriority;

	@FindBy(xpath = "//*[@id=\"id-253\"]") 
	private WebElement link_chart_MediumPriority;

	@FindBy(xpath = "//*[@id=\"id-287\"]") 
	private WebElement link_chart_LowPriority;

	@FindBy(xpath = "(//*[contains(text(),'High')])[3]") 
	private WebElement button_chart_HighPriority;

	@FindBy(xpath = "(//*[contains(text(),'Medium')])[2]") 
	private WebElement button_chart_MediumPriority;

	@FindBy(xpath = "(//*[contains(text(),'Low')])[2]") 
	private WebElement button_chart_LowPriority;

	@FindBy(xpath = "//a[@id='pnotification']") 
	private WebElement icon_bell_Notification;

	@FindBy(xpath = "//a[@id='pnotification']/..//i[@class='icon-settings']") 
	private WebElement icon_settings_Group;

	/**
	 * TESTCASE METHOD : DASHBOARD FUNCTIONALITY
	 */
	public void dashboardOperations() {
		navigateToAllTickets();
		driver.navigate().back();
		
		navigateToOpenTickets();
		driver.navigate().back();
		
		navigateToClosedTickets();
		driver.navigate().back();
		
		navigateToOnholdTickets();
		driver.navigate().back();
		
		navigateToReopenTickets();
		driver.navigate().back();
		
		navigateToMyTickets();
		driver.navigate().back();
		
		navigateToPendingTickets();
		driver.navigate().back();
		
		navigateByUrlAssignToGroup();
		driver.navigate().back();
		
		navigateIconSettingsGroup();
		driver.navigate().back();
		
		navigateIconBellNotification();
		driver.navigate().back();
		
		navigateHighPriority();
		driver.navigate().back();
		
		navigateMediumPriority();
		driver.navigate().back();
		
		navigateLowPriority();
		driver.navigate().back();
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
		String exp_URL =  Constants.BASEURL + "Ticket/TicketListing?status=all"; 
		String act_URL = driver.getCurrentUrl();
		Assert.assertEquals(act_URL, exp_URL);

		Reporter.log("Success: ALL TICKETS", true);
	}

	/**
	 * TESTCASE METHOD-3 : NAVIAGTE to OPEN TICKETS
	 */
	public void navigateToOpenTickets() {
		link_Open_Tickets.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String exp_URL =  Constants.BASEURL + "Ticket/TicketListing?status=open"; 
		String act_URL = driver.getCurrentUrl();
		Assert.assertEquals(act_URL, exp_URL);

		Reporter.log("Success: OPEN TICKETS", true);
	}

	/**
	 * TESTCASE METHOD-4 : NAVIAGTE to CLOSED TICKETS
	 */
	public void navigateToClosedTickets() {
		link_Closed_Tickets.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String exp_URL =  Constants.BASEURL + "Ticket/TicketListing?status=close"; 
		String act_URL = driver.getCurrentUrl();
		Assert.assertEquals(act_URL, exp_URL);

		Reporter.log("Success: CLOSED TICKETS", true);
	}

	/**
	 * TESTCASE METHOD-5 : NAVIAGTE to ON-HOLD TICKETS
	 */
	public void navigateToOnholdTickets() {

		link_Onhold_Tickets.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String exp_URL =  Constants.BASEURL + "Ticket/TicketListing?status=hold"; 
		String act_URL = driver.getCurrentUrl();
		Assert.assertEquals(act_URL, exp_URL);

		Reporter.log("Success: ON-HOLD TICKETS", true);
	}
	
	/**
	 * TESTCASE METHOD-6 : NAVIAGTE to RE-OPEN TICKETS
	 */
	public void navigateToReopenTickets() {

		link_Reopen_Tickets.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String exp_URL =  Constants.BASEURL + "Ticket/TicketListing?status=ReOpen"; 
		String act_URL = driver.getCurrentUrl();
		Assert.assertEquals(act_URL, exp_URL);

		Reporter.log("Success: RE-OPEN TICKETS", true);
	}

	/**
	 * TESTCASE METHOD-7 : NAVIAGTE to MY TICKETS / ASSIGNM-ME
	 */
	public void navigateToMyTickets() {

		link_AssignMe.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String exp_URL =  Constants.BASEURL + "Ticket/TicketListing?status=assigntome"; 
		String act_URL = driver.getCurrentUrl();
		Assert.assertEquals(act_URL, exp_URL);

		Reporter.log("Success: MY TICKETS", true);
	}

	/**
	 * TESTCASE METHOD-8 : NAVIAGTE to PENDING TICKETS
	 */
	public void navigateToPendingTickets() {
		link_Pending_Tickets.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String exp_URL =  Constants.BASEURL + "Ticket/TicketListing?status=pending"; 
		String act_URL = driver.getCurrentUrl();
		Assert.assertEquals(act_URL, exp_URL);

		Reporter.log("Success: PENDING TICKETS", true);
	}
	
	/**
	 * TESTCASE METHOD-9 : NAVIAGTE to ASSIGN-TO-GROUP
	 */
	public void navigateByUrlAssignToGroup() {
		link_Assign_to_Group.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String exp_URL =  Constants.BASEURL + "Ticket/TicketAssignListing"; 
		String act_URL = driver.getCurrentUrl();
		Assert.assertEquals(act_URL, exp_URL);

		Reporter.log("Success: ASSIGN-TO-GROUP BY URL NAVIGATED", true);
	}

	/**
	 * TESTCASE METHOD-10 : NAVIAGTE to ICON-SETTINGS-CUSTOM-GROUP
	 */
	public void navigateIconSettingsGroup() {
		icon_settings_Group.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String exp_URL =  Constants.BASEURL + "CustomGroup/ViewCustomGroups"; 
		String act_URL = driver.getCurrentUrl();
		Assert.assertEquals(act_URL, exp_URL);

		Reporter.log("Success: ICON-SETTINGS-CUSTOM-GROUP", true);
	}
	
	/**
	 * TESTCASE METHOD-11 : NAVIAGTE to ICON-BELL-NOTIFICATION
	 */
	public void navigateIconBellNotification() {
		icon_bell_Notification.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String exp_URL =  Constants.BASEURL + "Ticket/TicketListing?status=all"; 
		String act_URL = driver.getCurrentUrl();
		Assert.assertEquals(act_URL, exp_URL);

		Reporter.log("Success: ICON-BELL-NOTIFICATION", true);
	}
	
	/**
	 * TESTCASE METHOD-12 : NAVIAGTE from CHART to HIGH-PRIORITY LISTING
	 */
	public void navigateHighPriority() {
		button_chart_HighPriority.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String exp_URL =  Constants.BASEURL + "Ticket/TicketPriorityListing?priority=High"; 
		String act_URL = driver.getCurrentUrl();
		Assert.assertEquals(act_URL, exp_URL);

		Reporter.log("Success: ICON-BELL-NOTIFICATION", true);
	}
	
	/**
	 * TESTCASE METHOD-13 : NAVIAGTE from CHART to Medium-PRIORITY LISTING
	 */
	public void navigateMediumPriority() {
		button_chart_MediumPriority.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String exp_URL =  Constants.BASEURL + "Ticket/TicketPriorityListing?priority=Medium"; 
		String act_URL = driver.getCurrentUrl();
		Assert.assertEquals(act_URL, exp_URL);

		Reporter.log("Success: ICON-BELL-NOTIFICATION", true);
	}
	
	/**
	 * TESTCASE METHOD-14 : NAVIAGTE from CHART to Low-PRIORITY LISTING
	 */
	public void navigateLowPriority() {
		button_chart_LowPriority.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String exp_URL =  Constants.BASEURL + "Ticket/TicketPriorityListing?priority=Low"; 
		String act_URL = driver.getCurrentUrl();
		Assert.assertEquals(act_URL, exp_URL);

		Reporter.log("Success: ICON-BELL-NOTIFICATION", true);
	}
	
}
