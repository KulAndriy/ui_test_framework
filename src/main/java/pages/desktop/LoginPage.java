package pages.desktop;

import io.qameta.allure.Step;
import pages.BasePage;
import utils.ReadFileHandler;
import webelements.elements.Input;
import logger.MyLogger;
import org.openqa.selenium.support.FindBy;
import utils.WaitHelper;
import webelements.elements.WebElements;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@type='text'][@id='mn_lookupId']")
    private Input number;
    @FindBy(xpath = "//input[@type='password'][@id='mn_password']")
    private Input enterPassword;
    @FindBy(xpath = "//input[@class='mn_button mn_submitButton mn_loginButton'][@type='button']")
    private WebElements loginButton;
    @FindBy(xpath = "//ul[@class='mn_errorListWrap']//li[@class='mn_errTxt']")
    private WebElements errorAlert;
    @FindBy(xpath = "//nav[@class='mn_accountNavigation']")
    private WebElements userLoggedIn;

    @Step("Enter \"{number}\" username account.")
    public void enterNumber(String number, String pathName) {
        this.number.clear();
        this.number.write(ReadFileHandler.loadProperties(number, pathName));
        MyLogger.getLogger().info("Email is entered");
    }

    @Step("Enter \"{password}\" username password.")
    public void enterPassword(String password, String pathName) {
        this.enterPassword.clear();
        this.enterPassword.write(ReadFileHandler.loadProperties(password, pathName));
        MyLogger.getLogger().info("Password is entered");
    }

    @Step("Click on Login button.")
    public void clickLoginButton() {
        WaitHelper.waitForElementClickable(loginButton.getElement());
        loginButton.click();
        MyLogger.getLogger().info("Login button is clicked");
    }

    @Step("Verify if user is logged in.")
    public boolean userIsLoggedIn(){
        if (userLoggedIn.isPresent() && userLoggedIn.getElement().isDisplayed()){
            MyLogger.getLogger().info("Login is success!!!");
        }else {
            MyLogger.getLogger().info("Login is not success!!!");
        }
        return userLoggedIn.getElement().isDisplayed();
    }

    @Step("Verify if user is not logged in on the mall.")
    public boolean wrongLogin(){
        if (errorAlert.isPresent()){
            MyLogger.getLogger().info("Errors while login, please verify your credentials!!!");
        }else {
            MyLogger.getLogger().info("No errors while login!!!!");
        }
        return errorAlert.isPresent();

    }
}
