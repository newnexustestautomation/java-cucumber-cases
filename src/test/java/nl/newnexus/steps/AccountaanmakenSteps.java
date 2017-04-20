package nl.newnexus.steps;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import cucumber.api.java.nl.Gegeven;
import nl.newnexus.pages.CreateAccount;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Tester on 4/19/2017.
 */



public class AccountaanmakenSteps {
    WebDriver driver;
    CreateAccount createAccount;

    @Gegeven("^Gebruiker navigeert naar website$")
    public void gebruikerNavigeertNaarWebsite() throws Throwable {
        //driver.get("http://test-pc/catalog/create_account.php");
        createAccount= new CreateAccount(driver);
        createAccount.getDriver().get("http://test-pc/catalog/create_account.php");

    }

    @Als("^gebruiker zijn gegevens invult$")
    public void gebruikerZijnGegevensInvult() throws Throwable {

        String fn= "Carl";
        String ln= "ter Beek";
        String dob = "12/29/1981";
        String em = "test@test.nl";
        String pw = "testcarl";
        String cf = "testcarl";

        createAccount.vulAccountInformatieIn(fn,ln,dob,em);
        createAccount.vulPasswordIn(pw,cf);
        createAccount.clickOpAanmaken();

    }

    @Dan("^word er een nieuwe account voor gebruiker aangemaakt$")
    public void wordErEenNieuweAccountVoorGebruikerAangemaakt() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Deze som klopt niet", 1+1,2);
    }

    @En("^kan het nieuwe gebruiker inloggen$")
    public void kanHetNieuweGebruikerInloggen() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }
}
