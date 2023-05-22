package com.testeryou.bdd.client;

import io.restassured.RestAssured;
import io.restassured.response.ResponseOptions;

import java.util.HashMap;
import java.util.Map;

import static com.testeryou.bdd.generic.PropertyNames.TOKEN;

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
    public void post (String requestUrl, String requestContent) {
        RestAssured.baseURI = requestUrl;
        responseOptions = RestAssured
                .given()
                .log().all(true)
                .headers(getDefaultHeader())
                .body(requestContent)
                .post();
    }
    public void postWithToken (String requestUrl, String requestContent) {
        RestAssured.baseURI = requestUrl;
        responseOptions = RestAssured
                .given()
                .log().all(true)
                .headers(getHeadersWithToken())
                .body(requestContent)
                .post();
    }
    public void postWithToken (String requestUrl, Map<String, String> params) {
        RestAssured.baseURI = requestUrl;
        responseOptions = RestAssured
                .given()
                .log().all(true)
                .headers(getHeadersWithToken())
                .queryParams(params)
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
                .header("Accept","application/json")
                .get();
    }
    public void getWithToken (String requestUrl) {
        RestAssured.baseURI = requestUrl;
        responseOptions = RestAssured
                .given()
                .log().all(true)
                .headers(getHeadersWithToken())
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
    public void put (String requestUrl, String requestContent) {
        RestAssured.baseURI = requestUrl;
        responseOptions = RestAssured
                .given()
                .log().all(true)
                .headers(getDefaultHeader())
                .body(requestContent)
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
    public void deleteWithToken (String requestUrl) {
        RestAssured.baseURI = requestUrl;
        responseOptions = RestAssured
                .given()
                .log().all(true)
                .headers(getHeadersWithToken())
                .delete();
    }
    public void delete (String requestUrl) {
        RestAssured.baseURI = requestUrl;
        responseOptions = RestAssured
                .given()
                .log().all(true)
                .delete();
    }

    private Map<String, String> getHeadersWithToken() {
        Map<String,String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json; charset=utf-8");
        headers.put("Accept","application/json");
        headers.put("api_key", TOKEN);
        return headers;
    }
    private Map<String, String> getDefaultHeader() {
        Map<String,String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json; charset=utf-8");
        return headers;
    }
}
