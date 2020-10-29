package pages;

import TestUtil.CheckBox;
import TestUtil.Constants;
import TestUtil.HighlightElement;
import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Payroll_HelpDesk_page_UserLocator extends TestBase {

	public static WebDriverWait wait;
	public static CheckBox objCheckBox;

	public Payroll_HelpDesk_page_UserLocator(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	@FindBy(xpath = "//span[contains(text(),'Dashboard')]")
	public WebElement link_Dashboard;

	@FindBy(xpath = "//li[@id='link-User']//a[@class='nav-link nav-toggle']")
	public WebElement link_User;
	
	@FindBy(xpath = "//a[contains(@class,'btn-sm')]")
	public WebElement buttonAddUser;
		
	@FindBy(xpath = "//input[contains(@class,'form-control input-sm input-small input-inline')]")
	public WebElement searchBar;
	
	@FindBy(xpath = "//select[@id='customgroupForAdd']") //TestGroupName
	public WebElement SelectGroup;
	
	@FindBy(xpath = "//input[@id='emp_code']")
	public WebElement EmployeeCode;
	
	@FindBy(xpath = "//input[@id='FullName']")
	public WebElement EmployeeName;
	
	@FindBy(xpath = "//select[@id='userType']")
	public WebElement SelectUserType;
	
	@FindBy(xpath = "//input[@id='Email']")
	public WebElement Email;

	@FindBy(xpath = "//input[@id='Password']")
	public WebElement Password;
		
	@FindBy(xpath = "//div[contains(@class,'col-md-6')]//div[contains(@class,'md-checkbox-inline')]//div[contains(@class,'md-checkbox')]")
	public WebElement Active_checkbox;
	
	@FindBy(xpath = "//div[@id='editticket']//button[contains(@class,'btn btn-danger')][contains(text(),'Cancel')]")
	public WebElement buttonCancel;
	
	@FindBy(xpath = "//div[@id='editticket']//button[contains(@class,'btn green')][contains(text(),'Save')]")
	public WebElement buttonSave;
	
	@FindBy(xpath = "//div[@id='editticket']//button[contains(@class,'close')][contains(text(),'X')]")
	public WebElement buttonX;
	
	@FindBy(xpath = "//select[contains(@name,'tblusers_length')]")
	public WebElement NumberOfPages;
	
	@FindBy(xpath = "//a[contains(text(),'1')]")
	public WebElement PageNumber;

	@FindBy(xpath = "//div[contains(text(),'User Added Successfully !')]")
	public WebElement SuccessMsgAddUser;

	//----------------------------------EDIT---------------------------------------------------
	@FindBy(xpath = "//button[@class='btn text-primary btn-sm edit_btn mr-1']")
	public WebElement editIconButton;
	
	@FindBy(xpath = "//select[@id='customgroupForEdit']") //TestGroupName
	public WebElement edit_SelectGroup;
	
	@FindBy(xpath = "//input[@id='emp_codeForEdit']")
	public WebElement edit_EmployeeCode;
	
	@FindBy(xpath = "//input[@id='FullNameForEdit']")
	public WebElement edit_EmployeeName;
	
	@FindBy(xpath = "//select[@id='userTypeForEdit']")
	public WebElement edit_SelectUserType;
	
	@FindBy(xpath = "//input[@id='EmailForEdit']")
	public WebElement edit_Email;
	
	@FindBy(xpath = "//div[@id='editUser']//button[@class='btn btn-danger'][contains(text(),'Cancel')]")
	public WebElement edit_buttonCancel;
	
	@FindBy(xpath = "//div[@id='editUser']//button[@class='btn green'][contains(text(),'Save')]")
	public WebElement edit_buttonSave;

	@FindBy(xpath = "//div[contains(text(),'User updated successfully!')]")
	public WebElement updateSuccessMsgEditUser;
	//-----------------------------------------------------------------------------------------------
	@FindBy(xpath="//a[@href ='/Home/Index']")
	public WebElement logo_img;
	//-----------------------------------------------------------------------------------------------

	/**TESTCASE METHOD: CREATE USER
	 * 
	 * @param GroupName = group name
	 * @param EmpCode = employee code
	 * @param EmpName = employee name
	 * @param UserType = user type
	 * @param EmailID = email
	 * @param PasswordEncText = password
	 */
	public void createUser(String GroupName,String EmpCode,String EmpName,String UserType,String EmailID,String PasswordEncText) {
		try {
			HighlightElement.highlightElement(link_User);
			link_User.click();
			Thread.sleep(1000);

			HighlightElement.highlightElement(buttonAddUser);
			buttonAddUser.click();
			Thread.sleep(1000);

			HighlightElement.highlightElement(SelectGroup);
			SelectGroup.click();
			Thread.sleep(1000);

			Select selectGroup = new Select(SelectGroup);
			selectGroup.selectByVisibleText(GroupName);
			Thread.sleep(1000);

			HighlightElement.highlightElement(EmployeeCode);
			EmployeeCode.clear();
			EmployeeCode.sendKeys(EmpCode);
			Thread.sleep(1000);

			HighlightElement.highlightElement(EmployeeName);
			EmployeeName.clear();
			EmployeeName.sendKeys(EmpName);
			Thread.sleep(1000);

			HighlightElement.highlightElement(SelectUserType);
			SelectUserType.click();
			Thread.sleep(1000);

			Select selectUserType = new Select(SelectUserType);
			selectUserType.selectByVisibleText(UserType);
			Thread.sleep(1000);

			HighlightElement.highlightElement(Email);
			Email.clear();
			Email.sendKeys(EmailID);
			Thread.sleep(1000);

			HighlightElement.highlightElement(Password);
			Password.clear();
			Password.sendKeys(PasswordEncText);
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
//			Thread.sleep(3000);

			wait.until(ExpectedConditions.visibilityOf(SuccessMsgAddUser));
			if (SuccessMsgAddUser.isDisplayed()){
				Assert.assertEquals(SuccessMsgAddUser.getText(),"User Added Successfully !");
			}

			HighlightElement.highlightElement(NumberOfPages);
			NumberOfPages.click();
			Select selectNumberOfPages = new Select(NumberOfPages);
			selectNumberOfPages.selectByVisibleText("100");
			Thread.sleep(2000);

			HighlightElement.highlightElement(PageNumber);
			PageNumber.click();
			Thread.sleep(2000);

			HighlightElement.highlightElement(searchBar);
			searchBar.clear();
			searchBar.sendKeys(EmpCode);
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * TESTCASE METHOD : EDIT or MODIFY USER
	 * @param UpdatedGroupName = updated group name
	 * @param UpdatedEmpCode = updated employee name
	 * @param UpdatedEmpName = updated employee name
	 * @param UpdatedUserType = updated user type
	 * @param UpdatedEmailID = updated email
	 */
	public void editUser(String UpdatedGroupName,String UpdatedEmpCode,String UpdatedEmpName,String UpdatedUserType,String UpdatedEmailID) {
		try {
			HighlightElement.highlightElement(editIconButton);
			editIconButton.click();
			Thread.sleep(3000);

			HighlightElement.highlightElement(edit_SelectGroup);
			edit_SelectGroup.click();
			Thread.sleep(2000);

			Select selectGroup = new Select(edit_SelectGroup);
			selectGroup.selectByVisibleText(UpdatedGroupName);
			Thread.sleep(2000);

			HighlightElement.highlightElement(edit_EmployeeCode);
			edit_EmployeeCode.clear();
			edit_EmployeeCode.sendKeys(UpdatedEmpCode);
			Thread.sleep(2000);

			HighlightElement.highlightElement(edit_EmployeeName);
			edit_EmployeeName.clear();
			edit_EmployeeName.sendKeys(UpdatedEmpName);
			Thread.sleep(2000);

			HighlightElement.highlightElement(edit_SelectUserType);
			edit_SelectUserType.click();
			Thread.sleep(2000);

			Select selectUserType = new Select(edit_SelectUserType);
			selectUserType.selectByVisibleText(UpdatedUserType);
			Thread.sleep(2000);

			HighlightElement.highlightElement(edit_Email);
			edit_Email.clear();
			edit_Email.sendKeys(UpdatedEmailID);
			Thread.sleep(2000);

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

			HighlightElement.highlightElement(edit_buttonSave);
			edit_buttonSave.click();
			Thread.sleep(3000);

			wait.until(ExpectedConditions.visibilityOf(updateSuccessMsgEditUser));
			if (updateSuccessMsgEditUser.isDisplayed()){
				Assert.assertEquals(updateSuccessMsgEditUser.getText(),"User updated successfully!");
			}

			HighlightElement.highlightElement(searchBar);
			searchBar.clear();
			searchBar.sendKeys(UpdatedEmpCode);
			Thread.sleep(4000);

			logo_img.click();
			Thread.sleep(4000);
			Assert.assertEquals(driver.getCurrentUrl(), Constants.BASEURL + "Home/Index");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
