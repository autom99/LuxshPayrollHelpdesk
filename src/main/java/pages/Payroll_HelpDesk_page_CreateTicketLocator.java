package pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import utility.Constants;

public class Payroll_HelpDesk_page_CreateTicketLocator {

	WebDriver driver;
	WebDriverWait wait;

	public Payroll_HelpDesk_page_CreateTicketLocator(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	@FindBy(xpath = "//li[@id=\"link-Ticket\"]")
	private WebElement link_Ticket; 

	@FindBy(xpath = "//span[contains(text(),'Create A Ticket')]")
	private WebElement createTicket; 

	@FindBy(xpath = "//input[@name='Requester']")
	private WebElement requester; 

	@FindBy(xpath = "//select[@id='SubjectId']")
	private WebElement subject; 	

	@FindBy(xpath = "//select[@id='CatId']")
	private WebElement category; 

	@FindBy(xpath = "//select[@id='Priority']")
	private WebElement Priority; 

	@FindBy(xpath = "//textarea[@id='Description']")
	private WebElement Description; 

	@FindBy(xpath = "//input[@id='file']")
	private WebElement file; 

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement buttonSubmit; 

	@FindBy(xpath = "//input[@class=\"btn btn-danger valid\"]")
	private WebElement buttonCancel; 

	//------------------------------------------------------------------------------------------
	@FindBy(xpath = "//div[@id='editticket']//button[contains(@class,'close')][contains(text(),'X')]")
	private WebElement buttonX;

	@FindBy(xpath = "//select[contains(@name,'tblticket_length')]")
	private WebElement NumberOfPages;

	@FindBy(xpath = "//a[contains(text(),'1')]")
	private WebElement PageNumber;

	@FindBy(xpath = "//input[contains(@class,'form-control input-sm input-small input-inline')]")
	private WebElement searchBar;
	//----------------------------------EDIT---------------------------------------------------
	@FindBy(xpath = "//button[@class='btn text-primary btn-sm edit_btn mr-1'][2]")
	private WebElement editIconButton;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement editSaveButton;
	//------------------------------------------------------------------------------------------
	
	/**
	 * TESTCASE METOD: Create Ticket
	 * @param strSubject
	 * @param strCategory
	 * @param strPriority
	 * @param strDescription
	 */
	public void createticket(String strSubject,String strCategory,String strPriority,String strDescription){
		link_Ticket.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		createTicket.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		subject.click();
		Select selectSubject = new Select(subject);
		selectSubject.selectByVisibleText(strSubject); 
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		category.click();
		Select selectCategory = new Select(category);
		selectCategory.selectByVisibleText(strCategory); 
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Priority.click();
		Select selectPriority = new Select(Priority);
		selectPriority.selectByVisibleText(strPriority); 
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Description.clear();
		Description.sendKeys(strDescription);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Actions action = new Actions(driver);
		action.moveToElement(file).click().build().perform();
		
		//-----------ROBOT CLASS LOGIC-----------		  
		StringSelection selection = new StringSelection(Constants.FILEUPLOADPATH);		
		//Constants.PROJECTPATH  +  File.separator + "helper" + File.separator + "testingPurpose" + File.separator + "Test PNG-1.png"
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, selection);

		try { 
			Robot robot = new Robot(); robot.delay(200);
			robot.keyPress(KeyEvent.VK_ENTER); robot.delay(100);
			robot.keyRelease(KeyEvent.VK_ENTER); robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V); robot.delay(100);
			robot.keyRelease(KeyEvent.VK_V); robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_TAB); robot.delay(100);
			robot.keyRelease(KeyEvent.VK_TAB); robot.keyPress(KeyEvent.VK_TAB);
			robot.delay(100); robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_ENTER); robot.delay(100);
			robot.keyRelease(KeyEvent.VK_ENTER); robot.delay(100); 
		} catch (Exception e){
			e.printStackTrace(); 
		}

		buttonSubmit.click();	
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String exp_URL =  Constants.BASEURL + "Ticket/TicketListing";
		String act_URL = driver.getCurrentUrl();
		Assert.assertEquals(act_URL, exp_URL);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Reporter.log("SUCCESSFULLY Created Ticket.!", true);

		NumberOfPages.click();
		Select selectNumberOfPages = new Select(NumberOfPages);
		selectNumberOfPages.selectByVisibleText("100");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		
		PageNumber.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		
		searchBar.clear();
		searchBar.sendKeys(Constants.strDate);
		System.out.println("TODAY'S DATE:	"+ Constants.strDate);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}


	/**
	 * TESTCASE METOD: MODIFY or EDIT Ticket
	 * @param UpdatedstrSubject
	 * @param UpdatedstrCategory
	 * @param UpdatedstrPriority
	 * @param UpdatedstrDescription
	 */
	public void ediTicket(String UpdatedstrSubject,String UpdatedstrCategory,String UpdatedstrPriority,String UpdatedstrDescription){

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		editIconButton.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		subject.click();
		Select selectSubject = new Select(subject);
		selectSubject.selectByVisibleText(UpdatedstrSubject); 
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		category.click();
		Select selectCategory = new Select(category);
		selectCategory.selectByVisibleText(UpdatedstrCategory); 
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Priority.click();
		Select selectPriority = new Select(Priority);
		selectPriority.selectByVisibleText(UpdatedstrPriority); 
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Description.clear();
		Description.sendKeys(UpdatedstrDescription);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Actions action = new Actions(driver);
		action.moveToElement(file).click().build().perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//-----------ROBOT CLASS LOGIC-----------		  
		StringSelection selection = new StringSelection(Constants.UPDATEDFILEUPLOADPATH);		
		//Constants.PROJECTPATH  +  File.separator + "helper" + File.separator + "testingPurpose" + File.separator + "Test PNG-1.png"
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, selection);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try { 
			Robot robot = new Robot(); robot.delay(200);
			robot.keyPress(KeyEvent.VK_ENTER); robot.delay(100);
			robot.keyRelease(KeyEvent.VK_ENTER); robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V); robot.delay(100);
			robot.keyRelease(KeyEvent.VK_V); robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_TAB); robot.delay(100);
			robot.keyRelease(KeyEvent.VK_TAB); robot.keyPress(KeyEvent.VK_TAB);
			robot.delay(100); robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_ENTER); robot.delay(100);
			robot.keyRelease(KeyEvent.VK_ENTER); robot.delay(100); 
		} catch (Exception e){
			e.printStackTrace(); 
		}

		editSaveButton.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String exp_URL =  Constants.BASEURL + "Ticket/TicketListing";
		String act_URL = driver.getCurrentUrl();
		Assert.assertEquals(act_URL, exp_URL);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("SUCCESSFULLY Updated Ticket.!");
	}
}
