package pages;

import browser.BrowserImpl;
import browser.BrowserSize;
import io.qameta.allure.Step;
import logger.MyLogger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import utils.WaitHelper;
import webelements.elements.Link;
import webelements.elements.WebElements;

public class CategoryPage extends BasePage {
    @FindBy(xpath = "//a[@href='/Mens-Clothing/bc_2___.htm']")
    private Link categoryMen;
    @FindBy(xpath = "//div[@class='mn_categoryPage']")
    private WebElements page;
    @FindBy(xpath = "//span[@class = 'mn_mainNavTrigger']")
    private WebElements navArrow;
    @FindBy(xpath = "//button[@class='mn_navTrigger americanairlines-svgIcon americanairlines-icon_hamburger']")
    private WebElements hamburgerIcon;
    @FindBy(xpath = "//span[@role='button'][@class='mn_mainNavTopItem' and @aria-expanded='false']")
    private WebElements mobileCategoriesNav;
    @FindBy(tagName = "select")
    private WebElements selectDropDown;

    private  BrowserImpl browser = new BrowserImpl();

    @Step("Click on Category link from desktop navigation flyout.")
    public void clickOnCategoryFromDesktopNav(){
        browser.setScreenSize(BrowserSize.DESKTOP);
        MyLogger.getLogger().info("Clicks on navigation drop-down on desktop");
        navArrow.mouseHover();
        MyLogger.getLogger().info("Clicks on Category from desktop navigation");
        categoryMen.actionClick();
    }

    @Step("Click on Category link from mobile hamburger menu.")
    public void clickOnCategoryFromMobileNav(){
        browser.setScreenSize(BrowserSize.MOBILE);
        MyLogger.getLogger().info("Clicks on hamburger menu on mobile");
        hamburgerIcon.click();
        MyLogger.getLogger().info("Open Category drop-down");
        mobileCategoriesNav.actionClick();
        MyLogger.getLogger().info("Clicks on Category from mobile navigation");
        categoryMen.actionClick();
    }

    @Step("Click on '{value}' sort drop-down option.")
    public void chooseSortOptions(SortOption value){
        MyLogger.getLogger().info("Sort by: " + value);
        categoryMen.selectElementByValue(selectDropDown, String.valueOf(value));
    }

    @Step("Verify if Category page is opened.")
    public boolean verifyCategoryPageIsOpened(){
        try {
            WaitHelper.waitPageLoad();
            if (page.getElement().isDisplayed()) {
                MyLogger.getLogger().info("The Category page is opened!!!");
            }
            return page.getElement().isDisplayed();
        } catch (NoSuchElementException e) {
            MyLogger.getLogger().error("The Category page is not opened!!!");
        }
        return false;
    }

    public enum SortOption{
        featured,
        earn_rate,
        name
    }
}
