package pageObjectTests;

import applicationPages.pages.LoginPage;
import applicationPages.pages.MainPage;
import org.testng.annotations.Test;
import webDriverSettings.DriverType;
import webDriverSettings.DriverWrapper;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tests extends BaseTest{
    protected final String BASE_URL = "https://www.aadvantageeshopping.com/index.php?p=h";

    MainPage mainPage;
    LoginPage loginPage;

    public String baseUrl() {
        return BASE_URL;
    }

    @Test (dataProvider = "browser")
    public void login(String e) {
        driverWrapper.setDriver(DriverType.valueOf(e));
        DriverWrapper.getDriver().get(baseUrl());

        loginPage = new LoginPage(DriverWrapper.getDriver());
        mainPage = new MainPage(DriverWrapper.getDriver());
        loginPage.clickOnLogin();
        loginPage.enterNumber("7W05VC2");
        loginPage.enterPassword("Pa55word");
        loginPage.clickLoginButton();
        assertTrue(loginPage.userIsLoggedIn());
        assertTrue(mainPage.verifyMainPageIsLoaded());
        assertTrue(mainPage.checkURL().equals(baseUrl()));
        assertFalse(loginPage.wrongLogin());
    }

    @Test(dataProvider = "browser")
    public void loginIsNegative(String e){
        driverWrapper.setDriver(DriverType.valueOf(e));
        DriverWrapper.getDriver().get(baseUrl());
        mainPage = new MainPage(DriverWrapper.getDriver());
        loginPage = new LoginPage(DriverWrapper.getDriver());
        loginPage.clickOnLogin();
        loginPage.enterNumber("7W05VC2");
        loginPage.enterPassword("Pa55word1");
        loginPage.clickLoginButton();
        assertFalse(loginPage.userIsLoggedIn());
        assertFalse(mainPage.verifyMainPageIsLoaded());
        assertFalse(mainPage.checkURL().equals(baseUrl()));
        assertTrue(loginPage.wrongLogin());
    }
}
