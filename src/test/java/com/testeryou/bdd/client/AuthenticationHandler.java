package com.testeryou.bdd.client;

import com.testeryou.bdd.generic.RestProperties;
import com.testeryou.bdd.model.JsonParser;
import com.testeryou.bdd.model.LoginResponse;

import java.util.HashMap;
import java.util.Map;

import static com.testeryou.bdd.client.UserHandler.BASE_URL;
import static com.testeryou.bdd.generic.PropertyNames.*;

public class AuthenticationHandler {


    public static final String REST_USER = RestProperties.getProperties().getProperty(REST_USERNAME);
    public static final String REST_PASS = RestProperties.getProperties().getProperty(REST_PASSWORD);
    public static void sendAuthentication (String userName, String password) {
        Map<String,String> authParams = new HashMap<>();
        authParams.put("password",password);
        authParams.put("username",userName);
        new RestRequestHandler().get(BASE_URL+"user/login",authParams);
    }
    public static void sendAuthentication () {
        sendAuthentication(REST_USER,REST_PASS);
        TOKEN = getRegistrationResponse().getMessage().split(":")[1];
    }
    public static LoginResponse getRegistrationResponse() {
        String jsonString = RestRequestHandler.responseOptions.body().prettyPrint();
        return JsonParser.parseJson(jsonString, LoginResponse.class);
    }
}
