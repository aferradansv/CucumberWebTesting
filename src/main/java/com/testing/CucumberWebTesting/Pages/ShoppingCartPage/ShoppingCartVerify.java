package com.testing.CucumberWebTesting.Pages.ShoppingCartPage;

import com.testing.CucumberWebTesting.Utils.PriceCalculator;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class ShoppingCartVerify {

    @Autowired
    private ShoppingCartWebElements webElements;

    @Autowired
    private PriceCalculator priceCalculator;

    public void numberOfProducts(int productsExpected) {
        int productsFound = 0;
        for (WebElement element : webElements.quantity) {
            productsFound += Integer.parseInt(element.getAttribute("value"));
        }
        Assertions.assertThat(productsFound).isEqualTo(productsExpected);
    }

    public void pricesMatch() {
        List<WebElement> rows_table = webElements.pricesTable.findElements(By.tagName("tr"));
        for (WebElement rows : rows_table) {
            List<WebElement> columnsList = rows.findElements(By.tagName("td"));
            if (columnsList.get(0).getText().equalsIgnoreCase("Sub-Total:"))
                Assertions.assertThat(priceCalculator.getFinalPriceBeforeTaxes())
                        .isEqualTo(Double.parseDouble(columnsList.get(1).getText().replaceAll("\\p{Sc}", "")));

            if (columnsList.get(0).getText().equalsIgnoreCase("Total:"))
                Assertions.assertThat(priceCalculator.getFinalPrice())
                        .isEqualTo(Double.parseDouble(columnsList.get(1).getText().replaceAll("\\p{Sc}", "")));

        }
    }


}
