package webDriverSettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager{
    private static FirefoxDriverManager firefoxDriverManagerInstance;

    private FirefoxDriverManager(){};

    @Override
    protected void setDriverProperty() {
        System.setProperty("webdriver.gecko.driver","./src/main/resources/webdrivers/geckodriver.exe");
    }

    @Override
    public WebDriver createDriver() {
        setDriverProperty();
        return driver = new FirefoxDriver();
    }

    public static FirefoxDriverManager getFirefoxDriverManagerInstance(){
        if(firefoxDriverManagerInstance == null){
            firefoxDriverManagerInstance = new FirefoxDriverManager();
        }
        return firefoxDriverManagerInstance;
    }
}
