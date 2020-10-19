package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utility.Constants;
import utility.WebEventListener;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBaseNew{

    private WebDriver driver;
    private EventFiringWebDriver e_driver;
    private WebEventListener eventListener;
    private WebDriverWait wait;
    public int waitTime = 10;
    public static Properties ps;

    @BeforeClass()
    public void setUp() {

        // Initializing instance of Firefox WebDriver
        System.setProperty("webdriver.chrome.driver", Constants.PROJECTPATH + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, waitTime);

        // Initializing EventFiringWebDriver using Firefox WebDriver instance
        e_driver = new EventFiringWebDriver(driver);

        // Now create object of EventListerHandler to register it with EventFiringWebDriver
        eventListener = new WebEventListener();
        e_driver.register(eventListener);

        e_driver.manage().window().maximize();
        e_driver.get(Constants.BASEURL);
    }

    @Test
    public void testLogin()  {
        System.out.println("***** Executing Test Login ***** ");
        //Entering user name and clicking on next
        e_driver.findElement(By.xpath("//input[@id='emp_code']")).sendKeys("username");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Password']")));
        //Entering password and clicking on sign-in
        e_driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("password");
        e_driver.findElement(By.xpath("//button[@class='login100-form-btn']")).click();

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

}
