package pageObjectTests;

import org.testng.annotations.*;
import webDriverSettings.DriverType;
import webDriverSettings.DriverWrapper;

import java.util.*;

public class BaseTest {
    DriverWrapper driverWrapper = new DriverWrapper();

    @DataProvider(name = "browser")
    public Object[] testBrowsers() {
        return Arrays.stream(DriverType.values()).map(s->s.name()).toArray();
    }

    @AfterMethod
    public void clearCookies() {
        DriverWrapper.getDriver().manage().deleteAllCookies();
    }

//    @AfterMethod //don't work
    public void closeDriver(){
        DriverWrapper.getDriver().quit();
    }

    @AfterClass
    public void turnDown(){
        System.out.println(DriverWrapper.driversToCleanup);
        DriverWrapper.driverCleanup();
    }
}
