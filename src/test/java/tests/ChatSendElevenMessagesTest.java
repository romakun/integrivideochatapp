package tests;

import org.testng.annotations.Test;
import pages.IntegriChatPage;

public class ChatSendElevenMessagesTest extends BaseTest {

    IntegriChatPage chat;

    @Test
    public void integriChatSendMessage(){
        String message = "Hello World!";
        chat = new IntegriChatPage(driver);

        chat.openPage();
        chat.sendMoreMessages(message,11);
    }
}
