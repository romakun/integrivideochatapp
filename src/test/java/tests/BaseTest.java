package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import steps.LoginSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.CapabilitiesGenerator;

public class BaseTest {

    public WebDriver driver;
    protected LoginSteps steps;

    @BeforeMethod(description = "Opening Chrome Driver")
    public void setUp(){
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        steps = new LoginSteps(driver);
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
