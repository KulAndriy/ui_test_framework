package tests.aa;

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
    @Test(dataProvider = "browser")
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
