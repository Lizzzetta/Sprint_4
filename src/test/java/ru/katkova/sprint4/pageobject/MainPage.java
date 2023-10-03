package ru.katkova.sprint4.pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class MainPage
{
    private final WebDriver driver;

    // Кнопка "Заказать"
    private final By requestButton = By.xpath(".//button[text() = 'Заказать']");

    public MainPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickOnRequestButton()
    {
        WebElement element = driver.findElement(requestButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void checkAccordionItem(String itemTitle, String itemContent){
        WebElement element = driver.findElement(By.xpath(".//div[@data-accordion-component = 'AccordionItemHeading']/div[text() = '" + itemTitle + "']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@data-accordion-component = 'AccordionItemPanel']/p[text() = '" + itemContent + "']")));
    }
}
