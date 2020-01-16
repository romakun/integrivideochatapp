package tests;

import org.testng.annotations.Test;
import pages.IntegriChatPage;
import pages.IntegriSettingsModal;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class ChatEditUserEmailTest extends BaseTest {

    IntegriChatPage chat;
    IntegriSettingsModal settings;

    @Test
    public void integriChatCopyCode() {
        chat = new IntegriChatPage(driver);
        settings = new IntegriSettingsModal(driver);

        chat.openPage();
        chat.clickSettingButton();
        settings.editEmail("gotestweb@gmail.com");
        settings.clickSave();

    }
}
