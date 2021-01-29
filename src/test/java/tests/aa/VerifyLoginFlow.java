package tests.aa;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listener.Listener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.desktop.LoginPage;
import pages.desktop.MainPage;
import tests.BaseTest;
import utils.WaitHelper;
import webdriver.factory.DriverType;
import webdriver.DriverWrapper;

@Listeners(Listener.class)

public class VerifyLoginFlow extends BaseTest {

    private MainPage mainPage;
    private LoginPage loginPage;

    /**
     * Positive Login test
     */
    @Feature(value = "Verify login flow")
    @Story(value = "Verify Positive login flow")
    @Test (dataProvider = "dp")
    public void login(String driverType) {
        DriverWrapper.setDriver(DriverType.valueOf(driverType));
        DriverWrapper.getDriver().get(baseUrl("aa.base.url", testDataPropertyPath));
        loginPage = new LoginPage();
        mainPage = new MainPage();
        mainPage.clickLoginLink();
        loginPage.enterNumber("aa.user.number", testDataPropertyPath);
        loginPage.enterPassword("aa.user.password", testDataPropertyPath);
        loginPage.clickLoginButton();
        WaitHelper.waitPageLoad();
        Assert.assertTrue(loginPage.userIsLoggedIn(), "Login is not success!!!");
        Assert.assertTrue(mainPage.verifyMainPageIsOpened(), "The main page is not opened!!!");
        Assert.assertTrue(DriverWrapper.getCurrentURL().equals(baseUrl("aa.base.url", testDataPropertyPath)));
        Assert.assertFalse(loginPage.wrongLogin(), "Errors while login, please verify your credentials!!!");
    }

    /**
     * Negative Login test
     */
    @Feature(value = "Verify login flow")
    @Story(value = "Verify Negative login flow")
    @Test(dataProvider = "dp")
    public void loginIsNegative(String driverType) {
        DriverWrapper.setDriver(DriverType.valueOf(driverType));
        DriverWrapper.getDriver().get(baseUrl("aa.base.url", testDataPropertyPath));
        mainPage = new MainPage();
        loginPage = new LoginPage();
        mainPage.clickLoginLink();
        loginPage.enterNumber("aa.user.wrong.number", testDataPropertyPath);
        loginPage.enterPassword("aa.user.password", testDataPropertyPath);
        loginPage.clickLoginButton();
        WaitHelper.waitPageLoad();
        Assert.assertFalse(loginPage.userIsLoggedIn(), "Login is not success!!!");
        Assert.assertFalse(mainPage.verifyMainPageIsOpened(), "The main page is not opened!!!");
        Assert.assertFalse(DriverWrapper.getCurrentURL().equals(baseUrl("aa.base.url", testDataPropertyPath)));
        Assert.assertTrue(loginPage.wrongLogin(), "No errors while login!!!! There should be wrong credentials");
    }
}
