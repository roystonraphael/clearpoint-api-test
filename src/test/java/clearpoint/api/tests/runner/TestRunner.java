package clearpoint.api.tests.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/resources"},
        glue = { "classpath:clearpoint.api.tests.stepdefs" },
        plugin = {"pretty", "json:build/cucumber-json-report/results.json"},
        tags={"@APITest"})
public class TestRunner { }
