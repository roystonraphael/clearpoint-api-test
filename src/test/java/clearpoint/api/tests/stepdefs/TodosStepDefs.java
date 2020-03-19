package clearpoint.api.tests.stepdefs;

import clearpoint.api.tests.api.Todos;
import clearpoint.api.tests.objects.Task;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ResponseBody;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TodosStepDefs {
  private Todos todo = new Todos();
  private Task task;
  private ResponseBody responseBody;



  @Given("^I have access to the Todo list API$")
  public void iHaveAccessToTheTodoListAPI() {
    // verify is service is up and running
    todo.validateServicePresent();
  }

  @When("^I create a todo task with title \"([^\"]*)\" and body \"([^\"]*)\"$")
  public void iCreateATodoTaskWithTitleAndBody(String title, String body) {
    // create a new task. id is generated on the fly (current mock just returns 201 id always, but it would return a new
    // value in the real world )
    task = new Task(title, body);
    task.setId(todo.createNewItem(task));
  }

  @When("^I fetch all the tasks within my Todo list$")
  public void iFetchAllTheTasksWithinMyTodoList() {
    responseBody = todo.fetchAllItems();
  }

  @Then("^the new task is present in my list$")
  public void theNewTaskIsPresentInMyList() {
    //check new task created has the correct id. for now it's static 201 that's returned but it could be anything
    Assert.assertEquals(201, task.getId());
  }

  @Then("^I can see all the tasks present within my todo list$")
  public void iCanSeeAllTheTasksPresentWithinMyTodoList() throws IOException, ParseException {
    //this performs a full body comparison of json.
    // I could have used a library like ApprovalTests instead

    String expectedJson = Files.readString(Paths.get("src/test/resources/Json/fullJsonResponse.json"), StandardCharsets.UTF_8);
    expectedJson = expectedJson.replaceAll("\\s+","");
    String actualJson = responseBody.prettyPrint().replaceAll("\\s+","");
    Assert.assertEquals(expectedJson, actualJson);
  }
}
