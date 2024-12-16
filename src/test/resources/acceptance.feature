Feature: Customer API

  Scenario: Create a new customer
    Given the API is running
    When I send a POST request to "/customers" with:
      | firstName    | John    |
      | middleName   | A.      |
      | lastName     | Doe     |
      | emailAddress | john.doe@example.com |
      | phoneNumber  | 123-456-7890 |
    Then the response status should be 201
    And the response body should contain "id"

  Scenario: Get all customers
    Given the API is running
    When I send a GET request to "/customers"
    Then the response status should be 200
    And the response body should not be empty

  Scenario: Delete a customer
    Given the API is running
    When I send a DELETE request to "/customers/1"
    Then the response status should be 204