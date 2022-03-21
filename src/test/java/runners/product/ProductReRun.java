package runners.product;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/uiFailedTests.txt",
        glue = "stepdefinitions/productsteps",
        dryRun = false,
        tags = "@failedtest",
        plugin = {"pretty","html:target/iuReport.html","rerun:target/iuFailedTests.txt"}
)

public class ProductReRun {

}
