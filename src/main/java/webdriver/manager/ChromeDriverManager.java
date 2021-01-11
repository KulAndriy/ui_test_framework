package webdriver.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("window-size=1936,1056");
            return driver = new ChromeDriver(chromeOptions);
    }

    public static ChromeDriverManager getChromeDriverManagerInstance(){
        if(chromeDriverManagerInstance == null){
            chromeDriverManagerInstance = new ChromeDriverManager();
        }
        return chromeDriverManagerInstance;
    }
}
