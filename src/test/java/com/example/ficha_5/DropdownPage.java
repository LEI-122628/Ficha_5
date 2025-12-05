package com.example.ficha_5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {
    private WebDriver driver;

    // Localizador para a lista Dropdown (o elemento <select> tem o ID "dropdown")
    @FindBy(id = "dropdown")
    private WebElement dropdownList;

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Método de alto nível para selecionar uma opção pelo texto visível
    public void selectOptionByText(String optionText) {
        Select select = new Select(dropdownList);
        select.selectByVisibleText(optionText);
    }

    // Método para obter a opção selecionada atualmente
    public String getSelectedOption() {
        Select select = new Select(dropdownList);
        return select.getFirstSelectedOption().getText();
    }
}
