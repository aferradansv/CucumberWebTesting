package com.testing.CucumberWebTesting.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        extraGlue = "com/testing/CucumberWebTesting",
        features = "src/test/resources",
        plugin = { "pretty", "html:target/cucumber-reports/cucumber.html", "json:target/cucumber-reports/cucumber.json" },
        tags = "@run"
)
public class testRunner {
}
