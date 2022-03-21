package pages.productspages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class ProductOrderPage {
    public  ProductOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "ctl00$MainContent$fmwOrder$ddlProduct")
    private WebElement productName;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    private WebElement quantity;

    @FindBy(name = "ctl00$MainContent$fmwOrder$txtName")
    private WebElement costumerName;

    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox2")
    private WebElement street;

    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox3")
    private WebElement city;

    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox4")
    private WebElement state;

    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox5")
    private WebElement zipCode;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    private WebElement visa;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_1")
    private WebElement masterCard;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_2")
    private WebElement americanExpress;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    private WebElement cardNumber;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    private WebElement cardExpiration;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    private WebElement processButton;

    @FindBy(tagName = "strong")
    private WebElement message;

    @FindBy(xpath = "//a[.='View all orders']")
    private WebElement viewOrderButton;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr[2]//td")
    private List<WebElement> productInfo;


    public  void sendProductInfo(String productName,String quantity){
        BrowserUtils.selectBy(this.productName,productName,"value");
        this.quantity.clear();
        this.quantity.sendKeys(quantity);
    }

    public void sendAddressInfo(String costumerName,String street,String city,String state,String zipCode){
        this.costumerName.sendKeys(costumerName);
        this.street.sendKeys(street);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.zipCode.sendKeys(zipCode);

    }
    public void sendPaymentInfo(String cardNumber,String expirationDate){
        this.cardNumber.sendKeys(cardNumber);
        this.cardExpiration.sendKeys(expirationDate);
    }
    public void selectCard(String cardType){
        switch (cardType){
            case "Visa":
                visa.click();
                break;
            case "MasterCard":
                masterCard.click();
                break;
            case "American Express":
                americanExpress.click();
                break;

        }
    }
    public void clickProcessButton(){
        processButton.click();
    }
    public String getSuccessMessage(){
        return BrowserUtils.getText(message);
    }
    public void clickViewOrders(){
        viewOrderButton.click();
    }
    public  void getInfo(String productName, String quantity,String costumerName, String street, String city, String state, String zipcode,
                         String cardType, String cardNumber, String expireDate){
        Assert.assertEquals(productInfo.get(1).getText().trim(),costumerName);
        Assert.assertEquals(productInfo.get(2).getText().trim(),productName);
        Assert.assertEquals(productInfo.get(3).getText().trim(),quantity);
        Assert.assertEquals(productInfo.get(5).getText().trim(),street);
        Assert.assertEquals(productInfo.get(6).getText().trim(),city);
        Assert.assertEquals(productInfo.get(7).getText().trim(),state);
        Assert.assertEquals(productInfo.get(8).getText().trim(),zipcode);
        Assert.assertEquals(productInfo.get(9).getText().trim(),cardType);
        Assert.assertEquals(productInfo.get(10).getText().trim(),cardNumber);
        Assert.assertEquals(productInfo.get(11).getText().trim(),expireDate);


    }
}
