package webelements.elements;

import org.openqa.selenium.WebElement;
import utils.WaitHelper;

public class Input extends WebElements {

    protected WebElement element;

    public Input(WebElement element) {
        super(element);
        this.element = element;
    }


    public void clear() {
        if (WaitHelper.waitForElementVisible(element).isDisplayed()) {
            element.clear();
        }
    }
    public void write(String str) {
        element.sendKeys(str);
    }
}
