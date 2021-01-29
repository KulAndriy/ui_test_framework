package pages.desktop;

import browser.BrowserSizeHandler;
import browser.BrowserSize;
import io.qameta.allure.Step;
import logger.MyLogger;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import webelements.elements.Link;
import webelements.elements.WebElements;

public class CategoryPage extends BasePage {
    @FindBy(xpath = "//a[@href='/Mens-Clothing/bc_2___.htm']")
    protected Link categoryMen;
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

    protected BrowserSizeHandler browser = new BrowserSizeHandler();

    @Step("Click on Category link from desktop navigation flyout.")
    public void clickOnCategoryFromDesktopNav(BrowserSize size){
        browser.setScreenSize(size);
        MyLogger.getLogger().info("Clicks on navigation drop-down on desktop");
        navArrow.mouseHover();
        MyLogger.getLogger().info("Clicks on Category from desktop navigation");
        categoryMen.actionClick();
    }

    @Step("Click on '{value}' sort drop-down option.")
    public void sortBy(SortOption value){
        categoryMen.selectElementByValue(selectDropDown, String.valueOf(value));
        MyLogger.getLogger().info("Sort by: " + value);
    }

    @Step("Verify if Category page is opened.")
    public boolean verifyCategoryPageIsOpened(){
        if (page.isPresent() && page.getElement().isDisplayed()){
            MyLogger.getLogger().info("The Category page is opened!!!");
        }else {
            MyLogger.getLogger().info("The Category page is not opened!!!");
        }
        return page.getElement().isDisplayed();
    }

    public enum SortOption{
        featured,
        earn_rate,
        name
    }
}
