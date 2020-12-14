package elements;

import interfaces.elements.IBody;
import org.openqa.selenium.WebElement;

public class Body implements IBody {
    protected WebElement element;

    public Body(WebElement element) {
        this.element = element;
    }

    @Override
    public WebElement getBody() {
        return element;
    }
}
