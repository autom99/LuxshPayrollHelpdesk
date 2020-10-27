package pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import TestUtil.Constants;

public class Payroll_HelpDesk_page_CreateTicketLocator extends TestBase {

	public static WebDriverWait wait;

	public Payroll_HelpDesk_page_CreateTicketLocator(WebDriver driver) {
		Payroll_HelpDesk_page_CreateTicketLocator.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	@FindBy(xpath = "//span[contains(text(),'Dashboard')]")
	public WebElement link_Dashboard;

	@FindBy(xpath = "//li[@id=\"link-Ticket\"]")
	public WebElement link_Ticket;

	@FindBy(xpath = "//span[contains(text(),'Create A Ticket')]")
	public WebElement createTicket;

	@FindBy(xpath = "//input[@name='Requester']")
	public WebElement requester;

	@FindBy(xpath = "//select[@id='SubjectId']")
	public WebElement subject;

	@FindBy(xpath = "//select[@id='CatId']")
	public WebElement category;

	@FindBy(xpath = "//select[@id='Priority']")
	public WebElement Priority;

	@FindBy(xpath = "//textarea[@id='Description']")
	public WebElement Description;

	@FindBy(xpath = "//input[@id='file']")
	public WebElement file;

	@FindBy(xpath = "//input[@type='submit']")
	public WebElement buttonSubmit;

	@FindBy(xpath = "//input[@class=\"btn btn-danger valid\"]")
	public WebElement buttonCancel;

	//------------------------------------------------------------------------------------------
	@FindBy(xpath = "//div[@id='editticket']//button[contains(@class,'close')][contains(text(),'X')]")
	public WebElement buttonX;

	@FindBy(xpath = "//select[contains(@name,'tblticket_length')]")
	public WebElement NumberOfPages;

	@FindBy(xpath = "//a[contains(text(),'1')]")
	public WebElement PageNumber;

	@FindBy(xpath = "//input[contains(@class,'form-control input-sm input-small input-inline')]")
	public WebElement searchBar;
	//----------------------------------EDIT---------------------------------------------------
	@FindBy(xpath = "//button[@class='btn text-primary btn-sm edit_btn mr-1'][2]")
	public WebElement editIconButton;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	public WebElement editSaveButton;
	//------------------------------------------------------------------------------------------
	
	/**
	 * TESTCASE METHOD: Create Ticket
	 * @param strSubject = subject
	 * @param strCategory = category
	 * @param strPriority = priority
	 * @param strDescription = description
	 */
	public void createTicket(String strSubject,String strCategory,String strPriority,String strDescription){
		try {
//			link_Dashboard.click();
//			Thread.sleep(1000);

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
	 * TESTCASE METHOD: MODIFY or EDIT Ticket
	 * @param UpdatedSubject = subject
	 * @param UpdatedCategory = category
	 * @param UpdatedPriority = priority
	 * @param UpdatedDescription = description
	 */
	public void ediTicket(String UpdatedSubject,String UpdatedCategory,String UpdatedPriority,String UpdatedDescription){
		try {
			editIconButton.click();
			Thread.sleep(4000);

//			buttonX.click();
//			Thread.sleep(2000);
//
//			editIconButton.click();
//			Thread.sleep(4000);

			subject.click();
			Select selectSubject = new Select(subject);
			selectSubject.selectByVisibleText(UpdatedSubject);
			Thread.sleep(2000);

			category.click();
			Select selectCategory = new Select(category);
			selectCategory.selectByVisibleText(UpdatedCategory);
			Thread.sleep(2000);

			Priority.click();
			Select selectPriority = new Select(Priority);
			selectPriority.selectByVisibleText(UpdatedPriority);
			Thread.sleep(2000);

			Description.clear();
			Description.sendKeys(UpdatedDescription);
			Thread.sleep(2000);

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
			Thread.sleep(4000);
			System.out.println("SUCCESSFULLY Updated Ticket.!");

			searchBar.clear();
			searchBar.sendKeys(Constants.strDate);
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
