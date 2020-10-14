package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Constants;

public class Payroll_HelpDesk_page_AssignATicketLocator {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public Payroll_HelpDesk_page_AssignATicketLocator(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    @FindBy(xpath = "//li[@id=\"link-Ticket\"]")
    private WebElement link_Ticket;

    @FindBy(xpath = "//span[contains(text(),'Assign A Ticket')]")
    private WebElement link_assignATicket;

    @FindBy(xpath = "//button[@title=\"Assign\"]")
    private WebElement assignIconButton;

    @FindBy(xpath = "//input[@class='form-control input-sm input-small input-inline']")
    private WebElement searchBar;

    @FindBy(xpath = "//input[contains(@class,'btn-sm')]")
    private WebElement buttonSearch;

    @FindBy(xpath = "//button[@title=\"Assign\"]")
    private WebElement buttonPencilIcon_AssignTicket;

    @FindBy(xpath = "//select[@id='ddlGroup']")
    private WebElement group;

    @FindBy(xpath = "//select[@id='ddlUser']")
    private WebElement users;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    private WebElement editSaveButton;

    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement editCancelButton;

    @FindBy(xpath = "//div[@id='dtpTargetCompletion']")
    private WebElement targetCompletionDate;

    @FindBy(xpath = "//h4[@id='editTicketNumber']")
    private WebElement headingAssignTicket;


    public void pendingTicketAssignToUser(String strGroup,String strUsers) {

        try {
            link_Ticket.click();
            Thread.sleep(1000);

            link_assignATicket.click();
            Thread.sleep(1000);

            searchBar.clear();
            searchBar.sendKeys(Constants.strDate);
            System.out.println("TODAY'S DATE: "+ Constants.strDate);
            Thread.sleep(3000);

            buttonPencilIcon_AssignTicket.click();
            Thread.sleep(3000);

            group.click();
            Select selectGroup = new Select(group);
            selectGroup.selectByVisibleText(strGroup);
            Thread.sleep(1000);

            users.click();
            Select selectUsers = new Select(users);
            selectUsers.selectByVisibleText(strUsers);
            Thread.sleep(1000);

            targetCompletionDate.click();
            Thread.sleep(1000);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        //http://209.97.130.115:8011/Ticket/TicketAssignListing
    }
}
