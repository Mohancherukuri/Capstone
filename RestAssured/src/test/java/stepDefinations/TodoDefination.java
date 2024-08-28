package stepDefinations;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pages.TodoApi;

public class TodoDefination {

    private TodoApi todoApi = new TodoApi();
    private Response response;
    private int createdTodoId;

    @Given("The JSONPlaceholder API is available")
    public void the_json_placeholder_api_is_available() {
        // API is already set up in BaseTest
    }

    @When("I create a new todo with title {string} and completed status {string}")
    public void i_create_a_new_todo_with_title_and_completed_status(String title, String completedStatus) {
        boolean completed = Boolean.parseBoolean(completedStatus);
        response = todoApi.createTodo(title, completed);
        createdTodoId = response.jsonPath().getInt("id"); 
    }

    @Then("The response should return a status code of {int}")
    public void the_response_should_return_a_status_code_of(int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode);
    }

    @Then("The todo title should be {string}")
    public void the_todo_title_should_be(String title) {
        Assert.assertEquals(response.jsonPath().getString("title"), title);
    }

    @Then("The todo should not be completed")
    public void the_todo_should_not_be_completed() {
        Assert.assertFalse(response.jsonPath().getBoolean("completed"));
    }

    @When("I fetch details for todo with ID {string}")
    public void i_fetch_details_for_todo_with_id(String id) {
        response = todoApi.getTodoById(Integer.parseInt(id));
    }

    @When("I update todo with ID {string} with title {string} and completed status {string}")
    public void i_update_todo_with_id_with_title_and_completed_status(String id, String title, String completedStatus) {
        boolean completed = Boolean.parseBoolean(completedStatus);
        response = todoApi.updateTodoById(Integer.parseInt(id), title, completed);
    }

    @Then("The todo should be completed")
    public void the_todo_should_be_completed() {
        Assert.assertTrue(response.jsonPath().getBoolean("completed"));
    }

    @When("I delete todo with ID {string}")
    public void i_delete_todo_with_id(String id) {
        response = todoApi.deleteTodoById(Integer.parseInt(id));
    }

    @Then("The todo with ID {string} should no longer exist")
    public void the_todo_with_id_should_no_longer_exist(String id) {
        Response response = todoApi.getTodoById(Integer.parseInt(id));
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
