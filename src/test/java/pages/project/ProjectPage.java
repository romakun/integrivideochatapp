package pages.project;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import static org.testng.Assert.assertEquals;



public class ProjectPage extends BasePage{
    @FindBy(xpath = "//span[contains(@class, 'iv-icon-exit-right')]")
    WebElement logOutButton;


    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    public ProjectPage openPage(){
        driver.get("https://dev.integrivideo.com/login");
        isPageLoaded();
        PageFactory.initElements(driver, ProjectPage.this);
        return this;
    }

    public ProjectPage isPageLoaded(){

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'iv-icon-exit-right')]")));
        } catch (TimeoutException ex) {
            System.out.println("Page no load");
            throw new TimeoutException("Page no load");
        }
        return this;
    }

    public ProjectPage clickLogOut(){
        PageFactory.initElements(driver,ProjectPage.this);
        logOutButton.click();
        return this;
    }

    public void checkCurrentUrl(String url){
        assertEquals(driver.getCurrentUrl(), url, "Not Expected URL");
    }



}
