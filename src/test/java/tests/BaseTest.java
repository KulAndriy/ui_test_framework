package tests;

import listener.Listener;
import org.testng.annotations.*;
import webdriver.factory.DriverType;
import webdriver.DriverWrapper;

import java.util.*;

public class BaseTest {

    @DataProvider(name = "browser")
    public Object[] testBrowsers() {
        return Arrays.stream(DriverType.values()).map(s->s.name()).toArray();
    }

    @DataProvider(name = "partialBrowser")
    public Object[] partialBrowsers() {
        return new Object[] {"CHROME"};
    }

    @AfterMethod
    public void clearCookies() {
        DriverWrapper.getDriver().manage().deleteAllCookies();
    }

    @AfterMethod
    public void closeDriver(){
        DriverWrapper.getDriver().quit();
    }

    @AfterTest
    public void turnDown(){
        DriverWrapper.driverCleanup();
    }
}
