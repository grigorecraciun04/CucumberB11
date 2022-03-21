package pages.amazonpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.Queue;

public class AmazonSignUpPage {

    public AmazonSignUpPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "nav-link-accountList-nav-line-1")
    private WebElement singupButton;

    @FindBy(id = "createAccountSubmit")
    private WebElement createAccountButton;

    @FindBy(id = "ap_customer_name")
    private WebElement name;

    @FindBy(id = "ap_email")
    private WebElement email;

    @FindBy(xpath = "//input[@name=\"password\"]")
    private WebElement password;

    @FindBy(xpath = "//input[@name=\"passwordCheck\"]")
    private WebElement passwordCheck;

    @FindBy(tagName = "h1")
    public WebElement header;

    public  void setCreateAccount() {

        singupButton.click();
        createAccountButton.click();

    }
    public String getHeaderText(){
        return BrowserUtils.getText(header);
    }
    public void allInformation(String name,String email, String password,String passwordCheck){
        this.name.sendKeys(name);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.passwordCheck.sendKeys(passwordCheck);

    }
}
