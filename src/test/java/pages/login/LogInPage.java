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

public class LogInPage extends BasePage {
    @FindBy(name = "email")
    WebElement emailInput;
    @FindBy(name = "password")
    WebElement passwordInput;
    @FindBy(id = "login-form")
    WebElement LogInForm;
    @FindBy(xpath = "//span[@data-notify='message']")
    WebElement alertMessage;
    @FindBy(className = "forgot")
    WebElement forgotLink;


    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public LogInPage openPage(){
        driver.get("https://dev.integrivideo.com/login");
        isPageLoaded();
        PageFactory.initElements(driver, LogInPage.this);
        return this;
    }

    public void isPageLoaded(){

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form")));
        } catch (TimeoutException ex) {
            System.out.println("Page no load");
            throw new TimeoutException("Page no load");
        }
    }

    public LogInPage logIn(User user){

        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());
        LogInForm.submit();
        return this;

    }


    public LogInPage checkAlertMissingCredentials(){
        assertTrue(wait.until(ExpectedConditions.textToBePresentInElement(alertMessage,"Missing credentials")), "Alert not found");
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//span[@data-notify='message']"), "Missing credentials"));
        return this;
    }

    public LogInPage checkAlertUserNotFound(){
        assertTrue(wait.until(ExpectedConditions.textToBePresentInElement(alertMessage,"Error: User is not found")), "Alert not found");
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//span[@data-notify='message']"), "Error: User is not found"));
        return this;
    }

    public LogInPage goToForgotPage(){
        forgotLink.click();
        return this;
    }

    public void checkCurrentUrl(String url){
        assertEquals(driver.getCurrentUrl(), url, "Not Expected URL");
    }

}
