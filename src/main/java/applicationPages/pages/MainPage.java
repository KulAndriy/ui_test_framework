package applicationPages.pages;

import logger.MyLogger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//body[@id='mn_h']")
    private WebElement pageLoaded;

    public String checkURL() {
        return this.driver.getCurrentUrl();
    }

    public boolean verifyMainPageIsLoaded(){
        try {
            if (pageLoaded.isDisplayed()){
                MyLogger.getLogger().info("The main page is loaded!!!");
                return pageLoaded.isDisplayed();
            } else
                return false;
        } catch (NoSuchElementException e) {
            MyLogger.getLogger().error("The main page is not loaded!!!");
            return false;
        }
    }
}
