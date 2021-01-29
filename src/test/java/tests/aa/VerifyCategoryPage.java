package tests.aa;

import browser.BrowserSize;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listener.Listener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.desktop.CategoryPage;
import pages.mobile.MobileCategoryPage;
import tests.BaseTest;
import utils.WaitHelper;
import webdriver.DriverWrapper;
import webdriver.factory.DriverType;

import static org.testng.Assert.assertTrue;

@Listeners(Listener.class)
public class VerifyCategoryPage extends BaseTest {

    protected CategoryPage categoryPage;
    protected MobileCategoryPage mobileCategoryPage;

    /**
     * Open Category on desktop menu
     */
    @Feature(value = "Verify Category page on different devices")
    @Story(value = "Open Category page on desktop")
    @Test(dataProvider = "dp")
    public void openCategoryPageOnDesktop(String driverType) {
        DriverWrapper.setDriver(DriverType.valueOf(driverType));
        DriverWrapper.getURL(baseUrl("aa.base.url", testDataPropertyPath));
        categoryPage = new CategoryPage();
        categoryPage.clickOnCategoryFromDesktopNav(BrowserSize.DESKTOP);
        categoryPage.sortBy(CategoryPage.SortOption.name);
        WaitHelper.waitPageLoad();
        assertTrue(categoryPage.verifyCategoryPageIsOpened(), "The Category page is not opened!!!");
    }

    /**
     * Open Category on desktop menu
     */
    @Feature(value = "Verify Category page on different devices")
    @Story(value = "Open Category page on mobile device")
    @Test(dataProvider = "dp")
    public void openCategoryPageOnMobile(String driverType) {
        DriverWrapper.setDriver(DriverType.valueOf(driverType));
        DriverWrapper.getURL(baseUrl("aa.base.url", testDataPropertyPath));
        mobileCategoryPage = new MobileCategoryPage();
        mobileCategoryPage.clickOnCategoryFromMobileNav(BrowserSize.MOBILE);
        mobileCategoryPage.sortBy(CategoryPage.SortOption.earn_rate);
        WaitHelper.waitPageLoad();
        assertTrue(mobileCategoryPage.verifyCategoryPageIsOpened(), "The Category page is not opened!!!");
    }
}
