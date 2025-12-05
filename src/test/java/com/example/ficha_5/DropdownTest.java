package com.example.ficha_5;

import com.example.ficha_5.DropdownPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

public class DropdownTest {
    private WebDriver driver;
    private DropdownPage dropdownPage;
    private final String BASE_URL = "https://the-internet.herokuapp.com/dropdown";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Usar Implicit Wait para garantir que a página carrega os elementos
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(BASE_URL);
        dropdownPage = new DropdownPage(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void selectOptionsTest() {
        // 1. Selecionar a Opção 1 e verificar
        dropdownPage.selectOptionByText("Option 1");
        assertEquals("Option 1", dropdownPage.getSelectedOption(),
                "A Opção 1 deveria estar selecionada após a interação.");

        // 2. Selecionar a Opção 2 e verificar
        dropdownPage.selectOptionByText("Option 2");
        assertEquals("Option 2", dropdownPage.getSelectedOption(),
                "A Opção 2 deveria estar selecionada após a interação.");
    }
}
