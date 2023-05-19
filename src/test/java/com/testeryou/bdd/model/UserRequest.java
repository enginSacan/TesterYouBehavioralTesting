package com.testeryou.bdd.model;

@lombok.Data
@lombok.Builder
public class UserRequest implements SerializableJson{
    private User user;
}
