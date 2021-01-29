package pages.desktop;

import io.qameta.allure.Step;
import pages.BasePage;
import webelements.elements.Link;
import logger.MyLogger;
import org.openqa.selenium.support.FindBy;
import utils.WaitHelper;
import webelements.elements.WebElements;

public class MainPage extends BasePage {

    @FindBy(xpath = "//body[@id='mn_h']")
    private WebElements page;
    @FindBy(xpath = "//a[@class='mn_signInLink'][@href='/j____.htm']")
    private Link logIn;
    @FindBy(xpath = "//div[@class=\"mn_dotwLabel\"]")
    private WebElements dealOfTheWeek;

    @Step("Clicks on Login link.")
    public void clickLoginLink() {
        WaitHelper.waitForElementVisible(logIn.getElement());
        logIn.click();
        MyLogger.getLogger().info("Clicks on Login link");
    }

    @Step("Verify the main page is opened.")
    public boolean verifyMainPageIsOpened(){
        if (page.isPresent() && page.getElement().isDisplayed()){
            MyLogger.getLogger().info("The main page is opened!!!");
        }else {
            MyLogger.getLogger().info("The main page is not opened!!!");
        }
        return page.isPresent();
    }

    @Step("Verify the DOTW section is present on MHP page.")
    public boolean verifyDOTWIsPresent(){
        if (dealOfTheWeek.isPresent() && dealOfTheWeek.getElement().isDisplayed()){
            MyLogger.getLogger().info("The DOTW section is present on MHP page.");
        }else {
            MyLogger.getLogger().info("The DOTW section is not present on MHP page.");
        }
        return dealOfTheWeek.getElement().isDisplayed();
    }
}
