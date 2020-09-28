package testcase.payrollHelpDesk;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import PayrollHelpDesk.test.Payroll_HelpDesk_page_LoginLocator;

public class PayrollHelpDesk_LoginPageTests {

	public WebDriver driver;
	static Properties ps;

	Payroll_HelpDesk_page_LoginLocator objLoginPage;
	
	@BeforeTest
	public void initialBrowserDriver() throws InterruptedException {
		driver = TestBase.testBase();
	}

	//POSITIVE TESTCASE-1	:Login Page: verify Admin User type
	@Test(priority = 1)
	public void verifyAdminLogin() {

		objLoginPage = new Payroll_HelpDesk_page_LoginLocator(driver);		
		objLoginPage.validateLogin("testAdmin", "12345678");

		Reporter.log("POSITIVE TESTCASE-1	:Login Page: verify Admin User type", true);
		try { 
			Thread.sleep(4000); 
		} 
		catch (InterruptedException e) {
			e.printStackTrace(); 
		} 
	}

	//POSITIVE TESTCASE-2	:Login Page: verify Employee User type
	@Test(priority = 2)
	public void verifyEmployeeLogin() {

		objLoginPage = new Payroll_HelpDesk_page_LoginLocator(driver);		
		objLoginPage.validateLogin("testEmp", "12345678");

		Reporter.log("POSITIVE TESTCASE-2	:Login Page: verify Employee User type", true);
		try { 
			Thread.sleep(4000); 
		} 
		catch (InterruptedException e) {
			e.printStackTrace(); 
		} 
		//driver.close();
	}

	//POSITIVE TESTCASE-3	:Login Page: verify Normal User type
	@Test(priority = 3)	
	public void verifyUserLogin() {

		objLoginPage = new Payroll_HelpDesk_page_LoginLocator(driver);		
		objLoginPage.validateLogin("testUser", "12345678");

		Reporter.log("POSITIVE TESTCASE-3	:Login Page: verify Normal User type", true);
		try { 
			Thread.sleep(3000); 
		} 
		catch (InterruptedException e) {
			e.printStackTrace(); 
		} 
		//driver.close();
	}

	/*	
	@Test
	public void validateAllUsersLogin() {
		objLoginPage = new Payroll_HelpDesk_page_LoginLocator(driver);		

		try {
			FileInputStream fis = new FileInputStream("D:\\HARDIK\\LuxshHrUkSystem-master\\config.properties");
			ps = new Properties();
			ps.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}

		String userType = ps.getProperty("UserAdmin");		
		objLoginPage.validateLogin(userType,  "12345678");
		if (userType.equals("UserAdmin")) {
			objLoginPage.validateLogin(userType, "12345678");
		}


		Reporter.log("====Employee USER LoginPage Test====", true);

		try { 
			Thread.sleep(4000); 
		} 
		catch (InterruptedException e) {
			e.printStackTrace(); 
		} 

		String exp_URL = "http://209.97.130.115:8011/Home/Index";
		String act_URL = driver.getCurrentUrl(); Assert.assertEquals(act_URL,exp_URL);
		Reporter.log("====Employee USER Successfully login====", true);
	}

	 */

	@Test(priority = 4)
	public void EmptyUsernameEmptyPassword() {
		
		objLoginPage = new Payroll_HelpDesk_page_LoginLocator(driver);		
		objLoginPage.invalidLogin("", "");
		
		Reporter.log("NEGATIVE TESTCASE-1	:Login Page: Empty Username & Password!", true);
		try { 
			Thread.sleep(2000); 
		} 
		catch (InterruptedException e) {
			e.printStackTrace(); 
		} 

		//driver.close();
	}
	
	@Test(priority = 5)
	public void EmptyUsernameValidPassword() {
		
		objLoginPage = new Payroll_HelpDesk_page_LoginLocator(driver);		
		objLoginPage.invalidLogin("", "12345678");
		
		Reporter.log("NEGATIVE TESTCASE-2	:Login Page: Empty Username & valid Password", true);
		try { 
			Thread.sleep(2000); 
		} 
		catch (InterruptedException e) {
			e.printStackTrace(); 
		} 
		//driver.close();
	}
	
	@Test(priority = 6)
	public void ValidUsernameEmptyPassword() {
		
		objLoginPage = new Payroll_HelpDesk_page_LoginLocator(driver);
		objLoginPage.invalidLogin("testAdmin", "");
		
		Reporter.log("NEGATIVE TESTCASE-3	:Login Page: Valid Username & Empty Password", true);
		try { 
			Thread.sleep(2000); 
		} 
		catch (InterruptedException e) {
			e.printStackTrace(); 
		} 
		//driver.close();
	}
	

	//NEGATIVE TESTCASE-4	:Login Page: Invalid Username & valid Password
	@Test(priority = 7)
	public void InvalidUsernameValidPassword() {
		objLoginPage = new Payroll_HelpDesk_page_LoginLocator(driver);
		objLoginPage.invalidLogin("!@$~&", "12345678");
		
		Reporter.log("NEGATIVE TESTCASE-4	:Login Page: Invalid Username & valid Password", true);
		try { 
			Thread.sleep(2000); 
		} 
		catch (InterruptedException e) {
			e.printStackTrace(); 
		} 
		//driver.close();		
	}
	
	
	//NEGATIVE TESTCASE-5	:Login Page: Valid Username & invalid Password
	@Test(priority = 8)
	public void ValidUsernameInvalidPassword() {
		objLoginPage = new Payroll_HelpDesk_page_LoginLocator(driver);
		objLoginPage.invalidLogin("testAdmin", "!@$~&");
		
		Reporter.log("NEGATIVE TESTCASE-5	:Login Page: Valid Username & invalid Password", true);
		try { 
			Thread.sleep(2000); 
		} 
		catch (InterruptedException e) {
			e.printStackTrace(); 
		} 
		//driver.close();
	}

	//NEGATIVE TESTCASE-6	:Login Page: Invalid Username & invalid Password
	@Test(priority = 9)
	public void InvalidUsernameInvalidPassword() {
		objLoginPage = new Payroll_HelpDesk_page_LoginLocator(driver);
		objLoginPage.invalidLogin("!@$~&", "!@$~&");
		
		Reporter.log("NEGATIVE TESTCASE-6	:Login Page: Invalid Username & invalid Password", true);
		try { 
			Thread.sleep(2000); 
		} 
		catch (InterruptedException e) {
			e.printStackTrace(); 
		} 
		driver.close();
	}

	
	
	
	
}
