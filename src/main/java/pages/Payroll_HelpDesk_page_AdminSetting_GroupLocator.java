package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.CheckBox;

public class Payroll_HelpDesk_page_AdminSetting_GroupLocator {

	public WebDriver driver;
	public static WebDriverWait wait;

	public static CheckBox objCheckBox = new CheckBox();
	
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
	@FindBy(xpath="//a[@href ='/Home/Index']")
	private WebElement logo_img;
	//---------------------------------------------------------------------------------------------------------------------

	/**TESTCASE METHOD: CREATE GROUP
	 * 
	 * @param GroupCode
	 * @param GroupName
	 * @param Note
	 */
	public void createGroup(String GroupCode,String GroupName,String Note) {

		try {
			link_AdminSettings.click();
			Thread.sleep(1000);

			link_Group.click();
			Thread.sleep(1000);

			buttonAddGroup.click();
			Thread.sleep(2000);

			Group_Code.clear();
			Group_Code.sendKeys(GroupCode);
			Thread.sleep(2000);

			Group_Name.clear();
			Group_Name.sendKeys(GroupName);
			Thread.sleep(1000);

			Notes.clear();
			Notes.sendKeys(Note);
			Thread.sleep(1000);

			try {
				objCheckBox.Select_The_Checkbox(Active_checkbox);
				Thread.sleep(1000);
				objCheckBox.DeSelect_The_Checkbox(Active_checkbox);
				Thread.sleep(1000);
				objCheckBox.Select_The_Checkbox(Active_checkbox);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			buttonSave.click();
			Thread.sleep(4000);

			NumberOfPages.click();
			Select selectNumberOfPages = new Select(NumberOfPages);
			selectNumberOfPages.selectByVisibleText("100");
			Thread.sleep(1000);

			PageNumber.click();
			Thread.sleep(1000);

			searchBar.clear();
			searchBar.sendKeys(GroupCode);
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

		try {
			editIconButton.click();
			Thread.sleep(1000);

			edit_Group_Code.clear();
			edit_Group_Code.sendKeys(UpdatedGroupCode);
			Thread.sleep(1000);

			edit_Group_Name.clear();
			edit_Group_Name.sendKeys(UpdatedGroupName);
			Thread.sleep(1000);

			edit_Notes.clear();
			edit_Notes.sendKeys(UpdatedNote);
			Thread.sleep(1000);

			edit_buttonSave.click();
			Thread.sleep(2000);

			searchBar.clear();
			searchBar.sendKeys(UpdatedGroupCode);
			Thread.sleep(3000);

			//Navigate to the Dashboard Page
			logo_img.click();
			Thread.sleep(4000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}