package tests;

import org.testng.annotations.Test;
import pages.IntegriChatPage;

public class ChatSendMessageByButtonTest extends BaseTest {

    IntegriChatPage chat;

    @Test
    public void integriChatSendMessage(){
        String message = "Hello World!";
        chat = new IntegriChatPage(driver);

        chat.openPage();
        chat.typeMessage(message);
        chat.clickSendMessageButton();
        chat.messageShouldContainText(message, 1);

    }
}
