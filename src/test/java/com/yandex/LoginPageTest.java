package com.yandex;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LoginPageTest {
    WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void login() {
        driver.get("https://mail.yandex.com/");
        WebElement enterPage = driver.findElement(By.xpath("//a[contains(@class, \"HeadBanner-Button-Enter\")]"));
        enterPage.click();
        WebElement loginField = driver.findElement(By.id("passp-field-login"));
        loginField.sendKeys("someuserfortest");
        WebElement loginButton = driver.findElement(By.id("passp:sign-in"));
        loginButton.click();
        WebElement passField = driver.findElement(By.id("passp-field-passwd"));
        passField.click();
        passField.sendKeys("!QAZxsw2");
        WebElement signIn = driver.findElement(By.id("passp:sign-in"));
        signIn.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("search-bubble-list__bubble-wrap")));

        WebElement inbox = driver.findElement(By.xpath("//a[contains(@title, \"Inbox\")]"));
        String expectedTitle = "Inbox — Yandex.Mail";

        assertAll(
                () -> assertEquals(driver.getTitle(), expectedTitle),
                () -> assertEquals(inbox.getText(), "Inbox"));
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
