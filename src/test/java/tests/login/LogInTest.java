package tests.login;

import models.User;
import org.testng.annotations.Test;
import pages.login.LogInPage;
import pages.project.ProjectPage;
import tests.BaseTest;

public class LogInTest extends BaseTest {

    @Test
    public void LogIn(){
        User emptyUser = new User("", "");
        User withoutPass = new User("gotestweb@mailinator.com", "");
        User withoutEmail = new User("", "12345678");
        User admin = new User("admin@admin.com", "admin");
        User validUser = new User("gotestweb@mailinator.com", "12345678");
        String alertMissingCredentials = "Missing credentials";
        String alertUserNotFound = "Error: User is not found";

        new LogInPage(driver)
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
        new ProjectPage(driver)
                .openPage()
                .clickLogOutButton()
                .checkCurrentUrl("https://dev.integrivideo.com/");
    }
}
