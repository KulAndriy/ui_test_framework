package wrapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementsWrapper {
    public static Actions actions;

    public static void actionClick(WebElement element){
       actions = new Actions(DriverWrapper.getDriver());
        if (WaitWrapper.waitForElementVisible(element).isDisplayed()) {
            actions.moveToElement(element).click().perform();
        }
    }


}
