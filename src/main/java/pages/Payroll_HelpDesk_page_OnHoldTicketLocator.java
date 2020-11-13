package pages;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Payroll_HelpDesk_page_OnHoldTicketLocator  extends TestBase{

    public static WebDriverWait wait;

    public Payroll_HelpDesk_page_OnHoldTicketLocator(WebDriver driver){
        TestBase.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    @FindBy(xpath = "//li[@id='link-Ticket']")
    public WebElement link_Ticket;

    @FindBy(xpath = "//span[contains(text(),'Ticket On-Hold')]")
    public WebElement link_onHoldTicket;


}
