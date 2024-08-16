package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class UpdateCartPage {
    private final SHAFT.GUI.WebDriver driver;
    public UpdateCartPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By viewCart = By.linkText("View cart");
    private final By plusButton = By.xpath("//input[@value='+']");
    private final By updateCart = By.name("update_cart");
    private final By updateAssertionMessage = By.xpath("//div[@class='message-container container success-color medium-text-center']");
    private final By removeItem = By.xpath("//a[@class='remove']");
    private final By removeItemAssertion = By.xpath("//div[@class='message-container container medium-text-center']");

    public void navigateToCartPage() {
        driver.element().click(viewCart);
    }

    public void setUpdateCart() {
        driver.element().click(plusButton);
        driver.element().click(updateCart);
    }

    public String setUpdateAssertionMessage()  {
        return driver.element().getText(updateAssertionMessage);
    }
    public void setRemoveItem(){
        driver.element().click(removeItem);
    }
    public String getRemoveItemAssertionMessage() {
        return driver.element().getText(removeItemAssertion);
    }
}
