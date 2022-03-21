package runners.openmrs;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/com.openmrs",
        glue = "stepdefinitions/openmrssteps",
        dryRun = false,
        tags = "@openMRS"
)


public class OpenMrsRunner {


}
