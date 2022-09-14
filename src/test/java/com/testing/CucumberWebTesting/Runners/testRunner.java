package com.testing.CucumberWebTesting.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        extraGlue = "com/testing/CucumberWebTesting",
        features = "src/test/resources",
        plugin = {
                "pretty",
                "json:target/surefire-reports/cucumber.json",
                "html:target/surefire-reports/cucumber-html-report.html"
        },
        tags = "@regression"
)
public class testRunner {
}
