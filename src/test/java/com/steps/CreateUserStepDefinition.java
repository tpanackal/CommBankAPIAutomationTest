package com.steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;

import static com.utils.TestUtils.*;
import static com.utils.UtilConstants.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class CreateUserStepDefinition {

    Response createUserResponse;
    Response createUserInvalidResponse;

    public static String userName;

    @Given("^I call Create User API$")
    public void iCallCreateUserAPI() {
        RequestSpecification requestSpecification = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        userName = getUserName();
        requestParams.put("username", userName);
        requestParams.put("score", getScore());
        requestSpecification.header("Content-Type", "application/json");
        requestSpecification.body(requestParams.toJSONString());
        createUserResponse = requestSpecification.post(getBaseUrl()+getPathParameter()).then().body(matchesJsonSchema(getSchemaDetails("ValidCreateAndUpdateUserResponseSchema.json"))).extract().response();

    }

    @Then("^I should be to see a new user created to the leaderboard$")
    public void iShouldBeToSeeANewUserCreatedToTheLeaderboard() {
        Assert.assertEquals(createUserResponse.statusCode(),201);
        Assert.assertEquals(createUserResponse.getBody().jsonPath().get("status"), "success");
        Assert.assertEquals(createUserResponse.getBody().jsonPath().get("message"), "User added.");
    }

    @Given("^I call Create User API with an invalid request$")
    public void iCallCreateUserAPIWithAnInvalidRequest() {
        RequestSpecification requestSpecification = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("username", getUserName());
        requestParams.put("score", null);
        requestSpecification.header("Content-Type", "application/json");
        requestSpecification.body(requestParams.toJSONString());
        createUserInvalidResponse = requestSpecification.post(getBaseUrl()+getPathParameter()).then().extract().response();

    }


    @Then("^I should be shown a valid error response for Create Users API$")
    public void iShouldBeShownAValidErrorResponseForCreateUsersAPI() {
        Assert.assertEquals(createUserInvalidResponse.statusCode(),400);
    }

}
