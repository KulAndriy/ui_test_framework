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
    @FindBy(xpath = "//div[@class=\"mn_dotwLabel\"]")
    private WebElement dealOfTheWeek;

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
    public boolean verifyDOTWIsPresent(){
        try {
            if (dealOfTheWeek.isDisplayed()){
                MyLogger.getLogger().info("The DOTW section is present on MHP page.");
            }
            return dealOfTheWeek.isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }
}
