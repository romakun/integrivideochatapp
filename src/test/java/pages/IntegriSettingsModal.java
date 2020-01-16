package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class IntegriSettingsModal extends BasePage {

    private static final By EMAIL_FIELD = By.xpath("//input[@name='userEmail']");
    private static final By SAVE_BUTTON = By.xpath("//button[contains(@class, 'integri-user-settings-save')]");
    private static final By NAME_FIELD = By.xpath("//input[@name='userName']");
    private static final By IMAGE_LINK_FIELD = By.xpath("//input[@name='userPic']");

    public IntegriSettingsModal(WebDriver driver) {
        super(driver);
    }

    public void editEmail(String email){
        driver.findElement(EMAIL_FIELD).sendKeys(email);
    }

    public void clickSave(){
        driver.findElement(SAVE_BUTTON).click();
    }

    public void editName(String name){
        driver.findElement(NAME_FIELD).clear();
        driver.findElement(NAME_FIELD).sendKeys(name);
    }

    public void editImageLink(String imageLink){
        driver.findElement(IMAGE_LINK_FIELD).sendKeys(imageLink);
    }

    //email
    //name
    //photo
    //save
    //cancel

}
