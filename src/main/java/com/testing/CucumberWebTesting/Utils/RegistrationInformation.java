package com.testing.CucumberWebTesting.Utils;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Locale;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class RegistrationInformation {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private String password;
    private String repeatPassword;
    private boolean newsletter;
    private boolean privacyPolicy;

    Faker faker = new Faker(new Locale("en-GB"));

    public RegistrationInformation() {
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.emailAddress = faker.internet().emailAddress();
        this.phoneNumber = faker.phoneNumber().cellPhone();
        this.password = faker.internet().password();
        this.repeatPassword = this.password;
        this.newsletter = false;
        this.privacyPolicy = true;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public boolean isNewsletter() {
        return newsletter;
    }

    public void setNewsletter(boolean newsletter) {
        this.newsletter = newsletter;
    }

    public boolean isPrivacyPolicy() {
        return privacyPolicy;
    }

    public void setPrivacyPolicy(boolean privacyPolicy) {
        this.privacyPolicy = privacyPolicy;
    }

}
