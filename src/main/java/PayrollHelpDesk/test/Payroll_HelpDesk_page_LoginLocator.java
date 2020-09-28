package PayrollHelpDesk.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Payroll_HelpDesk_page_LoginLocator {

	WebDriver driver;
	WebDriverWait wait;

	public Payroll_HelpDesk_page_LoginLocator(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	@FindBy(xpath = "//input[@id='emp_code']")
	private WebElement emp_code;

	@FindBy(xpath = "//input[@id='Password']")
	private WebElement Password;

	@FindBy(xpath="//label[@class='label-checkbox100']")
	private WebElement RememberMe;

	@FindBy(xpath="//a[@id='forgetPassword']")
	private WebElement forgetPassword;

	@FindBy(xpath="//button[@class='login100-form-btn']")
	private WebElement buttonLogin;

	@FindBy(xpath="//span[@class='username username-hide-on-mobile']")
	private WebElement usernameTitle;

	@FindBy(xpath="//a[@href ='/Account/SignOut']") 
	private WebElement buttonLogout;

	@FindBy(xpath="//span[@id='emp_code-error']")
	private WebElement emp_code_error;

	@FindBy(xpath="//span[@id='Password-error']")
	private WebElement Password_error;

	@FindBy(xpath="//span[@class=\"field-validation-error\"]")
	private WebElement erroMessage;

	/*	POSITIVE TESTCASE METHOD
	 * 
	 * @param username
	 * @param password
	 */
	public void validateLogin(String username,String password) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emp_code.clear();
		emp_code.sendKeys(username);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Password.clear();
		Password.sendKeys(password);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		RememberMe.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		buttonLogin.click();		

		Reporter.log("====Login Page Test====", true);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		usernameTitle.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (buttonLogout.isEnabled() && buttonLogout.isDisplayed()) {
			//System.out.println("Clicking on buttonLogout with using java script click");
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonLogout);
		} else {
			System.out.println("Unable to click on element");
		}

		/*
		 * JavascriptExecutor executor = (JavascriptExecutor)driver;
		 * executor.executeScript("arguments[0].click();", buttonLogout);
		 * buttonLogout.click();
		 */
	}

	/*	NEGATIVE TESTCASE METHOD
	 * 
	 * @param username
	 * @param password
	 */
	public void invalidLogin(String username,String password){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emp_code.clear();
		emp_code.sendKeys(username);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Password.clear();
		Password.sendKeys(password);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		RememberMe.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		buttonLogin.click();		

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		/* NEGATIVE TESTCASE-1	:Login Page-Empty Username & Password!	*/
		if ((emp_code_error.isDisplayed() && emp_code_error.getText() == "Please enter username!") && (Password_error.isDisplayed() && (Password_error.getText() == "Please enter password !"))) {			
			System.out.println("NEGATIVE TESTCASE-1	: Empty username & Password!");
		}

		/* NEGATIVE TESTCASE-2	:Login Page-Empty Username & valid password */
		if (emp_code_error.getText() == "Please enter username!" && (Password_error.getText() != "Please enter password !")) {
			System.out.println("NEGATIVE TESTCASE-2	: Empty username & valid password");
		}		

		/* NEGATIVE TESTCASE-3	:Login Page-Valid Username & Empty Password */
		if ((erroMessage.isDisplayed()) && 
				(!emp_code_error.isDisplayed() && (Password_error.getText() == "Please enter password !"))) {
			System.out.println("NEGATIVE TESTCASE-3	: Login Page-Valid Username & Empty Password");
		}

		/* NEGATIVE TESTCASE-4 :Login Page: Invalid Username & valid Password */
		if ((erroMessage.isDisplayed()) && 
				(emp_code_error.getText()=="Please enter username!" && !Password_error.isDisplayed())) {
			System.out.println("NEGATIVE TESTCASE-4 :Login Page: Invalid Username & valid Password");
		}

		//NEGATIVE TESTCASE-5	:Login Page: Valid Username & invalid Password
		if ((erroMessage.isDisplayed()) && 
				(!emp_code_error.isDisplayed() && Password_error.getText() == "Please enter password !")) {
			System.out.println("NEGATIVE TESTCASE-5	:Login Page: Valid Username & invalid Password");
		}

		//NEGATIVE TESTCASE-6	:Login Page: Invalid Username & invalid Password
		if ((erroMessage.isDisplayed()) && 
				(emp_code_error.getText()=="Please enter username!" && Password_error.getText() == "Please enter password !")) {
			System.out.println("NEGATIVE TESTCASE-6	:Login Page: Invalid Username & invalid Password");
		}		
				
		
		/*
		 * //String ErrorMessage =
		 * driver.findElement(By.className(“field-validation-error”)).getText(); String
		 * err = erroMessage.getText(); //Please enter username! if
		 * (err.contains("Please enter username!") ||
		 * err.contains("Please enter password !")) {
		 * 
		 * }
		 */




	}

}
