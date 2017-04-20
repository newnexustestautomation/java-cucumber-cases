package nl.newnexus.steps;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import cucumber.api.java.nl.Gegeven;
import nl.newnexus.pages.CatalogPage;
import nl.newnexus.pages.MyAccountPage;
import nl.newnexus.pages.NewAccountCreatedPage;
import nl.newnexus.pages.NewCustomerPage;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Tester on 4/19/2017.
 */
public class MyStepdefs {
    private static WebDriver webDriver;

    private static String browserType = "chrome";

    @Before
    public void before() {
        if (webDriver == null) {
            System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");

            webDriver = new ChromeDriver();
            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)
                    .pageLoadTimeout(30, TimeUnit.SECONDS)
                    .setScriptTimeout(30, TimeUnit.SECONDS);
            webDriver.manage().deleteAllCookies();
        }
    }

    @After
    public void after(Scenario scenario) {
        if (webDriver != null) {
            try {
                if (scenario.isFailed()) {
                    final byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);

                    scenario.embed(screenshot, "image/png");
                }
            } finally {
                webDriver.quit();
            }
        }
    }

    @Dan("^word een accountgegevens aangemaakt$")
    public void wordEenAccountgegevensAangemaakt() throws Throwable {
        final NewAccountCreatedPage newAccountCreatedPage = new NewAccountCreatedPage(webDriver);

        Assert.assertTrue(newAccountCreatedPage.isAccountCreated());
    }

    @Gegeven("^dat ik geen account heb$")
    public void datIkGeenAccountHeb() throws Throwable {
        webDriver.get("http://test-pc/catalog/");
        webDriver.manage().window().maximize();

        final CatalogPage catalogPage = new CatalogPage(webDriver);

        Assert.assertTrue(catalogPage.isInitialized());
    }

    @En("^account aanmaken klik$")
    public void opAccountAanmakenKlik() throws Throwable {
        final NewCustomerPage newCustomerPage = new NewCustomerPage(webDriver);

        newCustomerPage.createNewCustomer();
    }

    @En("^dat ik naar de nieuwe account pagina navigeer$")
    public void opNaarDeNieuweAccountPaginaNavigeer() throws Throwable {
        final CatalogPage catalogPage = new CatalogPage(webDriver);

        catalogPage.navigateMyAccountPage();

        final MyAccountPage myAccountPage = new MyAccountPage(webDriver);

        Assert.assertTrue(myAccountPage.isInitialized());

        myAccountPage.navigateToNewCustomerPage();

        final NewCustomerPage newCustomerPage = new NewCustomerPage(webDriver);

        Assert.assertTrue(newCustomerPage.isInitialized());
    }

    @Als("^ik een accountgegevens invul voor \"([^\"]*)\" \"([^\"]*)\", \"([^\"]*)\" en \"([^\"]*)\" met een standaard adres$")
    public void ikEenAccountgegevensInvulVoorEnMetEenStandaardAdres(String arg0, String arg1, String arg2, String
            arg3) throws Throwable {
        final NewCustomerPage newCustomerPage = new NewCustomerPage(webDriver);

        newCustomerPage.fillNewCustomer();
    }
}
