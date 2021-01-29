package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.DriverWrapper;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class WaitHelper {

    private static final int PAGE_LOAD_TIME = 5;
    private static final int WAIT_ELEMENT_VISIBLE_TIME = 20;
    private static final int WAIT_ELEMENT_CLICKABLE_TIME = 10;
    private static final int IMPLICITLY_TIME = 5;


    public static void waitPageLoad(){
        DriverWrapper.getDriver().manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIME, TimeUnit.SECONDS);
    }

    public static void implicitlyWait(){
        DriverWrapper.getDriver().manage().timeouts().implicitlyWait(IMPLICITLY_TIME, SECONDS);
    }

    public static WebElement waitForElementVisible(WebElement element){
        new WebDriverWait(DriverWrapper.getDriver(), WAIT_ELEMENT_VISIBLE_TIME).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public static WebElement waitForElementClickable(WebElement element){
        new WebDriverWait(DriverWrapper.getDriver(), WAIT_ELEMENT_CLICKABLE_TIME).until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
}