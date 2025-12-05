package com.example.ficha_5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPage {
    private WebDriver driver;

    @FindBy(css = "#file-upload")
    private WebElement fileInput;

    @FindBy(xpath = "//*[@id='file-submit']")
    private WebElement uploadButton;

    @FindBy(xpath = "//h3[text()='File Uploaded!']")
    private WebElement successHeader;

    @FindBy(css = "div[id='uploaded-files']")
    private WebElement uploadedFilesPanel;

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void uploadFile(String absoluteFilePath) {
        fileInput.sendKeys(absoluteFilePath);
    }

    public void clickUpload() {
        uploadButton.click();
    }

    public String getSuccessHeaderText() {
        return successHeader.getText();
    }

    public String getUploadedFileName() {
        return uploadedFilesPanel.getText().trim();
    }
}
