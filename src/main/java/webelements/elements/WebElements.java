package webelements.elements;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Select;
import webelements.IElement;
import org.openqa.selenium.interactions.Actions;
import webdriver.DriverWrapper;
import utils.WaitHelper;

import java.util.List;

public class WebElements extends RemoteWebElement implements IElement {
        private WebElement element;

    public WebElements(WebElement element) {
        this.element = element;
    }

    @Override
    public void click() {
        element.click();
    }

    public WebElement getElement(){
        return element;
    }
    public static void actionClick(WebElements element){
        Actions actions = new Actions(DriverWrapper.getDriver());
        if (WaitHelper.waitForElementVisible(element.getElement()).isDisplayed()) {
            actions.moveToElement(element.getElement()).click().perform();
        }
    }

    public void selectElementByValue(WebElements element, String value){
        if (WaitHelper.waitForElementClickable(element.getElement()).isDisplayed()) {
            Select selectedElement = new Select(element.getElement());
            selectedElement.selectByValue(value);
        }
    }
}
