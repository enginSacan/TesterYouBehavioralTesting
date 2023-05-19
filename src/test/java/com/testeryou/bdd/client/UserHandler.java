package com.testeryou.bdd.client;

import com.testeryou.bdd.generic.RestProperties;
import com.testeryou.bdd.model.JsonParser;
import com.testeryou.bdd.model.User;
import com.testeryou.bdd.model.UserRequest;


import static com.testeryou.bdd.generic.PropertyNames.REST_BASE_ENDPOINT;


public class UserHandler {
    public static final String BASE_URL = RestProperties.getProperties().getProperty(REST_BASE_ENDPOINT);
    public static void createUser (String userName, String lastName, String email, String password) {
        User user = User
                .builder()
                .username(userName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .build();
        UserRequest requestBody = UserRequest
                .builder()
                .user(user)
                .build();
        new RestRequestHandler().post(BASE_URL+"user",requestBody.toJson());
    }

    public static void getUser (String userName) {
        new RestRequestHandler().getWithToken(BASE_URL+"user/"+userName);
    }
    public static User getUserResponse () {
        String jsonString = RestRequestHandler.responseOptions.body().prettyPrint();
        return JsonParser.parseJson(jsonString, User.class);
    }

}
