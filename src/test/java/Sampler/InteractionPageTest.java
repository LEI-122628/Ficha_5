package Sampler;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class InteractionPageTest {

    InteractionPage page = new InteractionPage();

    @BeforeAll
    public static void setUp() {
        // Configuração do Allure
        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));

        Configuration.browser = "chrome";
        Configuration.browserSize = "maximized";
        Configuration.timeout = 10000;
    }

    @Test
    @Description("Test Suite 5: Verificar Notificação (Interaction) no Vaadin Sampler")
    public void testNotificationInteraction() {
        // 1. Abrir a página das notificações diretamente
        page.openPage();

        page.clickButton();

        // 2. Clicar no botão para disparar a interação
        page.showMenu();

        // 3. Validar se a notificação apareceu
        page.verifyButtonAppears();
    }
}