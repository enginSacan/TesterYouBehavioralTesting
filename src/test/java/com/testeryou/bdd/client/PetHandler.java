package com.testeryou.bdd.client;


import com.testeryou.bdd.model.*;
import io.cucumber.datatable.DataTable;


import java.util.Map;

import static com.testeryou.bdd.client.UserHandler.BASE_URL;

public class PetHandler {

    private static Pet.PetBuilder petBuilder = Pet.builder();
    public static void createPet (DataTable table) {
        table.asMaps().forEach(PetHandler::petBodyBuilder);
        new RestRequestHandler().post(BASE_URL+"pet",petBuilder.build().toJson());
    }
    public static void updatePet (DataTable table) {
        table.asMaps().forEach(PetHandler::petBodyBuilder);
        new RestRequestHandler().put(BASE_URL+"pet",petBuilder.build().toJson());
    }
    public static void getPet(String petId) {
        new RestRequestHandler().get(BASE_URL+"pet/"+petId);
    }
    public static Pet getPetResponse () {
        String jsonString = RestRequestHandler.responseOptions.body().prettyPrint();
        return JsonParser.parseJson(jsonString, Pet.class);
    }
    public static void removePet(String petId) {
        new RestRequestHandler().deleteWithToken(BASE_URL+"pet/"+petId);
    }
    private static void petBodyBuilder(Map<String, String> data) {
        data.forEach(PetHandler::setParameter);
    }

    private static void setParameter(String key, String value) {
        switch (key) {
            case "id" :
                petBuilder.id(Integer.parseInt(value));
                break;
            case "name" :
                petBuilder.name(value);
                break;
            case "type" :
                PetCategory category = PetCategory.builder()
                        .id(100)
                        .name(value).build();
                petBuilder.category(category);
                break;
            case "status" :
            case "updatedStatus" :
                petBuilder.status(value);
                break;
        }
    }
}
