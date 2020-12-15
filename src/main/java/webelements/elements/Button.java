package webelements.elements;

import org.openqa.selenium.WebElement;

public class Button extends WebElements {
    protected WebElement element;

    public Button(WebElement element) {
        this.element = element;
    }

    public void click() {
        element.click();
    }

    public WebElement getElement(){
        return element;
    }
}
