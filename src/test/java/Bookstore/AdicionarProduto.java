package Bookstore;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AdicionarProduto {

    // --- LOCALIZADORES ---

    // Botão da página principal (New product)
    private final SelenideElement newProductButton = $(By.xpath("//vaadin-button[text()='New product']"));
    private final SelenideElement saveButton = $(By.xpath("//vaadin-button[text()='Save']"));
    // Campo de input do formulário (Product name *)
    private final SelenideElement productNameField = $(By.xpath("//*[@id=\"vaadin-text-field-input-3\"]/slot[2]/input"));

    private final SelenideElement priceField =
            $(By.xpath("//*[@id=\"vaadin-text-field-input-4\"]/slot[2]/input"));

    private final SelenideElement stockField =
            $(By.xpath("//*[@id=\"vaadin-text-field-input-5\"]/slot[2]/input"));

    private final SelenideElement availabilityDropdown =
            $(By.xpath("/html/body/vaadin-app-layout/vaadin-horizontal-layout[2]/div/vaadin-vertical-layout/vaadin-select//vaadin-select-text-field/div[1]"));

    // NOVO: Checkbox de Categoria (Função para encontrar qualquer categoria)
    // O Vaadin usa o label/texto para identificar a checkbox.
    private SelenideElement categoryCheckbox(String categoryName) {
        return $(By.xpath("//vaadin-checkbox[normalize-space(text())='" + categoryName + "']"));
    }

    // --- MÉTODOS PARA O TESTE ---

    // Asserção:
    public SelenideElement getNewProductButton() {
        return newProductButton;
    }

    // Clique:
    public void clickNewProduct() {
        newProductButton.click();
    }

    // Asserção do Formulário
    public SelenideElement getTitleField() {
        // Retornamos o campo 'Product name' para verificar se o formulário abriu.
        return productNameField;
    }

    // Preencher o Product name:
    public void setProductName(String name) {
        productNameField.shouldBe(Condition.visible);
        productNameField.setValue(name);
    }

    public void setPrice(String price) {
        priceField.shouldBe(Condition.visible);
        priceField.setValue(price);
    }

    // Definir Stock
    public void setStock(String quantity) {
        stockField.shouldBe(Condition.visible);
        stockField.setValue(quantity);
    }

    public void setAvailability(String option) {
        // 1. Clicar para abrir o dropdown
        availabilityDropdown.click();
    }

    //  Selecionar Categoria
    public void selectCategory(String categoryName) {
        // Clica na checkbox que contém o texto da categoria
        categoryCheckbox(categoryName).click();
    }

    // Clicar Save
    public void clickSave() {
        saveButton.click();
    }



}