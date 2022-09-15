package com.testing.CucumberWebTesting.Pages;

import com.testing.CucumberWebTesting.Factories.PageInitFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class CommonPage extends PageInitFactory {

    @FindBy(css = "[title=\"My Account\"]")
    private WebElement myAccountDropdown;

    @FindBy(linkText = "Register")
    private WebElement registerButton;

    @FindBy(linkText = "Login")
    private WebElement logInButton;

    @FindBy(linkText = "Logout")
    private WebElement logoutButton;

    public void navigateToRegistrationPage() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(myAccountDropdown));
        myAccountDropdown.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(registerButton));
        registerButton.click();
    }

    public void navigateToLogInPage() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(myAccountDropdown));
        myAccountDropdown.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(logInButton));
        logInButton.click();
    }

    public void LogOut() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(myAccountDropdown));
        myAccountDropdown.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
    }
}
