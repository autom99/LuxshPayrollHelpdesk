package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Payroll_HelpDesk_page_UserLocator {

	WebDriver driver;
	WebDriverWait wait;

	public Payroll_HelpDesk_page_UserLocator(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	@FindBy(xpath = "//li[@id='link-User']//a[@class='nav-link nav-toggle']")
	private WebElement link_User;
	
	@FindBy(xpath = "//a[contains(@class,'btn-sm')]")
	private WebElement buttonAddUser;
		
	@FindBy(xpath = "//input[contains(@class,'form-control input-sm input-small input-inline')]")
	private WebElement searchBar;
	
	@FindBy(xpath = "//select[@id='customgroupForAdd']") //TestGroupName
	private WebElement SelectGroup;
	
	@FindBy(xpath = "//input[@id='emp_code']")
	private WebElement EmployeeCode;
	
	@FindBy(xpath = "//input[@id='FullName']")
	private WebElement EmployeeName;
	
	@FindBy(xpath = "//select[@id='userType']")
	private WebElement SelectUserType;
	
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement Email;

	@FindBy(xpath = "//input[@id='Password']")
	private WebElement Password;
		
	@FindBy(xpath = "//div[contains(@class,'col-md-6')]//div[contains(@class,'md-checkbox-inline')]//div[contains(@class,'md-checkbox')]")
	private WebElement Active_checkbox;
	
	@FindBy(xpath = "//div[@id='editticket']//button[contains(@class,'btn btn-danger')][contains(text(),'Cancel')]")
	private WebElement buttonCancel;
	
	@FindBy(xpath = "//div[@id='editticket']//button[contains(@class,'btn green')][contains(text(),'Save')]")
	private WebElement buttonSave;
	
	@FindBy(xpath = "//div[@id='editticket']//button[contains(@class,'close')][contains(text(),'X')]")
	private WebElement buttonX;
	
	@FindBy(xpath = "//select[contains(@name,'tblusers_length')]")
	private WebElement NumberOfPages;
	
	@FindBy(xpath = "//a[contains(text(),'1')]")
	private WebElement PageNumber;
	
	//----------------------------------EDIT---------------------------------------------------
	@FindBy(xpath = "//button[@class='btn text-primary btn-sm edit_btn mr-1']")
	private WebElement editIconButton;
	
	@FindBy(xpath = "//select[@id='customgroupForEdit']") //TestGroupName
	private WebElement edit_SelectGroup;
	
	@FindBy(xpath = "//input[@id='emp_codeForEdit']")
	private WebElement edit_EmployeeCode;
	
	@FindBy(xpath = "//input[@id='FullNameForEdit']")
	private WebElement edit_EmployeeName;
	
	@FindBy(xpath = "//select[@id='userTypeForEdit']")
	private WebElement edit_SelectUserType;
	
	@FindBy(xpath = "//input[@id='EmailForEdit']")
	private WebElement edit_Email;
	
	@FindBy(xpath = "//div[@id='editUser']//button[@class='btn btn-danger'][contains(text(),'Cancel')]")
	private WebElement edit_buttonCancel;
	
	@FindBy(xpath = "//div[@id='editUser']//button[@class='btn green'][contains(text(),'Save')]")
	private WebElement edit_buttonSave;
		
	//------------------------------------------------------------------------------------------
	
	/**TESTCASE METHOD: CREATE USER
	 * 
	 * @param GroupName
	 * @param EmpCode
	 * @param EmpName
	 * @param UserType
	 * @param EmailID
	 * @param PasswordEncText
	 */
	public void createUser(String GroupName,String EmpCode,String EmpName,String UserType,String EmailID,String PasswordEncText) {
		link_User.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		buttonAddUser.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		SelectGroup.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Select selectGroup = new Select(SelectGroup);
		selectGroup.selectByVisibleText(GroupName);		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		EmployeeCode.clear();
		EmployeeCode.sendKeys(EmpCode);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		EmployeeName.clear();
		EmployeeName.sendKeys(EmpName);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		SelectUserType.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Select selectUserType = new Select(SelectUserType);
		selectUserType.selectByVisibleText(UserType);		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Email.clear();
		Email.sendKeys(EmailID);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Password.clear();
		Password.sendKeys(PasswordEncText);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
		/*
		 * Active_checkbox.click(); try { Thread.sleep(1000); } catch
		 * (InterruptedException e) { e.printStackTrace(); }
		 */
		
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
		searchBar.sendKeys(EmpCode);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * TESTCASE METHOD : EDIT or MODIFY USER
	 * @param UpdatedGroupName
	 * @param UpdatedEmpCode
	 * @param UpdatedEmpName
	 * @param UpdatedUserType
	 * @param UpdatedEmailID
	 */
	public void editUser(String UpdatedGroupName,String UpdatedEmpCode,String UpdatedEmpName,String UpdatedUserType,String UpdatedEmailID) {
		
		editIconButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		
		edit_SelectGroup.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Select selectGroup = new Select(edit_SelectGroup);
		selectGroup.selectByVisibleText(UpdatedGroupName);		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		edit_EmployeeCode.clear();
		edit_EmployeeCode.sendKeys(UpdatedEmpCode);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		edit_EmployeeName.clear();
		edit_EmployeeName.sendKeys(UpdatedEmpName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		edit_SelectUserType.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Select selectUserType = new Select(edit_SelectUserType);
		selectUserType.selectByVisibleText(UpdatedUserType);		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		edit_Email.clear();
		edit_Email.sendKeys(UpdatedEmailID);
		try {
			Thread.sleep(2000);
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
