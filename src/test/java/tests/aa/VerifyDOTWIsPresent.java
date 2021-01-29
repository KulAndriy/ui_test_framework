package tests.aa;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.desktop.LoginPage;
import pages.desktop.MainPage;
import tests.BaseTest;
import webdriver.DriverWrapper;
import webdriver.factory.DriverType;

import static org.testng.Assert.assertTrue;

public class VerifyDOTWIsPresent extends BaseTest {

    private MainPage mainPage;
    private LoginPage loginPage;

    /**
     * Verify DOTW section on desktop
     */
    @Feature(value = "Verify DOTW section on different devices")
    @Story(value = "Verify DOTW section on desktop")
    @Test(dataProvider = "dp")
    public void verifyDOTWOnDesktop(String driverType){
        DriverWrapper.setDriver(DriverType.valueOf(driverType));
        DriverWrapper.getURL(baseUrl("aa.base.url", testDataPropertyPath));
        loginPage = new LoginPage();
        mainPage = new MainPage();
        mainPage.clickLoginLink();
        loginPage.enterNumber("aa.user.number", testDataPropertyPath);
        loginPage.enterPassword("aa.user.password", testDataPropertyPath);
        loginPage.clickLoginButton();
        assertTrue(mainPage.verifyDOTWIsPresent(), "The DOTW section is absent on MHP page.");
    }
}
