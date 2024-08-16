package tests;

import com.shaft.driver.SHAFT;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class TestBase {

    protected  static SHAFT.GUI.WebDriver driver;

    @BeforeClass
    public void setDriver(){
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("https://www.itoucheg.com/accessories/");

    }

    @AfterClass
    public void closeDriver(){
        driver.quit();
    }
}
