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

public class Tests extends BaseTest {
    protected final String BASE_URL = "https://www.aadvantageeshopping.com/index.php?p=h";

    MainPage mainPage;
    LoginPage loginPage;
    CategoryPage categoryPage;

public String baseUrl() {
        return BASE_URL;
    }

    /**
     * Positive Login test
     */
    @Test (dataProvider = "browser")
    public void login(String driverType) {
        DriverWrapper.setDriver(DriverType.valueOf(driverType));
        DriverWrapper.getDriver().get(baseUrl());
        loginPage = new LoginPage();
        mainPage = new MainPage();
        mainPage.clickLoginLink();
        loginPage.enterNumber("aa.user.number");
        loginPage.enterPassword("aa.user.password");
        loginPage.clickLoginButton();
        assertTrue(loginPage.userIsLoggedIn());
        assertTrue(mainPage.verifyMainPageIsOpened());
        assertTrue(DriverWrapper.getCurrentURL().equals(baseUrl()));
        assertFalse(loginPage.wrongLogin());
    }

    /**
     * Negative Login test
     */
    @Test(dataProvider = "browser")
    public void loginIsNegative(String driverType) {
        DriverWrapper.setDriver(DriverType.valueOf(driverType));
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

    /**
     * Open Category on desktop menu
     */
    @Test(dataProvider = "browser")
    public void openCategoryPageOnDesktop(String driverType) throws InterruptedException {
        DriverWrapper.setDriver(DriverType.valueOf(driverType));
        DriverWrapper.getDriver().get(baseUrl());
        categoryPage = new CategoryPage();
        categoryPage.clickOnCategoryFromDesktopNav();
//        Thread.sleep(5000);
        WaitHelper.waitPageLoad();
        assertTrue(categoryPage.verifyCategoryIsOpened());
        categoryPage.chooseSortOptions(CategoryPage.SortOption.name);
    }

    /**
     * Open Category on desktop menu
     */
    @Test(dataProvider = "browser")
    public void openCategoryPageOnMobile(String driverType) throws InterruptedException {
        DriverWrapper.setDriver(DriverType.valueOf(driverType));
        DriverWrapper.getDriver().get(baseUrl());
        categoryPage = new CategoryPage();
        categoryPage.clickOnCategoryFromMobileNav();
        Thread.sleep(3000);
        assertTrue(categoryPage.verifyCategoryIsOpened());
        categoryPage.chooseSortOptions(CategoryPage.SortOption.earn_rate);
    }

    /**
     * Verify DOTW section on desktop
     */
    @Test(dataProvider = "browser")
    public void verifyDOTWSection(String driverType){
        DriverWrapper.setDriver(DriverType.valueOf(driverType));
        DriverWrapper.getDriver().get(baseUrl());
        loginPage = new LoginPage();
        mainPage = new MainPage();
        mainPage.clickLoginLink();
        loginPage.enterNumber("aa.user.number");
        loginPage.enterPassword("aa.user.password");
        loginPage.clickLoginButton();
        assertTrue(mainPage.verifyDOTWIsPresent());
    }
}
