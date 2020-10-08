package PayrollHelpDesk.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Payroll_HelpDesk_page_AdminSetting_GroupLocator {

	WebDriver driver;
	WebDriverWait wait;

	public Payroll_HelpDesk_page_AdminSetting_GroupLocator(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	@FindBy(xpath = "//span[contains(text(),'Admin Settings')]")
	private WebElement link_AdminSettings;

	@FindBy(xpath = "//li[@id='link-CustomGroup']//a[contains(@class,'nav-link')]")
	private WebElement link_Group;

	@FindBy(xpath = "//a[contains(@class,'btn-sm')]")
	private WebElement buttonAddGroup;

	@FindBy(xpath = "//input[contains(@class,'form-control input-sm input-small input-inline')]")
	private WebElement searchBar;

	@FindBy(xpath = "//input[@id='Group_Code']")
	private WebElement Group_Code;

	@FindBy(xpath = "//input[@id='Group_Name']")
	private WebElement Group_Name;

	@FindBy(xpath = "//input[@id='Notes']")
	private WebElement Notes;

	@FindBy(xpath = "//div[@id='frmEmp']//div[contains(@class,'md-checkbox-inline')]//div[contains(@class,'md-checkbox')]")
	private WebElement Active_checkbox;

	@FindBy(xpath = "//div[@id='editticket']//button[contains(@class,'btn light btn-outline btn-danger')][contains(text(),'Cancel')]")
	private WebElement buttonCancel;

	@FindBy(xpath = "//div[@id='editticket']//button[contains(@class,'btn green')][contains(text(),'Save')]")
	private WebElement buttonSave;

	@FindBy(xpath = "//div[@id='editticket']//button[contains(@class,'close')][contains(text(),'X')]")
	private WebElement buttonX;

	@FindBy(xpath = "//select[contains(@name,'tblCustomGroups_length')]")
	private WebElement NumberOfPages;

	@FindBy(xpath = "//a[contains(text(),'1')]")
	private WebElement PageNumber;

	//----------------------------------EDIT---------------------------------------------------
	@FindBy(xpath = "//button[@class='btn text-primary btn-sm edit_btn mr-1']")
	private WebElement editIconButton;
	
	@FindBy(xpath = "//input[@id='Group_CodeForEdit']")
	private WebElement edit_Group_Code;

	@FindBy(xpath = "//input[@id='Group_NameForEdit']")
	private WebElement edit_Group_Name;

	@FindBy(xpath = "//input[@id='NotesForEdit']")
	private WebElement edit_Notes;
	
	@FindBy(xpath = "//div[@id='editCustomGroup']//button[@class='btn green'][contains(text(),'Save')]")
	private WebElement edit_buttonSave;
	
	@FindBy(xpath = "//div[@id='editCustomGroup']//button[@class='btn light btn-outline btn-danger'][contains(text(),'Cancel')]")
	private WebElement edit_buttonCancel;
	//---------------------------------------------------------------------------------------------------------------------
	
	/**TESTCASE METHOD: CREATE GROUP
	 * 
	 * @param GroupCode
	 * @param GroupName
	 * @param Notes
	 */
	public void createGroup(String GroupCode,String GroupName,String Note) {

		link_AdminSettings.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		link_Group.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		buttonAddGroup.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Group_Code.clear();
		Group_Code.sendKeys(GroupCode);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Group_Name.clear();
		Group_Name.sendKeys(GroupName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Notes.clear();
		Notes.sendKeys(Note);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		

		//		Active_checkbox.click();
		//		try {
		//			Thread.sleep(2000);
		//		} catch (InterruptedException e) {
		//			e.printStackTrace();
		//		}		

		buttonSave.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		

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
		searchBar.sendKeys(GroupCode);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * TESTCASE METHOD-2: EDIT or MODIFY GROUP
	 * @param UpdatedGroupCode
	 * @param UpdatedGroupName
	 * @param UpdatedNote
	 */
	public void editGroup(String UpdatedGroupCode,String UpdatedGroupName,String UpdatedNote) {
		
		editIconButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		edit_Group_Code.clear();
		edit_Group_Code.sendKeys(UpdatedGroupCode);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		edit_Group_Name.clear();
		edit_Group_Name.sendKeys(UpdatedGroupName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		edit_Notes.clear();
		edit_Notes.sendKeys(UpdatedNote);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		edit_buttonSave.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
}
