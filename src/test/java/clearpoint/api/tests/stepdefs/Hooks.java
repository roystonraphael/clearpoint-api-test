package clearpoint.api.tests.stepdefs;


import io.cucumber.java.Before;
import io.restassured.RestAssured;


public class Hooks {
  @Before
  public void setup(){
    // set Rest Assured base url. I would ideally pass environment through here, but we have access to a single API
    RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
  }
}
