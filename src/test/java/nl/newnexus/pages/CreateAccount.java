package nl.newnexus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Tester on 3/28/2017.
 */
public class CreateAccount {

    private WebDriver driver;

    @FindBy(className = "messageStackError")
    private WebElement foutmelding;

    @FindBy(id="bodyContent")
    private WebElement content;

    @FindBy(name="firstname")
    private WebElement firstname;

    @FindBy(name="lastname")
    private WebElement lastname;

    @FindBy(name="dob")
    private WebElement dayofbirth;

    @FindBy(name="email_address")
    private WebElement emailaddress;

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

    @FindBy(name="gender")
    private List<WebElement> gender;

    @FindBy(name="telephone")
    private WebElement telephone;

    @FindBy(name="password")
    private WebElement password;

    @FindBy(name="confirmation")
    private WebElement confirmation;

    @FindBy(id="tdb4")
    private WebElement continuebutton;

    public CreateAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
            System.out.println(e.getAttribute("value"));
            if (e.getAttribute("value").equalsIgnoreCase("m"))
                e.click();
        }

        country.sendKeys("Netherlands");
        firstname.sendKeys(fn);
        lastname.sendKeys(ln);
        dayofbirth.sendKeys(dob);
        emailaddress.sendKeys(em);
        telephone.sendKeys("1234567890");
        streetadress.sendKeys("teststraat");
        suburb.sendKeys("test");
        city.sendKeys("Groningen");
        state.sendKeys("Groningen");
        postcode.sendKeys("9713SW");
        return true;
    }

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
