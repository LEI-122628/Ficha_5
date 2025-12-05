package Bookstore;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// page_url = https://vaadin-bookstore-example.demo.vaadin.com/
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