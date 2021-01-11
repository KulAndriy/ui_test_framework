package webdriver.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverManager extends DriverManager {
    private static EdgeDriverManager edgeDriverManagerInstance;

    private EdgeDriverManager(){};

    @Override
    public void setDriverProperty() {
        System.setProperty("webdriver.edge.driver","./src/main/resources/drivers/msedgedriver.exe");
    }

    @Override
    public WebDriver createDriver() {
            setDriverProperty();
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy("--headless");
            return driver = new EdgeDriver();
    }

    public static EdgeDriverManager getEdgeDriverManagerInstance(){
        if(edgeDriverManagerInstance == null){
            edgeDriverManagerInstance = new EdgeDriverManager();
        }
        return edgeDriverManagerInstance;
    }
}
