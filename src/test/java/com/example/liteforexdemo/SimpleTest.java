package com.example.liteforexdemo;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class SimpleTest extends BaseTest {

    @Test
    public void testAppiumLaunch() {
        assertNotNull(driver, "Appium driver was not initialized!");
    }

    @Test
    public void testCloseHelpScreen() {

        WebElement infoOverlay = driver.findElement(By.id("intro_image")); // Убедитесь, что ID правильный
        tapOnScreenByElement(infoOverlay);

        // Проверяем, что справка закрылась
        boolean isHelpClosed = driver.findElements(By.id("intro_image")).isEmpty();
        assertTrue(isHelpClosed, "Справка не закрылась");
    }

    @Test
    public void testOpenCalculator() {
        // Нажать на элемент валютной пары
        WebElement currencyPair = driver.findElement(By.id("id_валютной_пары")); // Замените "id_валютной_пары"
        currencyPair.click();

        // Проверить открытие калькулятора
        WebElement calculator = driver.findElement(By.id("id_калькулятора")); // Замените "id_калькулятора"
        assertTrue(calculator.isDisplayed(), "Калькулятор не открылся");
    }

    @Test
    public void testSideMenuTradeLink() {
        // Открыть боковое меню
        WebElement menuButton = driver.findElement(By.id("id_меню")); // Замените "id_меню"
        menuButton.click();

        // Нажать на ссылку "Торговать"
        WebElement tradeLink = driver.findElement(By.id("id_торговать")); // Замените "id_торговать"
        tradeLink.click();

        // Проверить, что открылась нужная страница
        WebElement tradePage = driver.findElement(By.id("id_страницы_торговли")); // Замените "id_страницы_торговли"
        assertTrue(tradePage.isDisplayed(), "Страница торговли не открылась");
    }

    @Test
    public void testChangeCurrencyList() {
        // Открыть настройки валют
        WebElement settingsButton = driver.findElement(By.id("id_настройки")); // Замените "id_настройки"
        settingsButton.click();

        // Выбрать новую валюту
        WebElement currencyOption = driver.findElement(By.xpath("//android.widget.TextView[@text='USD']")); // Пример выбора валюты
        currencyOption.click();

        // Сохранить изменения
        WebElement saveButton = driver.findElement(By.id("id_сохранить")); // Замените "id_сохранить"
        saveButton.click();

        // Проверить, что изменения отображаются на главном экране
        WebElement updatedCurrency = driver.findElement(By.xpath("//android.widget.TextView[@text='USD']"));
        assertTrue(updatedCurrency.isDisplayed(), "Изменения валют не отразились на главном экране");
    }

    public void tapOnScreenByElement(WebElement element) {
        // Получить координаты элемента
        int centerX = element.getRect().getX() + (element.getRect().getWidth() / 2);
        int centerY = element.getRect().getY() + (element.getRect().getHeight() / 2);

        // Выполнить тап по центру элемента
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap));
    }

}