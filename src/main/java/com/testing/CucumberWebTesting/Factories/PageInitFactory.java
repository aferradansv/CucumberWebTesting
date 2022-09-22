package com.testing.CucumberWebTesting.Factories;

import com.testing.CucumberWebTesting.Pages.CheckOutPage.CheckoutPageWebElements;
import com.testing.CucumberWebTesting.Pages.CommonPage.CommonPageWebElements;
import com.testing.CucumberWebTesting.Pages.HomePage.HomePage;
import com.testing.CucumberWebTesting.Pages.LogInPage.LogInPageWebElements;
import com.testing.CucumberWebTesting.Pages.ProductDetails.ProductDetailsPageWebElements;
import com.testing.CucumberWebTesting.Pages.ProductsPage.ProductsPageWebElements;
import com.testing.CucumberWebTesting.Pages.RegistrationPage.RegistrationPageWebElements;
import com.testing.CucumberWebTesting.Pages.ShoppingCartPage.ShoppingCartWebElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class PageInitFactory {

    @Autowired
    protected WebDriver webDriver;

    @Autowired
    protected WebDriverWait webDriverWait;

    @PostConstruct
    public void InitPageFactory() {
        PageFactory.initElements(webDriver, this);
        PageFactory.initElements(webDriver, CommonPageWebElements.class);
        PageFactory.initElements(webDriver, HomePage.class);
        PageFactory.initElements(webDriver, LogInPageWebElements.class);
        PageFactory.initElements(webDriver, ProductsPageWebElements.class);
        PageFactory.initElements(webDriver, RegistrationPageWebElements.class);
        PageFactory.initElements(webDriver, ShoppingCartWebElements.class);
        PageFactory.initElements(webDriver, CheckoutPageWebElements.class);
        PageFactory.initElements(webDriver, ProductDetailsPageWebElements.class);
    }
}
