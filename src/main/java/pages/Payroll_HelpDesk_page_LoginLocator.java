package pages;

import TestUtil.Constants;
import TestUtil.GenericUtil;
import TestUtil.HighlightElement;
import base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Payroll_HelpDesk_page_LoginLocator extends TestBase {

    public static WebDriverWait wait;
    public static GenericUtil genericUtil;

    public Payroll_HelpDesk_page_LoginLocator(WebDriver driver) {
        TestBase.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    @FindBy(xpath = "//img[@src=\"/Login/images/LuxshTechnologiesLogo_2020.svg\"]")
    public WebElement logo_img;

    @FindBy(xpath = "//input[@id='emp_code']")
    public WebElement emp_code;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement Password;

    @FindBy(xpath = "//label[@class='label-checkbox100']")
    public WebElement RememberMe;

    @FindBy(xpath = "//a[@id='forgetPassword']")
    public WebElement forgetPassword;

    @FindBy(xpath = "//button[@class='login100-form-btn']")
    public WebElement buttonLogin;

    @FindBy(xpath = "//a[@href ='/Account/SignOut']")
    public WebElement buttonLogout;

    @FindBy(xpath = "//span[@id='emp_code-error']")
    public WebElement emp_code_error;

    @FindBy(xpath = "//span[@id='Password-error']")
    public WebElement Password_error;

    @FindBy(xpath = "//span[@class=\"field-validation-error\"]")
    public WebElement errorMessage;

    @FindBy(xpath = "//span[@class='username username-hide-on-mobile']")
    public WebElement usernameTitle;

    @FindBy(xpath = "//span[contains(text(),'Test Admin')]")
    public WebElement lblLoginUser;

    @FindBy(xpath = "//h1[contains(text(),'Welcome to Admin Panel')]")
    public WebElement headerTextAdminUser;

    @FindBy(xpath = "//h1[contains(text(),'Welcome to User Panel')]")
    public WebElement headerTextNormalUser;

    @FindBy(xpath = "//h1[contains(text(),'Welcome to Employee Panel')]")
    public WebElement headerTextEmployee;

    /**
     * POSITIVE TESTCASE METHOD
     *
     * @param username = Username
     * @param password = password
     */
    public void validateLogin(String username, String password) {
        //Init GenericUtil object with driver instance
        genericUtil = new GenericUtil();

        try {
//            wait.until(ExpectedConditions.visibilityOf(logo_img));
            genericUtil.pause(1000);
            HighlightElement.highlightElement(logo_img);
            Assert.assertTrue(logo_img.isDisplayed());

            HighlightElement.highlightElement(emp_code);
            emp_code.clear();
            emp_code.sendKeys(username);
            Thread.sleep(2000);

            HighlightElement.highlightElement(Password);
            Password.clear();
            Password.sendKeys(password);
            Thread.sleep(2000);

            HighlightElement.highlightElement(RememberMe);
            RememberMe.click();
            Thread.sleep(2000);

            HighlightElement.highlightElement(buttonLogin);
            buttonLogin.click();
            Thread.sleep(2000);

//            lblLoginUser.click();
//            Thread.sleep(2000);
//            String exp = usernameTitle.getText().trim().toLowerCase();
//            System.out.println("--------------------------------Expected String is : " + exp.trim());
//            System.out.println("--------------------------------Actual String is : " + username.trim());
//            Assert.assertEquals(exp.equalsIgnoreCase(username),exp.trim());
//            Thread.sleep(2000);

//            if (buttonLogout.isEnabled() && buttonLogout.isDisplayed()) {
//                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonLogout);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * NEGATIVE TESTCASE METHOD
     *
     * @param username = username
     * @param password = Password
     */
    public void invalidLogin(String username, String password) {
        try {
            emp_code.clear();
            emp_code.sendKeys(username);
            Thread.sleep(2000);

            Password.clear();
            Password.sendKeys(password);
            Thread.sleep(2000);

            RememberMe.click();
            Thread.sleep(1000);

            buttonLogin.click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * NEGATIVE TESTCASE-1 :Login Page-Empty username & Password!
     *
     * @param username = Username
     * @param password = password
     */
    public void validateEmptyUsernameEmptyPassword(String username, String password) {
        String expectedUrl = driver.getCurrentUrl();
        invalidLogin(username, password);

        if ((emp_code_error.isDisplayed() && emp_code_error.getText().equals("Please enter username!")) &&
                (Password_error.isDisplayed() && (Password_error.getText().equals("Please enter password !")))) {
            Assert.assertEquals(expectedUrl, Constants.BASEURL);
        }
    }

    /**
     * NEGATIVE TESTCASE-2	:Login Page: Empty Username & valid Password
     *
     * @param username = Username
     * @param password = password
     */
    public void validateEmptyUsernameValidPassword(String username, String password) {
        String expectedUrl = driver.getCurrentUrl();
        invalidLogin(username, password);

        if (emp_code_error.getText().equals("Please enter username!")) {
            Assert.assertEquals(expectedUrl, Constants.BASEURL);
        }
    }

    /**
     * NEGATIVE TESTCASE-3	:Login Page: Valid Username & Empty Password
     *
     * @param username = Username
     * @param password = password
     */
    public void verifyValidUsernameEmptyPassword(String username, String password) {
        String expectedUrl = driver.getCurrentUrl();
        invalidLogin(username, password);

        if ((errorMessage.isDisplayed()) && (Password_error.getText().equals("Please enter password !"))) {
            Assert.assertEquals(expectedUrl, Constants.BASEURL);
        }
    }

    /**
     * NEGATIVE TESTCASE-4	:Login Page: Invalid Username & valid Password
     *
     * @param username = Username
     * @param password = password
     */
    public void verifyInvalidUsernameValidPassword(String username, String password) {
        String expectedUrl = driver.getCurrentUrl();
        invalidLogin(username, password);

        Assert.assertEquals(expectedUrl, Constants.BASEURL);
    }

    /**
     * NEGATIVE TESTCASE-5	:Login Page: Valid Username & invalid Password
     *
     * @param username = Username
     * @param password = password
     */
    public void verifyValidUsernameInvalidPassword(String username, String password) {
        String expectedUrl = driver.getCurrentUrl();
        invalidLogin(username, password);

        Assert.assertEquals(expectedUrl, Constants.BASEURL);
    }

    /**
     * NEGATIVE TESTCASE-6	:Login Page: Invalid Username & invalid Password
     *
     * @param username = Username
     * @param password = password
     */
    public void verifyInvalidUsernameInvalidPassword(String username, String password) {
        String expectedUrl = driver.getCurrentUrl();
        invalidLogin(username, password);

        Assert.assertEquals(expectedUrl, Constants.BASEURL);
    }

    /**
     * verifyAdminLogin TESTCASE METHOD
     *
     * @param username = Username
     * @param password = password
     */
    public void verifyAdminLogin(String username, String password) {
        //Init GenericUtil object with driver instance
        genericUtil = new GenericUtil();

        try {
//            wait.until(ExpectedConditions.visibilityOf(logo_img));
            genericUtil.pause(1000);
//            HighlightElement.highlightElement(logo_img);
//            Assert.assertTrue(logo_img.isDisplayed());

            HighlightElement.highlightElement(emp_code);
            emp_code.clear();
            emp_code.sendKeys(username);
            Thread.sleep(2000);

            HighlightElement.highlightElement(Password);
            Password.clear();
            Password.sendKeys(password);
            Thread.sleep(2000);

            HighlightElement.highlightElement(RememberMe);
            RememberMe.click();
            Thread.sleep(2000);

            HighlightElement.highlightElement(buttonLogin);
            buttonLogin.click();
            Thread.sleep(4000);

            Assert.assertEquals(driver.getCurrentUrl(), Constants.BASEURL + "Home/Index");
            Reporter.log("SUCCESSFULLY redirected to the Admin page.", true);

//            Assert.assertEquals(lblLoginUser.getText().trim().toLowerCase(), username.toLowerCase());
//            Reporter.log("SUCCESSFULLY login by Admin User", true);

            Assert.assertEquals(headerTextAdminUser.getText(), "Welcome to Admin Panel");
            Reporter.log("SUCCESSFULLY redirected to the Admin Page.!", true);
            Thread.sleep(2000);

            Assert.assertEquals(driver.getTitle(), "Home Page - HelpDeskTicketing");
            Reporter.log("SUCCESSFULLY matched with the title.!", true);
            Thread.sleep(1000);

            System.out.println("username text is : " + usernameTitle.getText());
            HighlightElement.highlightElement(usernameTitle);
            usernameTitle.click();
            Thread.sleep(1000);

            logOut();
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyNormalUser(String username, String password) {
        //Init GenericUtil object with driver instance
        genericUtil = new GenericUtil();

        try {
            genericUtil.pause(1000);
//            wait.until(ExpectedConditions.visibilityOf(logo_img));
//            HighlightElement.highlightElement(logo_img);
//            Assert.assertTrue(logo_img.isDisplayed());

            HighlightElement.highlightElement(emp_code);
            emp_code.clear();
            emp_code.sendKeys(username);
            Thread.sleep(2000);

            HighlightElement.highlightElement(Password);
            Password.clear();
            Password.sendKeys(password);
            Thread.sleep(2000);

            HighlightElement.highlightElement(RememberMe);
            RememberMe.click();
            Thread.sleep(2000);

            HighlightElement.highlightElement(buttonLogin);
            buttonLogin.click();
            Thread.sleep(4000);

            String exp_URL = Constants.BASEURL + "Home/Index";
            String act_URL = driver.getCurrentUrl();
            Assert.assertEquals(act_URL, exp_URL);
            Reporter.log("SUCCESSFULLY User page is redirected.", true);

//            Assert.assertEquals(lblLoginUser.getText().trim().toLowerCase(),usernameTitle);
//            Reporter.log("SUCCESSFULLY login by Normal User", true);

            Assert.assertEquals(headerTextNormalUser.getText(), "Welcome to User Panel");
            Reporter.log("SUCCESSFULLY redirected to the Admin Page", true);
            Thread.sleep(2000);

            Assert.assertEquals(driver.getTitle(), "Home Page - HelpDeskTicketing");
            Reporter.log("SUCCESSFULLY matched with the title.!", true);
            Thread.sleep(2000);

            HighlightElement.highlightElement(usernameTitle);
            usernameTitle.click();
            Thread.sleep(2000);

            logOut();
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyEmployeeUser(String username, String password) {
        //Init GenericUtil object with driver instance
        genericUtil = new GenericUtil();

        try {
////            wait.until(ExpectedConditions.visibilityOf(logo_img));
            genericUtil.pause(1000);
//            HighlightElement.highlightElement(logo_img);
//            Assert.assertTrue(logo_img.isDisplayed());

            HighlightElement.highlightElement(emp_code);
            emp_code.clear();
            emp_code.sendKeys(username);
            Thread.sleep(2000);

            HighlightElement.highlightElement(Password);
            Password.clear();
            Password.sendKeys(password);
            Thread.sleep(2000);

            HighlightElement.highlightElement(RememberMe);
            RememberMe.click();
            Thread.sleep(2000);

            HighlightElement.highlightElement(buttonLogin);
            buttonLogin.click();
            Thread.sleep(4000);

            Assert.assertEquals(driver.getCurrentUrl(), Constants.BASEURL + "Home/Index");
            Reporter.log("SUCCESSFULLY Employee page is redirected.", true);

//            Assert.assertEquals(headerTextEmployee.getText().trim().toLowerCase(),username.toLowerCase());
//            Reporter.log("SUCCESSFULLY login by Employee User", true);

            Assert.assertEquals(headerTextEmployee.getText(), "Welcome to Employee Panel");
            Reporter.log("SUCCESSFULLY redirected to the Employee Page", true);
            Thread.sleep(2000);

            Assert.assertEquals(driver.getTitle(), "Home Page - HelpDeskTicketing");
            Reporter.log("SUCCESSFULLY matched with the title.!", true);
            Thread.sleep(1000);

            HighlightElement.highlightElement(usernameTitle);
            usernameTitle.click();
            Thread.sleep(2000);

            logOut();

            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * verifyForgotPassword TESTCASE METHOD
     *
     * @param username = Username
     */
    public void verifyForgotPassword(String username) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(logo_img));
        HighlightElement.highlightElement(logo_img);
        Assert.assertTrue(logo_img.isDisplayed());

        forgetPassword.click();
        Thread.sleep(4000);
        emp_code.clear();
        emp_code.sendKeys(username);
        Thread.sleep(2000);
    }

    /**
     * logOut method
     */
    public void logOut() {
        //Init GenericUtil object with driver instance
        genericUtil = new GenericUtil();

        try {
//            HighlightElement.highlightElement(usernameTitle);
//            genericUtil.clickWithPause(usernameTitle, 2000);

            if (buttonLogout.isDisplayed()) {
                HighlightElement.highlightElement(buttonLogout);
                wait.until(ExpectedConditions.visibilityOf(buttonLogout));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonLogout);
                genericUtil.pause(2000);
//                driver.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
