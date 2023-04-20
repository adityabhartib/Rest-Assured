package com.bridgelabz.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetCallBDDTest {

    @Test
    public void getDetails() {

        String body = given().
                when().
                get("http://localhost:3000/posts").asPrettyString();

        System.out.println("Body: " + body);
    }

    @Test
    public void postTest(){

        given().when().post("http://localhost:3000/posts").then().assertThat().statusCode(200);

        Response response = given().when().put("http://localhost:3000/posts");
        Assert.assertEquals(response.statusCode(),200);
        JSONObject json = new JSONObject();
        json.put("id", 8);
        json.put("title", "RestAssured");
        json.put("auther", "Tushar");
        response.asPrettyString();
        response.getTime();
    }

    /*
     * given()
     * when()
     * then()
     * and()
     * */
}
