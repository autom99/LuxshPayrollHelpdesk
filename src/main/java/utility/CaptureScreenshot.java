package utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshot {

	public static void captureScreenshotFailedTests(WebDriver driver,String screenshotName) {
		try{
			// To create reference of TakesScreenshot
			TakesScreenshot screenshot = (TakesScreenshot)driver;

			// Call method to capture screenshot
			File src=screenshot.getScreenshotAs(OutputType.FILE);

			// Copy files to specific location 
			// result.getName() will return name of test case so that screenshot name will be same as test case name
			FileUtils.copyFile(src, new File("./Screenshots/"+ screenshotName +".png"));
			System.out.println("Successfully captured a screenshot");
		}catch (Exception e){
			System.out.println("Exception while taking screenshot "+e.getMessage());
		}
	}
}