package com.testing.CucumberWebTesting.Pages.CommonPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class CommonPageAct {

    @Autowired
    private CommonPageWebElements webElements;

    @Autowired
    protected WebDriver webDriver;

    @Autowired
    protected WebDriverWait webDriverWait;

    public void navigateToRegistrationPage() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElements.myAccountDropdown));
        webElements.myAccountDropdown.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElements.registerButton));
        webElements.registerButton.click();
    }

    public void navigateToLogInPage() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElements.myAccountDropdown));
        webElements.myAccountDropdown.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElements.logInButton));
        webElements.logInButton.click();
    }

    public void LogOut() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElements.myAccountDropdown));
        webElements.myAccountDropdown.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElements.logoutButton));
        webElements.logoutButton.click();
    }

    public void navigateToPhonesPdaProducts(){
        webElements.phonePdaProducts.click();
    }


    public void navigateToShoppingCart() {
        webElements.shoppingCart.click();
    }

    public void navigateToMonitorProducts() {
        webElements.components.click();
        webElements.monitors.click();
    }
}
