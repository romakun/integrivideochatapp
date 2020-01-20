package tests;

import org.testng.annotations.Test;
import pages.IntegriChatPage;

public class ChatEditMessageTest extends BaseTest {

    IntegriChatPage chat;

    @Test
    public void integriChatSendMessage(){
        String message = "Hello World!";
        chat = new IntegriChatPage(driver);

        chat.openPage();
        chat.sendMessageByReturn(message);
        chat.messageShouldContainText(message, 1);
        chat.clickEditIcon(1);
        chat.typeTextInEditArea("Bla Bla", 1);
        chat.messageShouldContainText("Bla Bla World!", 1);
    }
}
