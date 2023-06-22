package com.patron.pageObjects;

import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SideBar {
    WebElement searchBar = $(byXpath("//input[@placeholder='Search']"));

    public WebElement returnSearchElement(String searchElement){
        searchBar.clear();
        searchBar.sendKeys(searchElement);
        return $(byXpath(String.format("//span[contains(., '%s')]", searchElement)));
    }

}
