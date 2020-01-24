package tests.project;

import models.User;
import org.testng.annotations.Test;
import pages.login.LogInPage;
import pages.project.AddComponentPage;
import pages.project.ProjectPage;
import tests.BaseTest;

public class AddProjectComponentTest extends BaseTest {
    User validUser = new User("gotestweb@mailinator.com", "12345678");

    String[] componentName = {"Video Chat", "Multi-device Video Player", "Single Video", "Multiparty Video"};

            ProjectPage page;

    @Test
    public void createNewProject() {
        new LogInPage(driver)
                .openPage()
                .logIn(validUser);
        page = new ProjectPage(driver);
        page.openPage();
        page.goToProjectSettings(2);
        page.goToAddNewComponents();
        new AddComponentPage(driver)
                .openPage()
                .chooseComponent(componentName[0])
                .fillInComponentName("Chatik")
                .saveComponent()
                .saveComponent();
    }
}
