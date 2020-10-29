package TestUtil;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GenericUtil extends TestBase {

    //Pause the scripts
    public void pause(Integer milliseconds){
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    //Generic Click method
    public boolean click(WebElement elementToBeClicked) {
        try {
            elementToBeClicked.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //Generic clickWithPause method
    public boolean clickWithPause(WebElement elementToBeClicked,Integer milliseconds) {
        try {
            elementToBeClicked.click();
            pause(milliseconds);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //Generic clearWithPause method
    public boolean clearWithPause(WebElement elementToBeCleared,Integer milliseconds) {
        try {
            elementToBeCleared.clear();
            pause(milliseconds);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //Write Text
    public void writeText(By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }

    //Write Text
    public void writeTextWithPause(WebElement elementToBeWritten, String text,Integer milliseconds) {
        try {
            elementToBeWritten.sendKeys(text);
            pause(milliseconds);
        }
        catch (Exception ex){
            ex.getStackTrace();
        }
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

    public static void highlightElement(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('style', 'border: 3px solid red;');", element);
        try {
            Thread.sleep(500);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        jse.executeScript("arguments[0].style.border=''", element);
    }

    public void assertEqualsWithPause(String actualOutput,String expectedOutput,Integer milliseconds){
        try {
            Assert.assertEquals(actualOutput,expectedOutput);
            pause(milliseconds);
        }
        catch (Exception ex){
            ex.getStackTrace();
        }
    }

    public void selectElementWithPause(WebElement elementToBeChoose,Select selectOption,String selectByVisibleText,Integer milliseconds){
        try {
            clickWithPause(elementToBeChoose,1000);
            Select selectGroup = new Select((WebElement) selectOption);
            selectGroup.selectByVisibleText(selectByVisibleText);
        }
        catch (Exception ex){
            ex.getStackTrace();
        }
    }

}

