package Bookstore;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class AdicionarCategoria {

    private final SelenideElement addCategoryButton = $(byText("Add New Category"));

    private final SelenideElement linkAdmin = $("html > body > vaadin-app-layout > a:nth-of-type(3)");


    public void setLinkAdmin(){
        linkAdmin.shouldBe(Condition.visible).click();
    }

    public void createCategory(String name) {
        addCategoryButton.shouldBe(Condition.clickable).click();

        sleep(1000);

        actions()
                .sendKeys(name)
                .sendKeys(Keys.ENTER)
                .perform();
    }
}