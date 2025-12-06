package Sampler;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class InteractionPage {

    // Usamos o link direto para a secção de notificações para facilitar
    private static final String URL = "https://demo.vaadin.com/sampler/";

    private final SelenideElement showButton = $("html > body > div:nth-of-type(1) > div > div:nth-of-type(2) > div > div:nth-of-type(2) > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(3) > div:nth-of-type(1) > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2)");

    private final SelenideElement Button = $(byText("Button"));

    public void openPage() {
        open(URL);
    }

    public void showMenu() {
        // Espera que o botão carregue e clica
        showButton.shouldBe(Condition.visible).click();
    }

    public void clickButton() {
        Button.shouldBe(Condition.visible).click();
    }

    public void verifyButtonAppears() {

        SelenideElement ButtonClick = $("html > body > div:nth-of-type(1) > div > div:nth-of-type(2) > div > div:nth-of-type(2) > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(3) > div:nth-of-type(1) > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2)");

        ButtonClick.shouldBe(Condition.visible).click();
    }
}