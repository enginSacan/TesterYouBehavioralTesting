package com.testeryou.bdd.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Pet implements SerializableJson{
    int id;
    PetCategory category;
    String name;
    List<String> photoUrls;
    List<PetTags> tags;
    String status;
}
