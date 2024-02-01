package com.rest.utils;

import io.restassured.response.Response;
import org.testng.Assert;

public class TestUtilities {

    //Verification of HTTP response status returned

    public void verifyStatusIs200(Response res){
        Assert.assertEquals(res.getStatusCode(), 200, "Status Check Failed");
        System.out.println("Status Check passed.");
    }

    public void verifyPetName(Response res, String petName){
        Assert.assertEquals(res.getBody().asString().contains(petName),true, "Response does not contains pet name: " + petName);
        System.out.println("Response contains pet: " + petName);
    }

    public void verifyPetRace(Response res, String race){
        Assert.assertEquals(res.getBody().asString().contains(race),true, "Response does not contains pet race: " + race);
        System.out.println("Response contains pet: " + race);
    }

    public void verifyImageUpload(Response res){
        Assert.assertEquals(res.getBody().asString().contains(".jpg"), true, "Image is not successfully uploaded.");
        System.out.println("Image is successfully uploaded.");
    }
    public void verifyPetDeletion(Response res, String id){
        Assert.assertEquals(res.getBody().asString().contains("Pet not found"),true, "Pet with id: " + id + " is deleted.");
        System.out.println("Pet with id : " + id + " is not deleted.");
    }
}
