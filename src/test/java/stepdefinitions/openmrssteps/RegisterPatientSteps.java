package stepdefinitions.openmrssteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.openmrspages.MainOpenMrsPage;
import pages.openmrspages.OpenMrsLoginPage;
import pages.openmrspages.OpenRegisterPage;
import utils.DriverHelper;

import java.util.Map;

public class RegisterPatientSteps {
    WebDriver driver = DriverHelper.getDriver();
OpenMrsLoginPage loginPage = new OpenMrsLoginPage(driver);
MainOpenMrsPage mainPage= new MainOpenMrsPage(driver);
OpenRegisterPage registrationPage = new OpenRegisterPage(driver);
    @Given("the user logs in to OpenMRS with following credentials")
    public void the_user_logs_in_to_open_mrs_with_following_credentials(DataTable dataTable) {
        //you should know that dataTable will comes as a paramiters when you provide data in feature file
        Map<String, String> userNamePasswordMap = dataTable.asMap();
//        String name = userNamePasswordMap.get("username");
//        String password = userNamePasswordMap.get("password");
//        System.out.println(name);
//        System.out.println(password);
        loginPage.login(userNamePasswordMap.get("username"), userNamePasswordMap.get("password"));
    }
        @When("the user register a new patient with following  information")
        public void the_user_register_a_new_patient_with_following_information(DataTable dataTable) {
        Map<String,String> registerMap= dataTable.asMap();
         mainPage.registerNewPatientButton();
         registrationPage.registerAPatient(registerMap.get("givenName"),registerMap.get("familyName"),
                 registerMap.get("gender"),registerMap.get("day"),registerMap.get("month"),
                 registerMap.get("year"),registerMap.get("address"),
                 registerMap.get("phoneNumber"),registerMap.get("relative"),registerMap.get("relativeName"));

    }
    @Then("the user validate the patient name and familyName")
    public void the_user_validate_the_patient_name_and_family_name(DataTable dataTable) {
       Map<String,String> validationName=dataTable.asMap();
        Assert.assertEquals(validationName.get("GivenName"),registrationPage.validateName());
        Assert.assertEquals(validationName.get("FamilyName"),registrationPage.validateFamilyName());
    }

}
