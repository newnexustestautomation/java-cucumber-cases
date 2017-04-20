package nl.newnexus.pages;

import nl.newnexus.entity.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

/**
 * Created by Tester on 4/20/2017.
 */
public class NewCustomerPage extends AbstractPageObject {
    @FindBy(name = "gender")
    private WebElement elementGender;

    @FindBy(name = "firstname")
    private WebElement elementNameFirst;

    @FindBy(name = "lastname")
    private WebElement elementNameLast;

    @FindBy(name = "dob")
    private WebElement elementDateOfBirth;

    @FindBy(name = "email_address")
    private WebElement elementEmailAddress;

    @FindBy(name = "street_address")
    private WebElement elementAddressStreet;

    @FindBy(name = "postcode")
    private WebElement elementPostcode;

    @FindBy(name = "city")
    private WebElement elementCity;

    @FindBy(name = "state")
    private WebElement elementState;

    @FindBy(name = "country")
    private WebElement elementCountry;

    @FindBy(name = "telephone")
    private WebElement elementTelephone;

    @FindBy(name = "password")
    private WebElement elementPassword;

    @FindBy(name = "confirmation")
    private WebElement elementPasswordConfirmation;

    @FindBy(id = "tdb4")
    private WebElement elementMaakAccount;

    public NewCustomerPage(final WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public boolean isInitialized() {
        return this.elementGender.isDisplayed();
    }

    private String getRandomName() {
        final int number = (int)(Math.random() * 10000.0);

        return String.valueOf(number);
    }

    private static final String PW = String.valueOf(new Random().nextInt()) + "";

    public void fillNewCustomer(final User user) {
        final String emailAddress = getRandomName().concat("@doe.nl");
        final String addressStreet = "De Cockstraat 41";
        final String postcode = "9746BV";
        final String city = "Groningen";
        final String state = "Groningen";
        final String country = "Netherlands";
        final String telephone = "01234567890";
        final String password = "test1";

        elementGender.click();
        elementNameFirst.sendKeys(user.getNameFirst());
        elementNameLast.sendKeys(user.getNameLast());
        elementDateOfBirth.sendKeys(user.getDateOfBirth());
        elementEmailAddress.sendKeys(emailAddress);
        elementAddressStreet.sendKeys(addressStreet);
        elementPostcode.sendKeys(postcode);
        elementCity.sendKeys(city);
        elementState.sendKeys(state);
        elementCountry.sendKeys(country);
        elementTelephone.sendKeys(telephone);
        elementPassword.sendKeys(password);
        elementPasswordConfirmation.sendKeys(password);
    }

    public void createNewCustomer() {
        this.elementMaakAccount.click();
    }
}
