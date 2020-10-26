package base;

import TestUtil.CaptureScreenshot;
import TestUtil.Constants;
import TestUtil.WebEventListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Properties;

public class TestBaseNew {

    private WebDriver driver;
    private EventFiringWebDriver e_driver;
    private WebEventListener eventListener;
    private WebDriverWait wait;
    public int waitTime = 10;
    public static Properties ps;

    @BeforeClass()
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
		options.addArguments("-incognito");
        options.addArguments("start-maximized");

        System.setProperty("webdriver.chrome.driver", Constants.PROJECTPATH + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, waitTime);

        e_driver = new EventFiringWebDriver(driver);

        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;

        e_driver.manage().window().maximize();
        e_driver.get(Constants.BASEURL);
    }

   @Test
    public void testLogin()  {
        System.out.println("***** Executing Test Login ***** ");
        //Entering user name and clicking on next
        driver.findElement(By.xpath("//input[@id='emp_code']")).sendKeys("username");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Password']")));
        //Entering password and clicking on sign-in
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[@class='login100-form-btn']")).click();

        String exp_URL =  Constants.BASEURL + "Home/Index";
        String act_URL = driver.getCurrentUrl();
        Assert.assertEquals(act_URL, exp_URL);
        Reporter.log("SUCCESSFULLY login by Admin User", true);
    }

    @AfterClass()
    public void tearDown() {
        if (e_driver != null) {
            e_driver.quit();
        }
    }

    @AfterMethod
    public void captureScreenShot(ITestResult result){
        CaptureScreenshot.captureScreenshotForFailedTests(driver,result);
        CaptureScreenshot.captureScreenshotPassedTests(driver,result);
    }
}
