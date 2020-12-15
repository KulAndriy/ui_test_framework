package pages;

import org.openqa.selenium.support.PageFactory;
import webelements.FieldDecorator;
import webdriver.DriverWrapper;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(new FieldDecorator(DriverWrapper.getDriver()),this);
    }
}
