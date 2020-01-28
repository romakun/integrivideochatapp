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
    @FindBy(className = "forgot")
    WebElement forgotLink;

    private By ALERT_MESSAGE = By.xpath("//span[@data-notify='message']");

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public LogInPage openPage() {
        driver.get("https://dev.integrivideo.com/login");
        isPageLoaded(By.id("login-form"));
        PageFactory.initElements(driver, LogInPage.this);
        return this;
    }

    public LogInPage logIn(User user) {
        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());
        LogInForm.submit();
        return this;
    }

    public LogInPage checkAlert(String alertMessage) {
        waitAlertIsPresent(ALERT_MESSAGE);
        assertEquals(driver.findElement(ALERT_MESSAGE).getText(), alertMessage, "Wrong alert message");
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(ALERT_MESSAGE)));
        return this;
    }

    public LogInPage goToForgotPage() {
        forgotLink.click();
        return this;
    }
}
