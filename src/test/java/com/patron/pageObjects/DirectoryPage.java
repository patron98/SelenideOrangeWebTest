package com.patron.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DirectoryPage {
    private final SideBar sideBar = new SideBar();


    private final SelenideElement nameInput = $(byXpath("//input[@placeholder='Type for hints...']"));
    private final SelenideElement searchButton = $(byXpath("//button[@type='submit']"));

    public void searchDirectoryUser(String firstname){
        sideBar.returnSearchElement("Directory").click();
        nameInput.sendKeys(firstname);
        $(byXpath(returnXpath(firstname))).click();
        searchButton.click();
    }

    public void checkUserExistDirectory(String firstname, String lastname) {
        String xpathExpression = "//p[contains(@class, 'oxd-text oxd-text--p orangehrm-directory-card-header --break-words')]";
        $(byXpath(xpathExpression)).shouldBe(visible);
    }


    private String returnXpath(String username){
        return String.format("//span[contains(., '%s')]", username);
    }


}
