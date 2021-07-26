Feature: Validate that Get, Create and Update Covid Challenge API's are providing correct responses.

  @smoke
  Scenario: Validate that GetUsers API retrieves the list of all active users
    Given I call Get Users API
    Then I should get the list of all active users in the leaderboard

  @smoke
  Scenario:Validate that Create User API creates a new user to the leaderboard
    Given I call Create User API
    Then I should be to see a new user created to the leaderboard

  @smoke
  Scenario:Validate that Update User API updates the user details correctly to the leaderboard
    Given I call Update User API for an existing user
    Then I should be to see the updated details of the user reflected correctly to the leaderboard


  @skip
  Scenario:Validate that GetUsers API throws a valid error response when an invalid request is made
    Given I call Get Users API with an invalid request
    Then I should be shown a valid error response for Get Users API

  @skip
  Scenario:Validate that Create User API throws a valid error response when an invalid request is made
    Given I call Create User API with an invalid request
    Then I should be shown a valid error response for Create Users API


  @skip
  Scenario:Validate that Update User API throws a valid error response when an invalid request is made
    Given I call Update User API with an invalid request
    Then I should be shown a valid error response for Update User API

