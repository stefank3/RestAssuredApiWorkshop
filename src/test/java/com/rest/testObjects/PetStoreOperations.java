package com.rest.testObjects;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;

public class PetStoreOperations {
    public Response res = null;


    public void addPet(){
        res = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 1001,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 8,\n" +
                        "    \"name\": \"Cane Corso\"\n" +
                        "  },\n" +
                        "  \"name\": \"Aragorn\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .post("/pet");
    }

    public void updatePet(){
        res = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 1001,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 8,\n" +
                        "    \"name\": \"Doberman\"\n" +
                        "  },\n" +
                        "  \"name\": \"Gandalf\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .put("/pet");
    }

   /* public void uploadPetImage(){
        File dogImage = new File("src/test/resources/Doggo.jpg");

        res = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.MULTIPART)
                .multiPart("file",dogImage)
                .when()
                .post("/pet/1001/uploadImage");

    } */

    public void deletePet(){
        res = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 1001,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 8,\n" +
                        "    \"name\": \"Doberman\"\n" +
                        "  },\n" +
                        "  \"name\": \"Gandalf\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .delete("/pet/1001");
    }
}
