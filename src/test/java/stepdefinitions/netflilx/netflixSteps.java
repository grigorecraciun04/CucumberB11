package stepdefinitions.netflilx;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.netflix.LoginPage;
import utils.DriverHelper;

public class netflixSteps {

    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    @When("I navigate to Netflix login page")

    public void i_navigate_to_netflix_login_page() {

        driver.get("https://www.netflix.com/login");
    }

    @When("I enter not valid email")
    public void i_enter_not_valid_email() {

        loginPage.enterEmail("test@test.com");
    }

    @When("I enter not valid password")
    public void i_enter_not_valid_password() {
        loginPage.enterPassword("passwordFRFRF");
    }

    @When("I click submit button")
    public void i_click_submit_button() {
        loginPage.clickSubmit();
    }

    @Then("I see Incorrect password element")
    public void i_see_incorrect_password_element() {

        Assert.assertTrue(loginPage.incorrectPassword.isDisplayed());
    }

    @And("I enter not valid {string}")
    public void iEnterNotValid(String email) {

        loginPage.enterEmail(email);
    }










}
