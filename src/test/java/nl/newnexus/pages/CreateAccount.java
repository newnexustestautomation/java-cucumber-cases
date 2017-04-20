package nl.newnexus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by Tester on 4/19/2017.
 */
public class CreateAccount extends PageObject {

    @FindBy(className = "messageStackError")
    private WebElement foutmelding;

    @FindBy(id="bodyContent")
    private WebElement content;

    @FindBy(name="gender")
    private List<WebElement> gender;

    @FindBy(name="firstname")
    private WebElement firstName;

    @FindBy(name="lastname")
    private WebElement lastName;

    @FindBy(name="dob")
    private WebElement date;

    @FindBy(name="email_address")
    private WebElement email;

    @FindBy(name="street_address")
    private WebElement streetadress;

    @FindBy(name="postcode")
    private WebElement postcode;

    @FindBy(name="country")
    private WebElement country;

    @FindBy(name="state")
    private WebElement state;

    @FindBy(name="city")
    private WebElement city;

    @FindBy(name="suburb")
    private WebElement suburb;

    @FindBy(name="telephone")
    private WebElement telephone;

    @FindBy(name="password")
    private WebElement password;

    @FindBy(name="confirmation")
    private WebElement confirmation;

    @FindBy(id="tdb4")
    private WebElement continuebutton;

    public CreateAccount(WebDriver driver) {
        super(driver);
    }

    public Boolean wordtPaginaGetoond() {

        String text = content.getText().toLowerCase();

        if (text.contains("account information"))
            return true;
        else
            return false;

    }

    public Boolean vulAccountInformatieIn(String fn, String ln, String dob, String em)
    {
        for (WebElement e : gender) {
            if (e.getAttribute("value").equalsIgnoreCase("m"))
                e.click();
        }

        //country.sendKeys("Netherlands");
        Select countryDropdown = new Select(country);
        countryDropdown.selectByVisibleText("Netherlands");

        firstName.sendKeys(fn);
        lastName.sendKeys(ln);
        date.sendKeys(dob);
        email.sendKeys(em);
        telephone.sendKeys("06147067060");
        streetadress.sendKeys("teststraat");
        suburb.sendKeys("test");
        city.sendKeys("Groningen");
        state.sendKeys("Groningen");
        postcode.sendKeys("9736CD");
        return true;
    }


//    public void enterName(){
//        this.gender.ge
//        this.firstName.sendKeys("Carl");
//        this.lastName.sendKeys("ter Beek");
//        this.date.sendKeys("29-12-1981");
//        this.email.sendKeys("carlterbeek@home.nl");
//
//    }
//
//    public void enterAddress() {
//        this.streetadress.sendKeys("Jensemaheerd");
//        this.postcode.sendKeys("9736CD");
//        this.city.sendKeys("Groningen");
//        this.state.sendKeys("Groningen");
//        this.country.sendKeys("Nederland");
//        this.state.sendKeys("Groningen");
//        this.telefoonummer.sendKeys("Nederland");
//        this.country.sendKeys("Nederland");


    public Boolean vulPasswordIn(String pw, String cf)
    {
        password.sendKeys(pw);
        confirmation.sendKeys(cf);
        return true;
    }

    public Boolean clickOpAanmaken()
    {
        continuebutton.click();
        return true;
    }

    public Boolean checkFoutmelding(String melding) {

        String item = foutmelding.getAttribute("innerHTML").toLowerCase();

        if (item.contains(melding.toLowerCase())) {
            return true;
        } else {
            return false;
        }


    }



    }

