package tests;

import org.testng.annotations.Test;
import pages.IntegriChatPage;

public class ChatSendMessageWithsThousandSymbolsTest extends BaseTest {

    IntegriChatPage chat;

    @Test
    public void integriChatSendMessage(){
        chat = new IntegriChatPage(driver);

        chat.openPage();
        chat.sendMessageByReturn(chat.getRandomString());
        chat.checkMessageLength();
    }
}
