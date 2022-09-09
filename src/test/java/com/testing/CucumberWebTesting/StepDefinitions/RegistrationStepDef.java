package com.testing.CucumberWebTesting.StepDefinitions;

import com.testing.CucumberWebTesting.Pages.HomePage;
import com.testing.CucumberWebTesting.Pages.RegistrationPage;
import com.testing.CucumberWebTesting.Utils.RegistrationEnum;
import com.testing.CucumberWebTesting.Utils.RegistrationInformation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class RegistrationStepDef {

    @Autowired
    private HomePage homePage;

    @Autowired
    private RegistrationPage registrationPage;

    @Autowired
    private RegistrationInformation registrationInformation;

    @Given("the user opens the store web")
    public void openHomePage() {
        homePage.navigateTo();
        homePage.verifyHomePageIsDisplayed();
    }
    @Given("navigates to the registration page")
    public void i_navigate_to_the_registration_page() {
        homePage.navigateToRegistrationPage();
    }

    @Then("the user is on registration page")
    public void the_user_is_on_registration_page() {
        registrationPage.verifyRegistrationPageIsDisplayed();
    }


    @When("the user completes the registration with correct data")
    public void theUserFillsTheForm() {
        registrationPage.fillForm();
        registrationPage.completeRegistration();
    }

    @Then("the registration has been completed successfully")
    public void theRegistrationHasBeenCompletedSuccessfully() {
        registrationPage.verifyRegistrationCompleted();
    }

    @When("the user completes the registration with field {registrationEnum} and value {string}")
    public void theUserCompletesTheRegistrationWithFieldAndValue(RegistrationEnum field, String value) {
        switch (field) {
            case FirstName -> registrationInformation.setFirstName(value);
            case LastName -> registrationInformation.setLastName(value);
            case EMail -> registrationInformation.setEmailAddress(value);
            case Telephone ->  registrationInformation.setPhoneNumber(value);
            case Password -> registrationInformation.setPassword(value);
            case PasswordConfirm -> registrationInformation.setRepeatPassword(value);
            case Newsletter -> registrationInformation.setNewsletter(Boolean.parseBoolean(value));
            case Privacy -> registrationInformation.setPrivacyPolicy(Boolean.parseBoolean(value));
        }
        registrationPage.fillForm();
        registrationPage.completeRegistration();
    }


    @Then("an error message in the field {registrationEnum} is displayed")
    public void anErrorMessageInTheFieldIsDisplayed(RegistrationEnum field) {
        switch (field) {
            case FirstName -> registrationPage.verifyFirstNameErrorMessage();
            case LastName -> registrationPage.verifyLastNameErrorMessage();
            case EMail -> registrationPage.verifyEMailErrorMessage();
            case Telephone ->  registrationPage.verifyPhoneNumberErrorMessage();
            case Password -> registrationPage.verifyPasswordErrorMessage();
            case PasswordConfirm ->  registrationPage.verifyRepeatPasswordErrorMessage();
            case Privacy -> registrationPage.verifyPrivacyErrorMessage();
        }
    }
}
