package tests.login;

import models.User;
import org.testng.annotations.Test;
import pages.login.LogInPage;
import pages.login.SignUpPage;
import pages.project.ProjectPage;
import tests.BaseTest;

public class LogInTest extends BaseTest {

    @Test
    public void LogIn(){
        User fillUser = new User("", "");
        User withoutPass = new User("gotestweb@mailinator.com", "");
        User withoutEmail = new User("", "12345678");
        User admin = new User("admin@admin.com", "admin");
        User validUser = new User("gotestweb@mailinator.com", "12345678");

        new LogInPage(driver)
                .openPage()
                .logIn(fillUser)
                .checkAlertMissingCredentials()
                .logIn(withoutPass)
                .checkAlertMissingCredentials()
                .logIn(withoutEmail)
                .checkAlertMissingCredentials()
                .logIn(admin)
                .checkAlertUserNotFound()
                .logIn(validUser);
        new ProjectPage(driver)
                .isPageLoaded()
                .clickLogOut()
                .checkCurrentUrl("https://dev.integrivideo.com/");
    }
}
