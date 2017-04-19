package nl.newnexus.steps;

import cucumber.api.PendingException;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import cucumber.api.java.nl.Gegeven;
import org.junit.Assert;

/**
 * Created by Tester on 4/19/2017.
 */
public class accountaanmakenstepdefs {
    @Gegeven("^het scherm 'account aanmaken' zichtbaar is$")
    public void hetSchermAccountAanmakenZichtbaarIs() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Deze som klopt niet", 1+1,3);
    }

    @Als("^ik de accountgegevens invul voor \"([^\"]*)\" \"([^\"]*)\", \"([^\"]*)\" en \"([^\"]*)\"$")
    public void ikDeAccountgegevensInvulVoorEn(String arg0, String arg1, String arg2, String arg3) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @En("^het passwork met 'test(\\d+)'$")
    public void hetPassworkMetTest(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @En("^als ik op de knop 'aanmaken' klik$")
    public void alsIkOpDeKnopAanmakenKlik() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
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
