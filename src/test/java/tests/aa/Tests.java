package tests.aa;

import listener.Listener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.BaseTest;
import webdriver.factory.DriverType;
import wrapper.DriverWrapper;
import pages.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@Listeners(Listener.class)

public class Tests extends BaseTest {
    protected final String BASE_URL = "https://www.aadvantageeshopping.com/index.php?p=h";

    MainPage mainPage;
    LoginPage loginPage;

public String baseUrl() {
        return BASE_URL;
    }

    @Test (dataProvider = "browser")
    public void login(String e) {
        DriverWrapper.setDriver(DriverType.valueOf(e));
        DriverWrapper.getDriver().get(baseUrl());

        loginPage = new LoginPage(DriverWrapper.getDriver());
        mainPage = new MainPage(DriverWrapper.getDriver());
        mainPage.clickOnCategory();
        mainPage.clickLoginLink();
        loginPage.enterNumber("03UUF80");
        loginPage.enterPassword("Pa55word");
        loginPage.clickLoginButton();
        assertTrue(loginPage.userIsLoggedIn());
        assertTrue(mainPage.verifyMainPageIsOpened());
        assertTrue(DriverWrapper.getCurrentURL().equals(baseUrl()));
        assertFalse(loginPage.wrongLogin());
    }

    @Test(dataProvider = "browser")
    public void loginIsNegative(String e){
        DriverWrapper.setDriver(DriverType.valueOf(e));
        DriverWrapper.getDriver().get(baseUrl());

        mainPage = new MainPage(DriverWrapper.getDriver());
        loginPage = new LoginPage(DriverWrapper.getDriver());
        mainPage.clickOnCategory();
        mainPage.clickLoginLink();
        loginPage.enterNumber("03UUF80");
        loginPage.enterPassword("Pa55word1");
        loginPage.clickLoginButton();
        assertFalse(loginPage.userIsLoggedIn());
        assertFalse(mainPage.verifyMainPageIsOpened());
        assertFalse(DriverWrapper.getCurrentURL().equals(baseUrl()));
        assertTrue(loginPage.wrongLogin());
    }
}
