package com.testing.CucumberWebTesting.StepDefinitions;

import com.testing.CucumberWebTesting.Pages.CheckOutPage.CheckoutPageVerify;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class CheckoutStepDef {

    @Autowired
    private CheckoutPageVerify checkoutPageVerify;

    @Then("the checkout page is displayed")
    public void theCheckoutPageIsDisplayed() {
        checkoutPageVerify.checkoutPageIsDisplayed();
    }

    @And("the checkout options panel is expanded")
    public void theCheckoutOptionsPanelIsExpanded() {
        checkoutPageVerify.checkoutOptionsPanelExpanded();
    }

    @And("the billing options panel is expanded")
    public void theBillingOptionsPanelIsExpanded() {
        checkoutPageVerify.billingOptionsPanelExpanded();
    }



}
