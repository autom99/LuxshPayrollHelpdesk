package pages;

import TestUtil.CheckBox;
import TestUtil.Constants;
import TestUtil.GenericUtil;
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
	public static GenericUtil genericUtil;
	public static Payroll_HelpDesk_page_GenericLocator objGenericLocator;
	public static Payroll_HelpDesk_page_CreateTicketLocator objCreateTicketLocator;
	public static HighlightElement objHighlightElement;

	public Payroll_HelpDesk_page_UserLocator(WebDriver driver) {
		TestBase.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	@FindBy(xpath = "//li[@id='link-User']//a[@class='nav-link nav-toggle']")
	public WebElement link_User;
	
	@FindBy(xpath = "//a[contains(@class,'btn-sm')]")
	public WebElement buttonAddUser;

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
	public WebElement editUser_buttonCancel;
	
	@FindBy(xpath = "//div[@id='editUser']//button[@class='btn green'][contains(text(),'Save')]")
	public WebElement editUser_buttonSave;

	@FindBy(xpath = "//div[contains(text(),'User updated successfully!')]")
	public WebElement updateSuccessMsgEditUser;
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
			//Init GenericUtil object with driver instance
			genericUtil = new GenericUtil();
			objHighlightElement = new HighlightElement();
			objGenericLocator= new Payroll_HelpDesk_page_GenericLocator(driver);

			HighlightElement.highlightElement(link_User);
			genericUtil.clickWithPause(link_User,1000);

			HighlightElement.highlightElement(buttonAddUser);
			genericUtil.clickWithPause(buttonAddUser,1000);

			HighlightElement.highlightElement(SelectGroup);
			genericUtil.clickWithPause(SelectGroup,1000);

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
			genericUtil.writeTextWithPause(Password,PasswordEncText,1000);

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

			wait.until(ExpectedConditions.visibilityOf(SuccessMsgAddUser));
//			Thread.sleep(4000);
			Assert.assertEquals(SuccessMsgAddUser.getText(),"User Added Successfully !");
			Thread.sleep(2000);

//			HighlightElement.highlightElement(objGenericLocator.NumberOfPages);
//			objGenericLocator.NumberOfPages.click();
//			Select selectNumberOfPages = new Select(objGenericLocator.NumberOfPages);
//			selectNumberOfPages.selectByVisibleText("100");
//			Thread.sleep(2000);
//
//			HighlightElement.highlightElement(objGenericLocator.PageNumber);
//			objGenericLocator.PageNumber.click();
//			Thread.sleep(2000);

			HighlightElement.highlightElement(objGenericLocator.searchBar);
			objGenericLocator.searchBar.clear();
			objGenericLocator.searchBar.sendKeys("test" + "@");
			System.out.println("TODAY'S DATE:	"+ Constants.strDate);
			Thread.sleep(3000);
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
			//Init GenericUtil object with driver instance
			genericUtil = new GenericUtil();
			Thread.sleep(3000);

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

			HighlightElement.highlightElement(editUser_buttonSave);
			editUser_buttonSave.click();
			Thread.sleep(3000);

			wait.until(ExpectedConditions.visibilityOf(updateSuccessMsgEditUser));
			Assert.assertEquals(updateSuccessMsgEditUser.getText(),"User updated successfully!");
			Thread.sleep(2000);

			HighlightElement.highlightElement(objGenericLocator.searchBar);
			objGenericLocator.searchBar.clear();
			objGenericLocator.searchBar.sendKeys(UpdatedEmpCode);
			Thread.sleep(4000);

			Assert.assertEquals(driver.getCurrentUrl(), Constants.BASEURL + "Home/Index");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
