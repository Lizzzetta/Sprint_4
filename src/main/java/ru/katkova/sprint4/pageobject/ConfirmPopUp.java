package ru.katkova.sprint4.pageobject;

import org.openqa.selenium.*;

public class ConfirmPopUp
{
    private final WebDriver driver;

    //Кнопка "Заказать"
    private final By yesButton = By.xpath(".//button[text() = 'Да']");

    public ConfirmPopUp(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickOnYesButton()
    {
        driver.findElement(yesButton).click();
    }
}
