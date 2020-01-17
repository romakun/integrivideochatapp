package tests;

import models.User;
import org.testng.annotations.Test;
import pages.SignUpPage;

public class SignUpTest extends BaseTest {

    @Test
    public void signUp(){
        User user = new User("gotestweb@gmail.com", "123123123");
        new SignUpPage(driver)
                .openPage()
                .signUp(user);
    }
}
