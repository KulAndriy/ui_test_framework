package pages;

import logger.MyLogger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wrapper.ElementsWrapper;
import wrapper.WaitWrapper;

public class MainPage extends BasePage {

    @FindBy(xpath = "//body[@id='mn_h']")
    private WebElement page;
    @FindBy(xpath = "//a[@class='mn_signInLink'][@href='/j____.htm']")
    private WebElement logIn;
    @FindBy(xpath = "//div[@class='mn_navigationDropdownTrigger']/span[@class='mn_mainNavTrigger']")
    private WebElement navArrow;
    @FindBy(xpath = "//a[@href='/Mens-Clothing/bc_2___.htm']")
    private WebElement categoryMen;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginLink() {
        WaitWrapper.waitForElementVisible(logIn);
        logIn.click();
        MyLogger.getLogger().info("Clicks on Login link");
    }

    public boolean verifyMainPageIsOpened(){
        try {
            MyLogger.getLogger().info("The main page is opened!!!");
            return page.isDisplayed();
        } catch (NoSuchElementException e) {
            MyLogger.getLogger().error("The main page is not opened!!!");
            return false;
        }
    }

    public void clickOnCategory(){
        navArrow.click();
        ElementsWrapper.actionClick(categoryMen);

    }
}
