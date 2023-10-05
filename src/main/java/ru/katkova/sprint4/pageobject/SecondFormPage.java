package ru.katkova.sprint4.pageobject;

import org.openqa.selenium.*;

public class SecondFormPage
{
    private final WebDriver driver;

    // Заголовок
    private final By title = By.xpath(".//div[text() = 'Про аренду']");

    //Поле ввода даты
    private final By inputForDeliveryDate = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");

    //Поле ввода срока аренды
    private final By inputForDuration = By.xpath(".//div[@class = 'Dropdown-placeholder' and text() = '* Срок аренды']");

    //Кнопка "Заказать"
    private final By orderButton = By.xpath(".//div[starts-with(@class, 'Order_Buttons')]/button[text() = 'Заказать']");


    public SecondFormPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void setDeliveryDate(String value)
    {
        driver.findElement(inputForDeliveryDate).sendKeys(value);
        // close date chooser pop up
        driver.findElement(title).click();
    }

    public void setDuration(String value)
    {
        driver.findElement(inputForDuration).click();
        driver.findElement(By.xpath(".//div[@class = 'Dropdown-option' and text() = '" + value + "']")).click();
    }

    public void clickOnOrderButton()
    {
        driver.findElement(orderButton).click();
    }
}
