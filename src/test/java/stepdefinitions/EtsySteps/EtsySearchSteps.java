package stepdefinitions.EtsySteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.etsypages.EtsyHomePage;
import utils.DriverHelper;

public class EtsySearchSteps {
    WebDriver driver = DriverHelper.getDriver();
    EtsyHomePage etsyHomePage= new EtsyHomePage(driver);
    @Given("the user navigate to {string}")
    public void the_user_navigate_to(String url) {

        driver.navigate().to(url);
    }
    @When("the user search with {string}")
    public void the_user_search_with(String value) {
        etsyHomePage.sendKeys(value);

    }
    @Then("the user validate the title {string}")
    public void the_user_validate_the_title(String expectedTitle) {
        Assert.assertEquals(driver.getTitle(),expectedTitle);


    }

}
