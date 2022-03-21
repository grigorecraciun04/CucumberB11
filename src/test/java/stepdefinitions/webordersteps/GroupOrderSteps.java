package stepdefinitions.webordersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.weborderpages.LoginPage;
import pages.weborderpages.OrderPage;
import utils.ConfigReader;
import utils.DriverHelper;

public class GroupOrderSteps {
    WebDriver driver= DriverHelper.getDriver();
    LoginPage loginpage= new LoginPage(driver);
    OrderPage orderpage= new OrderPage(driver);
    @Given("the user is on webOrder homepage")
    public void the_user_is_on_web_order_homepage() {

    driver.navigate().to(ConfigReader.readProperty("weborderurl"));
    loginpage.login(ConfigReader.readProperty("weborderusername"),ConfigReader.readProperty("weborderpassword"));

    }
    @When("the user select {string} option")
    public void the_user_select_option(String deliveryOption) {
    orderpage.getDeliveryOption(deliveryOption);

    }
    @When("the user  is on the groupOrderPage")
    public void the_user_is_on_the_group_order_page() {
        orderpage.clickGroupOrder();
        orderpage.clickNextButton();
        Assert.assertEquals(driver.getTitle(), "Create Group Order - Weborder");

    }
    @When("the user send invitees note {string}")
    public void the_user_send_invitees_note(String inviteText) {
    orderpage.sendInvitations(inviteText);

    }
    @When("user sends invite list {string} and {string}")
    public void user_sends_invite_list_and(String name1, String name2) {

        orderpage.listOfInvitates(name1,name2);

    }
    @Then("the user validates the {string} address")
    public void the_user_validates_the_address(String expectedAddress) {

      Assert.assertTrue(orderpage.addressValidation(expectedAddress));


    }
    @Then("the user validates {string} text")
    public void the_user_validates_text(String expectedHeader) {
        orderpage.clickOnCreateGroup();
      Assert.assertEquals(orderpage.headerValidation(),expectedHeader);

    }
    @Then("the user validates total participants is {int}")
    public void the_user_validates_total_participants_is(int participants) {
Assert.assertTrue(orderpage.getParticipants()==participants);

    }

}
