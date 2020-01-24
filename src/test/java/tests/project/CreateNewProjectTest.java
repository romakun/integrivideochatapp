package tests.project;

import models.Project;
import models.User;
import org.testng.annotations.Test;
import pages.login.LogInPage;
import pages.project.ProjectPage;
import tests.BaseTest;

import static org.testng.Assert.assertEquals;

public class CreateNewProjectTest extends BaseTest {
    User validUser = new User("gotestweb@mailinator.com", "12345678");
    Project project = new Project("myProject", "bla bla bla bla bla");

    ProjectPage page;

    @Test
    public void createNewProject() {
        new LogInPage(driver)
                .openPage()
                .logIn(validUser);
        page = new ProjectPage(driver);
        page.openPage();
        int projectsCount = page.checkProjectsCount();
        page.clickAddProjectButton();
        page.fillInProjectData(project, 3);
        page.saveProjectData();
        page.openPage();
        int newProjectCount = page.checkProjectsCount();
        assertEquals(newProjectCount, projectsCount + 1, "Количество проектов не изменилось");
    }
}
