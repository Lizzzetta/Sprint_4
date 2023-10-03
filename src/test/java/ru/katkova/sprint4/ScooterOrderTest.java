package ru.katkova.sprint4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import ru.katkova.sprint4.pageobject.*;

@RunWith(Parameterized.class)
public class ScooterOrderTest
{
    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phone;
    private final String date;
    private final String duration;
    private WebDriver driver;

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

    @Before
    public void init()
    {
        WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();
    }

    @Test
    public void requestScooter()
    {
        ChromeOptions options = new ChromeOptions(); // Драйвер для браузера Chrome
        options.addArguments("--no-sandbox", /*"--headless",*/ "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);

//        driver = new FirefoxDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPage = new MainPage(driver);
        FirstFormPage firstFormPage = new FirstFormPage(driver);
        SecondFormPage secondFormPage = new SecondFormPage(driver);
        ConfirmPopUp confirmPopUp = new ConfirmPopUp(driver);
        ResultPopUp resultPopUp = new ResultPopUp(driver);

        mainPage.clickOnRequestButton();
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

    @After
    public void close()
    {
        driver.quit();
    }
}
