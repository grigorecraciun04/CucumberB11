package pages.openmrspages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenMrsLoginPage {
    public OpenMrsLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "username")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "Inpatient Ward")
    private WebElement impactPatient;

    @FindBy(id = "loginButton")
    private WebElement loginButton;


    public void login(String username,String password){
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        impactPatient.click();
        loginButton.click();
    }
}
