package ru.katkova.sprint4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class TestBase
{
    private final String URL = "https://qa-scooter.praktikum-services.ru/";
    protected WebDriver driver;

    @Before
    public void init()
    {
        WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();
    }

    @After
    public void close()
    {
        driver.quit();
    }

    protected void initDriver()
    {
        ChromeOptions options = new ChromeOptions(); // Драйвер для браузера Chrome
        options.addArguments("--no-sandbox", /*"--headless",*/ "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);

//        driver = new FirefoxDriver();

        driver.get(URL);
    }
}
