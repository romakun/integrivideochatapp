package pages.project;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import static org.testng.Assert.assertEquals;

public class NewProjectPage extends BasePage {

    public NewProjectPage(WebDriver driver) {
        super(driver);
    }



}
