package com.testing.CucumberWebTesting.Pages.CheckOutPage;

import com.testing.CucumberWebTesting.Factories.PageInitFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class CheckoutPageWebElements extends PageInitFactory {

    @FindBy(xpath = "//div[@id='collapse-checkout-option']")
    public WebElement checkoutOption;

    @FindBy(xpath = "//div[@id='collapse-payment-address']")
    public WebElement billingAddressOption;

}
