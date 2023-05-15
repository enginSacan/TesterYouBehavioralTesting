package com.testeryou.bdd.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CrudSteps {

    @Given("I have an authentication for application")
    public void authenticateUser() {

    }

    @Given("User has a pet with the following details:")
    public void creatingRequestForPet(DataTable table) {
    }

    @When("User add the pet to the store")
    public void addingPet() {
    }

    @Then("Store should return response with the following details:")
    public void validateResponse(DataTable table) {
    }

    @Given("User has the added pet information with following details:")
    public void creatingRequestWithAddedPet(DataTable table) {
    }

    @When("User removes the pet from the store")
    public void userRemovesThePetFromTheStore() {
    }
}
