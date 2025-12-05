package Bookstore;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

// page_url = https://vaadin-bookstore-example.demo.vaadin.com/
public class LoginPage {
    private static final String URL = "https://vaadin-bookstore-example.demo.vaadin.com/";

    private final SelenideElement usernameField = $(By.xpath("//input[@name='username']"));
    private final SelenideElement passwordField = $(By.xpath("//input[@name='password']"));

    // @Step removido para não crashar com Java 25
    public void openPage() {
        open(URL);
    }

    // @Step removido para não crashar com Java 25
    public void login(String user, String pass) {
        usernameField.setValue(user);
        passwordField.setValue(pass).pressEnter();
    }
}