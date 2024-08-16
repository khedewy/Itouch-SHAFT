package tests;

import com.shaft.driver.SHAFT;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.awt.*;
import java.io.IOException;

public class CheckOutTest extends TestBase{
    SearchPage searchPage;
    AddToCartPage add;
    HomePage homePage;
    RegisterPage registerPage;
    CheckoutPage checkoutPage;
    SHAFT.TestData.JSON registerData;
    SHAFT.TestData.JSON checkoutData;
    String currentTime = String.valueOf(System.currentTimeMillis());

    @Test
    public void navigateToRegisterPage(){

        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
    }

    @Test(priority = 1)
    public void enterRegisterData()  {
        registerPage = new RegisterPage(driver);
        registerData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/registerData.json");
        registerPage.enterRegisterData(registerData.getTestData("email")+currentTime+"@gmail.com",
                registerData.getTestData("password"));
    }

    @Test(priority = 2)
    public void getRegisterAssertionMessage(){

        registerPage = new RegisterPage(driver);
        Assert.assertEquals(registerPage.getAssertionMessage(),"My account");
    }
    @Test(priority = 3)
    public void searchForProduct() throws AWTException {
        searchPage = new SearchPage(driver);
        searchPage.searchForProduct("iphone");
    }
    @Test(priority = 4)
    public void getAssertionMessage()  {
        searchPage = new SearchPage(driver);
        Assert.assertEquals(searchPage.getAssertionMessage(),"Search results: “iphone”");
    }
    @Test(priority = 5)
    public void navigateToAddProductToCart() {
        add = new AddToCartPage(driver);
        add.navigateToAddToCartPage();
    }
    @Test(priority = 6)
    public void addProductToCart() {
        add = new AddToCartPage(driver);
        add.addProductToCart();
    }
    @Test(priority = 7)
    public void navigateToCheckoutPage() {
        add = new AddToCartPage(driver);
        add.navigateToCheckOutPage();
    }
    @Test(priority = 8)
    public void enterAddressInf()  {
        checkoutPage = new CheckoutPage(driver);
        checkoutData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/checkoutData.json");
        checkoutPage.enterAddressInf(checkoutData.getTestData("firstName"),
                checkoutData.getTestData("lastName"),checkoutData.getTestData("mobile"));
    }

    @Test(priority = 9)
    public void completeCheckout() {
        checkoutPage = new CheckoutPage(driver);
        checkoutData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/checkoutData.json");
        checkoutPage.completeCheckoutInf(checkoutData.getTestData("street1"),
                checkoutData.getTestData("street2"),checkoutData.getTestData("city")
                ,checkoutData.getTestData("postcode"),checkoutData.getTestData("comment"));
    }

    @Test(priority = 10)
    public void placeOrder()  {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.placeOrder();
    }

    @Test(priority = 11)
    public void assertThatOrderPlacedSuccessfully()  {
        checkoutPage = new CheckoutPage(driver);
        Assert.assertEquals(checkoutPage.getPlaceOrderAssertionMessage(),"Thank you. Your order has been received.");
    }

}
