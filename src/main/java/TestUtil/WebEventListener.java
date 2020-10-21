package TestUtil;

import base.TestBase;
import base.TestBaseNew;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class WebEventListener extends TestBase implements WebDriverEventListener {

    ITestResult testName;

    public void beforeAlertAccept(WebDriver driver) {

    }

    public void afterAlertAccept(WebDriver driver) {

    }

    public void afterAlertDismiss(WebDriver driver) {

    }

    public void beforeAlertDismiss(WebDriver driver) {

    }

    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Before navigating to: '" + url + "'");
    }

    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("Navigated to:'" + url + "'");
    }

    public void beforeChangeValueOf(WebElement element, WebDriver driver) {
        System.out.println("Value of the:" + element.toString()
                + " before any changes made");
    }

    public void afterChangeValueOf(WebElement element, WebDriver driver) {
        System.out.println("Element value changed to: " + element.toString());
    }

    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("Trying to click on: " + element.toString());
    }

    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("Clicked on: " + element.toString());
    }

    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    public void beforeNavigateBack(WebDriver driver) {
        System.out.println("Navigating back to previous page");
    }

    public void afterNavigateBack(WebDriver driver) {
        System.out.println("Navigated back to previous page");
    }

    public void beforeNavigateForward(WebDriver driver) {
        System.out.println("Navigating forward to next page");
    }

    public void afterNavigateForward(WebDriver driver) {
        System.out.println("Navigated forward to next page");
    }

    public void beforeNavigateRefresh(WebDriver driver) {

    }

    public void afterNavigateRefresh(WebDriver driver) {

    }

    public void onException(Throwable throwable, WebDriver driver) {
        try {
//            /* Take screenshot when exception happened. */
//            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//            /* save screenshot to file. */
//            FileUtils.copyFile(scrFile, new File("./Screenshots/Failed/"+ result.getName() + " On " + Constants.strDate + "_" + Constants.date.getTime() + ".png"));
            CaptureScreenshot.captureScreenshotForFailedTests(driver,testName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Exception occurred: " + throwable);
    }

    public <X> void beforeGetScreenshotAs(OutputType<X> target) {

    }

    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

    }

    public void beforeGetText(WebElement element, WebDriver driver) {

    }

    public void afterGetText(WebElement element, WebDriver driver, String text) {

    }

    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Trying to find Element By : " + by.toString());
    }

    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Found Element By : " + by.toString());
    }

    /*
     * non overridden methods of WebListener class
     */
    public void beforeScript(String script, WebDriver driver) {
    }

    public void afterScript(String script, WebDriver driver) {
    }

    public void beforeSwitchToWindow(String windowName, WebDriver driver) {

    }

    public void afterSwitchToWindow(String windowName, WebDriver driver) {

    }

//    public void onException(Throwable throwable, WebDriver driver) {
//
//        //            /* Take screenshot when exception happened. */
////            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
////            /* save screenshot to file. */
////            FileUtils.copyFile(scrFile, new File("./Screenshots/Failed/"+ result.getName() + " On " + Constants.strDate + "_" + Constants.date.getTime() + ".png"));
//        CaptureScreenshot.captureScreenshotForFailedTests(driver,result.getName());
//    }
}