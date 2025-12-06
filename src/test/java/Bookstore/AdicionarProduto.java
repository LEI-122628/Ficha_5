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
    private final SelenideElement saveButton = $(By.xpath("//vaadin-button[contains(., 'Save')]"));

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
    private void clearAndType(SelenideElement element, String value) {
        element.shouldBe(Condition.visible).click();
        actions().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE).perform();
        actions().sendKeys(value).perform();
    }

    public void setProductName(String name) {
        productNameField.shouldBe(Condition.visible).click();
        actions().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE).perform();
        actions().sendKeys(name).perform();
    }

    public void setPrice(String price) {
        clearAndType(priceField, price);
    }

    public void setStock(String quantity) {
        clearAndType(stockField, quantity);
    }

    public void setAvailability(String option) {
        availabilityDropdown.shouldBe(Condition.visible).click();
        $(By.xpath("//vaadin-item[contains(text(), '" + option + "')]"))
                .shouldBe(Condition.visible)
                .click();
    }

    public void selectCategory(String categoryName) {
        SelenideElement checkbox = $(By.xpath("//vaadin-checkbox[normalize-space(text())='" + categoryName + "']"));
        checkbox.scrollIntoView(true).shouldBe(Condition.visible).click();
    }

    public void clickSave() {
        saveButton.shouldBe(Condition.visible, Condition.enabled).click();
    }
}