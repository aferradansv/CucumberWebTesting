package com.testing.CucumberWebTesting.Pages.MyAccountPage;

import com.testing.CucumberWebTesting.Pages.LogInPage.LogInPageWebElements;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class MyAccountPageVerify {

    @Autowired
    protected WebDriver webDriver;

    private final String title = "My Account";

    public void myAccountPageIsDisplayed() {
        Assertions.assertThat(webDriver.getTitle()).isEqualTo(title);
    }
}
