package stepdefinitions.webordersteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class HookwebOrder {

    @Before
    public void beforeScenario(){
        System.out.println("it runs before eachScenario");
    }
    @After
    public void afterScenario(){

        DriverHelper.tearDown();
        System.out.println("it will run after each scenario");
    }
}
