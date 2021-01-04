package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.DriverWrapper;

import java.util.concurrent.TimeUnit;

public class WaitHelper {

    public static void waitPageLoad(){
        DriverWrapper.getDriver().manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }

    public static void implicitlyWait(){
        DriverWrapper.getDriver().manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
    }

    public static WebElement waitForElementVisible(WebElement element){
        new WebDriverWait(DriverWrapper.getDriver(),20).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public static WebElement waitForElementClickable(WebElement element){
        new WebDriverWait(DriverWrapper.getDriver(), 20).until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
}
