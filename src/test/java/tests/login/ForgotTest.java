package tests.login;

import models.User;
import org.testng.annotations.Test;
import pages.login.ForgotPage;
import pages.login.LogInPage;
import pages.login.SignUpPage;
import tests.BaseTest;

public class ForgotTest extends BaseTest {

    @Test
    public void restorePassword(){
        User fillEmail = new User("", "");
        User noExistEmail = new User("totoshka@mail.ru", "");
        User existEmail = new User("gotestweb@mailinator.com", "");

        new LogInPage(driver)
                .openPage()
                .goToForgotPage()
                .checkCurrentUrl("https://dev.integrivideo.com/recovery");
        new ForgotPage(driver)
                .openPage()
                .recoveryPassword(fillEmail)
                .checkAlertWrongEmail()
                .recoveryPassword(noExistEmail)
                .checkAlertWrongEmail()
                .recoveryPassword(existEmail)
                .checkAlertInstructionsSend()
                .goToLogInPage()
                .checkCurrentUrl("https://dev.integrivideo.com/login");
    }
}
