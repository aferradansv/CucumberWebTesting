package com.testing.CucumberWebTesting.Pages.RegistrationPage;

import com.testing.CucumberWebTesting.Utils.RegistrationInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class RegistrationPageAct {

    @Autowired
    private RegistrationPageWebElements registrationPageWebElements;

    @Autowired
    private RegistrationInformation registrationInformation;

    public RegistrationPageAct fillForm() {
        registrationPageWebElements.firstName.sendKeys(registrationInformation.getFirstName());
        registrationPageWebElements.lastname.sendKeys(registrationInformation.getLastName());
        registrationPageWebElements.email.sendKeys(registrationInformation.getEmailAddress());
        registrationPageWebElements.telephone.sendKeys(registrationInformation.getPhoneNumber());
        registrationPageWebElements.password.sendKeys(registrationInformation.getPassword());
        registrationPageWebElements.passwordConfirm.sendKeys(registrationInformation.getRepeatPassword());
        if (registrationInformation.isNewsletter()) {
            registrationPageWebElements.newsLetterYes.click();
        } else {
            registrationPageWebElements.newsLetterNo.click();
        }
        if (registrationInformation.isPrivacyPolicy()) {
            registrationPageWebElements.privacyPolicy.click();
        }
        return this;
    }

    public void completeRegistration() {
        registrationPageWebElements.continueButton.click();
    }

}
