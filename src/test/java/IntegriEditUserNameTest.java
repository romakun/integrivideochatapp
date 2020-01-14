import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class IntegriEditUserNameTest {

    @Test
    public void editUserName() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        driver.findElement(By.xpath("//span[contains(@class, 'integri-chat-settings')]")).click();
        driver.findElement(By.xpath("//input[@name='userName']")).clear();
        driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Raman");
        driver.findElement(By.xpath("//button[contains(@class, 'integri-user-settings-save')]")).click();
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[contains(@class, 'integri-session-user-name')]"), "Raman"));
        driver.findElement(By.xpath("//div[contains(@class, 'integri-session-user-name')]")).getText();
        assertEquals(driver.findElement(By.xpath("//div[contains(@class, 'integri-session-user-name')]")).getText(), "Raman", "Имя пользователя не совпадает с ожидаемым");
        driver.quit();
    }
}
