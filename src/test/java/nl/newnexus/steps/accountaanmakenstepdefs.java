package nl.newnexus.steps;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import cucumber.api.java.nl.Gegeven;

import nl.newnexus.pages.CreateAccount;
import org.junit.Assert;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Tester on 4/19/2017.
 */
public class accountaanmakenstepdefs {
    protected static WebDriver driver;
    private static String browserType = "chrome";

    @Before
    public void Start() {

        if (driver == null  ) {
            System.setProperty("webdriver.chrome.driver","driver//chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts()     .implicitlyWait(5, TimeUnit.SECONDS)
                    .pageLoadTimeout(30, TimeUnit.SECONDS)
                    .setScriptTimeout(30, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
            driver.get("http://localhost/catalog");
        }
    }

    @After
    public void Stop(Scenario scenario) {

        if (driver != null) {
            try {
                if (scenario.isFailed()) {
                    final byte[] screenshot = ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.BYTES);
                    scenario.embed(screenshot, "image/png");
                }
            } finally {
                driver.quit();
            }
        }
    }

    @Gegeven("^het scherm 'account aanmaken' zichtbaar is$")
    public void hetSchermAccountAanmakenZichtbaarIs() throws Throwable {
        CreateAccount createAccount = new CreateAccount(driver);
        createAccount.clickCreateAccount();
        Assert.assertTrue(createAccount.isInitialized());
        // Write code here that turns the phrase above into concrete actions

    }

    @Als("^ik de accountgegevens invul voor \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" en \"([^\"]*)\"$")
    public void ikDeAccountgegevensInvulVoorEn(String arg0, String arg1, String arg2, String arg3) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        CreateAccount createAccount = new CreateAccount(driver);
        //createAccount
        createAccount.enterName(arg0, arg1);
        createAccount.enterDateOfBirth(arg2);
        createAccount.enterEmail(arg3);

    }

    @En("^het password met 'test(\\d+)'$")
    public void hetPasswordMetTest(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        CreateAccount createAccount = new CreateAccount((driver));
        createAccount.enterPassword(arg0);
        createAccount.enterPasswordConfirmation(arg0);
    }

    @En("^als ik op de knop 'aanmaken' klik$")
    public void alsIkOpDeKnopAanmakenKlik() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        CreateAccount createAccount = new CreateAccount((driver));
        createAccount.submit();
    }

    @Dan("^komen mijn gegevens in de database$")
    public void komenMijnGegevensInDeDatabase() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @En("^kan ik inloggen$")
    public void kanIkInloggen() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
