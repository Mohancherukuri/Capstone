package pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TodoApi {

    // Create a new Todo
    public Response createTodo(String title, boolean completed) {
        return RestAssured.given()
            .contentType("application/json")
            .body("{\"title\":\"" + title + "\",\"completed\":" + completed + "}")
            .when()
            .post("/todos")
            .then()
            .extract()
            .response();
    }

    // Get Todo by ID
    public Response getTodoById(int id) {
        return RestAssured.given()
            .when()
            .get("/todos/" + id)
            .then()
            .extract()
            .response();
    }

    // Update Todo by ID
    public Response updateTodoById(int id, String title, boolean completed) {
        return RestAssured.given()
            .contentType("application/json")
            .body("{\"title\":\"" + title + "\",\"completed\":" + completed + "}")
            .when()
            .put("/todos/" + id)
            .then()
            .extract()
            .response();
    }

    // Delete Todo by ID
    public Response deleteTodoById(int id) {
        return RestAssured.given()
            .when()
            .delete("/todos/" + id)
            .then()
            .extract()
            .response();
    }
}
