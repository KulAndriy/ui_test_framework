package pages;

import elements.FieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import wrapper.DriverWrapper;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(new FieldDecorator(DriverWrapper.getDriver()),this);
    }
}
