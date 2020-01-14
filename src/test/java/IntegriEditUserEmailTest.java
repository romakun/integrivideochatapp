import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class IntegriEditUserEmailTest {

    @Test
    public void editUserEmail() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        driver.findElement(By.xpath("//span[contains(@class, 'integri-chat-settings')]")).click();
        driver.findElement(By.xpath("//input[@name='userEmail']")).sendKeys("gotestweb@gmail.com");
        driver.findElement(By.xpath("//button[contains(@class, 'integri-user-settings-save')]")).click();
        driver.quit();
    }
}
