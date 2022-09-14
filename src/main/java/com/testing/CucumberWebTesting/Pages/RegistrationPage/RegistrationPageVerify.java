package com.testing.CucumberWebTesting.Pages.RegistrationPage;

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
public class RegistrationPageVerify {

    @Autowired
    private RegistrationPageWebElements webElements;

    @Autowired
    protected WebDriver webDriver;

    @Autowired
    protected WebDriverWait webDriverWait;

    private final String title = "Register Account";

    public void registrationPageIsDisplayed() {
        Assertions.assertThat(webDriver.getTitle()).isEqualTo(title);
    }

    public void registrationCompleted() {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElements.congratulationsText));
        Assertions.assertThat(webElements.congratulationsText.isDisplayed()).isEqualTo(true);
    }

    public void firstNameErrorMessage () {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElements.alertFirstName));
        Assertions.assertThat(webElements.alertFirstName.isDisplayed()).isEqualTo(true);
        Assertions.assertThat(webElements.alertFirstName.getText()).isEqualTo("First Name must be between 1 and 32 characters!");
    }

    public void lastNameErrorMessage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElements.alertSecondName));
        Assertions.assertThat(webElements.alertSecondName.isDisplayed()).isEqualTo(true);
        Assertions.assertThat(webElements.alertSecondName.getText()).isEqualTo("Last Name must be between 1 and 32 characters!");
    }

    public void eMailErrorMessage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElements.alertEmail));
        Assertions.assertThat(webElements.alertEmail.isDisplayed()).isEqualTo(true);
        Assertions.assertThat(webElements.alertEmail.getText()).isEqualTo("E-Mail Address does not appear to be valid!");
    }

    public void phoneNumberErrorMessage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElements.alertTelephone));
        Assertions.assertThat(webElements.alertTelephone.isDisplayed()).isEqualTo(true);
        Assertions.assertThat(webElements.alertTelephone.getText()).isEqualTo("Telephone must be between 3 and 32 characters!");
    }

    public void passwordErrorMessage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElements.alertPassword));
        Assertions.assertThat(webElements.alertPassword.isDisplayed()).isEqualTo(true);
        Assertions.assertThat(webElements.alertPassword.getText()).isEqualTo("Password must be between 4 and 20 characters!");
    }

    public void repeatPasswordErrorMessage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElements.alertConfirmPassword));
        Assertions.assertThat(webElements.alertConfirmPassword.isDisplayed()).isEqualTo(true);
        Assertions.assertThat(webElements.alertConfirmPassword.getText()).isEqualTo("Password confirmation does not match password!");
    }

    public void privacyErrorMessage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElements.alertAgreeConditions));
        Assertions.assertThat(webElements.alertAgreeConditions.isDisplayed()).isEqualTo(true);
        Assertions.assertThat(webElements.alertAgreeConditions.getText()).isEqualTo("Warning: You must agree to the Privacy Policy!");
    }
}
