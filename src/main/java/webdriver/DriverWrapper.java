package webdriver;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import webdriver.factory.DriverManagerFactory;
import webdriver.factory.DriverType;
import utils.WaitHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DriverWrapper {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static List<WebDriver> driversToCleanup = Collections.synchronizedList(new ArrayList());
    private static DriverManagerFactory driverManagerFactory = new DriverManagerFactory();

    @Step("Start '{driverType}' driver")
    public static void setDriver(DriverType driverType){
        driver.set(driverManagerFactory.getDriverManager(driverType).getDriverByType());
        WaitHelper.implicitlyWait();
        driversToCleanup.add(getDriver());
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    @Step("Get '{url}' URL")
    public static void getURL(String url){
        getDriver().get(url);
    }

    public static String getCurrentURL() {
        return getDriver().getCurrentUrl();
    }

    public static void driverCleanup() {
        synchronized (driversToCleanup) {
            Iterator<WebDriver> iterator = driversToCleanup.iterator();
            while (iterator.hasNext()) {
                WebDriver driver = iterator.next();
                driver.quit();
                iterator.remove();
            }
        }
    }
}
