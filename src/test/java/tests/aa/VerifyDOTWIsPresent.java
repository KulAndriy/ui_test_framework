package tests.aa;

import io.qameta.allure.Epic;
import io.qameta.allure.Epics;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import tests.BaseTest;
import webdriver.DriverWrapper;
import webdriver.factory.DriverType;

import static org.testng.Assert.assertTrue;

public class VerifyDOTWIsPresent extends BaseTest {
    /**
     * Verify DOTW section on desktop
     */
//    @Epics(value = {@Epic(value = "CHROME"), @Epic(value = "FIREFOX"), @Epic(value = "EDGE")})
    @Feature(value = "Verify DOTW section on different devices")
    @Story(value = "Verify DOTW section on desktop")
    @Test(dataProvider = "dp")
    public void verifyDOTWOnDesktop(String driverType){
        DriverWrapper.setDriver(DriverType.valueOf(driverType));
        DriverWrapper.getDriver().get(baseUrl());
        loginPage = new LoginPage();
        mainPage = new MainPage();
        mainPage.clickLoginLink();
        loginPage.enterNumber("aa.user.number");
        loginPage.enterPassword("aa.user.password");
        loginPage.clickLoginButton();
        assertTrue(mainPage.verifyDOTWIsPresent());
    }
}
