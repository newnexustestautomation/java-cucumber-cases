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

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Tester on 4/19/2017.
 */
public class MyStepdefs {
    private static WebDriver driver;

    private static String browserType = "chrome";

    @Before
    public void before() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");

            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)
                    .pageLoadTimeout(30, TimeUnit.SECONDS)
                    .setScriptTimeout(30, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
        }
    }

    @After
    public void after(Scenario scenario) {
        if (driver != null) {
            try {
                if (scenario.isFailed()) {
                    final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

                    scenario.embed(screenshot, "image/png");
                }
            } finally {
                driver.quit();
            }
        }
    }

    @Dan("^word een accountgegevens aangemaakt$")
    public void wordEenAccountgegevensAangemaakt() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Gegeven("^dat ik geen account heb$")
    public void datIkGeenAccountHeb() throws Throwable {
        final String nameFirst = "John";
        final String nameLast = "Doe";
        final String dateOfBirth = "08/24/1978";
        final String emailAddress = "john@doe.net";
        final String addressStreet = "De Cockstraat 41";
        final String postcode = "9746BV";
        final String city = "Groningen";
        final String state = "Groningen";
        final String country = "Netherlands";
        final String telephone = "01234567890";
        final String password = "test1";

        driver.get("http://test-pc/catalog/");
        driver.manage().window().maximize();

        driver.findElement(By.id("tdb3")).click();
        driver.findElement(By.id("tdb2")).click();

        driver.findElement(By.name("gender")).click();
        driver.findElement(By.name("firstname")).sendKeys(nameFirst);
        driver.findElement(By.name("lastname")).sendKeys(nameLast);
        driver.findElement(By.name("dob")).sendKeys(dateOfBirth);
        driver.findElement(By.name("email_address")).sendKeys(emailAddress);
        driver.findElement(By.name("street_address")).sendKeys(addressStreet);
        driver.findElement(By.name("postcode")).sendKeys(postcode);
        driver.findElement(By.name("city")).sendKeys(city);
        driver.findElement(By.name("state")).sendKeys(state);
        driver.findElement(By.name("country")).sendKeys(country);
        driver.findElement(By.name("telephone")).sendKeys(telephone);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("confirmation")).sendKeys(password);

        driver.findElement(By.id("tdb4")).click();

        final List<WebElement> elements = driver.findElement(By.id("bodyContent")).findElements(By.tagName("h1"));

        Assert.assertEquals(1, elements.size());

        final WebElement webElement = elements.iterator().next();

        Assert.assertEquals("Your Account Has Been Created!", webElement.getText());

        // PageFactory.initElements(driver, this); // this == page!
    }

    @En("^op Continue klik$")
    public void opKlik() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Als("^ik een accountgegevens invul voor \"([^\"]*)\" \"([^\"]*)\", \"([^\"]*)\" en \"([^\"]*)\" met een standaard adres$")
    public void ikEenAccountgegevensInvulVoorEnMetEenStandaardAdres(String arg0, String arg1, String arg2, String
            arg3) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @En("^op My Account klik$")
    public void opMyAccountKlik() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
