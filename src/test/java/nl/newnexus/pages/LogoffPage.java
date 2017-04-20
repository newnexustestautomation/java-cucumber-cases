package nl.newnexus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Tester on 4/20/2017.
 */
public class LogoffPage extends AbstractPageObject {
    @FindBy(id = "tdb4")
    private WebElement elementContinue;

    public LogoffPage(final WebDriver webDriver) {
        super(webDriver);
    }

    protected boolean isInitialized() {
        return elementContinue.isDisplayed();
    }

    public void continueAfterLogoff() {
        elementContinue.click();
    }
}
