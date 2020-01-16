package tests;

import org.testng.annotations.Test;
import pages.IntegriChatPage;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class ChatCopyCodeTest extends BaseTest {

    IntegriChatPage chat;

    @Test
    public void integriChatCopyCode() throws IOException, UnsupportedFlavorException {
        chat = new IntegriChatPage(driver);

        chat.openPage();
        chat.clickCodeButton();
        chat.codeCopiedToClipboard();
    }
}
