package steps;

import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.login.LogInPage;
import tests.BaseTest;

public class LoginSteps extends BaseTest {

    private LogInPage page;

    public LoginSteps(WebDriver driver) {
        page = new LogInPage(driver);
    }


    @Step("Login integrivideoapp")
    public void LogIn() {
        User emptyUser = new User("", "");
        User withoutPass = new User("gotestweb@mailinator.com", "");
        User withoutEmail = new User("", "12345678");
        User admin = new User("admin@admin.com", "admin");
        User validUser = new User("gotestweb@mailinator.com", "12345678");
        String alertMissingCredentials = "Missing credentials";
        String alertUserNotFound = "Error: User is not found";

        page
                .openPage()
                .logIn(emptyUser)
                .checkAlert(alertMissingCredentials)
                .logIn(withoutPass)
                .checkAlert(alertMissingCredentials)
                .logIn(withoutEmail)
                .checkAlert(alertMissingCredentials)
                .logIn(admin)
                .checkAlert(alertUserNotFound)
                .logIn(validUser)
                .checkCurrentUrl("https://dev.integrivideo.com/app/projects");
//        new ProjectPage(driver)
//                .openPage()
//                .clickLogOutButton()
//                .checkCurrentUrl("https://dev.integrivideo.com/");
    }
}

