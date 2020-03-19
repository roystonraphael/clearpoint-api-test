#  API Tests built for Clearpoint 
------

## 🚀 Quick start Guide

1.  **Running Tests**

    Run tests via the command line on Mac/ Linux. You will need Java 11 to run these tests.
    
    ```
    ./gradlew test
    ```
    
    On Windows I presume it would be
    
    ```
    gradlew.bat test
    ```
    
    On successful run, within the `build` folder there is a json report created `cucumber-json-report\results.json` related to the test run
    
    There is also a default `reports` folder within the `build` directory which creates a very basic `index.html` report of the test run

## 🧐 What's inside?
------

A quick look at the top-level files and directories in the project.
    
    .
    ├── .gradle
    ├── src
    ├── .idea
    ├── gradle
    ├── build
    ├── gradlew
    ├── gradlew.bat
    ├── settings.gradle
    └── README.md
    
1.  **`/src`**: This directory will contain all of the code related to what you will see on the front-end of your site 
(what you see in the browser) such as your site header or a page template. `src` is a convention for “source code”.

## 🧪 Detailed Explanation of what the code is doing
------

A standard Java project, which fetches dependencies using Gradle. I have added a `features` directory within the 
`resources` folder to include our BDD scenarios

The Step definitions are located within the `stepdefs` folder. Basically the glue between the feature files and the code.

I also have a `runner` defined which uses the Junit cucumber runner to run the tests. I could have used TestNG as well
but decided to choose JUnit for simplicity sake.

Remaining code is self explanatory and divided appropriately into classes to make the code re-usable. I haven't used any
inheritance as the solution didn't call for it.

I have basically used the RestAssured library to test the APIs. I have used the Cucumber-java library to help with BDD. 
JUnit has been used to run the tests.

## 🎓 Challenges Faced
------

1.  **Test Data Setup**

I haven't written a test for the GET functionality of a single task within the list. Ideally I could have because the list
returns a static value for every id. But in the real world ideally we would have a background step , which would ensure the 
creation of the test data.

If I had access to the application code , I would call the underlying method to add a task to the todo list before running 
the GET test for an individual task. If I didn't have access to the underlying method I would look to add the data into the
database directly.

2.  **Full JSON body matching**

Since the [JSON Placeholder Endpoint](https://jsonplaceholder.typicode.com/todos) always returned a stubbed response, we could do a full JSON
object match against a file which contains the JSON response. If we needed replacement of certain fields , due to dynamic capabilities I would use 
something like [Approval Tests](https://github.com/approvals/ApprovalTests.Java/blob/master/README.md) to help with this.

3.  **Logging**

I haven't added any logging, but if I would I would use Log4J to do this.

4.  **Environment**

Since it's only one environment, I haven't had to define an environment. Would ideally define environment details within a `properties` file