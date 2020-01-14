import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class IntegriEditMessageTest {

    @Test
    public void editMessage() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        driver.findElement(By.xpath("//textarea[@placeholder='Start typing here']")).sendKeys("test", Keys.RETURN);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        List<WebElement> chatMessages = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class='integri-chat-message ']"), 0));
        List<WebElement> editIcons = driver.findElements(By.xpath("//span[contains(@class, 'iv-icon-pencil')]"));
        editIcons.get(0).click();
        chatMessages.get(0).findElement(By.xpath("./textarea")).sendKeys("Hello! ", Keys.RETURN);
        Thread.sleep(1000);
        chatMessages = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class='integri-chat-message ']"), 0));
        assertEquals(chatMessages.get(0).getText(), "Hello! test", "Введенный текст не соответствует ожидаемому");
        driver.quit();
    }
}
