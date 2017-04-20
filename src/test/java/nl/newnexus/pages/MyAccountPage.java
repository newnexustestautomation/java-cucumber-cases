package nl.newnexus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Tester on 4/20/2017.
 */
public class MyAccountPage extends AbstractPageObject {
    private WebDriver webDriver;

    @FindBy(id = "tdb2")
    private WebElement newCustomerWebElement;

    public MyAccountPage(final WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public boolean isInitialized() {
        return this.newCustomerWebElement.isDisplayed();
    }

    public void navigateToNewCustomerPage() {
        this.newCustomerWebElement.click();
    }
}
