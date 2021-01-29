package pages.mobile;

import browser.BrowserSize;
import io.qameta.allure.Step;
import logger.MyLogger;
import org.openqa.selenium.support.FindBy;
import pages.desktop.CategoryPage;
import webelements.elements.WebElements;

public class MobileCategoryPage extends CategoryPage {

    @FindBy(xpath = "//button[@class='mn_navTrigger americanairlines-svgIcon americanairlines-icon_hamburger']")
    private WebElements hamburgerIcon;
    @FindBy(xpath = "//span[@role='button'][@class='mn_mainNavTopItem' and @aria-expanded='false']")
    private WebElements mobileCategoriesNav;

    @Step("Click on Category link from mobile hamburger menu.")
    public void clickOnCategoryFromMobileNav(BrowserSize size){
        browser.setScreenSize(size);
        MyLogger.getLogger().info("Clicks on hamburger menu on mobile");
        hamburgerIcon.click();
        MyLogger.getLogger().info("Open Category drop-down");
        mobileCategoriesNav.actionClick();
        MyLogger.getLogger().info("Clicks on Category from mobile navigation");
        categoryMen.actionClick();
    }
}
