package com.patron.pageObjects;

import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    WebElement usernameInput = $(byName("username"));
    WebElement passwordInput = $(byName("password"));
    WebElement loginButton = $(byClassName("oxd-button"));

    public void login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
