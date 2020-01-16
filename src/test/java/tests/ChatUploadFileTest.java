package tests;

import org.testng.annotations.Test;
import pages.IntegriChatPage;
import pages.IntegriUploadModal;

public class ChatUploadFileTest extends BaseTest {

    IntegriChatPage chat;
    IntegriUploadModal upload;

    @Test
    public void integriChatSendMessage() throws InterruptedException {
        chat = new IntegriChatPage(driver);
        upload = new IntegriUploadModal(driver);

        chat.openPage();
        chat.clickUpload();
        upload.uploadFile();
    }
}
