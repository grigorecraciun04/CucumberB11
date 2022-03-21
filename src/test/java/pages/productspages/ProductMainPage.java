package pages.productspages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductMainPage {

    public  ProductMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[.='Order']")
    private WebElement orderButton;




    public void clickOrderButton(){
        orderButton.click();
    }
}
