package com.patron.stepDefinitions;

import com.patron.pageObjects.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;

import static com.codeborne.selenide.Selenide.*;

public class CommonSteps {
    private final LoginPage loginPage = new LoginPage();

    @Given("open browser and login with {string} and {string}")
    public void openBrowserAndLogin(String username, String password){

        open("https://opensource-demo.orangehrmlive.com/");
        loginPage.login(username, password);

    }

    @After
    public void tearDown(){
        closeWebDriver();
    }
}
