package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class RegisterPage {
    private final SHAFT.GUI.WebDriver driver;

    public RegisterPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }
    private final By emailTxt = By.id("reg_email");
    private final By passwordTxt = By.id("reg_password");
    private final By registerButton = By.xpath("//button[@name='register']");
    private final By assertionMessage = By.xpath("//h1[text()='My account']");

    public void enterRegisterData(String email, String password){
        driver.element().type(emailTxt,email);
        driver.element().type(passwordTxt,password);
        driver.element().click(registerButton);
    }

    public String getAssertionMessage(){
        return driver.element().getText(assertionMessage);
    }
}
