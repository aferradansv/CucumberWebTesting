package com.testing.CucumberWebTesting.StepDefinitions;

import com.testing.CucumberWebTesting.Pages.CommonPage.CommonPageAct;
import com.testing.CucumberWebTesting.Pages.HomePage.HomePage;
import com.testing.CucumberWebTesting.Pages.RegistrationPage.RegistrationPageAct;
import com.testing.CucumberWebTesting.Pages.RegistrationPage.RegistrationPageVerify;
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
    private CommonPageAct commonPageAct;

    @Autowired
    private RegistrationPageAct registrationPageAct;

    @Autowired
    private RegistrationPageVerify registrationPageVerify;

    @Autowired
    private RegistrationInformation registrationInformation;

    @Given("a new user opens the store web")
    public void openHomePage() {
        homePage.navigateTo();
        homePage.verifyHomePageIsDisplayed();
    }
    @Given("navigates to the registration page")
    public void i_navigate_to_the_registration_page() {
        commonPageAct.navigateToRegistrationPage();
    }

    @Then("the user is on registration page")
    public void the_user_is_on_registration_page() {
        registrationPageVerify.registrationPageIsDisplayed();
    }


    @When("the user completes the registration with correct data")
    public void theUserFillsTheForm() {
        registrationPageAct.fillForm().completeRegistration();
    }

    @Then("the registration has been completed successfully")
    public void theRegistrationHasBeenCompletedSuccessfully() {
        registrationPageVerify.registrationCompleted();
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
        registrationPageAct.fillForm().completeRegistration();
    }


    @Then("an error message in the field {registrationEnum} is displayed")
    public void anErrorMessageInTheFieldIsDisplayed(RegistrationEnum field) {
        switch (field) {
            case FirstName -> registrationPageVerify.firstNameErrorMessage();
            case LastName -> registrationPageVerify.lastNameErrorMessage();
            case EMail -> registrationPageVerify.eMailErrorMessage();
            case Telephone ->  registrationPageVerify.phoneNumberErrorMessage();
            case Password -> registrationPageVerify.passwordErrorMessage();
            case PasswordConfirm ->  registrationPageVerify.repeatPasswordErrorMessage();
            case Privacy -> registrationPageVerify.privacyErrorMessage();
        }
    }

    @Then("the registration fails since that email has been already registered")
    public void theRegistrationFailsSinceThatEmailHasBeenAlreadyRegistered() {
        registrationPageVerify.alreadyRegisteredErrorMessage();
    }
}
