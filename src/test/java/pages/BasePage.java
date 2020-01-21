package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.project.ProjectPage;

import static org.testng.Assert.assertEquals;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void checkCurrentUrl(String url) {
        assertEquals(driver.getCurrentUrl(), url, "Not Expected URL");
    }

    public void waitAlertIsPresent(By element) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (TimeoutException ex) {
            System.out.println("alert not present");
            throw new TimeoutException("alert not present");
        }
    }

    public void isPageLoaded(By element) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (TimeoutException ex) {
            System.out.println("Page no load");
            throw new TimeoutException("Page no load");
        }
    }
}
