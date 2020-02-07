package tests.login;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import models.User;
import org.testng.annotations.Test;
import pages.login.LogInPage;
import pages.project.ProjectPage;
import tests.BaseTest;

public class LogInTest extends BaseTest {

    @Test(description = "Login in integrivideo app")
    @Description("Validation of login functionality in Integry video app")
    @Link("https://instagram.com/dmitryrak11")
    @Issue("dmitryrak11")
    @TmsLink("dmitryrak11")
    public void LogInTest() {
        steps.LogIn();
    }
}
