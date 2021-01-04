package pages;

import browser.BrowserImpl;
import browser.BrowserSize;
import logger.MyLogger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import webelements.elements.Link;
import webelements.elements.WebElements;

public class CategoryPage extends BasePage {
    @FindBy(xpath = "//a[@href='/Mens-Clothing/bc_2___.htm']")
    private Link categoryMen;
    @FindBy(xpath = "//div[@class='mn_categoryPage']")
    private WebElements page;
    @FindBy(xpath = "//div[@class='mn_navigationDropdownTrigger']/span[@class='mn_mainNavTrigger']")
    private WebElements navArrow;
    @FindBy(xpath = "//button[@class='mn_navTrigger americanairlines-svgIcon americanairlines-icon_hamburger']")
    private WebElements hamburgerIcon;
    @FindBy(xpath = "//span[@role='button'][@class='mn_mainNavTopItem' and @aria-expanded='false']")
    private WebElements mobileCategoriesNav;
    @FindBy(tagName = "select")
    private WebElements selectDropDown;

    private  BrowserImpl browser = new BrowserImpl();

    public void clickOnCategoryFromDesktopNav(){
        browser.setScreenSize(BrowserSize.DESKTOP);
        MyLogger.getLogger().info("Clicks on navigation drop-down on desktop");
        navArrow.click();
        MyLogger.getLogger().info("Clicks on Category from desktop navigation");
        WebElements.actionClick(categoryMen);
    }

    public void clickOnCategoryFromMobileNav(){
        browser.setScreenSize(BrowserSize.MOBILE);
        MyLogger.getLogger().info("Clicks on hamburger menu on mobile");
        hamburgerIcon.click();
        MyLogger.getLogger().info("Open Category drop-down");
        WebElements.actionClick(mobileCategoriesNav);
        MyLogger.getLogger().info("Clicks on Category from mobile navigation");
        WebElements.actionClick(categoryMen);
    }

    public void chooseSortOptions(SortOption value){
        MyLogger.getLogger().info("Sort by: " + value);
        categoryMen.selectElementByValue(selectDropDown, String.valueOf(value));
    }

    public boolean verifyCategoryIsOpened(){
        try {
            if (page.getElement().isDisplayed()) {
                MyLogger.getLogger().info("The Category page is opened!!!");
            }
            return  page.getElement().isDisplayed();
        } catch (NoSuchElementException e) {
            MyLogger.getLogger().error("The Category page is not opened!!!");
            return false;
        }
    }
    public enum SortOption{
        featured,
        earn_rate,
        name
    }
}
