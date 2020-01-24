package pages.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;


public class AddComponentPage  extends BasePage{
    @FindBy(xpath = "//select[@data-select2-id='1']")
    WebElement componentType;
    @FindBy(name = "name")
    WebElement componentName;
    @FindBy(xpath = "//form[@ajax-form]")
    WebElement createButton;

    public AddComponentPage(WebDriver driver) {
        super(driver);
    }

    public AddComponentPage openPage() {
        isPageLoaded(By.xpath("//button[text()='Create']"));
        PageFactory.initElements(driver, AddComponentPage.this);
        return this;
    }

    public AddComponentPage chooseComponent(String componentName){
        Select select = new Select(componentType);
        select.selectByVisibleText(componentName);
        return this;
    }

    public AddComponentPage fillInComponentName(String name){
        componentName.sendKeys(name);
        return this;
    }

    public void saveComponent(){
        createButton.submit();
    }
}
