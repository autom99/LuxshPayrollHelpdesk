package pages;

import TestUtil.HighlightElement;
import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestUtil.CheckBox;
import org.testng.Assert;

import javax.xml.bind.Element;

public class Payroll_HelpDesk_page_AdminSetting_GroupLocator extends TestBase {

	public static WebDriverWait wait;
	public static CheckBox objCheckBox;

	public Payroll_HelpDesk_page_AdminSetting_GroupLocator(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	@FindBy(xpath = "//span[contains(text(),'Admin Settings')]")
	public WebElement link_AdminSettings;

	@FindBy(xpath = "//li[@id='link-CustomGroup']//a[contains(@class,'nav-link')]")
	public WebElement link_Group;

	@FindBy(xpath = "//a[contains(@class,'btn-sm')]")
	public WebElement buttonAddGroup;

	@FindBy(xpath = "//input[contains(@class,'form-control input-sm input-small input-inline')]")
	public WebElement searchBar;

	@FindBy(xpath = "//input[@id='Group_Code']")
	public WebElement Group_Code;

	@FindBy(xpath = "//input[@id='Group_Name']")
	public WebElement Group_Name;

	@FindBy(xpath = "//input[@id='Notes']")
	public WebElement Notes;

	@FindBy(xpath = "//div[@id='frmEmp']//div[contains(@class,'md-checkbox-inline')]//div[contains(@class,'md-checkbox')]")
	public WebElement Active_checkbox;

	@FindBy(xpath = "//div[@id='editticket']//button[contains(@class,'btn light btn-outline btn-danger')][contains(text(),'Cancel')]")
	public WebElement buttonCancel;

	@FindBy(xpath = "//div[@id='editticket']//button[contains(@class,'btn green')][contains(text(),'Save')]")
	public WebElement buttonSave;

	@FindBy(xpath = "//div[@id='editticket']//button[contains(@class,'close')][contains(text(),'X')]")
	public WebElement buttonX;

	@FindBy(xpath = "//select[contains(@name,'tblCustomGroups_length')]")
	public WebElement NumberOfPages;

	@FindBy(xpath = "//a[contains(text(),'1')]")
	public WebElement PageNumber;

	@FindBy(xpath = "//div[contains(text(),'Group added successfully!')]")
	public WebElement successMsgAddGroup;

	//----------------------------------EDIT---------------------------------------------------
	@FindBy(xpath = "//button[@class='btn text-primary btn-sm edit_btn mr-1']")
	public WebElement editIconButton;
	
	@FindBy(xpath = "//input[@id='Group_CodeForEdit']")
	public WebElement edit_Group_Code;

	@FindBy(xpath = "//input[@id='Group_NameForEdit']")
	public WebElement edit_Group_Name;

	@FindBy(xpath = "//input[@id='NotesForEdit']")
	public WebElement edit_Notes;
	
	@FindBy(xpath = "//div[@id='editCustomGroup']//button[@class='btn green'][contains(text(),'Save')]")
	public WebElement edit_buttonSave;
	
	@FindBy(xpath = "//div[@id='editCustomGroup']//button[@class='btn light btn-outline btn-danger'][contains(text(),'Cancel')]")
	public WebElement edit_buttonCancel;

	@FindBy(xpath = "//div[contains(text(),'CustomGroup updated successfully!')]")
	public WebElement updateSuccessMsgEditGroup;

	//-----------------------------------------------------------------------------------------------
	@FindBy(xpath="//a[@href ='/Home/Index']")
	public WebElement logo_img;
	//-----------------------------------------------------------------------------------------------

	/**TESTCASE METHOD: CREATE GROUP
	 * 
	 * @param GroupCode = group code
	 * @param GroupName = group name
	 * @param Note = note
	 */
	public void createGroup(String GroupCode,String GroupName,String Note) {
		try {
			HighlightElement.highlightElement(link_AdminSettings);
			link_AdminSettings.click();
			Thread.sleep(1000);

			HighlightElement.highlightElement(link_Group);
			link_Group.click();
			Thread.sleep(2000);

			HighlightElement.highlightElement(buttonAddGroup);
			buttonAddGroup.click();
			Thread.sleep(2000);

			HighlightElement.highlightElement(Group_Code);
			Group_Code.clear();
			Group_Code.sendKeys(GroupCode);
			Thread.sleep(2000);

			HighlightElement.highlightElement(Group_Name);
			Group_Name.clear();
			Group_Name.sendKeys(GroupName);
			Thread.sleep(1000);

			HighlightElement.highlightElement(Notes);
			Notes.clear();
			Notes.sendKeys(Note);
			Thread.sleep(1000);

			try {
				objCheckBox = new CheckBox();
				objCheckBox.Select_The_Checkbox(Active_checkbox);
				Thread.sleep(1000);
				objCheckBox.DeSelect_The_Checkbox(Active_checkbox);
				Thread.sleep(1000);
				objCheckBox.Select_The_Checkbox(Active_checkbox);
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}

			HighlightElement.highlightElement(buttonSave);
			buttonSave.click();
			Thread.sleep(4000);

//			wait.until(ExpectedConditions.visibilityOf(successMsgAddGroup));
			if (successMsgAddGroup.isDisplayed()){
				Assert.assertEquals(successMsgAddGroup.getText(),"Group added successfully!");
			}

			HighlightElement.highlightElement(NumberOfPages);
			NumberOfPages.click();
			Select selectNumberOfPages = new Select(NumberOfPages);
			selectNumberOfPages.selectByVisibleText("100");
			Thread.sleep(1000);

			HighlightElement.highlightElement(PageNumber);
			PageNumber.click();
			Thread.sleep(1000);

			HighlightElement.highlightElement(searchBar);
			searchBar.clear();
			searchBar.sendKeys(GroupCode);
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * TESTCASE METHOD-2: EDIT or MODIFY GROUP
	 * @param UpdatedGroupCode = updated group code
	 * @param UpdatedGroupName = updated group name
	 * @param UpdatedNote = updated note
	 */
	public void editGroup(String UpdatedGroupCode,String UpdatedGroupName,String UpdatedNote) {
		try {
			HighlightElement.highlightElement(editIconButton);
			editIconButton.click();
			Thread.sleep(1000);

			HighlightElement.highlightElement(edit_Group_Code);
			edit_Group_Code.clear();
			edit_Group_Code.sendKeys(UpdatedGroupCode);
			Thread.sleep(1000);

			HighlightElement.highlightElement(edit_Group_Name);
			edit_Group_Name.clear();
			edit_Group_Name.sendKeys(UpdatedGroupName);
			Thread.sleep(1000);

			HighlightElement.highlightElement(edit_Notes);
			edit_Notes.clear();
			edit_Notes.sendKeys(UpdatedNote);
			Thread.sleep(1000);

			HighlightElement.highlightElement(edit_buttonSave);
			edit_buttonSave.click();
			Thread.sleep(2000);

//			wait.until(ExpectedConditions.visibilityOf(updateSuccessMsgEditGroup));
			if (updateSuccessMsgEditGroup.isDisplayed()){
				Assert.assertEquals(updateSuccessMsgEditGroup.getText(),"CustomGroup updated successfully!");
			}

			HighlightElement.highlightElement(searchBar);
			searchBar.clear();
			searchBar.sendKeys(UpdatedGroupCode);
			Thread.sleep(3000);

			//Navigate to the Dashboard Page
			HighlightElement.highlightElement(logo_img);
			logo_img.click();
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}