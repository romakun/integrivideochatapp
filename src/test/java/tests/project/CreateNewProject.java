package tests.project;

import models.User;
import org.testng.annotations.Test;
import pages.login.LogInPage;
import pages.project.NewProjectPage;
import pages.project.ProjectPage;
import tests.BaseTest;

public class CreateNewProject extends BaseTest {
    User validUser = new User("gotestweb@mailinator.com", "12345678");

    @Test
    public void createNewProject(){

        new LogInPage(driver)
                .openPage()
                .logIn(validUser);
        new ProjectPage(driver)
                .openPage()
                .clickAddProjectButton();
        new NewProjectPage(driver)
                .openPage()
                .createProject();
    }
}
