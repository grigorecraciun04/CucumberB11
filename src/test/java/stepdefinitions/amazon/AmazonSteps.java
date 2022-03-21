package stepdefinitions.amazon;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.amazonpages.AmazonSignUpPage;
import utils.DriverHelper;

import java.util.List;

public class AmazonSteps {
WebDriver driver = DriverHelper.getDriver();
AmazonSignUpPage singUp=new AmazonSignUpPage(driver);
    @When("the user click sign in and create your amazon account button")
    public void the_user_click_sign_in_and_create_your_amazon_account_button() {
        driver.get("https://www.amazon.com/?tag=amazusnavi-20&hvadid=381823327651&hvpos=" +
                "&hvnetw=g&hvrand=11843409324958924986&hvpone=&hvptwo=&hvqmt=e&hvdev=" +
                "c&hvdvcmdl=&hvlocint=&hvlocphy=9021437&hvtargid=kwd-10573980&ref=" +
                "pd_sl_7j18redljs_e&hydadcr=28883_11845442&gclid=CjwKCAjwlcaRBhBYE" +
                "iwAK341jfedA0iUwHyf8341641X5eOKUXkegI8OX_mYgcG5Qv-b4t23SOeMiRoC1LYQAvD_BwE");
        singUp.setCreateAccount();
    }
    @Then("the user validate the header")
    public void the_user_validate_the_header(DataTable dataTable) {
        List<String> header=dataTable.asList();
        Assert.assertEquals(header.get(0),singUp.getHeaderText());
    }
    @Then("the user provide the information")
    public void the_user_provide_the_information(DataTable dataTable) {
        List<String> allInformationData=dataTable.asList();
        singUp.allInformation(allInformationData.get(0), allInformationData.get(1),
                allInformationData.get(2), allInformationData.get(3));
    }
}
