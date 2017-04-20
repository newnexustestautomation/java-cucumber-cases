package nl.newnexus.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Tester on 4/19/2017.
 */
public class CreateAccount extends PageObject{

    @FindBy(linkText = "create an account")
    private WebElement createAccount;

    @FindBy(name="gender")
    private List<WebElement> gender;

    @FindBy(name="firstname")
    private WebElement firstName;

    @FindBy(name="lastname")
    private WebElement lastName;

    @FindBy(name="dob")
    private  WebElement birthDate;

    @FindBy(name="password")
    private  WebElement password;

    @FindBy(name="confirmation")
    private  WebElement passwordConfirmation;

    @FindBy(name="street_address")
    private WebElement address;

    @FindBy(name="postcode")
    private WebElement zipCode;

    @FindBy(name="email_address")
    private  WebElement email;

    @FindBy(linkText="Continue")
    private WebElement submitButton;

    public CreateAccount(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public  void clickCreateAccount(){
        this.createAccount.click();
    }
    public boolean isInitialized() {
        return firstName.isDisplayed();
    }

    public void selectGender(String gender){

    }

    public void enterPassword(String password){
        this.password.clear();
        this.password.sendKeys(password);
    }

    public void enterPasswordConfirmation(String confirmation){
        this.passwordConfirmation.clear();
        this.passwordConfirmation.sendKeys(confirmation);
    }

    public void enterName(String firstName, String lastName){
        this.firstName.clear();
        this.firstName.sendKeys(firstName);

        this.lastName.clear();
        this.lastName.sendKeys(lastName);
    }

    public void enterAddress(String address, String zipCode){
        this.address.clear();
        this.address.sendKeys(address);

        this.zipCode.clear();
        this.zipCode.sendKeys((address));
    }

    public void enterDateOfBirth(String dateOfBirth){
        this.birthDate.clear();
        this.birthDate.sendKeys(dateOfBirth);
    }

    public void enterEmail(String email){
        this.email.clear();
    }
    public  CreateAccount submit(){
        submitButton.click();
        return new CreateAccount(driver);
    }
}
