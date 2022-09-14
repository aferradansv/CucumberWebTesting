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
    private RegistrationPageWebElements webElements;

    @Autowired
    private RegistrationInformation registrationInformation;

    public RegistrationPageAct fillForm() {
        webElements.firstName.sendKeys(registrationInformation.getFirstName());
        webElements.lastname.sendKeys(registrationInformation.getLastName());
        webElements.email.sendKeys(registrationInformation.getEmailAddress());
        webElements.telephone.sendKeys(registrationInformation.getPhoneNumber());
        webElements.password.sendKeys(registrationInformation.getPassword());
        webElements.passwordConfirm.sendKeys(registrationInformation.getRepeatPassword());
        if (registrationInformation.isNewsletter()) {
            webElements.newsLetterYes.click();
        } else {
            webElements.newsLetterNo.click();
        }
        if (registrationInformation.isPrivacyPolicy()) {
            webElements.privacyPolicy.click();
        }
        return this;
    }

    public void completeRegistration() {
        webElements.continueButton.click();
    }

}
