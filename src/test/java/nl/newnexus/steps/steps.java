package nl.newnexus.steps;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import cucumber.api.java.nl.Gegeven;
import nl.newnexus.database.acties.DatabaseActies;
import nl.newnexus.pages.CreateAccount;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Tester on 4/17/2017.
 */
public class steps {

    protected static WebDriver driver;
    private static String browserType = "chrome";
    
    private DatabaseActies dbActies;
    private String emailadres = "";

    @Before
    public void Start() {

        if (driver == null  ) {
            System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts()     .implicitlyWait(5, TimeUnit.SECONDS)
                    .pageLoadTimeout(30, TimeUnit.SECONDS)
                    .setScriptTimeout(30, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
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

        driver = null;
    }


    @Als("^ik een accountgegevens invul voor \"([^\"]*)\" \"([^\"]*)\", \"([^\"]*)\" en \"([^\"]*)\" met een standaard adres$")
    public void ikEenAccountgegevensInvulVoorEnMetEenStandaardAdres(String voornaam, String achternaam, String geboortedatum, String emailadres) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        CreateAccount create = new CreateAccount(driver);
        Assert.assertEquals("",true,create.wordtPaginaGetoond());

        Random rd = new Random();
        if (emailadres.equalsIgnoreCase("#random")) {
            emailadres = rd.nextInt(1000000)+ "test@test.nl";
        }
        //

        Assert.assertEquals("",true,create.vulAccountInformatieIn(voornaam,achternaam,geboortedatum,emailadres));
        this.emailadres = emailadres;
    }

    @Gegeven("^het scherm ‘account aanmaken’ zichtbaar is$")
    public void hetSchermAccountAanmakenZichtbaarIs() throws Throwable {

        // Write code here that turns the phrase above into concrete actions
        this.driver.get("http://localhost/catalog");
        this.driver.manage().window().maximize();

        String title = this.driver.getTitle();
        Assert.assertTrue(title.toLowerCase().contains("newnexus movies and more"));

        WebElement element = this.driver.findElement(By.linkText("create an account"));
        if (element.isDisplayed())
            element.click();

        CreateAccount create = new CreateAccount(this.driver);
        Assert.assertEquals("",true,create.wordtPaginaGetoond());

        //Assert.assertEquals("Kan niet op de link klikken", true, main.GoToCreateAnAccount());
    }


    @En("^het password met \"([^\"]*)\"$")
    public void hetPasswordMet(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        CreateAccount create = new CreateAccount(driver);
        Assert.assertEquals("", true, create.vulPasswordIn(arg0, arg0));
    }

    @En("^als ik op de knop ‘aanmaken' klik$")
    public void alsIkOpDeKnopAanmakenKlik() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        CreateAccount create = new CreateAccount(driver);
        Assert.assertEquals("",true,create.clickOpAanmaken());
    }

    @Dan("^komen mijn gegevens in de database$")
    public void komenMijnGegevensInDeDatabase() throws Throwable {
        Assert.assertTrue(dbActies.accountAanwezig(this.emailadres));
    }

    @En("^kan ik inloggen$")
    public void kanIkInloggen() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


}
