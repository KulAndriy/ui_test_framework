package pages;

import browser.BrowserImpl;
import browser.BrowserSize;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import webelements.elements.Button;
import webelements.elements.Link;
import webelements.elements.WebElements;

public class CategoryPage extends BasePage {
    @FindBy(xpath = "//a[@href='/Mens-Clothing/bc_2___.htm']")
    private Link categoryMen;

    @FindBy(xpath = "//div[@class='mn_navigationDropdownTrigger']/span[@class='mn_mainNavTrigger']")
    protected WebElement navArrow;
    @FindBy(xpath = "//button[@class='mn_navTrigger americanairlines-svgIcon americanairlines-icon_hamburger']")
    protected Button hamburgerIcon;
    @FindBy(xpath = "//span[@role='button'][@class='mn_mainNavTopItem' and @aria-expanded='false']")
    protected WebElements mobileCategoriesNav;
    @FindBy(tagName = "select")
    private WebElements selectDropDown;

    private  BrowserImpl browser = new BrowserImpl();

    public void clickOnCategoryFromDesktopNav(){
        browser.setScreenSize(BrowserSize.DESKTOP);
        navArrow.click();
        WebElements.actionClick(categoryMen);
    }

    public void clickOnCategoryFromMobileNav(){
        browser.setScreenSize(BrowserSize.MOBILE);
        hamburgerIcon.click();
        WebElements.actionClick(mobileCategoriesNav);
        WebElements.actionClick(categoryMen);
    }

    public void chooseSortOptions(String value){
        categoryMen.selectElementByValue(selectDropDown, value);

    }
}
