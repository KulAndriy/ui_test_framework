package elements;

import interfaces.elements.IButton;
import org.openqa.selenium.WebElement;

public class Button implements IButton {
    protected WebElement element;

    public Button(WebElement element) {
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
