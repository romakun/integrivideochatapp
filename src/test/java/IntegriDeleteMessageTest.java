import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class IntegriDeleteMessageTest {

    @Test
    public void deleteMessage() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        driver.findElement(By.xpath("//textarea[@placeholder='Start typing here']")).sendKeys("test", Keys.RETURN);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        List<WebElement> chatMessages = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class='integri-chat-message ']"), 0));
        List<WebElement> deleteIcons = driver.findElements(By.xpath("//span[contains(@class, 'iv-icon-trash2')]"));
        deleteIcons.get(0).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        chatMessages = wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath("//div[@class='integri-chat-message ']"), 1));
        assertEquals(chatMessages.size(), 0, "Введенный текст не соответствует ожидаемому");
        driver.quit();
    }
}
