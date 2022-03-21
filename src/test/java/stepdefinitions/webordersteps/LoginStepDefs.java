package stepdefinitions.webordersteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.weborderpages.LoginPage;
import utils.ConfigReader;
import utils.DriverHelper;

public class LoginStepDefs {
    WebDriver driver =DriverHelper.getDriver();
    LoginPage loginpage=new LoginPage(driver);





    @Given("the user navigate to the WebOrder website")
    public void the_user_navigate_to_the_web_order_website() {
        driver.navigate().to(ConfigReader.readProperty("weborderurl"));
    }
    @When("the user provide credentials")
    public void the_user_provide_credentials() {
        loginpage.login(ConfigReader.readProperty("weborderusername"),ConfigReader.readProperty("weborderpassword"));
    }
    @Then("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        Assert.assertEquals(driver.getTitle(),"ORDER DETAILS - Weborder");
    }
    @When("the provide correct username and wrong password")
    public void the_provide_correct_username_and_wrong_password() {
        loginpage.login(ConfigReader.readProperty("weborderusername"),"gregd");
    }
    @Then("the user validates the {string} error message")
    public void the_user_validates_the_error_message(String expectedMessage) {
        Assert.assertTrue(loginpage.validationErrorMessage(expectedMessage));
    }
    @When("the provide wrong {string} and wrong {string}")
    public void the_provide_wrong_and_wrong(String username, String password) {
       loginpage.login(username, password);
    }
    @When("the provide nothing for user name and nothing for password")
    public void the_provide_nothing_for_user_name_and_nothing_for_password() {
        loginpage.login(" "," ");
    }


}
