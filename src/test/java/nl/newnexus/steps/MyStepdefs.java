package nl.newnexus.steps;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import cucumber.api.java.nl.Gegeven;
//import gherkin.formatter.model.Scenario;
import nl.newnexus.database.acties.DatabaseActies;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


/**
 * Created by Tester on 4/19/2017.
 */


public class MyStepdefs {

    protected static WebDriver driver;

    private static String browserType = "chrome";

    private static final String PASSWORD = "Secret" + String.valueOf(new Random().nextInt(100000));
    private static final String EMAILADDRESS = "Me" + String.valueOf(new Random().nextInt(100000)+ "@test.nl");

    private DatabaseActies dbActies;


    @Before
    public void Start() {
        initDriver();
        dbActies = DatabaseActies.getInstance();

        if (!dbActies.valid){
            dbActies.init();
        }

    }

    private void initDriver() {
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


    @Als("^ik klik op \"([^\"]*)\"$")
    public void ikKlikOp(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        ////throw new PendingException();
        //Assert.assertEquals("Deze som klopt niet", 1+1,3);
        WebElement buttonMyAccount = driver.findElement(By.linkText("My Account"));
        buttonMyAccount.click();
    }

    @Gegeven("^de applicatie is opgestart$")
    public void deApplicatieIsOpgestart() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://localhost/catalog");
        driver.manage().window().maximize();


        //throw new PendingException();
    }

    @En("^het inlogscherm is actief$")
    public void hetInlogschermIsActief() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        //throw new PendingException();
    }

    @En("^vervolgens klik \"([^\"]*)\"$")
    public void vervolgensKlik(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement buttonContinue = driver.findElement(By.linkText("Continue"));
        buttonContinue.click();
        //throw new PendingException();
    }

    @Dan("^opent het scherm \"([^\"]*)\"$")
    public void opentHetScherm(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //NOG JUISTE XPATH + TEKST TOEVOEGEN Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"bodyContent\"]/p")).getText().equals("NOTE: If you already have an account with us, please login at the login page."));
        //throw new PendingException();
    }

    @Gegeven("^het scherm \"([^\"]*)\" is geopend$")
    public void hetSchermIsGeopend(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"bodyContent\"]/p")).getText().equals("NOTE: If you already have an account with us, please login at the login page."));
        //throw new PendingException();
    }

    @Als("^ik alle verplichte velden vul$")
    public void ikAlleVerplichteVeldenVul() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement radiobuttonGender = driver.findElement(By.name("gender"));
        WebElement editboxFirstName = driver.findElement(By.name("firstname"));
        WebElement editboxLastName = driver.findElement(By.name("lastname"));
        WebElement editboxDOB = driver.findElement(By.name("dob"));
        WebElement editboxEmailAddresss = driver.findElement(By.name("email_address"));
        WebElement editboxCompanyName = driver.findElement(By.name("company"));
        WebElement editboxStreetAddress = driver.findElement(By.name("street_address"));
        WebElement editboxSuburb = driver.findElement(By.name("suburb"));
        WebElement editboxPostCode = driver.findElement(By.name("postcode"));
        WebElement editboxCity = driver.findElement(By.name("city"));
        WebElement editboxState = driver.findElement(By.name("state"));
        WebElement listboxCountry = driver.findElement(By.name("country"));
        WebElement editboxTelephoneNumber = driver.findElement(By.name("telephone"));
        WebElement editboxFaxNumber = driver.findElement(By.name("fax"));
        WebElement checkboxNewsletter = driver.findElement(By.name("newsletter"));
        WebElement editboxPassword = driver.findElement(By.name("password"));
        WebElement editboxPasswordConfirmation = driver.findElement(By.name("confirmation"));
        WebElement buttonContinue = driver.findElement(By.id("tdb4"));

        Random rd = new Random();


        radiobuttonGender.click();
        editboxFirstName.sendKeys("Sjakie" + rd.nextInt(10000));
        editboxLastName.sendKeys("Schildpad");
        editboxDOB.sendKeys("06/11/1990");
        editboxEmailAddresss.sendKeys(EMAILADDRESS);
        editboxCity.sendKeys("Testdorp");
        editboxCompanyName.sendKeys("Test BV");
        editboxStreetAddress.sendKeys("Testlaan 45");
        editboxSuburb.sendKeys("Testbuurt");
        editboxPostCode.sendKeys("1000 AB");
        editboxState.sendKeys("Noord Testland");
        listboxCountry.sendKeys("Netherlands");
        editboxTelephoneNumber.sendKeys("06-12345678");
        editboxFaxNumber.sendKeys("050-1234567");
        checkboxNewsletter.click();
        editboxPassword.sendKeys(PASSWORD);
        editboxPasswordConfirmation.sendKeys(PASSWORD);
        buttonContinue.click();
        //throw new PendingException();
    }

    @En("^klik op \"([^\"]*)\"$")
    public void klikOp(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @Gegeven("^het scherm \"([^\"]*)\"$")
    public void hetScherm(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @Dan("^opent het wederom scherm \"([^\"]*)\"$")
    public void opentHetWederomScherm(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"bodyContent\"]/div/div[1]/ul/li[1]/a")).getText().equals("View or change my account information."));
        //throw new PendingException();
        //*[@id="bodyContent"]/div/div[1]/ul/li[1]/a
    }

    @En("^kan ik na het uitloggen weer opnieuw inloggen$")
    public void kanIkNaHetUitloggenWeerOpnieuwInloggen() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement buttonLogout = driver.findElement(By.id("tdb4"));
        //*[@id="tdb4"]/span
        buttonLogout.click();

        WebElement buttonContinue = driver.findElement(By.linkText("Continue"));
        buttonContinue.click();

        WebElement buttonMyAccount = driver.findElement(By.linkText("My Account"));
        buttonMyAccount.click();

        WebElement editboxEmailAddresss = driver.findElement(By.name("email_address"));
        editboxEmailAddresss.sendKeys(EMAILADDRESS);
        WebElement editboxPassword = driver.findElement(By.name("password"));
        editboxPassword.sendKeys(PASSWORD);
        WebElement buttonSignIn = driver.findElement(By.id("tdb1"));
        buttonSignIn.click();
        //synchronized (this){
          //  wait(5000);}



        //throw new PendingException();
    }


    @En("^is de gebruiker opgeslagen in de database$")
    public void isDeGebruikerOpgeslagenInDeDatabase() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(dbActies.accountAanwezig(EMAILADDRESS));
        //throw new PendingException();
    }
}
