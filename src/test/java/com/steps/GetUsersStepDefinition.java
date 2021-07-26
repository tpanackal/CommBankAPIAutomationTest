package com.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.testng.Assert;

import static com.utils.TestUtils.getSchemaDetails;
import static com.utils.UtilConstants.*;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class GetUsersStepDefinition {

    Response getUsersResponse;
    Response getUsersInvalidResponse;

    @Given("^I call Get Users API$")
    public void iCallGetUsersAPI() {
        getUsersResponse = given().when().log().all().get(getBaseUrl()+getPathParameter()).then().body(matchesJsonSchema(getSchemaDetails("ValidGetUsersResponseSchema.json"))).extract().response();

    }

    @Then("^I should get the list of all active users in the leaderboard$")
    public void iShouldGetTheListOfAllActiveUsersInTheLeaderboard() {
        Assert.assertEquals(getUsersResponse.statusCode(),200);
        Assert.assertTrue(getUsersResponse.getBody().jsonPath().getList("$").size() > 0);
    }

    @Given("^I call Get Users API with an invalid request$")
    public void iCallGetUsersAPIWithAnInvalidRequest() {
        getUsersInvalidResponse = given().when().log().all().get(getBaseUrl()+getInvalidGetUserPathParameter()).then().extract().response();

    }

    @Then("^I should be shown a valid error response for Get Users API$")
    public void iShouldBeShownAValidErrorResponseForGetUsersAPI() {
        Assert.assertEquals(getUsersInvalidResponse.statusCode(),400);
    }

}
