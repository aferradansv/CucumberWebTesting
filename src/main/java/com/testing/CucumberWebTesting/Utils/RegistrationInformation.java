package com.testing.CucumberWebTesting.Utils;

import com.github.javafaker.Faker;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Locale;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
@Data
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

}
