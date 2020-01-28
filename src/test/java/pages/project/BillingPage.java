package pages.project;


import models.Card;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class BillingPage extends BasePage {
    @FindBy(xpath = "//a[text()='Add new']")
    WebElement addNewPaymentButton;
    @FindBy(name = "number")
    WebElement cardNumberInput;
    @FindBy(name = "expirationMonth")
    WebElement cardDateMontInput;
    @FindBy(name = "expirationYear")
    WebElement cardDateYearInput;
    @FindBy(name = "cardholderName")
    WebElement cardHolderNameInput;
    @FindBy(xpath = "//form[@action='/app/billing/payment-methods']")
    WebElement addCardButton;

    private By ADD_BUTTON = By.xpath("//button[text()='Add']");

    public BillingPage(WebDriver driver) {
        super(driver);
    }

    public BillingPage openPage() {
        isPageLoaded(By.xpath("//a[text()='Add new']"));
        PageFactory.initElements(driver, BillingPage.this);
        return this;
    }

    public BillingPage clickAddNewPaymentButton() {

        addNewPaymentButton.click();
        isPageLoaded(By.xpath("//button[text()='Add']"));
        wait.until(ExpectedConditions.elementToBeClickable(ADD_BUTTON));
        PageFactory.initElements(driver, BillingPage.this);
        return this;
    }

    public BillingPage fillInCardData(Card card) {
        cardNumberInput.sendKeys(card.getCartNumber());
        cardDateMontInput.sendKeys(card.getDateMonth());
        cardDateYearInput.sendKeys(card.getDateYear());
        cardHolderNameInput.sendKeys(card.getCardHolderName());
        return this;
    }

    public BillingPage clickAddNewCardButton() {
        addCardButton.submit();
        return this;
    }
}
