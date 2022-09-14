package com.testing.CucumberWebTesting.Utils;

public enum AuthenticationData {

    TEST_USER_EMAIL("user@testemail.com"),
    TEST_USER_PASSWORD("password01"),
    TEST_USER_EMAIL_NON_EXISTING("nonregistered@hello.com"),
    TEST_USER_PASSWORD_WRONG("wrongPassword");

    private String stringValue;

    AuthenticationData(String value) {
        this.stringValue = value;
    }

    public String get() {
        return stringValue;
    }
}
