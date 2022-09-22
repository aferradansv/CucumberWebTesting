package com.testing.CucumberWebTesting.Pages.HomePage;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class HomePage {

    @Autowired
    private WebDriver webDriver;

    private final String title = "Your Store";
    private final String url = "http://opencart.abstracta.us/";

    public void navigateTo() {
        webDriver.navigate().to(url);
    }

    public void verifyHomePageIsDisplayed () {
        Assertions.assertThat(webDriver.getTitle()).isEqualTo(title);
    }




}