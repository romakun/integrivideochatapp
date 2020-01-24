package tests.project;

import models.Project;
import models.User;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.login.LogInPage;
import pages.project.ProjectPage;
import tests.BaseTest;

import static org.testng.Assert.assertEquals;

public class ChangeProjectSettingsTest extends BaseTest {
    User validUser = new User("gotestweb@mailinator.com", "12345678");
    Project newProjectData = new Project("SHAKALAKA", "pum purum");
    ProjectPage page;

    @Test
    public void createNewProject() {
        new LogInPage(driver)
                .openPage()
                .logIn(validUser);
        page = new ProjectPage(driver);
        page.openPage();
        page.goToProjectSettings(2);
        page.goToEditionsProjectData();
        page.editProjectData(newProjectData);
        page.deleteDomainName(1);
        page.saveProjectData();
    }
}
