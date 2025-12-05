package Bookstore;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

public class AdicionarProdutoTest {

    // Credenciais de teste
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    // CORREÇÃO: Variável que faltava (PRODUCT_NAME)
    private static final String PRODUCT_NAME = "Automacao Selenium Teste";

    private static final String PRODUCT_PRICE = "35.50";

    private static final String PRODUCT_STOCK = "150";

    private static final String PRODUCT_AVAILABILITY = "Available";

    private static final String PRODUCT_CATEGORY = "Ficção";

    // Page Objects
    private final LoginPage loginPage = new LoginPage();
    private final AdicionarProduto addProductPage = new AdicionarProduto();

    @Test
    public void testAll() { // Nome do método atualizado
        // 1. Abrir e Logar
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);

        // Asserção 1: Login OK
        addProductPage.getNewProductButton().shouldBe(Condition.visible);

        // 2. Clicar e abrir formulário
        addProductPage.clickNewProduct();

        // Asserção 2: Formulário de adição visível
        addProductPage.getTitleField().shouldBe(Condition.visible);

        // 3. Ação 1: Preencher o Product name
        addProductPage.setProductName(PRODUCT_NAME);

        // 4. Ação 2: Definir o preço
        addProductPage.setPrice(PRODUCT_PRICE);

        addProductPage.setStock(PRODUCT_STOCK);

        // 6. Ação 4: Definir Availability
        addProductPage.setAvailability(PRODUCT_AVAILABILITY);

        // 7. Ação 5: Selecionar Categoria
        addProductPage.selectCategory(PRODUCT_CATEGORY);

        // 8. Ação 6: CLICAR SAVE
        addProductPage.clickSave();

        System.out.println("✅ Product name e Price preenchidos com sucesso.");
    }
}