package tests.aa;

import listener.Listener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ReadFileHandler;
import webdriver.factory.DriverType;
import webdriver.DriverWrapper;
import pages.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@Listeners(Listener.class)

public class Tests extends BaseTest {
    protected final String BASE_URL = "https://www.aadvantageeshopping.com/index.php?p=h";

    MainPage mainPage;
    LoginPage loginPage;
    CategoryPage categoryPage;

public String baseUrl() {
        return BASE_URL;
    }

    @Test (dataProvider = "browser")
    public void login(String e) throws Exception {
        DriverWrapper.setDriver(DriverType.valueOf(e));
        DriverWrapper.getDriver().get(baseUrl());

        loginPage = new LoginPage();
        mainPage = new MainPage();
        categoryPage = new CategoryPage();
        mainPage.clickLoginLink();
        loginPage.enterNumber("aa.user.number");
        loginPage.enterPassword("aa.user.password");
        loginPage.clickLoginButton();
        categoryPage.clickOnCategoryFromMobileNav();
        categoryPage.chooseSortOptions("name");
        assertTrue(loginPage.userIsLoggedIn());
//        assertTrue(mainPage.verifyMainPageIsOpened());
//        assertTrue(DriverWrapper.getCurrentURL().equals(baseUrl()));
        assertFalse(loginPage.wrongLogin());
    }

    @Test(dataProvider = "browser")
    public void loginIsNegative(String e) throws Exception {
        DriverWrapper.setDriver(DriverType.valueOf(e));
        DriverWrapper.getDriver().get(baseUrl());

        mainPage = new MainPage();
        loginPage = new LoginPage();
        mainPage.clickLoginLink();
        loginPage.enterNumber("aa.user.number");
        loginPage.enterPassword("aa.user.wrong.number");
        loginPage.clickLoginButton();
        assertFalse(loginPage.userIsLoggedIn());
        assertFalse(mainPage.verifyMainPageIsOpened());
        assertFalse(DriverWrapper.getCurrentURL().equals(baseUrl()));
        assertTrue(loginPage.wrongLogin());
    }
}
