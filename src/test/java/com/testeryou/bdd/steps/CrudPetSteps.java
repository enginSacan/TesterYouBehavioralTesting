package com.testeryou.bdd.steps;

import com.testeryou.bdd.client.AuthenticationHandler;
import com.testeryou.bdd.client.PetHandler;
import com.testeryou.bdd.client.UserHandler;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.internal.http.HttpResponseException;
import org.junit.jupiter.api.function.Executable;


import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class CrudPetSteps {

    private String userName = "qwertyu";
    private String password = "tete";

    @Given("I have an authentication for application")
    public void authenticateUser() {
        UserHandler.createUser(userName,"lastName","me@me.com",password);
        AuthenticationHandler.sendAuthentication();
    }
    @When("User added a pet with the following details:")
    public void creatingRequestForPet(DataTable table) {
        PetHandler.createPet(table);
    }
    @Then("Store should return response with the following details:")
    public void validateResponse(DataTable table) {

        List<Executable> assertions = new ArrayList<>();
        //We are taking all the fields from data table and try to verify with the response from api service
        table.asMaps().forEach( verificationField -> {
            String id = Objects.requireNonNull(verificationField.get("id"));
            PetHandler.getPet(id);
            String name = Objects.requireNonNull(verificationField.get("name"));
            String type = Objects.requireNonNull(verificationField.get("type"));
            String status = verificationField.get("status");
            String updatedStatus = verificationField.get("updated status");
            if (updatedStatus!= null) {
                assertions.add( () -> assertEquals(updatedStatus,PetHandler.getPetResponse().getStatus()));
            }
            if (status != null) {
                assertions.add( () -> assertEquals(status,PetHandler.getPetResponse().getStatus()));
            }
            assertions.add( () -> assertEquals(Integer.parseInt(id),PetHandler.getPetResponse().getId()));
            assertions.add( () -> assertEquals(name,PetHandler.getPetResponse().getName()));
            assertions.add( () -> assertEquals(type,PetHandler.getPetResponse().getCategory().getName()));
        });
       assertAll("There were mismatch in the fields",assertions);
    }
    @Given("User has the added pet information with following details:")
    public void creatingRequestWithAddedPet(DataTable table) {
        PetHandler.createPet(table);
    }
    @When("User removes the pet from the store")
    public void userRemovesThePetFromTheStore() {
        PetHandler.removePet(String.valueOf(PetHandler.getPetResponse().getId()));
    }
    @Then("Store should delete pet with the following details:")
    public void storeShouldDeletePetWithTheFollowingDetails(DataTable table) {
        List<Executable> assertions = new ArrayList<>();

        table.asMaps().forEach( verificationField -> {
            String id = verificationField.get("id");
           assertions.add(() -> assertThrows(HttpResponseException.class,() -> PetHandler.getPet(id)));
        });

        assertAll("There should not be any pet", assertions);
    }
    @When("User updated a pet with the following details:")
    public void userUpdatedAPetWithTheFollowingDetails(DataTable table) {
        PetHandler.updatePet(table);
    }
}
