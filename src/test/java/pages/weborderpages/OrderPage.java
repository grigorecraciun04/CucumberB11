package pages.weborderpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class OrderPage {
    public OrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "ConfirmAddressID")
    WebElement address;

    @FindBy(xpath = "//label[@class='custom-control-label']")
    WebElement groupOrderBox;

    @FindBy(id = "getAddressNextButton")
    WebElement nextButton;

    @FindBy(id = "InviteNote")
    WebElement invitationText;

   @FindBy(xpath = "//textarea[@id='InviteList']")
   WebElement invitationList;

    @FindBy(id = "addressPreview")
    WebElement addressValidate;

    @FindBy(id = "createGroupOrder")
    WebElement createGroupButton;

    @FindBy(xpath = "//h1[.='View Group Order']")
    WebElement validationHeader;

    @FindBy(xpath = "//label[.='Total Participants:']//following-sibling::div")
    WebElement numberOfParticipants;



    public  void getDeliveryOption(String option){
        BrowserUtils.selectBy(address,option,"text");
    }
    public void clickGroupOrder(){
        groupOrderBox.click();
    }
    public void clickNextButton(){
        nextButton.click();
    }
    public void sendInvitations(String invitation){
        invitationText.sendKeys(invitation);
    }
    public void listOfInvitates(String name1,String name2){
        invitationList.sendKeys(name1,name2);

    }
    public void clickOnCreateGroup(){
        createGroupButton.click();
    }
public  boolean addressValidation(String address){
        return BrowserUtils.getText(addressValidate).contains(address);
}
public String headerValidation(){
      return BrowserUtils.getText(validationHeader);

}
public int getParticipants(){
        return Integer.parseInt(BrowserUtils.getText(numberOfParticipants));
}



}
