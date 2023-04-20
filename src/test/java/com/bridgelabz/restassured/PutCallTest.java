package com.bridgelabz.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PutCallTest {

    @Test
    public void modifyPetDetails() {

        RequestSpecification request = RestAssured.given();
        request.head("Content-Type", "application/json");
        JSONObject json = new JSONObject();
        json.put("id", "6");
        json.put("title", "Restassured");
        json.put("authar", "Avinash");

        request.body(json.toJSONString());

        Response response = request.put("http://localhost:3000/posts");
        System.out.println("Status code: " + response.statusCode());
        System.out.println("Time:" + response.getTime());
        System.out.println("Response Body: " + response.asPrettyString());

        Assert.assertEquals(response.statusCode(), 201);

    }
}