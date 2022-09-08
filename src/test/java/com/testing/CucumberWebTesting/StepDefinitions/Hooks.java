package com.testing.CucumberWebTesting.StepDefinitions;

import io.cucumber.core.gherkin.Step;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class Hooks {

    @Autowired
    private WebDriver webDriver;


    @After()
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
            long time = new Date().getTime();
            String outputName = "screenshot_" + time + ".png";
            scenario.attach(screenshot, "image/png", outputName);
        }
        webDriver.close();
    }
}
