package webDriverSettings;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DriverWrapper {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static List<WebDriver> driversToCleanup = Collections.synchronizedList(new ArrayList());
    private DriverManagerFactory driverManagerFactory = new DriverManagerFactory();

    public void setDriver(DriverType driverType){
        driver.set(driverManagerFactory.getDriverManager(driverType).getDriverByType());
        getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
        driversToCleanup.add(getDriver());
    }

    public static WebDriver getDriver(){
        return driver.get();
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
