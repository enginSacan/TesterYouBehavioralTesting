package com.testeryou.bdd.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PetCategory implements SerializableJson{
    int id;
    String name;
}
