package com.testing.CucumberWebTesting.Pages.RegistrationPage;

import com.testing.CucumberWebTesting.Pages.CommonPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class RegistrationPageWebElements extends CommonPage {

    @FindBy(id = "input-firstname")
    public WebElement firstName;

    @FindBy(id = "input-lastname")
    public WebElement lastname;

    @FindBy(id = "input-email")
    public WebElement email;

    @FindBy(id = "input-telephone")
    public WebElement telephone;

    @FindBy(id = "input-password")
    public WebElement password;

    @FindBy(id = "input-confirm")
    public WebElement passwordConfirm;

    @FindBy(xpath = "//input[@name = 'agree']")
    public WebElement privacyPolicy;

    @FindBy(xpath = "//input[@name = 'newsletter' and @value = '1']")
    public WebElement newsLetterYes;

    @FindBy(xpath = "//input[@name = 'newsletter' and @value = '0']")
    public WebElement newsLetterNo;

    @FindBy(xpath = "//input[@value = 'Continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//p[contains(text(), 'Congratulations!')]")
    public WebElement congratulationsText;

    @FindBy(xpath = "//div[@class = 'alert alert-danger alert-dismissible']")
    public WebElement alertAgreeConditions;

    @FindBy(xpath = "//div[@class = 'text-danger' and contains(text(), 'First Name')]")
    public WebElement alertFirstName;

    @FindBy(xpath = "//div[@class = 'text-danger' and contains(text(), 'Last Name')]")
    public WebElement alertSecondName;

    @FindBy(xpath = "//div[@class = 'text-danger' and contains(text(), 'E-Mail')]")
    public WebElement alertEmail;

    @FindBy(xpath = "//div[@class = 'text-danger' and contains(text(), 'Telephone')]")
    public WebElement alertTelephone;

    @FindBy(xpath = "//div[@class = 'text-danger' and contains(text(), 'Password must be')]")
    public WebElement alertPassword;

    @FindBy(xpath = "//div[@class = 'text-danger' and contains(text(), 'Password confirmation')]")
    public WebElement alertConfirmPassword;


}