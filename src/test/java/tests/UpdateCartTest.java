package tests;

import com.shaft.driver.SHAFT;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.awt.*;


public class UpdateCartTest extends TestBase{
    SearchPage searchPage;
    AddToCartPage add;
    HomePage homePage;
    RegisterPage registerPage;
    UpdateCartPage updateCartPage;
    SHAFT.TestData.JSON registerData;
    String currentTime = String.valueOf(System.currentTimeMillis());

    @Test
    public void navigateToRegisterPage(){

        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
    }

    @Test(priority = 1)
    public void enterRegisterData() {
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
    public void getAssertionMessage() {
        searchPage = new SearchPage(driver);
        Assert.assertEquals(searchPage.getAssertionMessage(),"Search results: “iphone”");
    }
    @Test(priority = 5)
    public void navigateToAddProductToCart() {
        add = new AddToCartPage(driver);
        add.navigateToAddToCartPage();
    }
    @Test(priority = 6)
    public void addProductToCart()  {
        add = new AddToCartPage(driver);
        add.addProductToCart();
    }
    @Test(priority = 7)
    public void navigateToCartPage()  {
        updateCartPage = new UpdateCartPage(driver);
        updateCartPage.navigateToCartPage();
    }
    @Test(priority = 8)
    public void updateCartPage()  {
        updateCartPage = new UpdateCartPage(driver);
        updateCartPage.setUpdateCart();
        Assert.assertTrue(updateCartPage.setUpdateAssertionMessage().contains("Cart updated"));
    }
    @Test(priority = 9)
    public void removeItem()  {
        updateCartPage = new UpdateCartPage(driver);
        updateCartPage.setRemoveItem();
        Assert.assertTrue(updateCartPage.getRemoveItemAssertionMessage().contains("Your cart is currently empty"));
    }
}
