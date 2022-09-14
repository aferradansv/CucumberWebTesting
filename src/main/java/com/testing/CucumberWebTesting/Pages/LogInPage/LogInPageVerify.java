package com.testing.CucumberWebTesting.Pages.LogInPage;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class LogInPageVerify {

    @Autowired
    LogInPageWebElements webElements;

    @Autowired
    protected WebDriver webDriver;

    @Autowired
    protected WebDriverWait webDriverWait;

    private final String title = "Account Login";

    public void logInPageIsDisplayed() {
        Assertions.assertThat(webDriver.getTitle()).isEqualTo(title);
    }

    public void assertLogInErrorMessage() {
        Assertions.assertThat(webElements.errorMessage.getText()).isEqualTo("Warning: No match for E-Mail Address and/or Password.");
    }

}
