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
    private RegistrationPageWebElements registrationPageWebElements;

    @Autowired
    protected WebDriver webDriver;

    @Autowired
    protected WebDriverWait webDriverWait;

    private final String title = "Register Account";

    public void registrationPageIsDisplayed() {
        Assertions.assertThat(webDriver.getTitle()).isEqualTo(title);
    }

    public void registrationCompleted() {
        webDriverWait.until(ExpectedConditions.visibilityOf(registrationPageWebElements.congratulationsText));
        Assertions.assertThat(registrationPageWebElements.congratulationsText.isDisplayed()).isEqualTo(true);
    }

    public void firstNameErrorMessage () {
        webDriverWait.until(ExpectedConditions.visibilityOf(registrationPageWebElements.alertFirstName));
        Assertions.assertThat(registrationPageWebElements.alertFirstName.isDisplayed()).isEqualTo(true);
        Assertions.assertThat(registrationPageWebElements.alertFirstName.getText()).isEqualTo("First Name must be between 1 and 32 characters!");
    }

    public void lastNameErrorMessage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(registrationPageWebElements.alertSecondName));
        Assertions.assertThat(registrationPageWebElements.alertSecondName.isDisplayed()).isEqualTo(true);
        Assertions.assertThat(registrationPageWebElements.alertSecondName.getText()).isEqualTo("Last Name must be between 1 and 32 characters!");
    }

    public void eMailErrorMessage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(registrationPageWebElements.alertEmail));
        Assertions.assertThat(registrationPageWebElements.alertEmail.isDisplayed()).isEqualTo(true);
        Assertions.assertThat(registrationPageWebElements.alertEmail.getText()).isEqualTo("E-Mail Address does not appear to be valid!");
    }

    public void phoneNumberErrorMessage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(registrationPageWebElements.alertTelephone));
        Assertions.assertThat(registrationPageWebElements.alertTelephone.isDisplayed()).isEqualTo(true);
        Assertions.assertThat(registrationPageWebElements.alertTelephone.getText()).isEqualTo("Telephone must be between 3 and 32 characters!");
    }

    public void passwordErrorMessage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(registrationPageWebElements.alertPassword));
        Assertions.assertThat(registrationPageWebElements.alertPassword.isDisplayed()).isEqualTo(true);
        Assertions.assertThat(registrationPageWebElements.alertPassword.getText()).isEqualTo("Password must be between 4 and 20 characters!");
    }

    public void repeatPasswordErrorMessage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(registrationPageWebElements.alertConfirmPassword));
        Assertions.assertThat(registrationPageWebElements.alertConfirmPassword.isDisplayed()).isEqualTo(true);
        Assertions.assertThat(registrationPageWebElements.alertConfirmPassword.getText()).isEqualTo("Password confirmation does not match password!");
    }

    public void privacyErrorMessage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(registrationPageWebElements.alertAgreeConditions));
        Assertions.assertThat(registrationPageWebElements.alertAgreeConditions.isDisplayed()).isEqualTo(true);
        Assertions.assertThat(registrationPageWebElements.alertAgreeConditions.getText()).isEqualTo("Warning: You must agree to the Privacy Policy!");
    }
}
