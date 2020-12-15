package webelements.elements;

import org.openqa.selenium.WebElement;

public class Link extends WebElements {
    protected WebElement element;

    public Link(WebElement element) {
        this.element = element;
    }

    public void click() {
        element.click();
    }

    public WebElement getElement(){
        return element;
    }
}
