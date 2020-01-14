import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class IntegriSendMessageWithCodeTest {

    @Test
    public void sendMessageWithCode() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        driver.findElement(By.xpath("//textarea[@placeholder='Start typing here']")).sendKeys("<html><body><p>test</p></body></html>", Keys.RETURN);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        List<WebElement> chatMessages = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class='integri-chat-message ']"), 0));
        assertEquals(chatMessages.get(0).getText(), "<html><body><p>test</p></body></html>", "Введенный текст не соответствует ожидаемому");
        driver.quit();
    }

}
