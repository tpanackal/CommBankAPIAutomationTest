package com.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;

import static com.steps.CreateUserStepDefinition.userName;
import static com.utils.TestUtils.getScore;
import static com.utils.UtilConstants.*;

public class UpdateUserStepDefinition {

    Response updateUserResponse;
    Response updateUserInvalidResponse;

    @Given("^I call Update User API for an existing user$")
    public void iCallUpdateUserAPIForAnExistingUser() {
        RequestSpecification requestSpecification = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("username", userName);
        requestParams.put("score", getScore());
        requestSpecification.header("Content-Type", "application/json");
        requestSpecification.body(requestParams.toJSONString());
        updateUserResponse = requestSpecification.put(getBaseUrl()+getPathParameter()).then().extract().response();

    }


    @Then("^I should be to see the updated details of the user reflected correctly to the leaderboard$")
    public void iShouldBeToSeeTheUpdatedDetailsOfTheUserReflectedCorrectlyToTheLeaderboard() {
        Assert.assertEquals(updateUserResponse.statusCode(),204);
        
    }

    @Given("^I call Update User API with an invalid request$")
    public void iCallUpdateUserAPIWithAnInvalidRequest() {
        RequestSpecification requestSpecification = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("username", userName);
        requestParams.put("score", null);
        requestSpecification.header("Content-Type", "application/json");
        requestSpecification.body(requestParams.toJSONString());
        updateUserInvalidResponse = requestSpecification.post(getBaseUrl()+getPathParameter()).then().extract().response();
        
    }

    @Then("^I should be shown a valid error response for Update User API$")
    public void iShouldBeShownAValidErrorResponseForUpdateUserAPI() {
        Assert.assertEquals(updateUserInvalidResponse.statusCode(),400);
    }
}
