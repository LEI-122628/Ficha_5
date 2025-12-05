package com.example.ficha_5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage {
    private WebDriver driver;

    @FindBy(css = "#start button")
    private WebElement startButton;

    @FindBy(css = "#finish h4")
    private WebElement finishText;

    @FindBy(id = "loading")
    private WebElement loadingIndicator;

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickStart() {
        startButton.click();
    }

    public String getFinishText() {
        return finishText.getText();
    }

    public WebElement getFinishTextElement() {
        return finishText;
    }
}