package tests;

import org.testng.annotations.Test;
import pages.IntegriChatPage;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class ChatInviteTest extends BaseTest {

    IntegriChatPage chat;

    @Test
    public void integriChatSendMessage() throws IOException, UnsupportedFlavorException {
        String message = "Hello World!";
        chat = new IntegriChatPage(driver);

        chat.openPage();
        chat.sendMessageByReturn(message);
        chat.messageShouldContainText(message, 1);
        chat.clickInvite();
        chat.openPage2();
        chat.sendMessageByReturn("Hello my friend!");
    }
}
