package com.example.ficha_5;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicLoadingPageTest {
    private WebDriver driver;
    private DynamicLoadingPage loadingPage;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        loadingPage = new DynamicLoadingPage(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testDynamicContentReveal() {
        loadingPage.clickStart();

        wait.until(ExpectedConditions.visibilityOf(loadingPage.getFinishTextElement()));

        String text = loadingPage.getFinishText();
        assertEquals("Hello World!", text, "O texto escondido devia ter aparecido.");
    }
}