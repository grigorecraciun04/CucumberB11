package pages.weborderpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public  LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
        @FindBy(xpath = "//input[@id='Email']")
      private   WebElement userName;

        @FindBy(id="Password")
           private WebElement password;

        @FindBy(xpath = "//button[@type='submit']")
             private    WebElement singinButton;

        @FindBy(xpath = "//div[contains(text(),'Sign in Failed')]")
       private WebElement errorMessage;


        public void login(String username,String pasWword){
            this.userName.clear();
            this.password.clear();
            this.userName.sendKeys(username);
            this.password.sendKeys(pasWword);
            this.singinButton.submit();

        }
        public  boolean validationErrorMessage(String errorMessage){
            return this.errorMessage.getText().trim().equals(errorMessage);
        }
}
