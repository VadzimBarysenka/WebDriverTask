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
    public static WebDriver driver = null;
    public static LoginPage loginPage;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vadim\\Downloads\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void login() {
        driver.get("https://mail.yandex.com/");
        WebElement enterPage = driver.findElement(By.linkText("Log in"));
        enterPage.click();
        WebElement lofinField = driver.findElement(By.id("passp-field-login"));
        lofinField.sendKeys("someuserfortest");
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
        String actualTitle = "Inbox — Yandex.Mail";
        String expectedTitle = driver.getTitle();


        //Assert.assertEquals(expectedTitle, actualTitle);

        assertAll(
                () -> assertEquals(expectedTitle, actualTitle),
                () -> assertEquals(inbox.getText(), "Inbox"));

    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}
