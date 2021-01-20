package tests;

import io.qameta.allure.Epic;
import org.testng.ITest;
import org.testng.annotations.*;
import pages.CategoryPage;
import pages.LoginPage;
import pages.MainPage;
import webdriver.factory.DriverType;
import webdriver.DriverWrapper;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;

public class BaseTest implements ITest {

    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected CategoryPage categoryPage;
    protected final String BASE_URL = "https://www.aadvantageeshopping.com/index.php?p=h";

    private ThreadLocal<String> testName = new ThreadLocal<>();

    public String baseUrl() {
        return BASE_URL;
    }
    String env = System.getProperty("environment");

    @DataProvider(name = "browser")
    public Object[] testBrowsers() {
        return Arrays.stream(DriverType.values()).map(s->s.name()).toArray();
    }

    @DataProvider(name = "dp")
    public Object[] dataInjection(){
        if (env.equals("ALL") | env == null) {
            return Arrays.stream(DriverType.values()).map(s->s.name()).toArray();

        }else {
            return new Object[][]{{env}};
        }
    }

    @BeforeMethod
    public void setTestName(Annotation a, Method method, Object[] testData){
        testName.set(method.getName() + "_" + testData[0]);
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

    @Override
    public String getTestName() {
        return testName.get();
    }
}
