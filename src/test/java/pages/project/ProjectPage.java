package pages.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

import java.util.List;



public class ProjectPage extends BasePage {
    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logOutButton;
    @FindBy(xpath = "//a[text()='Billing']")
    WebElement billingButton;
    @FindBy(xpath = "//a[text()='Projects']")
    WebElement projectsButton;
    @FindBy(xpath = "//div[text()='Add project']")
    WebElement addProject;

    private By PROJECTS = By.xpath("//div[@class='project']");


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

    public int clickAddProjectButton() {
        int projectsCount = checkProjectsCount();
        addProject.click();
        return projectsCount;
    }

    public int checkProjectsCount(){
        List<WebElement> projects = driver.findElements(PROJECTS);
        return projects.size();
    }
}
