package tests.chat;

import org.testng.annotations.Test;
import pages.chat.IntegriChatPage;
import tests.BaseTest;

public class ChatSendMessageWithCodeTest extends BaseTest {

    IntegriChatPage chat;

    @Test
    public void integriChatSendMessage(){
        String message = "<html><body><p>test</p></body></html>";
        chat = new IntegriChatPage(driver);

        chat.openPage();
        chat.sendMessageByReturn(message);
        chat.messageShouldContainText(message, 1);
    }
}
