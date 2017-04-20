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

    @Before
    public void Start() {

        if (driver == null  ) {
            System.setProperty("webdriver.chrome.driver","drivers//chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts()     .implicitlyWait(5, TimeUnit.SECONDS)
                    .pageLoadTimeout(30, TimeUnit.SECONDS)
                    .setScriptTimeout(30, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
        }
    }


    @After
    public void Stop(Scenario scenario){

        if(driver!=null){
            try{
                if(scenario.isFailed()){
                    final byte[]screenshot=((TakesScreenshot)driver)
                            .getScreenshotAs(OutputType.BYTES);
                    scenario.embed(screenshot,"image/png");
                }
            }finally{
                driver.quit();
            }
        }

    }


    @Gegeven("^Gebruiker navigeert naar website$")
    public void gebruikerNavigeertNaarWebsite() throws Throwable {

        CreateAccount createAccount= new CreateAccount(driver);
        driver.get("http://test-pc/catalog/create_account.php");

    }

    @Als("^gebruiker zijn gegevens invult$")
    public void gebruikerZijnGegevensInvult() throws Throwable {


        createAccount.enterName();




    }

    @Dan("^word er een nieuwe account voor gebruiker aangemaakt$")
    public void wordErEenNieuweAccountVoorGebruikerAangemaakt() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Deze som klopt niet", 1+1,2);
    }

    @En("^kan het nieuwe gebruiker inloggen$")
    public void kanHetNieuweGebruikerInloggen() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Deze som klopt niet", 1+1,2);
    }
}
