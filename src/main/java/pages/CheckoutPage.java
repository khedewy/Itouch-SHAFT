package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class CheckoutPage {
    private final SHAFT.GUI.WebDriver driver;

    public CheckoutPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }
    private final By firstNameTxt = By.id("billing_first_name");
    private final By lastNameTxt = By.id("billing_last_name");
    private final By mobileNumTxt = By.id("billing_phone");
    private final By streetNumber = By.id("billing_address_1");
    private final By streetNumber2 = By.id("billing_address_2");
    private final By cityTxt = By.id("billing_city");
    private final By postCodeTxt = By.id("billing_postcode");
    private final By commentTxt = By.id("order_comments");
    private final By placeOrderButton = By.id("place_order");
    private final By  assertionMessage = By.xpath("//strong[text()='Thank you. Your order has been received.']");


    public void enterAddressInf(String firstName,String lastName, String mobile){
        driver.element().type(firstNameTxt,firstName);
        driver.element().type(lastNameTxt,lastName);
        driver.element().type(mobileNumTxt,mobile);
    }

    public void completeCheckoutInf(String street1,String street2,String cit,String postCode, String comment){
        driver.element().type(streetNumber,street1);
        driver.element().type(streetNumber2,street2);
        driver.element().type(cityTxt,cit);
        driver.element().type(postCodeTxt,postCode);
        driver.element().type(commentTxt,comment);
    }
    public void placeOrder()  {
        driver.element().click(placeOrderButton);
    }
    public String getPlaceOrderAssertionMessage(){
        return driver.element().getText(assertionMessage);
    }
}
