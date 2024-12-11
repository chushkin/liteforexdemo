package com.example.liteforexdemo;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {


    protected AppiumDriver driver;

    @BeforeEach
    public void setUp() throws Exception {
        // Настройки UiAutomator2Options
        UiAutomator2Options options = new UiAutomator2Options();
        options.setUdid("emulator-5554");
        options.setApp(System.getProperty("user.dir") + "/app-debug.apk");
        options.setAppPackage("com.liteforex.forexcurrencies"); // Укажите пакет приложения
        options.setAppActivity("com.liteforex.forexcurrencies.Activity.IntroActivity"); // Укажите стартовую активность
        options.setAppWaitActivity("com.liteforex.forexcurrencies.Activity.MainActivity,com.liteforex.forexcurrencies.Activity.*"); // Укажите ожидаемые активности
        options.setAutomationName("UIAutomator2"); // Установите AutomationName

        // Инициализация драйвера Android
        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"), // URL Appium сервера
                options
        );

        // Установка времени ожидания для поиска элементов
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }



    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
