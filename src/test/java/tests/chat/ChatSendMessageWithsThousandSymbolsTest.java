package tests.chat;

import org.testng.annotations.Test;
import pages.chat.IntegriChatPage;
import tests.BaseTest;

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
