package webdriver;

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

    public static void setDriver(DriverType driverType){
        driver.set(driverManagerFactory.getDriverManager(driverType).getDriverByType());
        WaitHelper.implicitlyWait();
        getDriver().manage().window().maximize();
        driversToCleanup.add(getDriver());
    }

    public static WebDriver getDriver(){
        return driver.get();
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
