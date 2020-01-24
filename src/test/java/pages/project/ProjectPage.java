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


public class ProjectPage extends BasePage {
    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logOutButton;
    @FindBy(xpath = "//a[text()='Billing']")
    WebElement billingButton;
    @FindBy(xpath = "//a[text()='Projects']")
    WebElement projectsButton;
    @FindBy(xpath = "//div[text()='Add project']")
    WebElement addProject;
    @FindBy(name = "name")
    WebElement nameProjectInput;
    @FindBy(xpath = "//textarea[@placeholder='Type here...']")
    WebElement descriptionProjectInput;

    private By SAVE_PROJECT_DATA_BUTTON = By.xpath("//form[@ajax-form]");
    private By DOMAINS_INPUT = By.name("domains[]");
    private By PROJECTS = By.xpath("//div[@class='project']");
    private By EDIT_PROJECT_DATA = By.xpath("//a[text()='Edit']");
    private By REMOVE_DOMAIN_BUTTON = By.className("remove-domain");


    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    public ProjectPage openPage() {
        isPageLoaded(By.xpath("//div[text()='Add project']"));
        PageFactory.initElements(driver, ProjectPage.this);
        return this;
    }

    public ProjectPage clickLogOutButton() {
        logOutButton.click();
        return this;
    }

    public ProjectPage clickBillingButton() {
        billingButton.click();
        return this;
    }

    public ProjectPage clickProjectButton() {
        projectsButton.click();
        isPageLoaded(By.xpath("//div[text()='Add project']"));
        return this;
    }

    public void clickAddProjectButton() {
        addProject.click();
        isPageLoaded(By.xpath("//button[text()='Create']"));
        PageFactory.initElements(driver, ProjectPage.this);
    }

    public int checkProjectsCount() {
        List<WebElement> projects = driver.findElements(PROJECTS);
        int projectsCount = projects.size();
        return projectsCount;
    }

    public void fillInProjectData(Project project, int domainsCount) {
        nameProjectInput.sendKeys(project.getProjectName());
        descriptionProjectInput.sendKeys(project.getProjectDescription());
        fillInDomains(domainsCount);
    }

    public void saveProjectData(){
        driver.findElement(SAVE_PROJECT_DATA_BUTTON).submit();
    }

    public void editProjectData(Project project){
        nameProjectInput.clear();
        nameProjectInput.sendKeys(project.getProjectName());
        descriptionProjectInput.clear();
        descriptionProjectInput.sendKeys(project.getProjectDescription());
    }

    public void fillInDomains(int domainsCount) {
        for (int i = 0; i < domainsCount; i++) {
            List<WebElement> domainList = driver.findElements(DOMAINS_INPUT);
            domainList.get(i).sendKeys(getRandomDomain());
        }
    }

    public static String getRandomDomain() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'

        Random random = new Random();
        int targetStringLength = 5 + random.nextInt(11 - 5 + 1);

        String word = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        String[] domainZone = {".com", ".ru", ".by", ".org", ".net"};
        String[] sslOrNot = {"", "http://", "https://"};
        String[] wwwOrNot = {"", "www."};

        return sslOrNot[random.nextInt(3)] + wwwOrNot[random.nextInt(2)] + word + domainZone[random.nextInt(5)];
    }

    public void goToProjectSettings(int projectNumber) {
        List<WebElement> projects = driver.findElements(PROJECTS);
        projects.get(projectNumber - 1).click();
        isPageLoaded(By.xpath("//div[text()='Add new component']"));
    }

    public void goToEditionsProjectData() {
        driver.findElement(EDIT_PROJECT_DATA).click();
        isPageLoaded(By.xpath("//button[text()='Update']"));
        PageFactory.initElements(driver, ProjectPage.this);
    }


    public void deleteDomainName(int domainNumber) {
        List<WebElement> domainList = driver.findElements(REMOVE_DOMAIN_BUTTON);
        domainList.get(domainNumber - 1).click();
    }

}
