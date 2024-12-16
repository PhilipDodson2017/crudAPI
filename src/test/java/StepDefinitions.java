
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {

    private static final String BASE_URL = "http://localhost:8080/api/customers";
    private Response response;

    @Given("the API is running")
    public void theApiIsRunning() {
        // Optionally, you can check if the API is up
        RestAssured.given().when().get(BASE_URL).then().statusCode(200);
    }

    @When("I send a POST request to {string} with:")
    public void iSendAPostRequestToWith(String endpoint, io.cucumber.datatable.DataTable dataTable) {
        var customerData = dataTable.asMaps(String.class, String.class).get(0);

        response = RestAssured.given()
                .contentType("application/json")
                .body(customerData)
                .post(BASE_URL + endpoint);
    }

    @When("I send a GET request to {string}")
    public void iSendAGetRequestTo(String endpoint) {
        response = RestAssured.given().get(BASE_URL + endpoint);
    }

    @When("I send a DELETE request to {string}")
    public void iSendADeleteRequestTo(String endpoint) {
        response = RestAssured.given().delete(BASE_URL + endpoint);
    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    @Then("the response body should contain {string}")
    public void theResponseBodyShouldContain(String key) {
        assertNotNull(response.jsonPath().get(key));
    }

    @Then("the response body should not be empty")
    public void theResponseBodyShouldNotBeEmpty() {
        assertFalse(response.getBody().asString().isEmpty());
    }
}