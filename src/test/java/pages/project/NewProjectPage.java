package pages.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.BasePage;



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

    public NewProjectPage createProject() {
        nameProjectInput.sendKeys("bla bla");
        descriptionProjectInput.sendKeys("bla bla bla");
        //domainProjectInput.sendKeys("google.com");
        createProjectForm.submit();
        return this;
    }
}
