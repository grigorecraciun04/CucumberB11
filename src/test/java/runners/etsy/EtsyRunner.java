package runners.etsy;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/com.etsy/EtsyResearch.feature",
        glue = "stepdefinitions/EtsySteps",
        dryRun = false




)


public class EtsyRunner {

}
