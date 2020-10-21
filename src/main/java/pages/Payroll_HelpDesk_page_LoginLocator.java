package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import TestUtil.Constants;

public class Payroll_HelpDesk_page_LoginLocator {

    WebDriver driver;
    WebDriverWait wait;

    public Payroll_HelpDesk_page_LoginLocator(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    @FindBy(xpath = "//input[@id='emp_code']")
    WebElement emp_code;

    @FindBy(xpath = "//input[@id='Password']")
    WebElement Password;

    @FindBy(xpath = "//label[@class='label-checkbox100']")
    WebElement RememberMe;

    @FindBy(xpath = "//a[@id='forgetPassword']")
    WebElement forgetPassword;

    @FindBy(xpath = "//button[@class='login100-form-btn']")
    WebElement buttonLogin;

    @FindBy(xpath = "//span[@class='username username-hide-on-mobile']")
    WebElement usernameTitle;

    @FindBy(xpath = "//a[@href ='/Account/SignOut']")
    WebElement buttonLogout;

    @FindBy(xpath = "//span[@id='emp_code-error']")
    WebElement emp_code_error;

    @FindBy(xpath = "//span[@id='Password-error']")
    WebElement Password_error;

    @FindBy(xpath = "//span[@class=\"field-validation-error\"]")
    WebElement errorMessage;

    /**
     * POSITIVE TESTCASE METHOD
     *
     * @param username = Username
     * @param password = password
     */
    public void validateLogin(String username, String password) {
        try {
            emp_code.clear();
            emp_code.sendKeys(username);
            Thread.sleep(2000);

            Password.clear();
            Password.sendKeys(password);
            Thread.sleep(2000);

            RememberMe.click();
            Thread.sleep(2000);

            buttonLogin.click();
            Thread.sleep(2000);

            usernameTitle.click();
            Thread.sleep(2000);

            if (buttonLogout.isEnabled() && buttonLogout.isDisplayed()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonLogout);
            }
        } catch (InterruptedException e) {
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
        try {
            emp_code.clear();
            emp_code.sendKeys(username);
            Thread.sleep(2000);

            Password.clear();
            Password.sendKeys(password);
            Thread.sleep(2000);

            RememberMe.click();
            Thread.sleep(2000);

            buttonLogin.click();
            Thread.sleep(4000);

            String exp_URL = Constants.BASEURL + "Home/Index";
            String act_URL = driver.getCurrentUrl();
            Assert.assertEquals(act_URL, exp_URL);
            Reporter.log("SUCCESSFULLY login by Admin User", true);

            if (buttonLogout.isEnabled() && buttonLogout.isDisplayed()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonLogout);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * logOut method
     */
    public void logOut() {
        try {
            if (buttonLogout.isEnabled() && buttonLogout.isDisplayed()) {
                buttonLogout.click();
                Thread.sleep(2000);
            } else {
                System.out.println("Unable to click on element");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
