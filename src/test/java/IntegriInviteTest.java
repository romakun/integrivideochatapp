import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class IntegriInviteTest {

    @Test
    public void testInviteSystem() throws IOException, UnsupportedFlavorException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(By.id("invite-users-to-chat")).click();
        driver.findElement(By.xpath("//textarea[@placeholder='Start typing here']")).sendKeys("Hello World!", Keys.RETURN);

        List<WebElement> chatMessages = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class='integri-chat-message ']"), 0));
        assertEquals(chatMessages.get(0).getText(), "Hello World!", "Сообщение не найдено");

        WebDriver driver2 = new ChromeDriver();
        driver2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String data = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        driver2.get(data);
        driver2.findElement(By.xpath("//textarea[@placeholder='Start typing here']")).sendKeys("Hello my friend!", Keys.RETURN);
        List<WebElement> chatMessages2 = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class='integri-chat-message ']"), 1));
        assertEquals(chatMessages2.get(1).getText(), "Hello my friend!", "Сообщение не найдено");

        driver.quit();
        driver2.quit();

    }
}
