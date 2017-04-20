package nl.newnexus.steps;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import cucumber.api.java.nl.Gegeven;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Tester on 4/19/2017.
 */

public class MyStepdefs {

    protected static WebDriver driver;
    private static String browserType = "chrome";

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



        @Gegeven("^ik heb de website geopend$")
    public void ikHebDeWebsiteGeopend() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
            driver.get("http://localhost/catalog");
            driver.manage().window().maximize();

        }

    @Als("^ik heb de link 'new customer' geklikt$")
    public void ikHebDeLinkNewCustomerGeklikt() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement myaccount = driver.findElement(By.xpath("//*[@id=\"tdb3\"]"));
        myaccount.click();

    }




    @En("^ik mijn gegevens invul voor \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" en #random met een standaard adres$")
    public void ikMijnGegevensInvulVoorEnRandomMetEenStandaardAdres(String arg0, String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement newcustomer = driver.findElement(By.xpath("//*[@id=\"tdb2\"]"));
        newcustomer.click();
        //WebElement gender =
                driver.findElements(By.name("gender")).get(0).click();
        WebElement firstname = driver.findElement(By.name("firstname"));
        firstname.sendKeys("Mark");
        WebElement lastname = driver.findElement(By.name("lastname"));
        lastname.sendKeys("Winters");
        WebElement dob = driver.findElement(By.name("dob"));
        dob.sendKeys("05/21/1970");

        WebElement email = driver.findElement(By.name("email_address"));
        Random rd = new Random();
        String emailaddress = rd.nextInt(10000000) + "test@mail.nl";
        email.sendKeys(emailaddress);

        WebElement streetaddress = driver.findElement(By.name("street_address"));
        streetaddress.sendKeys("Kalverstraat");
        WebElement postcode = driver.findElement(By.name("postcode"));
        postcode.sendKeys("9766PC");
        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Eelderwolde");
        WebElement state = driver.findElement(By.name("state"));
        state.sendKeys("Drenthe");
        WebElement country = driver.findElement(By.name("country"));
        country.sendKeys("Net");
        WebElement phone = driver.findElement(By.name("telephone"));
        phone.sendKeys("0681810172");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("123456");
        WebElement confirmation = driver.findElement(By.name("confirmation"));
        confirmation.sendKeys("123456");
        WebElement confirmbutton = driver.findElement(By.id("tdb4"));
        confirmbutton.click();

    }

    @Dan("^wordt mijn account aangemaakt$")
    public void wordtMijnAccountAangemaakt() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement melding = driver.findElement(By.id("bodyContent"));
        Assert.assertTrue("account niet aangemaakt",melding.getText().contains("Created!"));
    }


}
