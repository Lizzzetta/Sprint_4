package ru.katkova.sprint4;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.katkova.sprint4.pageobject.*;

@RunWith(Parameterized.class)
public class ScooterOrderTest extends TestBase
{
    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phone;
    private final String date;
    private final String duration;

    public ScooterOrderTest(String name, String surname, String address, String metroStation, String phone, String date, String duration)
    {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.date = date;
        this.duration = duration;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData()
    {
        return new Object[][] {
                {"Вася", "Телегин", "Москва", "Черкизовская", "12345678900", "11.11.2023", "сутки"},
                {"Ася", "Лютикова", "Раменское", "Лубянка", "32165498777", "03.09.2023", "трое суток"}
        };
    }

    @Test
    public void requestScooter()
    {
        initDriver();

        MainPage mainPage = new MainPage(driver);
        FirstFormPage firstFormPage = new FirstFormPage(driver);
        SecondFormPage secondFormPage = new SecondFormPage(driver);
        ConfirmPopUp confirmPopUp = new ConfirmPopUp(driver);
        ResultPopUp resultPopUp = new ResultPopUp(driver);

        mainPage.clickOnRequestButtonInHeader();
        firstFormPage.setName(name);
        firstFormPage.setSurname(surname);
        firstFormPage.setAddress(address);
        firstFormPage.setStationOfMetro(metroStation);
        firstFormPage.setPhone(phone);
        firstFormPage.clickOnNextButton();
        secondFormPage.setDeliveryDate(date);
        secondFormPage.setDuration(duration);
        secondFormPage.clickOnOrderButton();
        confirmPopUp.clickOnYesButton();

        resultPopUp.checkForResultPopUp();
    }

    @Test
    public void requestScooterByButtonInBody()
    {
        initDriver();

        MainPage mainPage = new MainPage(driver);
        FirstFormPage firstFormPage = new FirstFormPage(driver);

        mainPage.clickOnRequestButtonInBody();
        firstFormPage.checkFormTitle();
    }
}
