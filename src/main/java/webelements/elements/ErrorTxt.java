package webelements.elements;

import org.openqa.selenium.WebElement;

public class ErrorTxt extends WebElements {
    protected WebElement element;

    public ErrorTxt(WebElement element) {
        super(element);
        this.element = element;
    }


    public WebElement getErrorList() {
        return element;
    }
}
