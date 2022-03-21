package stepdefinitions.productsteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.productspages.ProductLoginPage;
import pages.productspages.ProductMainPage;
import pages.productspages.ProductOrderPage;
import pages.weborderpages.LoginPage;
import utils.ConfigReader;
import utils.DriverHelper;

public class ProductOrderSteps {
    WebDriver driver= DriverHelper.getDriver();
ProductLoginPage loginPage =new ProductLoginPage(driver);
ProductMainPage mainPage = new ProductMainPage(driver);
ProductOrderPage orderPage=new ProductOrderPage(driver);
    @Given("the user navigate to product website homepage and click orderButton")
    public void the_user_navigate_to_product_website_homepage_and_click_order_button() {

        loginPage.login(ConfigReader.readProperty("productusername"),ConfigReader.readProperty("productpassword"));

        mainPage.clickOrderButton();
    }
    @When("the user enters the product information {string} and {string}")
    public void the_user_enters_the_product_information_and(String productName, String quantity) {

        orderPage.sendProductInfo(productName, quantity);

    }
    @When("the user enters the address information {string},{string},{string},{string},{string}")
    public void the_user_enters_the_address_information(String costumerName, String street, String city, String state, String zipcode) {
    orderPage.sendAddressInfo(costumerName, street, city, state, zipcode);

    }
    @When("the user enters the card information {string},{string},{string}")
    public void the_user_enters_the_card_information(String cardType, String cardNumber, String expireDate) {
        orderPage.selectCard(cardType);
        orderPage.sendPaymentInfo(cardNumber,expireDate);
        orderPage.clickProcessButton();
    }
    @Then("the user validats success message")
    public void the_user_validats_success_message() {
        Assert.assertEquals("New order has been successfully added.",orderPage.getSuccessMessage());
    }
    @Then("the user validate product details {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void the_user_validate_product_details(String costumerName,String productName,String quantity, String street, String city, String state,
                                                  String zipcode,String cardType, String cardNumber, String expireDate) {
orderPage.clickViewOrders();
orderPage.getInfo(productName,quantity,costumerName,street,city,state,zipcode,cardType,cardNumber,expireDate);



    }


}
