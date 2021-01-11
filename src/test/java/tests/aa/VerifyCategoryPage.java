package tests.aa;

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
    @Test(dataProvider = "dp")
    public void openCategoryPageOnDesktop(String driverType) throws InterruptedException {
        DriverWrapper.setDriver(DriverType.valueOf(driverType));
        DriverWrapper.getDriver().get(baseUrl());
        categoryPage = new CategoryPage();
        categoryPage.clickOnCategoryFromDesktopNav();
//        Thread.sleep(3000);
        categoryPage.chooseSortOptions(CategoryPage.SortOption.name);
        WaitHelper.waitPageLoad();
        assertTrue(categoryPage.verifyCategoryIsOpened());

    }

    /**
     * Open Category on desktop menu
     */
    @Test(dataProvider = "dp")
    public void openCategoryPageOnMobile(String driverType) throws InterruptedException {
        DriverWrapper.setDriver(DriverType.valueOf(driverType));
        DriverWrapper.getDriver().get(baseUrl());
        categoryPage = new CategoryPage();
        categoryPage.clickOnCategoryFromMobileNav();
//        Thread.sleep(3000);
        categoryPage.chooseSortOptions(CategoryPage.SortOption.earn_rate);
        WaitHelper.waitPageLoad();
        assertTrue(categoryPage.verifyCategoryIsOpened());

    }
}
