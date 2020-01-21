package pages.login;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class ForgotPage extends BasePage{
    @FindBy(name = "email")
    WebElement emailInput;
    @FindBy(className = "display-center")
    WebElement recoveryButton;
    @FindBy(linkText = "Log in")
    WebElement logInLink;

    private By ALERT_MESSAGE = By.xpath("//span[@data-notify='message']");

    public ForgotPage(WebDriver driver) {
        super(driver);
    }

    public ForgotPage openPage(){
        isPageLoaded(By.className("display-center"));
        PageFactory.initElements(driver, ForgotPage.this);
        return this;
    }

    public ForgotPage recoveryPassword(User user){
        emailInput.sendKeys(user.getEmail());
        recoveryButton.submit();
        return this;
    }

    public ForgotPage checkAlert(String alertMessage){
        waitAlertIsPresent(ALERT_MESSAGE);
        assertEquals(driver.findElement(ALERT_MESSAGE).getText(), alertMessage, "Wrong alert message");
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(ALERT_MESSAGE)));
        return this;
    }

    public ForgotPage goToLogInPage(){
        logInLink.click();
        return this;
    }

}
