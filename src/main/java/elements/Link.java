package elements;

import interfaces.elements.ILink;
import org.openqa.selenium.WebElement;

public class Link implements ILink {
    protected WebElement element;

    public Link(WebElement element) {
        this.element = element;
    }

    @Override
    public void click() {
        element.click();
    }

    public WebElement getElement(){
        return element;
    }
}
