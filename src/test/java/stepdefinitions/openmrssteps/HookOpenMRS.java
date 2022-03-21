package stepdefinitions.openmrssteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class HookOpenMRS {
    WebDriver driver= DriverHelper.getDriver();

    @Before
    public void beforeScenario(){
        driver.navigate().to(ConfigReader.readProperty("openmrsurl"));
    }
    @After
    public void afterScenario(Scenario scenario){


        Date currentDate = new Date();
        String screenShotFileName = currentDate.toString().replace(" ","-").replace(":","-");
        if (scenario.isFailed()){
            File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenShot, new File(new File("src/test/java/screenshot/" + screenShotFileName) + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        DriverHelper.tearDown();

    }
}
