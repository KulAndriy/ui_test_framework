package webelements.elements;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Select;
import webelements.IElement;
import org.openqa.selenium.interactions.Actions;
import webdriver.DriverWrapper;
import utils.WaitHelper;

public class WebElements extends RemoteWebElement implements IElement {
        private WebElement element;

    public WebElements(WebElement element) {
        this.element = element;
    }

    @Override
    public void click() {
            element.click();
//        }
    }

    public WebElement getElement(){
        return element;
    }

    public void actionClick(){
        Actions actions = new Actions(DriverWrapper.getDriver());
        WaitHelper.waitForElementClickable(element);
            actions.moveToElement(element).click().perform();

    }

    public void mouseHover(){
        Actions action = new Actions(DriverWrapper.getDriver());
        WaitHelper.waitForElementVisible(element);
            action.moveToElement(element).build().perform();
    }

    public void selectElementByValue(WebElements element, String value){
        if (WaitHelper.waitForElementClickable(element.getElement()).isDisplayed()) {
            Select selectedElement = new Select(element.getElement());
            selectedElement.selectByValue(value);
        }
    }
}
