package browser;

import org.openqa.selenium.Dimension;
import webdriver.DriverWrapper;

import java.util.HashMap;
import java.util.Map;

public class BrowserSizeHandler {

    private Map<BrowserSize, String> screenSize = null;

    public BrowserSizeHandler() {
        this.screenSize = new HashMap<>();
        screenSize.put(BrowserSize.DESKTOP, "1530x1176");
        screenSize.put(BrowserSize.LAPTOP,"1278x768");
        screenSize.put(BrowserSize.MOBILE,"480x768");
    }

    public void setScreenSize(BrowserSize size) {
        int width = Integer.parseInt(screenSize.get(size).split("x")[0]);
        int height = Integer.parseInt(screenSize.get(size).split("x")[1]);
        DriverWrapper.getDriver().manage().window().setSize(new Dimension(width, height));
    }

    public Dimension getScreenSize(){
        return DriverWrapper.getDriver().manage().window().getSize();
    }

}
