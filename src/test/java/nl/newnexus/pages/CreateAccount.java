package nl.newnexus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Tester on 4/19/2017.
 */

public class CreateAccount extends PageObject{

    public CreateAccount(WebDriver driver){
        super(driver);
    }

    @FindBy(name= "gender")
    private List<WebElement> Genders;

    @FindBy(name = "firstname")
    private WebElement firstName;

    @FindBy(name= "lastname")
    private WebElement lastName;

    @FindBy(name= "dob")
    private WebElement birthDate;

    @FindBy(name= "email_address")
    private WebElement emailAddress;

    @FindBy(name= "street_address")
    private WebElement streetAddress;

    @FindBy(name= "postcode")
    private WebElement postCode;

    @FindBy(name= "city")
    private WebElement city;

    @FindBy(name= "state")
    private WebElement state;

    @FindBy(name= "country")
    private WebElement country;

    @FindBy(name= "telephone")
    private WebElement telePhone;

    @FindBy(name= "password")
    private WebElement passWord;

    @FindBy(name= "confirmation")
    private WebElement confirmPassWord;

    @FindBy(xpath= "//*[@id=\"tdb4\"]/span[2]")
    private WebElement buttonContinue;

    @FindBy(id= "bodyContent")
    private WebElement bodyContent;

    public void selectGender(String genderinput){

        for (WebElement Gender : Genders){
            if (Gender.getAttribute("value").equals(genderinput))
                    Gender.click();
        }
    }

    public void enterName(String inputFirstName, String inputLastName, String inputGeboortedatum, String inputEmailAddress){
        firstName.clear();
        firstName.sendKeys(inputFirstName);
        lastName.clear();
        lastName.sendKeys(inputLastName);
        birthDate.clear();
        birthDate.sendKeys(inputGeboortedatum);
        emailAddress.clear();
        emailAddress.sendKeys(inputEmailAddress);

    }

    public void enterAddress(){
        streetAddress.clear();
        streetAddress.sendKeys("Handelsweg 6-8");
        postCode.clear();
        postCode.sendKeys("9999XX");
        city.clear();
        city.sendKeys("Tynaarlo");
        state.clear();
        state.sendKeys("Drenthe");
        country.sendKeys("Nether");

    }

    public void enterPhoneNumber(String phone){
        telePhone.clear();
        telePhone.sendKeys(phone);
    }

    public void enterPassword(String password){
        passWord.clear();
        passWord.sendKeys(password);
    }

    public void confirmPassword(String password){
        confirmPassWord.clear();
        confirmPassWord.sendKeys(password);
    }

    public void clickButtonContinue(){
        buttonContinue.click();
    }

    public void gotoURL(String url){
        driver.get(url);
    }

    public boolean checkConfirmPage(){
        String pagetext = bodyContent.getText();
        System.out.print(pagetext);
        return pagetext.contains("Your Account Has Been Created!");


    }
}
