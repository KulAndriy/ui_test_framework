package wrapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitWrapper {

    public static void waitPageLoad(){
        DriverWrapper.getDriver().manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }

    public static void implicitlyWait(){
        DriverWrapper.getDriver().manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
    }

    public static WebElement waitForElementVisible(WebElement element){
        new WebDriverWait(DriverWrapper.getDriver(),10).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public static WebElement waitForElementClickable(WebElement element){
        new WebDriverWait(DriverWrapper.getDriver(), 10).until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
}
