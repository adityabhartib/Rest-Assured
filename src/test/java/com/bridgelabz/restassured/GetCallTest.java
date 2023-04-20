package com.bridgelabz.restassured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetCallTest {

    @Test
    public void getPetTest() {
        Response response = RestAssured.get("http://localhost:3000/posts");
        System.out.println("Status code: " + response.statusCode());
        Assert.assertEquals(response.statusCode(), 200);
        System.out.println("Time: " + response.getTime());
        System.out.println(response.getBody().asPrettyString());
    }
}
