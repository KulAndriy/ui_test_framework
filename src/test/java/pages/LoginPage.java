package pages;

import logger.MyLogger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wrapper.WaitWrapper;

public class LoginPage extends BasePage {


    @FindBy(xpath = "//input[@type='text'][@id='mn_lookupId']")
    private WebElement number;
    @FindBy(xpath = "//input[@type='password'][@id='mn_password']")
    private WebElement enterPassword;
    @FindBy(xpath = "//input[@class='mn_button mn_submitButton mn_loginButton'][@type='button']")
    private WebElement loginButton;
    @FindBy(xpath = "//ul[@class='mn_errorListWrap']//li[@class='mn_errTxt']")
    private WebElement errorAlert;
    @FindBy(xpath = "//nav[@class='mn_accountNavigation']")
    private WebElement userLoggedIn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterNumber(String number) {
        this.number.clear();
        this.number.sendKeys(number);
        MyLogger.getLogger().info("Email is entered");
    }

    public void enterPassword(String password) {
        this.enterPassword.clear();
        this.enterPassword.sendKeys(password);
        MyLogger.getLogger().info("Password is entered");
    }

    public void clickLoginButton() {
        WaitWrapper.waitForElementClickable(loginButton);
        loginButton.click();
        MyLogger.getLogger().info("Login button is clicked");
    }

    public boolean userIsLoggedIn(){
        try {
            MyLogger.getLogger().info("Login is success!!!");
            return userLoggedIn.isDisplayed();
        } catch (NoSuchElementException e) {
            MyLogger.getLogger().info("Login is not success!!!");
            return false;
        }
    }

    public boolean wrongLogin(){
        try {
            MyLogger.getLogger().info("Errors while login, please verify your credentials!!!");
            return errorAlert.isDisplayed();
        } catch (NoSuchElementException e) {
            MyLogger.getLogger().info("No errors while login!!!!");
            return false;
        }
    }
}
