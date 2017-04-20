package nl.newnexus.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import cucumber.api.java.nl.Gegeven;
import nl.newnexus.database.acties.DatabaseActies;
import nl.newnexus.database.entiteiten.Customers;
import nl.newnexus.entiteiten.User;
import nl.newnexus.pages.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Tester on 4/19/2017.
 */
public class MyStepdefs {
    private static WebDriver webDriver;

    private static String browserType = "chrome";

    private DatabaseActies databaseActies;

    private User user;

    @Before
    public void before() {
        this.databaseActies = DatabaseActies.getDatabaseActiesInstance();

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

                webDriver = null;
            }
        }
    }

    private boolean accountAanwezigInDatabase(final String emailAddress) {
        final EntityManager entityManager = this.databaseActies.getEntityManager();
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Customers> criteriaQuery = criteriaBuilder.createQuery(Customers.class);
        final Root<Customers> root = criteriaQuery.from(Customers.class);
        final Predicate predicateEmailAddress =
                criteriaBuilder.equal(root.get("customersEmailAddress"), emailAddress);

        criteriaQuery.where(predicateEmailAddress);
        criteriaQuery.select(root);

        final TypedQuery<Customers> typedQuery = entityManager.createQuery(criteriaQuery);
        final List<Customers> resultList = typedQuery.getResultList();

        return !resultList.isEmpty();
    }

    @Dan("^word een accountgegevens aangemaakt$")
    public void wordEenAccountgegevensAangemaakt() throws Throwable {
        final NewAccountCreatedPage newAccountCreatedPage = new NewAccountCreatedPage(webDriver);

        Assert.assertTrue(newAccountCreatedPage.isAccountCreated());
        Assert.assertTrue(accountAanwezigInDatabase(this.user.getEmailAddress()));

        newAccountCreatedPage.logoff();

        final LogoffPage logoffPage = new LogoffPage(webDriver);

        logoffPage.continueAfterLogoff();
    }

    @Gegeven("^dat ik geen account heb$")
    public void datIkGeenAccountHeb() throws Throwable {
        final String currentUrl = webDriver.getCurrentUrl();

        if (!"http://test-pc/catalog/index.php".equals(currentUrl)) {
            webDriver.get("http://test-pc/catalog/");
            webDriver.manage().window().maximize();
        }

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

    private String getRandomName() {
        final int number = (int)(Math.random() * 10000.0);

        return String.valueOf(number);
    }

    private String generateEmailAddress() {
        return getRandomName().concat("@doe.nl");
    }

    @Als("^ik een accountgegevens invul voor \"([^\"]*)\" \"([^\"]*)\", \"([^\"]*)\" met een standaard adres$")
    public void ikEenAccountgegevensInvulVoorEnMetEenStandaardAdres(final String nameFirst,
                                                                    final String nameLast,
                                                                    final String dateOfBirth) throws Throwable {
        user = new User();

        user.setDateOfBirth(dateOfBirth);
        user.setNameFirst(nameFirst);
        user.setNameLast(nameLast);
        user.setEmailAddress(generateEmailAddress());

        final NewCustomerPage newCustomerPage = new NewCustomerPage(webDriver);

        newCustomerPage.fillNewCustomer(user);
    }
}
