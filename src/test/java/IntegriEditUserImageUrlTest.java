import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class IntegriEditUserImageUrlTest {

    @Test
    public void editUserName() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        driver.findElement(By.xpath("//span[contains(@class, 'integri-chat-settings')]")).click();
        driver.findElement(By.xpath("//input[@name='userPic']")).sendKeys("https://tinyjpg.com/images/social/website.jpg");
        driver.findElement(By.xpath("//button[contains(@class, 'integri-user-settings-save')]")).click();
        assertEquals(driver.findElement(By.xpath("//div[contains(@style, '(https://tinyjpg.com/images/social/website.jpg')]")).getAttribute("style"), "background-image: url(\"https://tinyjpg.com/images/social/website.jpg\");", "Изображение пользователя не изменено");
        driver.quit();
    }
}
