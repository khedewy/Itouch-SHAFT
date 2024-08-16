package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;






public class HomePage {
    private final SHAFT.GUI.WebDriver driver;
    public HomePage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }
    private final By accountManager = By.xpath("//a[@class='nav-top-link nav-top-not-logged-in is-small']");

    public RegisterPage navigateToRegisterPage(){
        driver.element().click(accountManager);
        return new RegisterPage(driver);
    }


}
