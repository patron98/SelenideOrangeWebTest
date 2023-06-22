package com.patron.pageObjects;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class PimPage {

    private final SideBar sideBar = new SideBar();
    private final SelenideElement addEmployeeLink = $(byXpath("//a[contains(., 'Add Employee')]"));
    private final SelenideElement firstNameInput = $(byName("firstName"));
    private final SelenideElement lastNameInput = $(byName("lastName"));
    private final SelenideElement saveButton = $(byXpath("//button[@type='submit']"));
    private final SelenideElement searchPimUser = $(byXpath("//input[@placeholder='Type for hints...']"));
    private final SelenideElement searchButton = $(byXpath("//button[@type='submit']"));
    private final SelenideElement deleteButton = $(byXpath("//i[@class='oxd-icon bi-trash']"));
    private final SelenideElement confirmDelete = $(byXpath("//i[@class='oxd-icon bi-trash oxd-button-icon']"));

    public void addPimUser(String firstname, String lastname) {
        sideBar.returnSearchElement("PIM").click();
        addEmployeeLink.click();
        firstNameInput.sendKeys(firstname);
        lastNameInput.sendKeys(lastname);
        saveButton.click();
    }

    public void removePimUser(String firstname, String lastname) {
        sideBar.returnSearchElement("PIM").click();
        searchPimUser.sendKeys(firstname, " ", lastname);
        searchButton.click();
        deleteButton.should(visible, Duration.ofSeconds(5));
        while (deleteButton.isDisplayed()) {
            deleteButton.click();
            confirmDelete.click();
            sleep(4000);
        }
        deleteButton.shouldBe(hidden, Duration.ofSeconds(2));
    }
}
