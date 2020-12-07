package webdriver.manager;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    public WebDriver driver;
    protected abstract void setDriverProperty();
    protected abstract WebDriver createDriver();

    public WebDriver getDriverByType(){
//        if (driver == null){
            driver = createDriver();
//        }
        return driver;
    }

}
