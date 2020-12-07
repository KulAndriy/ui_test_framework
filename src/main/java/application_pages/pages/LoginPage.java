package application_pages.pages;

import logger.MyLogger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//a[@class='mn_signInLink'][@href='/j____.htm']")
    private WebElement logIn;
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



    //*********Constructor*********
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnLogin(){
        logIn.click();
        MyLogger.getLogger().info("Clicks on Login link");
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
        loginButton.click();
        MyLogger.getLogger().info("Login button is clicked");
    }

    public boolean userIsLoggedIn(){
        try {
            if (userLoggedIn.isDisplayed()) {
                MyLogger.getLogger().info("Login is success!!!");
                return userLoggedIn.isDisplayed();
            }else
                return false;
        } catch (NoSuchElementException e) {
            MyLogger.getLogger().info("Login is not success!!!");
            return false;
        }
    }

    public boolean wrongLogin(){
        try {
            if (errorAlert.isDisplayed()){
                MyLogger.getLogger().info("Errors while login, please verify your credentials!!!");
                return errorAlert.isDisplayed();
            } else
                return false;
        } catch (NoSuchElementException e) {
            MyLogger.getLogger().info("No errors while login!!!!");
            return false;
        }
    }
}
