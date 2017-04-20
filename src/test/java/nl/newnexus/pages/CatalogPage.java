package nl.newnexus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Tester on 4/20/2017.
 */
public class CatalogPage {
    private WebDriver webDriver;

    @FindBy(className = "greetUser")
    private WebElement greetUserElement;

    @FindBy(id = "tdb3")
    private WebElement myAccountWebElement;

    public CatalogPage(final WebDriver webDriver) {
        this.webDriver = webDriver;

        PageFactory.initElements(webDriver, this);
    }

    public boolean isInitialized() {
        return this.greetUserElement.isDisplayed();
    }

    public void navigateMyAccountPage() {
        this.myAccountWebElement.click();
    }
}
