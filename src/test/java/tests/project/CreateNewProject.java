package tests.project;

import models.Project;
import models.User;
import org.testng.annotations.Test;
import pages.login.LogInPage;
import pages.project.NewProjectPage;
import pages.project.ProjectPage;
import tests.BaseTest;

public class CreateNewProject extends BaseTest {
    User validUser = new User("gotestweb@mailinator.com", "12345678");
    Project project = new Project("myProject", "bla bla bla bla bla");

    @Test
    public void createNewProject(){

        new LogInPage(driver)
                .openPage()
                .logIn(validUser);
        new NewProjectPage(driver)
                .createProject(project, 3);
    }
}
