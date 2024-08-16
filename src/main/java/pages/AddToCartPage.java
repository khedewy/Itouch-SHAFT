package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class AddToCartPage {
    private final SHAFT.GUI.WebDriver driver;
    public AddToCartPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }
    private final By chosenProduct = By.xpath("//a[text()='Apple iPhone 15 Pro Max FineWoven Case With Magsafe Mulberry']");
    private final By addToCartButton = By.xpath("//button[@class='single_add_to_cart_button button alt']");
    private final By checkoutPage = By.linkText("Checkout");


    public void navigateToAddToCartPage(){
        driver.element().click(chosenProduct);
    }

    public void addProductToCart() {
        driver.element().click(addToCartButton);
    }
    public CheckoutPage navigateToCheckOutPage() {
        driver.element().click(checkoutPage);
        return new CheckoutPage(driver);

    }



}
