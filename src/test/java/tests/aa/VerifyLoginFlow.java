package tests.aa;

import listener.Listener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.WaitHelper;
import webdriver.factory.DriverType;
import webdriver.DriverWrapper;
import pages.*;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


@Listeners(Listener.class)

public class VerifyLoginFlow extends BaseTest {

    /**
     * Positive Login test
     */
    @Test (dataProvider = "dp")
    public void login(String driverType) {
        DriverWrapper.setDriver(DriverType.valueOf(driverType));
        DriverWrapper.getDriver().get(baseUrl());
        loginPage = new LoginPage();
        mainPage = new MainPage();
        mainPage.clickLoginLink();
        loginPage.enterNumber("aa.user.number");
        loginPage.enterPassword("aa.user.password");
        loginPage.clickLoginButton();
        WaitHelper.waitPageLoad();
        assertTrue(loginPage.userIsLoggedIn());
        assertTrue(mainPage.verifyMainPageIsOpened());
        assertTrue(DriverWrapper.getCurrentURL().equals(baseUrl()));
        assertFalse(loginPage.wrongLogin());
    }

    /**
     * Negative Login test
     */
    @Test(dataProvider = "dp")
    public void loginIsNegative(String driverType) {
        DriverWrapper.setDriver(DriverType.valueOf(driverType));
        DriverWrapper.getDriver().get(baseUrl());

        mainPage = new MainPage();
        loginPage = new LoginPage();
        mainPage.clickLoginLink();
        loginPage.enterNumber("aa.user.number");
        loginPage.enterPassword("aa.user.wrong.number");
        loginPage.clickLoginButton();
        WaitHelper.waitPageLoad();
        assertFalse(loginPage.userIsLoggedIn());
        assertFalse(mainPage.verifyMainPageIsOpened());
        assertFalse(DriverWrapper.getCurrentURL().equals(baseUrl()));
        assertTrue(loginPage.wrongLogin());
    }




}