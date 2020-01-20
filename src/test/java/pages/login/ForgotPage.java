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
    @FindBy(xpath = "//span[@data-notify='message']")
    WebElement alertMessage;
    @FindBy(linkText = "Log in")
    WebElement logInLink;



    public ForgotPage(WebDriver driver) {
        super(driver);
    }

    public ForgotPage openPage(){
        isPageLoaded();
        PageFactory.initElements(driver, ForgotPage.this);
        return this;
    }

    public void isPageLoaded(){

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("display-center")));
        } catch (TimeoutException ex) {
            System.out.println("Page no load");
            throw new TimeoutException("Page no load");
        }
    }

    public ForgotPage recoveryPassword(User user){
        emailInput.sendKeys(user.getEmail());
        recoveryButton.submit();
        return this;
    }

    public ForgotPage checkAlertWrongEmail(){
        assertTrue(wait.until(ExpectedConditions.textToBePresentInElement(alertMessage,"Wrong email. Please ensure that you use correct email address")), "Alert not found");
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//span[@data-notify='message']"), "Wrong email. Please ensure that you use correct email address"));
        return this;
    }

    public ForgotPage checkAlertInstructionsSend(){
        assertTrue(wait.until(ExpectedConditions.textToBePresentInElement(alertMessage,"Message with instructions was sent")), "Alert not found");
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//span[@data-notify='message']"), "Message with instructions was sent"));
        return this;
    }

    public ForgotPage goToLogInPage(){
        logInLink.click();
        return this;
    }

    public void checkCurrentUrl(String url){
        assertEquals(driver.getCurrentUrl(), url, "Not Expected URL");
    }


}
