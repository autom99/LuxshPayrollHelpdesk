package demo;

import TestUtil.Constants;
import base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;

public class SS_Prac extends TestBase {

    WebDriver driver;

    @Test
    public void captureScreenshot() throws Exception {

        System.setProperty("webdriver.chrome.driver", Constants.PROJECTPATH + "\\drivers\\chromedriver.exe");

        // Initiate Firefox browser
        driver = new ChromeDriver();

        // Maximize the browser
        driver.manage().window().maximize();

        // Pass application url
        driver.get("http://www.gmail.com");

        // Here we are forcefully passing wrong id so that it will fail our testcase
        driver.findElement(By.xpath(".//*[@id='emailasdasdas']")).sendKeys("Learn Automation");
    }

    // It will execute after every test execution
    @AfterMethod
    public void tearDown(ITestResult result) {

        // Here will compare if test is failing then only it will enter into if condition
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
            // Create refernce of TakesScreenshot
                TakesScreenshot ts = (TakesScreenshot) driver;

            // Call method to capture screenshot
                File source = ts.getScreenshotAs(OutputType.FILE);

            // Copy files to specific location here it will save all screenshot in our project home directory and
            // result.getName() will return name of test case so that screenshot name will be same
                FileUtils.copyFile(source, new File("./Screenshots/" + result.getName() + ".png"));

                System.out.println("Screenshot taken");
            } catch (Exception e) {

                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
// close application
        driver.quit();
    }


}