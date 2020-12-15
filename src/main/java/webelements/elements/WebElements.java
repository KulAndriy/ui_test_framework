package webelements.elements;

import interfaces.elements.IElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import webdriver.DriverWrapper;
import utils.WaitHelper;

public class WebElements implements IElement {
    public static Actions actions;

    public static void actionClick(WebElement element){
       actions = new Actions(DriverWrapper.getDriver());
        if (WaitHelper.waitForElementVisible(element).isDisplayed()) {
            actions.moveToElement(element).click().perform();
        }
    }


}
