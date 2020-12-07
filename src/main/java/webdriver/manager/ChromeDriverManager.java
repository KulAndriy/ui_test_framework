package webdriver.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {
    private static ChromeDriverManager chromeDriverManagerInstance;

    private ChromeDriverManager(){};

    @Override
    protected void setDriverProperty(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/drivers/chromedriver.exe");
    }

    @Override
    public WebDriver createDriver() {
            setDriverProperty();
            return driver = new ChromeDriver();
    }

    public static ChromeDriverManager getChromeDriverManagerInstance(){
        if(chromeDriverManagerInstance == null){
            chromeDriverManagerInstance = new ChromeDriverManager();
        }
        return chromeDriverManagerInstance;
    }
}
