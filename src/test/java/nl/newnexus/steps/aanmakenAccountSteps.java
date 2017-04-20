package nl.newnexus.steps;

import cucumber.api.PendingException;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import cucumber.api.java.nl.Gegeven;
import nl.newnexus.pages.CreateAccount;
import nl.newnexus.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/**
 * Created by Tester on 4/19/2017.
 */
public class aanmakenAccountSteps {
    WebDriver driver;
    @Als("^de gebruiker op de knop Opslaan klikt$")
    public void deGebruikerOpDeKnopOpslaanKlikt() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @Gegeven("^de gebruiker is op de account aanmaken pagina$")
    public void deGebruikerIsOpDeAccountAanmakenPagina() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        CreateAccount createAccount = new CreateAccount(driver);
        createAccount.gotoURL("http://test-pc/catalog/create_account.php");
    }

    @Als("^ik accountgegevens invul voor \"([^\"]*)\" \"([^\"]*)\", \"([^\"]*)\" en \"([^\"]*)\"$")
    public void ikAccountgegevensInvulVoorEn(String voornaam, String achternaam, String geboortedatum, String emailadres) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        CreateAccount createAccount = new CreateAccount(driver);
        createAccount.enterName(voornaam,achternaam,geboortedatum, emailadres);
    }

    @En("^ik adresgegevens invul voor een standaardadres$")
    public void ikAdresgegevensInvulVoorEenStandaardadres() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @En("^het password is \"([^\"]*)\"$")
    public void hetPasswordIs(String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @Dan("^wordt een nieuw account aangemaakt$")
    public void wordtEenNieuwAccountAangemaakt() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }
}
