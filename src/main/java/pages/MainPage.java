package pages;

import webelements.elements.Body;
import webelements.elements.Link;
import logger.MyLogger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webelements.elements.WebElements;
import utils.WaitHelper;

public class MainPage extends BasePage {

    @FindBy(xpath = "//body[@id='mn_h']")
    private Body page;
    @FindBy(xpath = "//a[@class='mn_signInLink'][@href='/j____.htm']")
    private Link logIn;
    @FindBy(xpath = "//div[@class='mn_navigationDropdownTrigger']/span[@class='mn_mainNavTrigger']")
    private WebElement navArrow;
    @FindBy(xpath = "//a[@href='/Mens-Clothing/bc_2___.htm']")
    private Link categoryMen;

    public void clickLoginLink() {
        WaitHelper.waitForElementVisible(logIn.getElement());
        logIn.click();
        MyLogger.getLogger().info("Clicks on Login link");
    }

    public boolean verifyMainPageIsOpened(){
        try {
            if (page.getBody().isDisplayed()) {
                MyLogger.getLogger().info("The main page is opened!!!");
            }
            return  page.getBody().isDisplayed();
        } catch (NoSuchElementException e) {
            MyLogger.getLogger().error("The main page is not opened!!!");
            return false;
        }
    }

    public void clickOnCategory(){
        navArrow.click();
        WebElements.actionClick(categoryMen.getElement());

    }
}
