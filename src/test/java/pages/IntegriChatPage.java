package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import javax.swing.text.EditorKit;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class IntegriChatPage extends BasePage {

    private static final By MESSAGE_TEXT_AREA = By.xpath("//textarea[@placeholder='Start typing here']");
    private static final By SEND_BUTTON = By.xpath("//button[@title='Send message']");
    private static final String URL = "https://dev.integrivideo.com/demo/chat/new";
    private static final By MESSAGE_TEXT = By.xpath("//div[@class='integri-chat-message ']");
    private static final By EDIT_ICON = By.xpath("//span[contains(@class, 'iv-icon-pencil')]");
    private static final By SETTINGS_ICON = By.xpath("//span[contains(@class, 'integri-chat-settings')]");
    private static final By DELETE_ICON = By.xpath("//span[contains(@class, 'iv-icon-trash2')]");
    private static final By COPY_CODE = By.xpath("//code[@class='component-code']");
    private static final By INVITE_BUTTON = By.id("invite-users-to-chat");
    private static final By UPLOAD_BUTTON = By.xpath("//span[contains(@class, 'integri-chat-manual-upload')]");
    private static final By PROFILE_DETAILS = By.xpath("//div[contains(@class, 'integri-session-user-name')]");
    private static final By EDIT_AREA = By.xpath("//div[@class='integri-chat-message ']/textarea");

    public IntegriChatPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(URL);
    }

    public void typeMessage(String message) {
        driver.findElement(MESSAGE_TEXT_AREA).sendKeys(message);
    }

    public void clickSendMessageButton() {
        driver.findElement(SEND_BUTTON).click();
    }

    public void sendMessageByReturn(String message) {
        driver.findElement(MESSAGE_TEXT_AREA).sendKeys(message, Keys.RETURN);
    }

    public void messageShouldContainText(String message, int messageNumber) {
        List<WebElement> chatMessages = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(MESSAGE_TEXT, messageNumber - 1));
        assertEquals(chatMessages.get(messageNumber - 1).getText(), message, "Сообщение не найдено");
    }

    public void clickEditIcon(int messageNumber) {
        List<WebElement> editIcons = driver.findElements(EDIT_ICON);
        editIcons.get(messageNumber - 1).click();
    }

    public void typeTextInEditArea(String message, int messageNumber) {
        List<WebElement> chatMessages = driver.findElements(MESSAGE_TEXT);
        String firstMessage = chatMessages.get(0).getText();
        List<WebElement> editAreas = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(EDIT_AREA, messageNumber - 1));
        editAreas.get(0).sendKeys(message, Keys.RETURN);
        wait.until(ExpectedConditions.textToBe(MESSAGE_TEXT, message + firstMessage));
    }
}
