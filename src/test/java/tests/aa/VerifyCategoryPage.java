package tests.aa;

import io.qameta.allure.Epic;
import io.qameta.allure.Epics;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listener.Listener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CategoryPage;
import tests.BaseTest;
import utils.WaitHelper;
import webdriver.DriverWrapper;
import webdriver.factory.DriverType;

import static org.testng.Assert.assertTrue;

@Listeners(Listener.class)
public class VerifyCategoryPage extends BaseTest {
    /**
     * Open Category on desktop menu
     */
    @Epics(value = {@Epic(value = "CHROME"), @Epic(value = "FIREFOX"), @Epic(value = "EDGE")})
    @Feature(value = "Verify Category page on different devices")
    @Story(value = "Open Category page on desktop")
    @Test(dataProvider = "dp")
    public void openCategoryPageOnDesktop(String driverType) {
        DriverWrapper.setDriver(DriverType.valueOf(driverType));
        DriverWrapper.getDriver().get(baseUrl());
        categoryPage = new CategoryPage();
        categoryPage.clickOnCategoryFromDesktopNav();
        categoryPage.chooseSortOptions(CategoryPage.SortOption.name);
        WaitHelper.waitPageLoad();
        assertTrue(categoryPage.verifyCategoryIsOpened());

    }

    /**
     * Open Category on desktop menu
     */
    @Epics(value = {@Epic(value = "CHROME"), @Epic(value = "FIREFOX"), @Epic(value = "EDGE")})
    @Feature(value = "Verify Category page on different devices")
    @Story(value = "Open Category page on mobile device")
    @Test(dataProvider = "dp")
    public void openCategoryPageOnMobile(String driverType) {
        DriverWrapper.setDriver(DriverType.valueOf(driverType));
        DriverWrapper.getDriver().get(baseUrl());
        categoryPage = new CategoryPage();
        categoryPage.clickOnCategoryFromMobileNav();
        categoryPage.chooseSortOptions(CategoryPage.SortOption.earn_rate);
        WaitHelper.waitPageLoad();
        assertTrue(categoryPage.verifyCategoryIsOpened());

    }
}
