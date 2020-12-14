package elements;

import interfaces.elements.IErrorTxt;
import org.openqa.selenium.WebElement;

public class ErrorTxt implements IErrorTxt {
    protected WebElement element;

    public ErrorTxt(WebElement element) {
        this.element = element;
    }

    @Override
    public WebElement getErrorList() {
        return element;
    }
}
