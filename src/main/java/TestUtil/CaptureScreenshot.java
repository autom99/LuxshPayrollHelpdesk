package TestUtil;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class CaptureScreenshot {

	/**
	 * METHOD-1 All TESTS SCREENSHOT USING "ITestResult"
	 * 
	 * @param driver name of driver instance
	 * @param result name of the method
	 */
	public static void captureScreenshotAllTests(WebDriver driver,ITestResult result) {
		try{
			TakesScreenshot screenshot = (TakesScreenshot)driver;
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./Screenshots/All/"+ result.getName() + " On " + Constants.strDate + "_" + Constants.date.getTime() + ".png"));
			System.out.println("Successfully captured a screenshot");
		}catch (Exception e){
			System.out.println("Exception while taking screenshot "+e.getMessage());
		}
	}

	/**
	 * METHOD-2 ONLY FAILED TESTS USING "ITestResult"
	 * @param driver name of WebDriver instance
	 * @param result name of method
	 */
	public static void captureScreenshotForFailedTests(WebDriver driver, ITestResult result){
		if(ITestResult.FAILURE == result.getStatus()){
			try{
				TakesScreenshot screenshot = (TakesScreenshot)driver;
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("./Screenshots/"+ result.getName()
						+ " On " + Constants.strDate + "_" + Constants.date.getTime() + ".png"));
				System.out.println("Screenshot captured successfully.!");
			}catch (Exception e){
				System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
		}
	}

}