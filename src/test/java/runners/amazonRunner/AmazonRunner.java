package runners.amazonRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/com.amazon",
        glue = "stepdefinitions/amazon",
        dryRun = false,
        tags = "@amazon",
        plugin = {"pretty","html:target/iuReport.html","rerun:target/iuFailedTests.txt"}

)

public class AmazonRunner {
}
