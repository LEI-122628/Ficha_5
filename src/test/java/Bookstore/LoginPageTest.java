package Bookstore;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide; // Importante para o closeWebDriver
import org.junit.jupiter.api.AfterEach; // Importante para correr após cada teste
import org.junit.jupiter.api.Test;

public class LoginPageTest {

    // Credenciais
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";
    private static final String WRONG_PASSWORD = "senhaerrada123";

    // Page Objects
    private final LoginPage loginPage = new LoginPage();
    private final AdicionarProduto mainPage = new AdicionarProduto();

    // --- CORREÇÃO: Limpar o estado após cada teste ---
    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    public void testLoginSuccess() {
        // 1. Abrir a página de Login
        loginPage.openPage();

        // 2. Tentar login com credenciais corretas
        loginPage.login(USERNAME, PASSWORD);

        // 3. Validar sucesso: O botão "New product" deve estar visível
        mainPage.getNewProductButton().shouldBe(Condition.visible);
    }

    @Test
    public void testLoginFailure() {
        loginPage.openPage();

        // 2. Tentar login com senha errada
        loginPage.login(USERNAME, WRONG_PASSWORD);

        // 3. Validar insucesso:
        mainPage.getNewProductButton().shouldNotBe(Condition.visible);
    }
}