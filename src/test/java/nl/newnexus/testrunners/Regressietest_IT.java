package nl.newnexus.testrunners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Tester on 4/4/2017.
 */


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/",
        glue = "nl.newnexus.steps",
        tags = "@REGRESSIETEST",
        format = {"pretty", "json:target/cucumber/cucumber.json"})
public class Regressietest_IT {

}



