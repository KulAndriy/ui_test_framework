package tests;

import org.testng.annotations.*;
import pages.CategoryPage;
import pages.LoginPage;
import pages.MainPage;
import webdriver.factory.DriverType;
import webdriver.DriverWrapper;

import java.util.*;

public class BaseTest {

    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected CategoryPage categoryPage;
    protected final String BASE_URL = "https://www.aadvantageeshopping.com/index.php?p=h";

    public String baseUrl() {
        return BASE_URL;
    }
    String env = System.getProperty("environment");

//    private String getDataProvider(){
//        if (env != null){
//            return env;
//        }
//        return "CHROME";
//    }

    @DataProvider(name = "browser")
    public Object[] testBrowsers() {
        return Arrays.stream(DriverType.values()).map(s->s.name()).toArray();
    }

    @DataProvider(name = "partialBrowser")
    public Object[] partialBrowsers() {
        return new Object[] {"FIREFOX"};
    }

    @DataProvider(name = "dp")
    public Object[] dataInjection(){
        if (env.equals("DEFAULT") || env == null) {
            return Arrays.stream(DriverType.values()).map(s->s.name()).toArray();

        }else {
            return new Object[][]{{env}};
        }
    }

    @AfterMethod
    public void clearCookies() {
        DriverWrapper.getDriver().manage().deleteAllCookies();
    }

    @AfterMethod
    public void closeDriver(){
        DriverWrapper.getDriver().quit();
    }

    @AfterClass
    public void turnDown(){
        DriverWrapper.driverCleanup();
    }


}
