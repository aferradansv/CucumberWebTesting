package com.testing.CucumberWebTesting.Pages.ProductsPage;

import com.testing.CucumberWebTesting.Factories.PageInitFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class ProductsPageWebElements extends PageInitFactory {

    @FindBy(xpath = "//span[text()='Add to Cart']")
    public List<WebElement> addToCartButtonsList;

    @FindBy(xpath = "//div[@class='product-thumb']//p[@class='price']")
    public List<WebElement> price;

    @FindBy(xpath = "//div[@class='product-thumb']//span[@class='price-tax']")
    public List<WebElement> priceBeforeTax;

    @FindBy(className = "image")
    public List<WebElement> productImages;

}
