package elements;

import interfaces.elements.IInput;
import org.openqa.selenium.WebElement;

public class Input implements IInput {
    protected WebElement element;

    public Input(WebElement element) {
        this.element = element;
    }

    @Override
    public void clear() {
        element.clear();
    }

    @Override
    public void write(String str) {
        element.sendKeys(str);
    }
}
