package page_object_tests;

import application_pages.pages.LoginPage;
import application_pages.pages.MainPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import webdriver.factory.DriverType;
import webdriver.DriverWrapper;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@Listeners(logger.Listener.class)

public class Tests extends BaseTest{
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
        loginPage.clickOnLogin();
        loginPage.enterNumber("03UUF80");
        loginPage.enterPassword("Pa55word");
        loginPage.clickLoginButton();
        assertTrue(loginPage.userIsLoggedIn());
        assertTrue(mainPage.verifyMainPageIsLoaded());
        assertTrue(mainPage.checkURL().equals(baseUrl()));
        assertFalse(loginPage.wrongLogin());
    }

    @Test(dataProvider = "browser")
    public void loginIsNegative(String e){
        DriverWrapper.setDriver(DriverType.valueOf(e));
        DriverWrapper.getDriver().get(baseUrl());

        mainPage = new MainPage(DriverWrapper.getDriver());
        loginPage = new LoginPage(DriverWrapper.getDriver());
        mainPage.clickOnCategory();
        loginPage.clickOnLogin();
        loginPage.enterNumber("03UUF80");
        loginPage.enterPassword("Pa55word1");
        loginPage.clickLoginButton();
        assertFalse(loginPage.userIsLoggedIn());
        assertFalse(mainPage.verifyMainPageIsLoaded());
        assertFalse(mainPage.checkURL().equals(baseUrl()));
        assertTrue(loginPage.wrongLogin());
    }
}
