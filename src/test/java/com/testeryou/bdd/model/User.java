package com.testeryou.bdd.model;

@lombok.Data
@lombok.Builder
public class User implements SerializableJson{

    int id;
    String username;
    String firstName;
    String lastName;
    String email;
    String password;
    String phone;
    int userStatus;

}
