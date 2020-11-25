package webDriverSettings;

public class DriverManagerFactory {

    public DriverManager getDriverManager(DriverType type){
        DriverManager driverManager;

        switch (type){
            case CHROME:
                driverManager = ChromeDriverManager.getChromeDriverManagerInstance();
                break;
            case FIREFOX:
                driverManager = FirefoxDriverManager.getFirefoxDriverManagerInstance();
                break;
            case EDGE:
                driverManager = EdgeDriverManager.getEdgeDriverManagerInstance();
                break;
            default:
                driverManager = ChromeDriverManager.getChromeDriverManagerInstance();
        }
        return driverManager;
    }
}
