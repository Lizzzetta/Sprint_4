package ru.katkova.sprint4.pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class MainPage
{
    private final WebDriver driver;

    // Кнопка "Заказать"
    private final By requestButtonInHeader = By.xpath(".//div[starts-with(@class, 'Header_Nav')]/button[text() = 'Заказать']");
    private final By requestButtonInBody = By.xpath(".//div[starts-with(@class, 'Home_FinishButton')]/button[text() = 'Заказать']");

    public MainPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickOnRequestButtonInHeader()
    {
        WebElement element = driver.findElement(requestButtonInHeader);
        element.click();
    }

    public void clickOnRequestButtonInBody()
    {
        WebElement element = driver.findElement(requestButtonInBody);
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
