package tests;


import com.shaft.driver.SHAFT;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.HomePage;
import pages.RegisterPage;
import pages.SearchPage;

import java.awt.*;


public class AddToCartTest extends TestBase{
    SearchPage searchPage;
    AddToCartPage add;
    HomePage homePage;
    RegisterPage registerPage;
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
    public void getAssertionMessage()  {
        searchPage = new SearchPage(driver);
        Assert.assertEquals(searchPage.getAssertionMessage(),"Search results: “iphone”");
    }
    @Test(priority = 5)
    public void navigateToAddProductToCart()  {
        add = new AddToCartPage(driver);
        add.navigateToAddToCartPage();
    }
    @Test(priority = 6)
    public void addProductToCart()  {
        add = new AddToCartPage(driver);
        add.addProductToCart();
    }
    @Test(priority = 7)
    public void navigateToCheckoutPage() {
        add = new AddToCartPage(driver);
        add.navigateToCheckOutPage();
    }


}
