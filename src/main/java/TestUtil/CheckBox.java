package TestUtil;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckBox {

	/**
	 * METHOD-1 :This method is used to Select a Checkbox, if it is not selected already
	 * @param element
	 */
	public void Select_The_Checkbox(WebElement element) {
		try {
			if (element.isSelected()) {
				System.out.println("Checkbox: " + element + "is already selected");
			} else {
				// Select the Checkbox
				HighlightElement.highlightElement(element);
				element.click();
			}
		} catch (Exception e) {
			System.out.println("Unable to select the checkbox: " + element);
		}
	}

	/**
	 * METHOD-2 :This method is used to De-select a Checkbox, if it is selected already
	 * @param element
	 */
	public void DeSelect_The_Checkbox(WebElement element) {
		try {
			if (element.isSelected()) {
				//De-select the Checkbox
				HighlightElement.highlightElement(element);
				element.click();
			} else {
				System.out.println("Checkbox: "+element+"is already deselected");
			}
		} catch (Exception e) {
			System.out.println("Unable to deselect checkbox: "+element);
		}
	}		

	/**
 * 	METHOD-3 : is used to select the checkbox with the specified value from multiple checkboxes.
 * @param element
 * @param valueToSelect
 */
	public void Select_The_CheckBox_from_List(WebElement element, String valueToSelect) {
		List<WebElement> allOptions = element.findElements(By.tagName("input"));
		for (WebElement option : allOptions) {
			System.out.println("Option value "+option.getText());
			if (valueToSelect.equals(option.getText())) {
				option.click();
				break;
			}
		}
	}


}

