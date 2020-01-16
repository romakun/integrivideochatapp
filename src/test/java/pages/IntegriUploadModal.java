package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class IntegriUploadModal extends BasePage{

    private static final By UPLOAD_FIELD = By.xpath("//input[@type='file']");

    public IntegriUploadModal(WebDriver driver) {
        super(driver);
    }

    public void uploadFile() throws InterruptedException {
        driver.findElement(UPLOAD_FIELD).sendKeys(new File("./src/test/resources/1.jpg").getAbsolutePath());
        Thread.sleep(20000);
    }
}
