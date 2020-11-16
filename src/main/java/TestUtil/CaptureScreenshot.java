package TestUtil;

import base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;

public class CaptureScreenshot extends TestBase {

	/**
	 * METHOD-1 Passed TESTS SCREENSHOT USING "ITestResult"
	 * 
	 * @param driver name of driver instance
	 * @param result name of the method
	 */
	public static void captureScreenshotPassedTests(WebDriver driver,ITestResult result) {
		if(ITestResult.SUCCESS == result.getStatus()){
			try{
				TakesScreenshot screenshot = (TakesScreenshot)driver;
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("./Screenshots/Passed/" + result.getName() + " On " + Constants.strDate + "_" + Constants.date.getTime() + ".png"));
				System.out.println("Successfully captured a screenshot");
			}catch (Exception e){
				System.out.println("Exception while taking screenshot "+e.getMessage());
			}
		}
	}

	/**
	 * METHOD-2 ONLY FAILED TESTS USING "ITestResult"
	 *
	 * @param result name of method
	 */
	public static void captureScreenshotForFailedTests(WebDriver driver,ITestResult result){
		if(ITestResult.FAILURE == result.getStatus()){
			try{
				TakesScreenshot screenshot = (TakesScreenshot)driver;
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("./Screenshots/Failed/"+ result.getName() + " On " + Constants.strDate + "_" + Constants.date.getTime() + ".png"));
				System.out.println("Screenshot captured successfully.!");
			}catch (Exception e){
				System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
		}
	}

}