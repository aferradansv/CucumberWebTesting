package com.testing.CucumberWebTesting.Pages.CommonPage;

import com.testing.CucumberWebTesting.Factories.PageInitFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.w3c.dom.html.HTMLInputElement;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class CommonPageWebElements extends PageInitFactory {

    @FindBy(css = "[title=\"My Account\"]")
    public WebElement myAccountDropdown;

    @FindBy(linkText = "Register")
    public WebElement registerButton;

    @FindBy(linkText = "Login")
    public WebElement logInButton;

    @FindBy(linkText = "Logout")
    public WebElement logoutButton;

    @FindBy(linkText = "Phones & PDAs")
    public WebElement phonePdaProducts;

    @FindBy(linkText = "Shopping Cart")
    public WebElement shoppingCart;

    @FindBy(linkText = "Components")
    public WebElement components;

    @FindBy(xpath = "//a[contains(text(), 'Monitors')]")
    public WebElement monitors;
}
