package nl.newnexus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Tester on 4/19/2017.
 */
public class CreateAccount extends PageObject {

    WebDriver driver;

    @FindBy(name="gender")
    private List<WebElement> gender;

    @FindBy(id="firstename")
    private WebElement firstName;

    @FindBy(id="lastename")
    private WebElement lastName;

    @FindBy(name="dob")
    private WebElement date;

    @FindBy(id="email_adress")
    private WebElement email;

    @FindBy(id="address")
    private WebElement address;

    @FindBy(id="zipcode")
    private WebElement zipcodename;

    @FindBy(id="signup")
    private WebElement signup;

    @FindBy(id="tdb4")
    private WebElement continuebutton;

    @FindBy(id="tdb5")
    private WebElement myaccountbutton;

    public CreateAccount(WebDriver driver) {
        super(driver);
    }

    public void enterName(){
        this.firstName.sendKeys("Carl");
        this.lastName.sendKeys("ter Beek");
        this.date.sendKeys("29-12-1981");
        this.email.sendKeys("carlterbeek@home.nl");

    }

//    public void enterAdress(){
//        this.firstName.clear();
//        this.lastName.clear();
//        this.date.clear();
//        this.email.clear();
//        this.firstName.sendKeys("Carl");
//        this.lastName.sendKeys("ter Beek");
//        this.lastName.sendKeys("29-12-1981");
//        this.lastName.sendKeys("carlterbeek@home.nl");

//
//    public ReceiptPage submit(){
//        submitButton.click();
//        return new ReceiptPage(driver);
//    }


    }

