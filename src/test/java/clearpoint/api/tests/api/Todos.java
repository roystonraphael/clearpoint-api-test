package clearpoint.api.tests.api;

import clearpoint.api.tests.objects.Task;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import org.apache.http.HttpStatus;


public class Todos {

  //check if API is alive by validating the response code
  public void validateServicePresent() {
    RestAssured.given()
        .contentType(ContentType.JSON).accept(ContentType.JSON)
      .when()
        .get("/todos")
      .then()
        .log()
        .ifError()
        .assertThat()
        .statusCode(HttpStatus.SC_OK);
  }

  //returns the id when creating a new task
  public int createNewItem(Task task) {
    return Integer.parseInt(
      RestAssured.given()
        .body(task)
      .when()
        .post("/todos")
      .then()
        .log()
        .ifError()
        .assertThat()
        .statusCode(HttpStatus.SC_CREATED)
        .extract()
        .path("id")
        .toString()
    );
  }

  public ResponseBody fetchAllItems() {
    return RestAssured.given()
      .when()
        .get("/todos")
      .then()
        .log()
        .ifError()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract()
        .response()
        .body();
  }
}
