package nl.newnexus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Tester on 4/19/2017.
 */


public class CreateAccount extends PageObject{

    public CreateAccount(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"bodyContent\"]/form/div/div[2]/table/tbody/tr[1]/td[2]/text()[1]")
    private WebElement Gender;

    @FindBy(name = "firstname")
    private WebElement firstName;

    @FindBy(name= "lastname")
    private WebElement lastName;

    @FindBy(name= "dob")
    private WebElement birthDate;

    @FindBy(name= "email_address")
    private WebElement emailAddress;





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

    public void gotoURL(String url){
        driver.get(url);
    }
}
