package pages;

import TestUtil.Constants;
import TestUtil.GenericUtil;
import TestUtil.HighlightElement;
import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Payroll_HelpDesk_page_CreateTicketLocator extends TestBase {

	public static WebDriverWait wait;
	public static Payroll_HelpDesk_page_GenericLocator objGenericLocator;
	public static GenericUtil genericUtil;

	public Payroll_HelpDesk_page_CreateTicketLocator(WebDriver driver) {
		Payroll_HelpDesk_page_CreateTicketLocator.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	@FindBy(xpath = "//li[@id='link-Ticket']")
	public WebElement link_Ticket;

	@FindBy(xpath = "//span[contains(text(),'Create A Ticket')]")
	public WebElement link_createTicket;

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

	@FindBy(xpath = "//div[contains(text(),'Ticket Added Successfully !')]")
	public WebElement SuccessMsgAddTicket;

	//------------------------------------------------------------------------------------------
	@FindBy(xpath = "//div[@id='editticket']//button[contains(@class,'close')][contains(text(),'X')]")
	public WebElement buttonX;
	//----------------------------------EDIT---------------------------------------------------
	@FindBy(xpath = "//button[@class='btn text-primary btn-sm edit_btn mr-1'][2]")
	public WebElement editIconButton;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	public WebElement editSaveButton;

	@FindBy(xpath = "//div[contains(text(),'Ticket Updated Successfully !')]")
	public WebElement UpdateMsgEditTicket;

	/**
	 * TESTCASE METHOD: Create Ticket
	 * @param strSubject = subject
	 * @param strCategory = category
	 * @param strPriority = priority
	 * @param strDescription = description
	 */
	public void createTicket(String strSubject,String strCategory,String strPriority,String strDescription){
		try {
			//Init GenericUtil object with driver instance
			genericUtil = new GenericUtil();

			objGenericLocator = new Payroll_HelpDesk_page_GenericLocator(driver);

			wait.until(ExpectedConditions.visibilityOf(link_Ticket));
			HighlightElement.highlightElement(link_Ticket);
			link_Ticket.click();
			Thread.sleep(1000);

			HighlightElement.highlightElement(link_createTicket);
			link_createTicket.click();
			Thread.sleep(1000);

//			Assert.assertEquals(usernameTitle.getText(),requester.getText());
//			System.out.println("usernameTitle.getText()---------" + usernameTitle.getText());
//			System.out.println("requester.getText()---------" + requester.getText());

			HighlightElement.highlightElement(subject);
			subject.click();
			Select selectSubject = new Select(subject);
			selectSubject.selectByVisibleText(strSubject);
			Thread.sleep(1000);

			HighlightElement.highlightElement(category);
			category.click();
			Select selectCategory = new Select(category);
			selectCategory.selectByVisibleText(strCategory);
			Thread.sleep(1000);

			HighlightElement.highlightElement(Priority);
			Priority.click();
			Select selectPriority = new Select(Priority);
			selectPriority.selectByVisibleText(strPriority);
			Thread.sleep(1000);

			HighlightElement.highlightElement(Description);
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

			HighlightElement.highlightElement(buttonSubmit);
			buttonSubmit.click();
			Thread.sleep(3000);

//			wait.until(ExpectedConditions.textToBePresentInElement(SuccessMsgAddTicket,"Ticket added successfully!"));
//			Assert.assertEquals(SuccessMsgAddTicket.getText(),"Ticket added successfully!");

			Assert.assertEquals(driver.getCurrentUrl(), Constants.BASEURL + "Ticket/TicketListing");
			Thread.sleep(2000);

			HighlightElement.highlightElement(objGenericLocator.NumberOfPages);
			objGenericLocator.NumberOfPages.click();
			Select selectNumberOfPages = new Select(objGenericLocator.NumberOfPages);
			selectNumberOfPages.selectByVisibleText("100");
			Thread.sleep(2000);

			HighlightElement.highlightElement(objGenericLocator.PageNumber);
			objGenericLocator.PageNumber.click();
			Thread.sleep(2000);

			HighlightElement.highlightElement(objGenericLocator.searchBar);
			objGenericLocator.searchBar.clear();
			objGenericLocator.searchBar.sendKeys(Constants.strDate);
			System.out.println("TODAY'S DATE:	"+ Constants.strDate);
			Thread.sleep(3000);
		} catch (Exception e) {
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
			//Init GenericUtil object with driver instance
			genericUtil = new GenericUtil();

			HighlightElement.highlightElement(objGenericLocator.searchBar);
			objGenericLocator.searchBar.clear();
			objGenericLocator.searchBar.sendKeys(Constants.strDate);
			Thread.sleep(3000);

			HighlightElement.highlightElement(editIconButton);
			editIconButton.click();
			Thread.sleep(4000);

			HighlightElement.highlightElement(subject);
			subject.click();
			Select selectSubject = new Select(subject);
			selectSubject.selectByVisibleText(UpdatedSubject);
			Thread.sleep(2000);

			HighlightElement.highlightElement(category);
			category.click();
			Select selectCategory = new Select(category);
			selectCategory.selectByVisibleText(UpdatedCategory);
			Thread.sleep(2000);

			HighlightElement.highlightElement(Priority);
			Priority.click();
			Select selectPriority = new Select(Priority);
			selectPriority.selectByVisibleText(UpdatedPriority);
			Thread.sleep(2000);

			HighlightElement.highlightElement(Description);
			Description.clear();
			Description.sendKeys(UpdatedDescription);
			Thread.sleep(2000);

			Actions action = new Actions(driver);
			action.moveToElement(file).click().build().perform();
			Thread.sleep(2000);

			//-----------FILE UPLOAD using ROBOT CLASS-----------
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

			HighlightElement.highlightElement(editSaveButton);
			editSaveButton.click();
//			Thread.sleep(2000);

			wait.until(ExpectedConditions.visibilityOf(UpdateMsgEditTicket));
			if (UpdateMsgEditTicket.isDisplayed()){
				Assert.assertEquals(UpdateMsgEditTicket.getText(),"Ticket Updated Successfully !");
			}

			Assert.assertEquals(driver.getCurrentUrl(), Constants.BASEURL + "Ticket/TicketListing");
			Thread.sleep(4000);

			HighlightElement.highlightElement(objGenericLocator.searchBar);
			objGenericLocator.searchBar.clear();
			objGenericLocator.searchBar.sendKeys(Constants.strDate);
			Thread.sleep(3000);

			genericUtil.clickWithPause(objGenericLocator.logoImage,3000);
			Assert.assertEquals(driver.getCurrentUrl(),Constants.BASEURL + "Home/Index");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
