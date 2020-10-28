package TestUtil;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GenericUtil extends TestBase {

    //Generic Click method
    public boolean click(WebElement elementToBeClicked) {
        try {
            elementToBeClicked.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    //Click Method
    public void click(By elementLocation) {
        driver.findElement(elementLocation).click();
    }

    //Write Text
    public void writeText(By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }

    //Read Text
    public String readText(By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }

    public void Select_The_Checkbox(WebElement element) {
        try {
            if (element.isSelected()) {
                System.out.println("Checkbox: " + element + "is already selected");
            } else {
                // Select the checkbox
                element.click();
            }
        } catch (Exception e) {
            System.out.println("Unable to select the checkbox: " + element);
        }

    }

    public void DeSelect_The_Checkbox(WebElement element) {
        try {
            if (element.isSelected()) {
                //De-select the checkbox
                element.click();
            } else {
                System.out.println("Checkbox: " + element + "is already deselected");
            }
        } catch (Exception e) {
            System.out.println("Unable to deselect checkbox: " + element);
        }
    }

    public void Select_The_CheckBox_from_List(WebElement element, String valueToSelect) {
        List<WebElement> allOptions = element.findElements(By.tagName("input"));
        for (WebElement option : allOptions) {
            System.out.println("Option value " + option.getText());
            if (valueToSelect.equals(option.getText())) {
                option.click();
                break;
            }
        }
    }

}

