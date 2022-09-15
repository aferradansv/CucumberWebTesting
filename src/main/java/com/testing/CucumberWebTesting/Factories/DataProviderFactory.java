package com.testing.CucumberWebTesting.Factories;


import com.testing.CucumberWebTesting.Utils.RegistrationInformation;
import okhttp3.*;
import org.assertj.core.api.Assertions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class DataProviderFactory {


    private RegistrationInformation registrationInformation;


    public DataProviderFactory(RegistrationInformation registrationInformation) {
        this.registrationInformation = registrationInformation;
    }

    public void createNewCustomerByAPI() throws IOException {

        OkHttpClient client = new OkHttpClient();

        RequestBody body = new FormBody.Builder()
                .add("customer_group_id", "1")
                .add("firstname", registrationInformation.getFirstName())
                .add("lastname", registrationInformation.getLastName())
                .add("email", registrationInformation.getEmailAddress())
                .add("telephone", registrationInformation.getPhoneNumber())
                .add("password", registrationInformation.getPassword())
                .add("confirm", registrationInformation.getRepeatPassword())
                .add("newsletter", "0")
                .add("agree", "1")
                .build();

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("https")
                .host("opencart.abstracta.us")
                .addPathSegment("index.php")
                .addQueryParameter("route", "account/register")
                .build();

        Request request = new Request.Builder()
                .post(body)
                .url(httpUrl)
                .build();

        Response response = client.newCall(request).execute();

        Assertions.assertThat(response.code()).isEqualTo(200);
    }
}
