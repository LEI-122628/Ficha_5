package com.example.ficha_5;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

public class FileUploadPageTest {
    private WebDriver driver;
    private FileUploadPage upload;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://the-internet.herokuapp.com/upload");
        upload = new FileUploadPage(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testFileUpload() throws IOException {
        File tempFile = File.createTempFile("teste-selenium-lab5", ".txt");
        tempFile.deleteOnExit();

        String absolutePath = tempFile.getAbsolutePath();
        String fileName = tempFile.getName();

        upload.uploadFile(absolutePath);
        upload.clickUpload();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> upload.getSuccessHeaderText().contains("File Uploaded!"));

        assertEquals("File Uploaded!", upload.getSuccessHeaderText());

        assertEquals(fileName, upload.getUploadedFileName());
    }
}
