package com.bridgelabz.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteCallTest {

    @Test
    public void deletePetDetails() {
        Response response = RestAssured.delete("http://localhost:3000/posts");

        RequestSpecification request = RestAssured.given();
        request.body("http://localhost:3000/posts");

        JSONObject json = new JSONObject();
        json.put("id", 10);
        json.put("title", "RestAssured");
        json.put("auther", "Sachin");
        request.body(json.toJSONString());

        request.delete("http://localhost:3000/posts");

        System.out.println("Status code: " + response.statusCode());
        System.out.println("Time:" + response.getTime());
        System.out.println("Response Body: " + response.asPrettyString());

        Assert.assertEquals(response.statusCode(), 200);
    }
}
