package tests;

import org.testng.annotations.Test;
import pages.IntegriChatPage;

public class ChatDeleteMessageTest extends BaseTest {

    IntegriChatPage chat;

    @Test
    public void integriChatDeleteMessage(){
        String message = "Hello World!";
        chat = new IntegriChatPage(driver);

        chat.openPage();
        chat.sendMessageByReturn(message);
        chat.messageShouldContainText(message, 1);
        chat.deleteMessage(1);
        chat.messageDeleted();
    }
}
