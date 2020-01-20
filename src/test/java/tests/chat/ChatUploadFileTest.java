package tests.chat;

import org.testng.annotations.Test;
import pages.chat.IntegriChatPage;
import pages.chat.IntegriUploadModal;
import tests.BaseTest;

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
