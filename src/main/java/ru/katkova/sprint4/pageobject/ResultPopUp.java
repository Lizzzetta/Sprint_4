package ru.katkova.sprint4.pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class ResultPopUp
{
    private final WebDriver driver;

    private final By header = By.xpath(".//div[starts-with(text(), 'Заказ оформлен')]");

    public ResultPopUp(WebDriver driver)
    {
        this.driver = driver;
    }

    public void checkForResultPopUp()
    {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(header));
    }
}
