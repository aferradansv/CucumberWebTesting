package com.testing.CucumberWebTesting.StepDefinitions;

import com.testing.CucumberWebTesting.Factories.DataProviderFactory;
import com.testing.CucumberWebTesting.Pages.HomePage;
import com.testing.CucumberWebTesting.Pages.LogInPage.LogInPageAct;
import com.testing.CucumberWebTesting.Pages.LogInPage.LogInPageVerify;
import com.testing.CucumberWebTesting.Pages.LogOutPage.LogOutPageVerify;
import com.testing.CucumberWebTesting.Pages.MyAccountPage.MyAccountPageVerify;
import com.testing.CucumberWebTesting.Utils.RegistrationInformation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class LogInOutStepDef {

    @Autowired
    private HomePage homePage;

    @Autowired
    private LogInPageAct logInPageAct;

    @Autowired
    private LogInPageVerify logInPageVerify;

    @Autowired
    private MyAccountPageVerify myAccountPageVerify;

    @Autowired
    private DataProviderFactory dataProvider;

    @Autowired
    private RegistrationInformation regInfo;

    @Autowired
    private LogOutPageVerify logOutPageVerify;

    @Given("an existing customer user opens the store web")
    public void anExistingCustomerUserOpensTheStoreWeb() throws IOException {
        dataProvider.createNewCustomerByAPI();
        homePage.navigateTo();
        homePage.verifyHomePageIsDisplayed();
    }

    @Given("navigates to the login page")
    public void navigatesToTheLoginPage() {
        homePage.navigateToLogInPage();
    }

    @Given("the user is on login page")
    public void theUserIsOnLoginPage() {
        logInPageVerify.logInPageIsDisplayed();
    }

    @And("the customer logs in")
    public void theCustomerLogsIn() {
        navigatesToTheLoginPage();
        theUserIsOnLoginPage();
        logInUsingValidCredentials();
        verifyMyPersonalAccountPageIsDisplayed();
    }

    @When("the user introduces valid credentials")
    public void logInUsingValidCredentials() {
        logInPageAct.fillCredentials(regInfo.getEmailAddress(), regInfo.getPassword()).completeLogIn();
    }

    @When("the user introduces valid username and wrong password")
    public void logInUsingWrongPassword() {
        logInPageAct.fillCredentials(regInfo.getEmailAddress(),"wrongPassword123").completeLogIn();
    }

    @When("the user introduces valid password and wrong username")
    public void logInUsingWrongUsername() {
        logInPageAct.fillCredentials("lkdjlaksjdlas@sdkjashdkjasdhas.com",regInfo.getPassword()).completeLogIn();
    }

    @Then("the user can see My personal account page")
    public void verifyMyPersonalAccountPageIsDisplayed() {
        myAccountPageVerify.myAccountPageIsDisplayed();
    }


    @Then("a error message is shown to the customer and user can not log In")
    public void aErrorMessageIsShownToTheCustomerAndUserCanNotLogIn() {
        logInPageVerify.assertLogInErrorMessage();
        logInPageVerify.logInPageIsDisplayed();
    }


    @When("the customer logs out successfully")
    public void theCustomerLogsOutSuccessfully() {
        homePage.LogOut();
    }

    @Then("the customer can see the log out page")
    public void theCustomerCanSeeTheLogOutPage() {
        logOutPageVerify.logOutPageIsDisplayed();
    }



}
