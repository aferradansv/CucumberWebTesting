package com.testing.CucumberWebTesting.Pages.ShoppingCartPage;

import com.testing.CucumberWebTesting.Factories.PageInitFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class ShoppingCartWebElements extends PageInitFactory {

    @FindBy(xpath = "//input[contains(@name,'quantity')]")
    public List<WebElement> quantity;

    @FindBy(xpath = "//div[@class='col-sm-4 col-sm-offset-8']/table")
    public WebElement pricesTable;

    @FindBy(xpath = "//div[@class='input-group btn-block']//button[@class='btn btn-danger']")
    public List<WebElement> removeButtons;

    @FindBy(xpath = "//div[@class='input-group btn-block']//button[@class='btn btn-primary']")
    public List<WebElement> updateButtons;

    @FindBy(linkText = "Checkout")
    public WebElement checkOutButton;

}
