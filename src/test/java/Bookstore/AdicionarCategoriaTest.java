package Bookstore;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AdicionarCategoriaTest {
    LoginPage loginPage = new LoginPage();
    AdicionarCategoria categoriesPage = new AdicionarCategoria();

    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));

        Configuration.browser = "chrome";
        Configuration.browserSize = "maximized";
        Configuration.timeout = 10000;
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    @Description("Testa a criação de uma categoria na Bookstore Vaadin")
    public void testAddCategory() {
        String categoryName = "Teste";
        String user = "admin";
        String password = "admin";
        loginPage.openPage();
        loginPage.login(user, password);

        categoriesPage.setLinkAdmin();
        categoriesPage.createCategory(categoryName);
    }
}