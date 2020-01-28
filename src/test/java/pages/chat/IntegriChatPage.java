package pages.chat;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;


import static org.testng.Assert.assertEquals;


public class IntegriChatPage extends BasePage {

    private static final By MESSAGE_TEXT_AREA = By.xpath("//textarea[@placeholder='Start typing here']");
    private static final By SEND_BUTTON = By.xpath("//button[@title='Send message']");
    private static final String URL = "https://dev.integrivideo.com/demo/chat/new";
    private static final By MESSAGE_TEXT = By.xpath("//div[@class='integri-chat-message-text']");
    private static final By EDIT_ICON = By.xpath("//span[contains(@class, 'iv-icon-pencil')]");
    private static final By SETTINGS_ICON = By.xpath("//span[contains(@class, 'integri-chat-settings')]");
    private static final By DELETE_ICON = By.xpath("//span[contains(@class, 'iv-icon-trash2')]");
    private static final By COPY_CODE = By.xpath("//code[@class='component-code']");
    private static final By INVITE_BUTTON = By.id("invite-users-to-chat");
    private static final By UPLOAD_BUTTON = By.xpath("//span[contains(@class, 'integri-chat-manual-upload')]");
    private static final By PROFILE_DETAILS = By.xpath("//div[contains(@class, 'integri-session-user-name')]");
    private static final By EDIT_AREA = By.xpath("//div[@class='integri-chat-message ']/textarea");
    private static final By IMAGE_BOX = By.xpath("//div[contains(@style, '(https://tinyjpg.com/images/social/website.jpg')]");
    private static final By DEMO_ELEMENT = By.xpath("//div[@class='integri-demo-version']/div");

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
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(EDIT_AREA, messageNumber - 1));
    }

    public void typeTextInEditArea(String edition, int messageNumber) {
        List<WebElement> editAreas = driver.findElements(EDIT_AREA);
        for(int i = 0; i < 5; i++){
            editAreas.get(messageNumber - 1).sendKeys(Keys.DELETE);
        }
        editAreas.get(messageNumber - 1).sendKeys(edition, Keys.RETURN);
        wait.until(ExpectedConditions.textToBe(MESSAGE_TEXT, "Bla Bla World!"));

    }

    public void clickCodeButton(){
        driver.findElement(COPY_CODE).click();
    }

    public void codeCopiedToClipboard() throws IOException, UnsupportedFlavorException {
        String data = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);

        String expectedData = driver.findElement(By.xpath("//code[@class='component-code']")).getText();
        expectedData = expectedData.replaceAll("\n", "");
        assertEquals(data, expectedData, "Скопированный текст не соответствует тексту на сайте");

    }

    public void deleteMessage(int messageNumber){
        List<WebElement> deleteIcons = driver.findElements(DELETE_ICON);
        deleteIcons.get(messageNumber - 1).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void messageDeleted(){
        List<WebElement> chatMessages = wait.until(ExpectedConditions.numberOfElementsToBeLessThan(MESSAGE_TEXT, 1));
        assertEquals(chatMessages.size(), 0, "Количество сообщений не соответствует ожидаемому");
    }

    public void clearEditionArea(){
        List<WebElement> editAreas = driver.findElements(EDIT_AREA);
        editAreas.get(0).clear();
        editAreas.get(0).sendKeys(Keys.RETURN);
        assertEquals(driver.findElement(By.xpath("//div[contains(@class, 'integri-notify-error')]")).isDisplayed(), true, "Сообщение об ошибке не появилось");
    }

    public void clickSettingButton(){
        driver.findElement(SETTINGS_ICON).click();
    }

    public void checkNameEdition(){
        wait.until(ExpectedConditions.textToBe(PROFILE_DETAILS, "Ramashka"));
        assertEquals(driver.findElement(PROFILE_DETAILS).getText(), "Ramashka", "Имя пользователя не совпадает с ожидаемым");
    }

    public void checkImageEdition(){
        assertEquals(driver.findElement(IMAGE_BOX).getAttribute("style"), "background-image: url(\"https://tinyjpg.com/images/social/website.jpg\");", "Изображение пользователя не изменено");
    }

    public void clickInvite(){
        driver.findElement(INVITE_BUTTON).click();
    }

    public void openPage2() throws IOException, UnsupportedFlavorException {
        String data = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        driver.quit();
        driver = null;
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(data);
    }

    public void sendMoreMessages(String message, int messagesCount){
        for (int i = 0; i < messagesCount; i++) {
            driver.findElement(MESSAGE_TEXT_AREA).sendKeys(message, Keys.RETURN);
            if (i < messagesCount - 1) {
                List<WebElement> chatMessages = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(MESSAGE_TEXT, i));
                assertEquals(chatMessages.get(i).getText(), message, "Сообщение не найдено");
            } else {
                assertEquals(driver.findElement(DEMO_ELEMENT).getText(), "This is trial version\n" +
                        "Sign up or Skip", "Сообщение не найдено");
            }
        }
    }

    public void switchToNewTab(){
        List<WebElement> chatMessages = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(MESSAGE_TEXT, 0));
        chatMessages.get(0).click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }

    public void checkCurrentUrl(String url){
        assertEquals(driver.getCurrentUrl(), url, "Введенный url не соответствует ожидаемому");
    }

    public String getRandomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 1000;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public void checkMessageLength(){
        List<WebElement> chatMessages = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(MESSAGE_TEXT, 0));
        String messageLength = chatMessages.get(0).getText();
        assertEquals(messageLength.length(), 1000, "Сообщение состоит не из 1000 символов");
        driver.quit();
    }

    public void clickUpload(){
        driver.findElement(UPLOAD_BUTTON).click();
    }
}
