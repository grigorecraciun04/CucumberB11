package runners.weborder;
//runner class is the way to run all your feature files from here
//run with annotation comes from Junit, and it executes the feature file steps
//cucumberOption is a special annotation that have some keywords
//dryrun this is the way to get snips without execute all the codes
//it means if you make it true you will get  immediately unimplemented snips

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/features/com.weborder/LoginOutline.feature",//this is the path for feature file(content root)
        glue = "stepdefinitions/webordersteps",//this is the path for stepDefinition(source root and delete java part to make it more general)
        dryRun = false //is  the way to get new sniper from features(but should be dryRun = true)


)


public class WebOrderRunner {


}
