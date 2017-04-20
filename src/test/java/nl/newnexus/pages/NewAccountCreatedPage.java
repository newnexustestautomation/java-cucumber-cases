package nl.newnexus.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Tester on 4/20/2017.
 */
public class NewAccountCreatedPage extends AbstractPageObject {
    @FindBy(id = "bodyContent")
    private WebElement elementBodyContent;

    public NewAccountCreatedPage(final WebDriver webDriver) {
        super(webDriver);
    }

    private WebElement getTextElement() {
        final List<WebElement> headerElements = this.elementBodyContent.findElements(By.tagName("h1"));

        return headerElements.iterator().next();
    }

    protected boolean isInitialized() {
        final WebElement elementText = getTextElement();

        return elementText.isDisplayed();
    }

    public boolean isAccountCreated() {
        final WebElement elementText = getTextElement();

        return "Your Account Has Been Created!".equals(elementText.getText());
    }
}
