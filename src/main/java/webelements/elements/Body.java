package webelements.elements;

import org.openqa.selenium.WebElement;

public class Body extends WebElements {
    protected WebElement element;

    public Body(WebElement element) {
        super(element);
        this.element = element;
    }


    public WebElement getBody() {
        return element;
    }
}
