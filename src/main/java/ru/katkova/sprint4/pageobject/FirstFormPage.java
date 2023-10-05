package ru.katkova.sprint4.pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstFormPage
{
    private final WebDriver driver;

    // Поля ввода имени
    private final By inputForName = By.xpath(".//input[@placeholder = '* Имя']");

    // Поле ввода фамилии
    private final By inputForSurname = By.xpath(".//input[@placeholder = '* Фамилия']");

    // Поле ввода адреса
    private final By inputForAddress = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");

    // Поле ввода станции метро
    private final By inputForStationOfMetro = By.xpath(".//input[@placeholder = '* Станция метро']");

    // Поле ввода телефона
    private final By inputForPhone = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");

    // Заголовок формы
    private final By title = By.xpath(".//div[text() = 'Для кого самокат']");

    // Кнопка "далее"
    private final By nextButton = By.xpath(".//button[text() = 'Далее']");

    public FirstFormPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void setName(String value)
    {
        driver.findElement(inputForName).sendKeys(value);
    }

    public void setSurname(String value)
    {
        driver.findElement(inputForSurname).sendKeys(value);
    }

    public void setAddress(String value)
    {
        driver.findElement(inputForAddress).sendKeys(value);
    }

    public void setStationOfMetro(String value)
    {
        driver.findElement(inputForStationOfMetro).click();
        WebElement element = driver.findElement(By.xpath(".//li[@role = 'menuitem']/button/div[text() = '" + value + "']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void setPhone(String value)
    {
        driver.findElement(inputForPhone).sendKeys(value);
    }

    public void clickOnNextButton()
    {
        WebElement element = driver.findElement(nextButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void checkFormTitle()
    {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(title));
    }
}
