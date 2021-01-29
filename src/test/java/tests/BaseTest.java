package tests;

import org.testng.ITest;
import org.testng.annotations.*;
import utils.ReadFileHandler;
import webdriver.factory.DriverType;
import webdriver.DriverWrapper;

import java.lang.reflect.Method;
import java.util.*;

public class BaseTest implements ITest {

    protected String testDataPropertyPath = "src/test/resources/test-data.properties";
    private ThreadLocal<String> testName = new ThreadLocal<>();

    private final String env = System.getProperty("environment");

    public String baseUrl(String baseURL, String pathName) {
        return ReadFileHandler.loadProperties(baseURL, pathName);
    }

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
    public void setTestName(Method method, Object[] testData){
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
