package testcase.payrollHelpDesk;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PayrollHelpDesk.test.Payroll_HelpDesk_page_CreateTicketLocator;
import PayrollHelpDesk.test.Payroll_HelpDesk_page_LoginLocator;
import base.TestBase;
import utility.Constants;

public class PayrollHelpDesk_CreateTicketPageTests extends TestBase{

	public WebDriver driver;

	Payroll_HelpDesk_page_LoginLocator objLoginPage;
	PayrollHelpDesk_LoginPageTests objLoginTestpage;
	Payroll_HelpDesk_page_CreateTicketLocator objCreatePage;

	@BeforeTest
	public void initialBrowserDriver() throws InterruptedException {
		driver = TestBase.testBase();
	}
	
	@Test
	public void createTicket() throws InterruptedException, IOException {

		objLoginPage= new Payroll_HelpDesk_page_LoginLocator(driver);
		objLoginPage.verifyAdminLogin("testAdmin", "12345678");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String exp_URL = "http://209.97.130.115:8011/Home/Index";
		String act_URL = driver.getCurrentUrl();
		Assert.assertEquals(act_URL, exp_URL);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		objCreatePage = new Payroll_HelpDesk_page_CreateTicketLocator(driver);
		objCreatePage.createticket("General Query", "General Query", "High", "Test Description");
	}
	
	//AfterMethod annotation - This method executes after every test execution
	@AfterMethod 
	public void screenShot(ITestResult result){
	//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
		if(ITestResult.FAILURE == result.getStatus()){
			try{
				// To create reference of TakesScreenshot
				TakesScreenshot screenshot = (TakesScreenshot)driver;
				// Call method to capture screenshot
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				// Copy files to specific location 
				// result.getName() will return name of test case so that screenshot name will be same as test case name
				FileUtils.copyFile(src, new File("./Screenshots/"+ result.getName() + " On " + Constants.date.getTime() + ".png")); 
				System.out.println("Successfully captured a screenshot");
			}catch (Exception e){
				System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
	}
	driver.quit();
	}	
}
