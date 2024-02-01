package com.rest.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestAssuredUtils {

    //Base URI
    public static void setBaseURI(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    /*
     * Reset Base URI(After test or Teardown)
     */
    public static void resetBaseUri(){
        RestAssured.baseURI = null;
    }

    /*
      * Set Content Type
      */
    public static void setContentType(ContentType type) {
        given().contentType(type);
    }

    //Returns response for the given path
    public static Response getResponse (String path){
        return given().get(path);
    }

    //Returns Response

    public static Response getResponse(){
        return given().get();
    }

    //returns Json Path object
    public static JsonPath getJsonPath(Response res){
        String json = res.asString();
        return new JsonPath(json);
    }

}
