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

public class SignUpPage extends BasePage {
    @FindBy(name = "email")
    WebElement emailInput;
    @FindBy(name = "password")
    WebElement passwordInput;
    @FindBy(id = "signup-form")
    WebElement signUpForm;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public SignUpPage openPage(){
        driver.get("https://www.integrivideo.com/signup");
        isPageLoaded();
        PageFactory.initElements(driver, SignUpPage.this);
        return this;
    }

    public SignUpPage isPageLoaded(){

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signup-form")));
        } catch (TimeoutException ex) {
            System.out.println("Page no load");
            throw new TimeoutException("Page no load");
        }
        return this;
    }

    public SignUpPage signUp(User user){

        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());
        signUpForm.submit();
        return this;
    }

}
