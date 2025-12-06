package Bookstore;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AdicionarProduto {

    // --- LOCALIZADORES (Corrigidos para usar Labels) ---

    // Botão "New product"
    private final SelenideElement newProductButton = $(By.xpath("//vaadin-button[text()='New product']"));

    // Botão Save (procura pelo texto)
    private final SelenideElement saveButton = $(By.xpath("//vaadin-button[text()='Save']"));

    // CORREÇÃO: Seletores Específicos por Label (Nome do campo)
    // Assim não há confusão entre Preço, Nome e Stock.
    private final SelenideElement productNameField = $("html > body > vaadin-app-layout > vaadin-horizontal-layout:nth-of-type(2) > div > vaadin-vertical-layout > vaadin-text-field");
    private final SelenideElement priceField = $("html > body > vaadin-app-layout > vaadin-horizontal-layout:nth-of-type(2) > div > vaadin-vertical-layout > vaadin-horizontal-layout > vaadin-text-field:nth-of-type(1)");
    // Nota: Confirma no site se o label é "In stock" ou "Stock". Geralmente é "In stock".
    private final SelenideElement stockField = $("html > body > vaadin-app-layout > vaadin-horizontal-layout:nth-of-type(2) > div > vaadin-vertical-layout > vaadin-horizontal-layout > vaadin-text-field:nth-of-type(2)");

    // Dropdown de Availability (Geralmente é um vaadin-select, não text-field)
    private final SelenideElement availabilityDropdown = $("vaadin-select[aria-required='true']");


    // --- MÉTODOS ---

    public SelenideElement getNewProductButton() {
        return newProductButton;
    }

    public void clickNewProduct() {
        newProductButton.shouldBe(Condition.visible).click();
    }

    public SelenideElement getTitleField() {
        return productNameField;
    }

    // --- MÉTODOS DE PREENCHIMENTO (Usando Actions para não falhar) ---

    public void setProductName(String name) {
        productNameField.shouldBe(Condition.visible).click();
        // Truque do Vaadin: Clicar e Teclar
        actions().sendKeys(name).perform();
    }

    public void setPrice(String price) {
        priceField.shouldBe(Condition.visible).click();
        actions().sendKeys(Keys.DELETE).perform();
        actions().sendKeys(Keys.DELETE).perform();
        actions().sendKeys(Keys.DELETE).perform();
        actions().sendKeys(Keys.DELETE).perform();
        actions().sendKeys(Keys.DELETE).perform();
        actions().sendKeys(price).perform();
    }

    public void setStock(String quantity) {
        stockField.shouldBe(Condition.visible).click();
        actions().sendKeys(Keys.DELETE).perform();
        actions().sendKeys(Keys.DELETE).perform();
        actions().sendKeys(Keys.DELETE).perform();
        actions().sendKeys(Keys.DELETE).perform();
        actions().sendKeys(Keys.DELETE).perform();
        actions().sendKeys(quantity).perform();
    }

    public void setAvailability(String option) {
        // Dropdowns Vaadin são complexos:
        // 1. Clicar no dropdown para abrir
        availabilityDropdown.shouldBe(Condition.visible).click();

        // 2. Esperar que as opções apareçam (vaadin-item) e clicar na correta
        // O elemento <vaadin-item> costuma estar num overlay separado
        $(By.xpath("//vaadin-item[contains(text(), '" + option + "')]"))
                .shouldBe(Condition.visible)
                .click();
    }

    public void selectCategory(String categoryName) {
        // Scroll para garantir que a checkbox está visível
        SelenideElement checkbox = $(By.xpath("//vaadin-checkbox[normalize-space(text())='" + categoryName + "']"));
        checkbox.scrollIntoView(true).click();
    }

    public void clickSave() {
        saveButton.click();
    }
}