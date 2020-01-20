package tests.login;

        import models.User;
        import org.testng.annotations.Test;
        import pages.login.SignUpPage;
        import tests.BaseTest;

public class SignUpTest extends BaseTest {

    @Test
    public void signUp(){
        User user = new User("gotestweb@gmail.com", "123123123");
        new SignUpPage(driver)
                .openPage()
                .signUp(user);
    }
}
