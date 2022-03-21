package pages.openmrspages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class OpenRegisterPage {
 public OpenRegisterPage(WebDriver driver){
     PageFactory.initElements(driver,this);
 }
 @FindBy(name = "givenName")
    private WebElement givenName;

    @FindBy(name = "familyName")
    private WebElement familyName;

    @FindBy(id = "next-button")
    private WebElement nextButton;

    @FindBy(name = "gender")
    private WebElement selectGender;

    @FindBy(id = "birthdateDay-field")
    private WebElement birthDay;

    @FindBy(id = "birthdateMonth-field")
    private WebElement selectBirthMonth;

    @FindBy(id = "birthdateYear-field")
    private WebElement birthYear;

    @FindBy(id = "address1")
    private WebElement address;

//    @FindBy(id = "cityVillage")
//    private WebElement city;
//
//    @FindBy(id = "stateProvince")
//    private WebElement state;
//
//    @FindBy(id = "country")
//    private WebElement county;
//
//    @FindBy(id = "postalCode")
//    private WebElement zipCode;

    @FindBy(name = "phoneNumber")
    private WebElement phoneNumber;

    @FindBy(id = "relationship_type")
    private WebElement selectRelationType;

    @FindBy(xpath = "//input[@placeholder='Person Name']")
    private WebElement relativeName;

    @FindBy(id = "submit")
    private WebElement confirmButton;

    @FindBy(className = "PersonName-givenName")
    private WebElement validateGivenName;

    @FindBy(className = "PersonName-familyName")
    private WebElement validateFamilyName;





    public void registerAPatient(String givenName, String familyName, String gender, String birthDay,
                                 String birthMonth, String birthYear, String address
                                 , String phoneNumber, String relative,
                                 String relativeName) {
        this.givenName.sendKeys(givenName);
        this.familyName.sendKeys(familyName);
        nextButton.click();
        BrowserUtils.selectBy(selectGender, gender, "text");
        nextButton.click();
        this.birthDay.sendKeys(birthDay);
        BrowserUtils.selectBy(selectBirthMonth, birthMonth, "text");
        this.birthYear.sendKeys(birthYear);
        nextButton.click();
        this.address.sendKeys(address);
        nextButton.click();
        this.phoneNumber.sendKeys(phoneNumber);
        nextButton.click();
        BrowserUtils.selectBy(selectRelationType, relative, "text");
        this.relativeName.sendKeys(relativeName);
        nextButton.click();
        confirmButton.click();


    }
    public String validateName(){
       return BrowserUtils.getText(validateGivenName);
    }
public String validateFamilyName(){
        return  BrowserUtils.getText(validateFamilyName);
}
}
