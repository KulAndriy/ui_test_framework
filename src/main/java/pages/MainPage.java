package pages;

import io.qameta.allure.Step;
import webelements.elements.Link;
import logger.MyLogger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitHelper;
import webelements.elements.WebElements;

public class MainPage extends BasePage {

    @FindBy(xpath = "//body[@id='mn_h']")
    private WebElements page;
    @FindBy(xpath = "//a[@class='mn_signInLink'][@href='/j____.htm']")
    private Link logIn;
    @FindBy(xpath = "//div[@class=\"mn_dotwLabel\"]")
    private WebElement dealOfTheWeek;

    @Step("Clicks on Login link.")
    public void clickLoginLink() {
        WaitHelper.waitForElementVisible(logIn.getElement());
        logIn.click();
        MyLogger.getLogger().info("Clicks on Login link");
    }

    @Step("Verify the main page is opened.")
    public boolean verifyMainPageIsOpened(){
        try {
            if (page.getElement().isDisplayed()) {
                MyLogger.getLogger().info("The main page is opened!!!");
            }
            return page.getElement().isDisplayed();
        } catch (NoSuchElementException e) {
            MyLogger.getLogger().error("The main page is not opened!!!");
        }
        return false;
    }

    @Step("Verify the DOTW section is present on MHP page.")
    public boolean verifyDOTWIsPresent(){
        try {
            WaitHelper.waitForElementVisible(dealOfTheWeek);
            if (dealOfTheWeek.isDisplayed()){
                MyLogger.getLogger().info("The DOTW section is present on MHP page.");
            }
            return dealOfTheWeek.isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return false;
    }
}
