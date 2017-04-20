package nl.newnexus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Tester on 4/20/2017.
 */
public abstract class AbstractPageObject {
    private final WebDriver webDriver;

    public AbstractPageObject(final WebDriver webDriver) {
        this.webDriver = webDriver;

        PageFactory.initElements(webDriver, this);
    }

    protected WebDriver getWebDriver() {
        return this.webDriver;
    }

    protected abstract boolean isInitialized();
}
