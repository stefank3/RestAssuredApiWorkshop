package com.rest.tests;

import com.rest.testObjects.PetStoreOperations;
import com.rest.utils.RestAssuredUtils;
import com.rest.utils.TestUtilities;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public Response res = null;
    PetStoreOperations storeOperation = new PetStoreOperations();
    TestUtilities testUtil = new TestUtilities();
    RestAssuredUtils utils = new RestAssuredUtils();

    @BeforeClass
    public void setUp(){
        utils.setBaseURI();
        utils.setContentType(ContentType.JSON);
    }


    @AfterClass
    public void tearDown(){
        utils.resetBaseUri();
    }
}
