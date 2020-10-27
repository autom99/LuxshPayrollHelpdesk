package TestUtil;

import base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HighlightElement extends TestBase {

    public static void highlightElement(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('style', 'border: 3px solid red;');", element);

        try {
            Thread.sleep(500);
        }
        catch (Exception ex){
            ex.getMessage();
        }
        jse.executeScript("arguments[0].style.border=''", element);
    }
}
