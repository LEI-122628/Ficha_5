package com.example.ficha_5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxesPage {
    // Checkbox 1 (o primeiro input dentro do div #checkboxes)
    @FindBy(css = "#checkboxes input:nth-child(1)")
    private WebElement checkbox1;

    // Checkbox 2 (o segundo input dentro do div #checkboxes)
    @FindBy(css = "#checkboxes input:nth-child(3)")
    private WebElement checkbox2;

    public CheckboxesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Método para alternar o estado do Checkbox 1
    public void clickCheckbox1() {
        checkbox1.click();
    }

    // Método para alternar o estado do Checkbox 2
    public void clickCheckbox2() {
        checkbox2.click();
    }

    // Método para verificar o estado de seleção do Checkbox 1
    public boolean isCheckbox1Selected() {
        return checkbox1.isSelected();
    }

    // Método para verificar o estado de seleção do Checkbox 2
    public boolean isCheckbox2Selected() {
        return checkbox2.isSelected();
    }
}
