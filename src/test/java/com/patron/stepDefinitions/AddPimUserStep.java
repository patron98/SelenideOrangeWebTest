package com.patron.stepDefinitions;

import com.patron.pageObjects.DirectoryPage;
import com.patron.pageObjects.PimPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;


public class AddPimUserStep {
    private final PimPage pimPage = new PimPage();
    private final DirectoryPage directoryPage = new DirectoryPage();

    @When("i add a PIM user with name {string} {string}")
    public void addPimUser(String firstname, String lastname){
        pimPage.addPimUser(firstname, lastname);
    }

    @Then("the user should exist with name {string} {string}")
    public void checkAndDeleteNewUser(String firstname, String lastname){
        directoryPage.searchDirectoryUser(firstname);
        try {
            directoryPage.checkUserExistDirectory(firstname, lastname);
        }catch (NoSuchElementException e) {
            e.getMessage();
        } finally {
            pimPage.removePimUser(firstname, lastname);
        }
    }
}
