package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class OnlinerLocators {

    @Test
    public void checkCheckboxes() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver browser = new ChromeDriver();
        browser.get("https://catalog.onliner.by/");

        browser.findElement(By.id("fast-search"));
        browser.findElement(By.className("tiles_grid_4"));
        browser.findElement(By.name("query"));
        browser.findElement(By.tagName("img"));
        browser.findElement(By.linkText("Автомобильные шины"));
        browser.findElement(By.partialLinkText("браслеты"));

        //CSS
        browser.findElement((By.cssSelector(".fast-search__input")));
        browser.findElement(By.cssSelector("#fast-search"));
        browser.findElement(By.cssSelector("input.fast-search__input"));
        browser.findElement(By.cssSelector("form input"));
        browser.findElement(By.cssSelector("form > input"));
        browser.findElement(By.cssSelector("[id]"));
        browser.findElement(By.cssSelector("[name=query]"));
        browser.findElement(By.cssSelector("[title~=Корзина]"));
        browser.findElement(By.cssSelector("[method|=get]"));
        browser.findElement(By.cssSelector("a[href^=\"https://catalog.onliner.by/catfood\"]"));
        browser.findElement(By.cssSelector("a[class$=\"_primary\"]"));
        browser.findElement(By.cssSelector("input[class*=\"search\"]"));


        //xpath
        browser.findElement(By.xpath("//li[@data-id='1']"));
        browser.findElement(By.xpath("//li/span/span[text()='Электроника']"));
        browser.findElement(By.xpath("//span[text()='Электроника']/../../span"));
        browser.findElement(By.xpath("//input[@placeholder='Поиск в Каталоге. Например, \"горный велосипед\"']"));
        browser.findElement(By.xpath("//a[@class='tiles__widget']"));
        browser.findElement(By.xpath("//li/span/child::*"));

        browser.quit();
    }
}