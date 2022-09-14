package com.testing.CucumberWebTesting.StepDefinitions;

import com.testing.CucumberWebTesting.Pages.HomePage;
import com.testing.CucumberWebTesting.Pages.LogInPage.LogInPageAct;
import com.testing.CucumberWebTesting.Pages.LogInPage.LogInPageVerify;
import com.testing.CucumberWebTesting.Pages.MyAccountPage.MyAccountPageVerify;
import com.testing.CucumberWebTesting.Utils.AuthenticationData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class LogInStepDef {

    @Autowired
    private HomePage homePage;

    @Autowired
    private LogInPageAct logInPageAct;

    @Autowired
    private LogInPageVerify logInPageVerify;

    @Autowired
    private MyAccountPageVerify myAccountPageVerify;

    @Given("navigates to the login page")
    public void navigates_to_the_login_page() {
        homePage.navigateToLogInPage();
    }

    @Given("the user is on login page")
    public void the_user_is_on_login_page() {
        logInPageVerify.logInPageIsDisplayed();
    }

    @When("the user introduces valid credentials")
    public void logIn_using_valid_credentials() {
        logInPageAct.fillCredentials(AuthenticationData.TEST_USER_EMAIL.get(),AuthenticationData.TEST_USER_PASSWORD.get()).completeLogIn();
    }

    @When("the user introduces valid username and wrong password")
    public void logIn_using_wrong_password() {
        logInPageAct.fillCredentials(AuthenticationData.TEST_USER_EMAIL.get(),AuthenticationData.TEST_USER_PASSWORD_WRONG.get()).completeLogIn();
    }

    @When("the user introduces valid password and wrong username")
    public void logIn_using_wrong_username() {
        logInPageAct.fillCredentials(AuthenticationData.TEST_USER_EMAIL_NON_EXISTING.get(),AuthenticationData.TEST_USER_PASSWORD.get()).completeLogIn();
    }

    @Then("the user can see My personal account page")
    public void i_can_see_my_personal_account_page() {
        myAccountPageVerify.myAccountPageIsDisplayed();
    }


    @Then("a error message is shown to the customer and user can not log In")
    public void aErrorMessageIsShownToTheCustomerAndUserCanNotLogIn() {
        logInPageVerify.assertLogInErrorMessage();
        logInPageVerify.logInPageIsDisplayed();
    }
}
