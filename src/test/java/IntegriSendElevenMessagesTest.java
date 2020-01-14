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

public class IntegriSendElevenMessagesTest {

    @Test
    public void sendElevenMessages() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        for (int i = 0; i < 11; i++) {
            driver.findElement(By.xpath("//textarea[@placeholder='Start typing here']")).sendKeys("Hello World!", Keys.RETURN);
            if (i < 10) {
                List<WebElement> chatMessages = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class='integri-chat-message ']"), i));
                assertEquals(chatMessages.get(i).getText(), "Hello World!", "Сообщение не найдено");
            } else {
                assertEquals(driver.findElement(By.xpath("//div[@class='integri-demo-version']/div")).getText(), "This is trial version\n" +
                        "Sign up or Skip", "Сообщение не найдено");
            }
        }

        driver.quit();
    }
}
