package tests.project;

import models.Card;
import models.User;
import org.testng.annotations.Test;
import pages.login.LogInPage;
import pages.project.BillingPage;
import pages.project.ProjectPage;
import tests.BaseTest;

import static org.testng.Assert.assertEquals;

public class AddPaymentMethodTest extends BaseTest {
    User validUser = new User("gotestweb@mailinator.com", "12345678");
    Card carData = new Card("4242424242424242", "10", "2022", "Bublik Bublikovich");

    @Test
    public void createNewProject() {
        new LogInPage(driver)
                .openPage()
                .logIn(validUser);
        new ProjectPage(driver)
                .openPage()
                .clickBillingButton();
        new BillingPage(driver)
                .openPage()
                .clickAddNewPaymentButton()
                .fillInCardData(carData)
                .clickAddNewCardButton()
                .openPage();

    }
}
