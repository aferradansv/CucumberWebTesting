package com.testing.CucumberWebTesting.Pages.ProductsPage;

import com.testing.CucumberWebTesting.Utils.PriceCalculator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class ProductsPageAct {

    @Autowired
    private ProductsPageWebElements webElements;

    @Autowired
    private WebDriver webDriver;

    @Autowired
    private PriceCalculator priceCalculator;

    public void addToCartProductFromList(int position) {
        priceCalculator.addToFinalPrice(Double.parseDouble(webElements.price.get(position).getText()
                .split("\n")[0].replaceAll("\\p{Sc}", "").trim()));

        priceCalculator.addToFinalPriceBeforeTaxes(Double.parseDouble(webElements.priceBeforeTax.get(position).getText()
                .replace("Ex Tax: ", "").replaceAll("\\p{Sc}", "").trim()));

        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", webElements.addToCartButtonsList.get(position));
        webElements.addToCartButtonsList.get(position).click();
    }


    public void selectMonitorAppleCinema() {
        webElements.productImages.get(0).click();
    }
}
