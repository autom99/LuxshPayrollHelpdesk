package pages;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import bsh.Console;
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

	@FindBy(xpath = "//span[contains(text(),'Create Ticket')]")
	private WebElement createTicket; 

	@FindBy(xpath = "//input[@name='Requester']")
	private WebElement requester; //E001

	@FindBy(xpath = "//select[@id='SubjectId']")
	private WebElement subject; //General Query	

	@FindBy(xpath = "//select[@id='CatId']")
	private WebElement category; 

	@FindBy(xpath = "//select[@id='Priority']")
	private WebElement Priority; 

	@FindBy(xpath = "//textarea[@id='Description']")
	private WebElement Description; 

	@FindBy(xpath = "//input[@id='file']")
	private WebElement file; 

	//	@FindBy(xpath = "//input[@placeholder='Resume*']")
	//	private WebElement file; 

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement buttonSubmit; 

	@FindBy(xpath = "//input[@class=\"btn btn-danger valid\"]")
	private WebElement buttonCancel; 

	/**
	 * TESTCASE METOD: Create Ticket
	 * @param strSubject
	 * @param strCategory
	 * @param strPriority
	 * @param strDescription
	 * @throws IOException 
	 * @throws  
	 */
	public void createticket(String strSubject,String strCategory,String strPriority,String strDescription) throws InterruptedException, IOException {

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

		//subject.clear();
		subject.click();
		Select selectSubject = new Select(subject);
		selectSubject.selectByVisibleText(strSubject); //("General Query");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//category.clear();
		category.click();
		Select selectCategory = new Select(category);
		selectCategory.selectByVisibleText(strCategory); //("General Query");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//Priority.clear();
		Priority.click();
		Select selectPriority = new Select(Priority);
		selectPriority.selectByVisibleText(strPriority); //("Medium");
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

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", file);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		file.click();
		Runtime.getRuntime().exec(Constants.PROJECTPATH  +  File.separator + "helper" + File.separator +"fileUpload.exe");
		System.out.println(Constants.PROJECTPATH  +  File.separator + "helper" + File.separator +"fileUpload.exe");		
		Reporter.log(Constants.PROJECTPATH  +  File.separator + "helper" + File.separator +"fileUpload.exe");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		/* -----------ROBOT LOGIC-----------
		 * 
		 * StringSelection selection = new StringSelection(pathfileupload); Clipboard
		 * clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		 * clipboard.setContents(selection, selection);
		 * 
		 * try { Robot robot = new Robot(); robot.delay(200);
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.delay(100);
		 * robot.keyRelease(KeyEvent.VK_ENTER); robot.keyPress(KeyEvent.VK_CONTROL);
		 * robot.keyPress(KeyEvent.VK_V); robot.delay(100);
		 * robot.keyRelease(KeyEvent.VK_V); robot.keyRelease(KeyEvent.VK_CONTROL);
		 * robot.keyPress(KeyEvent.VK_TAB); robot.delay(100);
		 * robot.keyRelease(KeyEvent.VK_TAB); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.delay(100); robot.keyRelease(KeyEvent.VK_TAB);
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.delay(100);
		 * robot.keyRelease(KeyEvent.VK_ENTER); robot.delay(100); } catch (Exception e)
		 * { e.printStackTrace(); }
		 */		
				
		buttonSubmit.click();	

	}
}
