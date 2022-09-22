package com.testing.CucumberWebTesting.Pages.LogInPage;

import com.testing.CucumberWebTesting.Factories.PageInitFactory;
import com.testing.CucumberWebTesting.Pages.CommonPage.CommonPageWebElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class LogInPageWebElements extends PageInitFactory {

    @FindBy(id = "input-email")
    public WebElement usernameTextField;

    @FindBy(id = "input-password")
    public WebElement passwordTextField;

    @FindBy(xpath = "//input[@class = 'btn btn-primary']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class = 'alert alert-danger alert-dismissible']")
    public WebElement errorMessage;



}
