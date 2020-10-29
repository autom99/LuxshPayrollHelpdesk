package pages;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Payroll_HelpDesk_page_GenericLocator extends TestBase {

    public static WebDriverWait wait;

    public Payroll_HelpDesk_page_GenericLocator(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    @FindBy(xpath = "//div[contains(text(),\"ERR_CONNECTION_TIMED_OUT\")]")
    public WebElement errorMessageNetwork;

    @FindBy(xpath="//a[@href ='/Home/Index']")
    public WebElement logoImage;

    @FindBy(xpath = "//span[@class='username username-hide-on-mobile']")
    public WebElement usernameTitle;

//---------------------DASHBOARD-----------------------------
    @FindBy(xpath = "//span[contains(text(),'Dashboard')]")
    public WebElement link_Dashboard;

//-----------------------SEARCH---------------------
    @FindBy(xpath = "//select[contains(@name,'tblticket_length')]")
    public WebElement NumberOfPages;

    @FindBy(xpath = "//a[contains(text(),'1')]")
    public WebElement PageNumber;

    @FindBy(xpath = "//input[contains(@class,'form-control input-sm input-small input-inline')]")
    public WebElement searchBar;

}
