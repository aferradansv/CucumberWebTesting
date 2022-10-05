package com.testing.CucumberWebTesting.Factories;


import com.testing.CucumberWebTesting.Utils.RegistrationInformation;
import okhttp3.*;
import org.assertj.core.api.Assertions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class DataProviderFactory {


    private final RegistrationInformation registrationInformation;


    public DataProviderFactory(RegistrationInformation registrationInformation) {
        this.registrationInformation = registrationInformation;
    }

    public void createNewCustomerByAPI() throws IOException, KeyManagementException, NoSuchAlgorithmException {

        OkHttpClient.Builder client = new OkHttpClient.Builder();

        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, new TrustManager[] { TRUST_ALL_CERTS }, new java.security.SecureRandom());
        client.sslSocketFactory(sslContext.getSocketFactory(), (X509TrustManager) TRUST_ALL_CERTS);


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

        Response response = client.build().newCall(request).execute();

        Assertions.assertThat(response.code()).isEqualTo(200);
    }


    TrustManager TRUST_ALL_CERTS = new X509TrustManager() {
        @Override
        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
        }

        @Override
        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
        }

        @Override
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return new java.security.cert.X509Certificate[] {};
        }
    };
}
