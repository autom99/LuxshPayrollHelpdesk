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

	public  static WebDriver driver;
	public  static WebDriverWait wait;

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
	public void createTicket(String strSubject,String strCategory,String strPriority,String strDescription){
		try {
			link_Ticket.click();
			Thread.sleep(1000);

			createTicket.click();
			Thread.sleep(1000);

			subject.click();
			Select selectSubject = new Select(subject);
			selectSubject.selectByVisibleText(strSubject);
			Thread.sleep(1000);

			category.click();
			Select selectCategory = new Select(category);
			selectCategory.selectByVisibleText(strCategory);
			Thread.sleep(1000);

			Priority.click();
			Select selectPriority = new Select(Priority);
			selectPriority.selectByVisibleText(strPriority);
			Thread.sleep(1000);

			Description.clear();
			Description.sendKeys(strDescription);
			Thread.sleep(1000);

			Actions action = new Actions(driver);
			action.moveToElement(file).click().build().perform();
			Thread.sleep(2000);

			//-----------ROBOT CLASS LOGIC-----------
			StringSelection selection = new StringSelection(Constants.FILEUPLOADPATH);
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
			Thread.sleep(3000);

			String exp_URL =  Constants.BASEURL + "Ticket/TicketListing";
			String act_URL = driver.getCurrentUrl();
			Assert.assertEquals(act_URL, exp_URL);
			Thread.sleep(2000);
			Reporter.log("SUCCESSFULLY Created Ticket.!", true);

			NumberOfPages.click();
			Select selectNumberOfPages = new Select(NumberOfPages);
			selectNumberOfPages.selectByVisibleText("100");
			Thread.sleep(2000);

			PageNumber.click();
			Thread.sleep(2000);

			searchBar.clear();
			searchBar.sendKeys(Constants.strDate);
			System.out.println("TODAY'S DATE:	"+ Constants.strDate);
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * TESTCASE METOD: MODIFY or EDIT Ticket
	 * @param UpdatedSubject
	 * @param UpdatedCategory
	 * @param UpdatedPriority
	 * @param UpdatedDescription
	 */
	public void ediTicket(String UpdatedSubject,String UpdatedCategory,String UpdatedPriority,String UpdatedDescription){

		try {
			editIconButton.click();
			Thread.sleep(4000);

			subject.click();
			Select selectSubject = new Select(subject);
			selectSubject.selectByVisibleText(UpdatedSubject);
			Thread.sleep(1000);

			category.click();
			Select selectCategory = new Select(category);
			selectCategory.selectByVisibleText(UpdatedCategory);
			Thread.sleep(1000);

			Priority.click();
			Select selectPriority = new Select(Priority);
			selectPriority.selectByVisibleText(UpdatedPriority);
			Thread.sleep(1000);

			Description.clear();
			Description.sendKeys(UpdatedDescription);
			Thread.sleep(1000);

			Actions action = new Actions(driver);
			action.moveToElement(file).click().build().perform();
			Thread.sleep(2000);

			//-----------ROBOT CLASS LOGIC-----------
			StringSelection selection = new StringSelection(Constants.UPDATEDFILEUPLOADPATH);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(selection, selection);
			Thread.sleep(2000);

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
			Thread.sleep(4000);

			String exp_URL =  Constants.BASEURL + "Ticket/TicketListing";
			String act_URL = driver.getCurrentUrl();
			Assert.assertEquals(act_URL, exp_URL);
			Thread.sleep(2000);
			System.out.println("SUCCESSFULLY Updated Ticket.!");

			searchBar.clear();
			searchBar.sendKeys(Constants.strDate);
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
