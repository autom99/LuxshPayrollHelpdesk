package TestUtil;

import base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HighlightElement extends TestBase {

    public static void highlightElement(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("arguments[0].setAttribute('style', 'background-color:hsla(9, 100%, 64%, 0.5);border: 5px DodgerBlue;');", element);
        jse.executeScript("arguments[0].setAttribute('style', 'border:4px solid DodgerBlue;');", element);
        try {
            Thread.sleep(500);
        }
        catch (Exception ex){
            ex.getStackTrace();
        }
        jse.executeScript("arguments[0].style.border=''", element);
    }
}
