package nl.newnexus.steps;

import cucumber.api.PendingException;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import cucumber.api.java.nl.Gegeven;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Tester on 4/19/2017.
 */
public class AccountaanmakenSteps {
    @Gegeven("^Gebruiker navigeert naar website$")
    public void gebruikerNavigeertNaarWebsite() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        try {
            URL myURL = new URL("http://localhost/catalog/");
            URLConnection myURLConnection = myURL.openConnection();
            myURLConnection.connect();
        }
        catch (MalformedURLException e) {
            // new URL() failed
            // ...
        }
        catch (IOException e) {
            // openConnection() failed
            // ...
        }

    }

    @Als("^gebruiker zijn gegevens invult$")
    public void gebruikerZijnGegevensInvult() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @Dan("^word er een nieuwe account voor gebruiker aangemaakt$")
    public void wordErEenNieuweAccountVoorGebruikerAangemaakt() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @En("^kan het nieuwe gebruiker inloggen$")
    public void kanHetNieuweGebruikerInloggen() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }
}
