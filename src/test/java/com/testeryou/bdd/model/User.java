package com.testeryou.bdd.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User implements SerializableJson{

    @Builder.Default
    int id= 1000000000;
    @Builder.Default
    String username= "mese";
    @Builder.Default
    String firstName="mehmet";
    @Builder.Default
    String lastName="sacan";
    @Builder.Default
    String email="mes@mes.com";
    @Builder.Default
    String password="mesePass";
    @Builder.Default
    String phone="0123456789";
    @Builder.Default
    int userStatus= 1000;

}
