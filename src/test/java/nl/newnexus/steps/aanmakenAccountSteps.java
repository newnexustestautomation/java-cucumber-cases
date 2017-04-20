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
    CreateAccount createAccount;

    @Als("^de gebruiker op de knop Opslaan klikt$")
    public void deGebruikerOpDeKnopOpslaanKlikt() throws Throwable {

        createAccount.clickButtonContinue();

    }

    @Gegeven("^de gebruiker is op de account aanmaken pagina$")
    public void deGebruikerIsOpDeAccountAanmakenPagina() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        createAccount = new CreateAccount(driver);
        createAccount.gotoURL("http://test-pc/catalog/create_account.php");
    }

    @Als("^ik accountgegevens invul voor \"([^\"]*)\" \"([^\"]*)\", \"([^\"]*)\" en \"([^\"]*)\"$")
    public void ikAccountgegevensInvulVoorEn(String voornaam, String achternaam, String geboortedatum, String emailadres) throws Throwable {

        createAccount.enterName(voornaam,achternaam,geboortedatum,emailadres);
    }

    @En("^ik adresgegevens invul voor een standaardadres$")
    public void ikAdresgegevensInvulVoorEenStandaardadres() throws Throwable {

        createAccount.enterAddress();

    }

    @Dan("^wordt een nieuw account aangemaakt$")
    public void wordtEenNieuwAccountAangemaakt() throws Throwable {

        Assert.assertTrue(createAccount.checkConfirmPage());

    }

    @En("^ik als password \"([^\"]*)\" invul$")
    public void ikAlsPasswordInvul(String password) throws Throwable {

        createAccount.enterPassword(password);
    }

    @En("^ik het password bevestig met \"([^\"]*)\"$")
    public void ikHetPasswordBevestigMet(String password) throws Throwable {

        createAccount.confirmPassword(password);
    }

    @En("^ik kies geslacht \"([^\"]*)\"$")
    public void ikKiesGeslacht(String gender) throws Throwable {

        createAccount.selectGender(gender.substring(0,1).toLowerCase());
    }

    @En("^ik telefoonnummer \"([^\"]*)\" invul$")
    public void ikTelefoonnummerInvul(String phone) throws Throwable {

        createAccount.enterPhoneNumber(phone);
    }
}
