package com.testeryou.bdd.client;

import io.restassured.RestAssured;
import io.restassured.response.ResponseOptions;

import java.util.Map;

public class RestRequestHandler {

    public static ResponseOptions responseOptions;

    public void post (String requestUrl, Map<String, String> params) {
        RestAssured.baseURI = requestUrl;
        responseOptions = RestAssured
                .given()
                .log().all(true)
                .queryParams(params)
                .noContentType()
                .post();
    }
    public void post (String requestUrl) {
        RestAssured.baseURI = requestUrl;
        responseOptions = RestAssured
                .given()
                .log().all(true)
                .noContentType()
                .post();
    }
    public void get (String requestUrl, Map<String, String> params) {
        RestAssured.baseURI = requestUrl;
        responseOptions = RestAssured
                .given()
                .log().all(true)
                .queryParams(params)
                .get();
    }
    public void get (String requestUrl) {
        RestAssured.baseURI = requestUrl;
        responseOptions = RestAssured
                .given()
                .log().all(true)
                .get();
    }
    public void put (String requestUrl, Map<String, String> params) {
        RestAssured.baseURI = requestUrl;
        responseOptions = RestAssured
                .given()
                .log().all(true)
                .queryParams(params)
                .put();
    }
    public void put (String requestUrl) {
        RestAssured.baseURI = requestUrl;
        responseOptions = RestAssured
                .given()
                .log().all(true)
                .put();
    }
    public void delete (String requestUrl, Map<String, String> params) {
        RestAssured.baseURI = requestUrl;
        responseOptions = RestAssured
                .given()
                .log().all(true)
                .queryParams(params)
                .delete();
    }
    public void delete (String requestUrl) {
        RestAssured.baseURI = requestUrl;
        responseOptions = RestAssured
                .given()
                .log().all(true)
                .delete();
    }
}
