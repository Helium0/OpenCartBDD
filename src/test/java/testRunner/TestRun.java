package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions( features = ".//Feature//Login.feature",
                   glue = "stepsDefinitions",
                    dryRun = false,
                    plugin = {"pretty","html:.//src//test//resources//reports//Patrick`s report"})

public class TestRun {

}
