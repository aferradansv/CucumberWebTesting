package com.testing.CucumberWebTesting.Pages.LogInPage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class LogInPageAct {

    @Autowired
    LogInPageWebElements webElements;

    public LogInPageAct fillCredentials(String username, String password) {
        webElements.usernameTextField.sendKeys(username);
        webElements.passwordTextField.sendKeys(password);
        return this;
    }


    public void completeLogIn() {
        webElements.loginButton.click();
    }
}
