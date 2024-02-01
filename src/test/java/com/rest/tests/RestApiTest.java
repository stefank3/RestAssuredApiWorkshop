package com.rest.tests;


import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class RestApiTest extends BaseTest {

    @Test
    public void T01_verifyAddPet(){

        //Post operation to add the pet from Pet Store Operations class
        storeOperation.addPet();

        /*
        Sending a get request with the ID that we are sending in the post operation
         and validating that the proper name/race is added and the status is HTTP 200
         */
        res = utils.getResponse("/pet/1001");
        res.getBody().prettyPeek().asString();
        testUtil.verifyStatusIs200(res);
        testUtil.verifyPetName(res,"Aragorn");
        testUtil.verifyPetRace(res,"Cane Corso");

    }


    @Test
    public void T02_verifyUpdatePet(){

        /*
        Put operation to edit the added pet from TC1 and to update the race and name of the pet
         */
        storeOperation.updatePet();
        /*
        Sending a get request with the ID that we are sending in the post operation
         and validating that the proper name/race is edited and the status is HTTP 200
         */
        res = utils.getResponse("/pet/1001");
        res.getBody().prettyPeek().asString();
        testUtil.verifyStatusIs200(res);
        testUtil.verifyPetName(res,"Gandalf");
        testUtil.verifyPetRace(res,"Doberman");


    }

    @Test
    public void T03_verifyPetImageUpload(){
        File dogImage = new File("src/test/resources/Doggo.jpg");

        res = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.MULTIPART)
                .multiPart("file",dogImage)
                .when()
                .post("/pet/1001/uploadImage");
        res.getBody().prettyPeek().asString();
        testUtil.verifyStatusIs200(res);
    }

    @Test
    public void T04_verifyPetDelete(){
        storeOperation.deletePet();
        res = utils.getResponse("/pet/1001");
        res.getBody().prettyPeek().asString();
        testUtil.verifyPetDeletion(res, "1001");

    }

}
