package nl.newnexus.steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import cucumber.api.java.nl.Gegeven;
import nl.newnexus.database.acties.DatabaseActies;
import nl.newnexus.database.entiteiten.Customers;
import nl.newnexus.entiteiten.User;
import nl.newnexus.pages.*;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Tester on 4/20/2017.
 */
public class MeerdereAccountsStepdefs {
    private static WebDriver webDriver;

    private DatabaseActies databaseActies;

    private List<User> users;

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

    @Gegeven("^Het scherm 'account aanmaken' zichtbaar is$")
    public void hetSchermAccountAanmakenZichtbaarIs() throws Throwable {
        webDriver.get("http://test-pc/catalog/");
        webDriver.manage().window().maximize();

        navigeerNaarNewAccountsPage();
    }

    private void navigeerNaarNewAccountsPage() {
        final CatalogPage catalogPage = new CatalogPage(webDriver);

        Assert.assertTrue(catalogPage.isInitialized());

        catalogPage.navigateMyAccountPage();

        final MyAccountPage myAccountPage = new MyAccountPage(webDriver);

        Assert.assertTrue(myAccountPage.isInitialized());

        myAccountPage.navigateToNewCustomerPage();

        final NewCustomerPage newCustomerPage = new NewCustomerPage(webDriver);

        Assert.assertTrue(newCustomerPage.isInitialized());
    }

    private void maakUserAccount(final User user) {
        final NewCustomerPage newCustomerPage = new NewCustomerPage(webDriver);

        newCustomerPage.fillNewCustomer(user);
        newCustomerPage.createNewCustomer();

        final NewAccountCreatedPage newAccountCreatedPage = new NewAccountCreatedPage(webDriver);

        Assert.assertTrue(newAccountCreatedPage.isAccountCreated());

        newAccountCreatedPage.logoff();

        final LogoffPage logoffPage = new LogoffPage(webDriver);

        logoffPage.continueAfterLogoff();

        navigeerNaarNewAccountsPage();
    }

    @Dan("^moeten deze accounts aangemaakt zijn$")
    public void moetenDezeAccountsAangemaaktZijn() throws Throwable {
        Assert.assertTrue(accountsAanwezigInDatabase());
    }

    private Collection<String> getEmailAddresses() {
        final List<String> emailAddresses = new ArrayList<>();

        for (final User user : users) {
            final String emailAddress = user.getEmailAddress();

            emailAddresses.add(emailAddress);
        }

        return emailAddresses;
    }

    private boolean accountsAanwezigInDatabase() {
        final Collection<String> emailAddresses = getEmailAddresses();

        final EntityManager entityManager = this.databaseActies.getEntityManager();
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Customers> criteriaQuery = criteriaBuilder.createQuery(Customers.class);
        final Root<Customers> root = criteriaQuery.from(Customers.class);
        final Predicate predicateEmailAddress = root.get("customersEmailAddress").in(emailAddresses);

        criteriaQuery.where(predicateEmailAddress);
        criteriaQuery.select(root);

        final TypedQuery<Customers> typedQuery = entityManager.createQuery(criteriaQuery);
        final List<Customers> resultList = typedQuery.getResultList();

        return resultList.size() == emailAddresses.size();
    }

    @En("^deze accounts zijn aangemaakt$")
    public void dezeAccountsZijnAangemaakt(final DataTable dataTable) throws Throwable {
        this.users = new ArrayList<>();

        final List<List<String>> lists = dataTable.raw();

        for (final List<String> list : lists) {
            final String nameFirst = list.get(0);
            final String nameLast = list.get(1);
            final String dateOfBirth = list.get(2);
            final String emailAddress = list.get(3);

            final User user = new User();

            user.setEmailAddress(emailAddress);
            user.setNameFirst(nameFirst);
            user.setNameLast(nameLast);
            user.setDateOfBirth(dateOfBirth);

            maakUserAccount(user);

            this.users.add(user);
        }
    }
}
