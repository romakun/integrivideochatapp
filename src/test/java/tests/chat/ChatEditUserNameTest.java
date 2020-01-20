package tests.chat;

import org.testng.annotations.Test;
import pages.chat.IntegriChatPage;
import pages.chat.IntegriSettingsModal;
import tests.BaseTest;

public class ChatEditUserNameTest extends BaseTest {

    IntegriChatPage chat;
    IntegriSettingsModal settings;

    @Test
    public void integriChatCopyCode() {
        chat = new IntegriChatPage(driver);
        settings = new IntegriSettingsModal(driver);

        chat.openPage();
        chat.clickSettingButton();
        settings.editName("Ramashka");
        settings.clickSave();
        chat.checkNameEdition();

    }
}
