package com.testing.CucumberWebTesting.Pages;

import com.testing.CucumberWebTesting.Utils.RegistrationInformation;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class RegistrationPage extends CommonPage {

    @Autowired
    private RegistrationInformation registrationInformation;

    private final String title = "Register Account";

    @FindBy(id = "input-firstname")
    private WebElement firstName;

    @FindBy(id = "input-lastname")
    private WebElement lastname;

    @FindBy(id = "input-email")
    private WebElement email;

    @FindBy(id = "input-telephone")
    private WebElement telephone;

    @FindBy(id = "input-password")
    private WebElement password;

    @FindBy(id = "input-confirm")
    private WebElement passwordConfirm;

    @FindBy(xpath = "//input[@name = 'agree']")
    private WebElement privacyPolicy;

    @FindBy(xpath = "//input[@name = 'newsletter' and @value = '1']")
    private WebElement newsLetterYes;

    @FindBy(xpath = "//input[@name = 'newsletter' and @value = '0']")
    private WebElement newsLetterNo;

    @FindBy(xpath = "//input[@value = 'Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//p[contains(text(), 'Congratulations!')]")
    private WebElement congratulationsText;

    @FindBy(xpath = "//div[@class = 'alert alert-danger alert-dismissible']")
    private WebElement alertAgreeConditions;

    @FindBy(xpath = "//div[@class = 'text-danger' and contains(text(), 'First Name')]")
    private WebElement alertFirstName;

    @FindBy(xpath = "//div[@class = 'text-danger' and contains(text(), 'Last Name')]")
    private WebElement alertSecondName;

    @FindBy(xpath = "//div[@class = 'text-danger' and contains(text(), 'E-Mail')]")
    private WebElement alertEmail;

    @FindBy(xpath = "//div[@class = 'text-danger' and contains(text(), 'Telephone')]")
    private WebElement alertTelephone;

    @FindBy(xpath = "//div[@class = 'text-danger' and contains(text(), 'Password must be')]")
    private WebElement alertPassword;

    @FindBy(xpath = "//div[@class = 'text-danger' and contains(text(), 'Password confirmation')]")
    private WebElement alertConfirmPassword;

    public void fillForm() {
        firstName.sendKeys(registrationInformation.getFirstName());
        lastname.sendKeys(registrationInformation.getLastName());
        email.sendKeys(registrationInformation.getEmailAddress());
        telephone.sendKeys(registrationInformation.getPhoneNumber());
        password.sendKeys(registrationInformation.getPassword());
        passwordConfirm.sendKeys(registrationInformation.getRepeatPassword());
        if (registrationInformation.isNewsletter()) {
            newsLetterYes.click();
        } else {
            newsLetterNo.click();
        }
        if (registrationInformation.isPrivacyPolicy()) {
            privacyPolicy.click();
        }
    }

    public void completeRegistration() {
        continueButton.click();
    }

    public void verifyRegistrationPageIsDisplayed() {
        Assertions.assertThat(webDriver.getTitle()).isEqualTo(title);
    }

    public void verifyRegistrationCompleted() {
        webDriverWait.until(ExpectedConditions.visibilityOf(congratulationsText));
        Assertions.assertThat(congratulationsText.isDisplayed()).isEqualTo(true);
    }

    public void verifyFirstNameErrorMessage () {
        webDriverWait.until(ExpectedConditions.visibilityOf(alertFirstName));
        Assertions.assertThat(alertFirstName.isDisplayed()).isEqualTo(true);
        Assertions.assertThat(alertFirstName.getText()).isEqualTo("First Name must be between 1 and 32 characters!");
    }

    public void verifyLastNameErrorMessage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(alertSecondName));
        Assertions.assertThat(alertSecondName.isDisplayed()).isEqualTo(true);
        Assertions.assertThat(alertSecondName.getText()).isEqualTo("Last Name must be between 1 and 32 characters!");
    }

    public void verifyEMailErrorMessage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(alertEmail));
        Assertions.assertThat(alertEmail.isDisplayed()).isEqualTo(true);
        Assertions.assertThat(alertEmail.getText()).isEqualTo("E-Mail Address does not appear to be valid!");
    }

    public void verifyPhoneNumberErrorMessage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(alertTelephone));
        Assertions.assertThat(alertTelephone.isDisplayed()).isEqualTo(true);
        Assertions.assertThat(alertTelephone.getText()).isEqualTo("Telephone must be between 3 and 32 characters!");
    }

    public void verifyPasswordErrorMessage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(alertPassword));
        Assertions.assertThat(alertPassword.isDisplayed()).isEqualTo(true);
        Assertions.assertThat(alertPassword.getText()).isEqualTo("Password must be between 4 and 20 characters!");
    }

    public void verifyRepeatPasswordErrorMessage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(alertConfirmPassword));
        Assertions.assertThat(alertConfirmPassword.isDisplayed()).isEqualTo(true);
        Assertions.assertThat(alertConfirmPassword.getText()).isEqualTo("Password confirmation does not match password!");
    }

    public void verifyPrivacyErrorMessage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(alertAgreeConditions));
        Assertions.assertThat(alertAgreeConditions.isDisplayed()).isEqualTo(true);
        Assertions.assertThat(alertAgreeConditions.getText()).isEqualTo("Warning: You must agree to the Privacy Policy!");
    }
}