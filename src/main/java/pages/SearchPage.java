package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import java.awt.*;
import java.awt.event.KeyEvent;


public class SearchPage {
    private final SHAFT.GUI.WebDriver driver;
    Robot robot;
    public SearchPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }
    private final By searchBox = By.id("woocommerce-product-search-field-0");
    private final By assertionMessage = By.xpath("//h1[text()='Search results: “iphone”']");

    public void searchForProduct(String product) throws AWTException {
        driver.element().type(searchBox,product);
        robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
    }

    public String getAssertionMessage(){
        return driver.element().getText(assertionMessage);
    }
}
