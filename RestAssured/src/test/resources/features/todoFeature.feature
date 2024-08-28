Feature: CRUD Operations on Todos

  Scenario: Create a new Todo
    Given The JSONPlaceholder API is available
    When I create a new todo with title "Buy groceries" and completed status "false"
    Then The response should return a status code of 201
    And The todo title should be "Buy groceries"
    And The todo should not be completed

  Scenario: Fetch Todo details by ID
    Given The JSONPlaceholder API is available
    When I fetch details for todo with ID "1"
    Then The response should return a status code of 200
    And The todo title should be "delectus aut autem"
    And The todo should not be completed

  Scenario: Update an existing Todo
    Given The JSONPlaceholder API is available
    When I update todo with ID "1" with title "Updated title" and completed status "true"
    Then The response should return a status code of 200
    And The todo title should be "Updated title"
    And The todo should be completed

  Scenario: Delete a Todo
    Given The JSONPlaceholder API is available
    When I delete todo with ID "1"
    Then The response should return a status code of 200
    And The todo with ID "1" should no longer exist
