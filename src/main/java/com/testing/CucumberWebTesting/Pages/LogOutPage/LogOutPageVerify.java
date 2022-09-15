package com.testing.CucumberWebTesting.Pages.LogOutPage;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class LogOutPageVerify{

   private String title = "Account Logout";

   @Autowired
   private WebDriver webDriver;

    public void logOutPageIsDisplayed() {
        Assertions.assertThat(webDriver.getTitle()).isEqualTo(title);
    }

}
