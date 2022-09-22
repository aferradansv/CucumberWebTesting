package com.testing.CucumberWebTesting.Pages.ProductDetails;

import com.testing.CucumberWebTesting.Factories.PageInitFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class ProductDetailsPageWebElements extends PageInitFactory {

    @FindBy(xpath = "//div[@id='input-option218']//input[@value='5']")
    public WebElement smallSize;

    @FindBy(xpath = "//div[@id='input-option218']//input[@value='7']")
    public WebElement largeSize;

    @FindBy(xpath = "//div[@id='input-option223']//input[@value='8']")
    public WebElement checkbox1;

    @FindBy(xpath = "//div[@id='input-option223']//input[@value='9']")
    public WebElement checkbox2;

    @FindBy(xpath = "//div[@id='input-option223']//input[@value='10']")
    public WebElement checkbox3;

    @FindBy(xpath = "//div[@id='input-option223']//input[@value='11']")
    public WebElement checkbox4;

    @FindBy(id = "input-option208")
    public WebElement textBar;

    @FindBy(id = "input-option217")
    public WebElement selectDropBox;

    @FindBy(id = "input-option209")
    public WebElement textBox;

    @FindBy(id = "button-upload222")
    public WebElement uploadButton;

    @FindBy(id = "input-option222")
    public WebElement uploadInput;

    @FindBy(id = "input-option219")
    public WebElement date;

    @FindBy(id = "input-option221")
    public WebElement time;

    @FindBy(id = "input-option220")
    public WebElement dateTime;

    @FindBy(id = "input-quantity")
    public WebElement quantity;

    @FindBy(id = "button-cart")
    public WebElement addToCart;
}
