package com.example.ficha_5;

import com.example.ficha_5.CheckboxesPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

public class CheckboxesTest {
    private WebDriver driver;
    private CheckboxesPage checkboxesPage;
    private final String BASE_URL = "https://the-internet.herokuapp.com/checkboxes";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(BASE_URL);
        checkboxesPage = new CheckboxesPage(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void toggleCheckboxesTest() {
        // 1. Assegura que o Checkbox 1 fica ATIVADO (clica se estiver desativado)
        if (!checkboxesPage.isCheckbox1Selected()) {
            checkboxesPage.clickCheckbox1();
        }
        assertTrue(checkboxesPage.isCheckbox1Selected(), "Checkbox 1 deve estar ATIVADO no final do teste.");

        // 2. Assegura que o Checkbox 2 fica DESATIVADO (clica se estiver ativado)
        if (checkboxesPage.isCheckbox2Selected()) {
            checkboxesPage.clickCheckbox2();
        }
        assertFalse(checkboxesPage.isCheckbox2Selected(), "Checkbox 2 deve estar DESATIVADO no final do teste.");
    }
}
