package com.testeryou.bdd.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse implements SerializableJson{
    String code;
    String type;
    String message;
}
