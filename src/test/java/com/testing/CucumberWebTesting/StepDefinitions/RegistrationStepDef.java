package com.testing.CucumberWebTesting.StepDefinitions;

import com.testing.CucumberWebTesting.Pages.HomePage;
import com.testing.CucumberWebTesting.Pages.RegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class RegistrationStepDef {

    @Autowired
    private HomePage homePage;

    @Autowired
    private RegistrationPage registrationPage;

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        homePage.navigateTo();
        homePage.verifyHomePageIsDisplayed();
    }
    @When("I navigate to the registration page")
    public void i_navigate_to_the_registration_page() {
        homePage.navigateToRegistrationPage();
    }

    @Then("the user is on registration page")
    public void the_user_is_on_registration_page() {
        registrationPage.verifyRegistrationPageIsDisplayed();
    }


}
