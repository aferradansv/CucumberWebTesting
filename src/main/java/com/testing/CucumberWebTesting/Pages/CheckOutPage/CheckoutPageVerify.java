package com.testing.CucumberWebTesting.Pages.CheckOutPage;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class CheckoutPageVerify {

    @Autowired
    private WebDriver webDriver;

    @Autowired
    private WebDriverWait webDriverWait;

    @Autowired
    private CheckoutPageWebElements webElements;

    private final String title = "Checkout";

    public void checkoutPageIsDisplayed() {
        Assertions.assertThat(webDriver.getTitle()).isEqualTo(title);
    }

    public void checkoutOptionsPanelExpanded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElements.checkoutOption));
        Assertions.assertThat(webElements.checkoutOption.getAttribute("aria-expanded")).isEqualTo("true");
    }

    public void billingOptionsPanelExpanded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElements.billingAddressOption));
        Assertions.assertThat(webElements.billingAddressOption.getAttribute("aria-expanded")).isEqualTo("true");
    }
}
