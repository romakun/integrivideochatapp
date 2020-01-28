package tests.chat;

import org.testng.annotations.Test;
import pages.chat.IntegriChatPage;
import tests.BaseTest;

public class ChatSendMessageWithLinkTest extends BaseTest {

    IntegriChatPage chat;

    @Test
    public void integriChatSendMessage(){
        String url = "https://vigbo.com/";
        chat = new IntegriChatPage(driver);

        chat.openPage();
        chat.sendMessageByReturn(url);
        chat.switchToNewTab();
        chat.checkCurrentUrl(url);
    }
}
