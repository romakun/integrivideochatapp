package pages.project;

import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.BasePage;

import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;


public class NewProjectPage extends BasePage {
    @FindBy(name = "name")
    WebElement nameProjectInput;
    @FindBy(xpath = "//textarea[@placeholder='Type here...']")
    WebElement descriptionProjectInput;
    @FindBy(xpath = "//form[@ajax-form]")
    WebElement createProjectForm;

    private By DOMAINS_INPUT = By.name("domains[]");

    public NewProjectPage(WebDriver driver) {
        super(driver);
    }

    public NewProjectPage openPage() {
        isPageLoaded(By.xpath("//button[text()='Create']"));
        PageFactory.initElements(driver, NewProjectPage.this);
        return this;
    }

    public void createProject(Project project, int domainsCount) {
        PageFactory.initElements(driver, ProjectPage.class);
        int projectsCount = new ProjectPage(driver)
                .openPage()
                .clickAddProjectButton();
        System.out.println(projectsCount);
        openPage();
        nameProjectInput.sendKeys(project.getProjectName());
        descriptionProjectInput.sendKeys(project.getProjectDescription());
        fillInDomains(domainsCount);
        createProjectForm.submit();
        int newProjectsCount = new ProjectPage(driver)
                .openPage()
                .checkProjectsCount();
        System.out.println(newProjectsCount);
        assertEquals(newProjectsCount, projectsCount + 1, "Количество проектов не увеличилось");
    }

    public NewProjectPage fillInDomains(int domainsCount){
        for(int i = 0; i < domainsCount; i++){
            List<WebElement> domainList = driver.findElements(DOMAINS_INPUT);
            domainList.get(i).sendKeys(getRandomDomain());
        }
        return this;
    }

    public static String getRandomDomain() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'

        Random random = new Random();
        int targetStringLength = 5 + random.nextInt(11 - 5 + 1);

        String word =  random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        String[] domainZone = {".com", ".ru", ".by", ".org", ".net"};
        String[] sslOrNot = {"", "http://", "https://"};
        String[] wwwOrNot = {"", "www."};

        return sslOrNot[random.nextInt(3)] + wwwOrNot[random.nextInt(2)] + word + domainZone[random.nextInt(5)];
    }

}
