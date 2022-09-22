package com.testing.CucumberWebTesting.Pages.ShoppingCartPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class ShoppingCartAct {

    @Autowired
    private ShoppingCartWebElements webElements;

    public void removeProductsFromShoppingCart(int productAmount) {
        for (int i = 0; i < productAmount; i++) {
            webElements.removeButtons.get(i).click();
        }
    }

    public void changeProductAmount(String newProductAmount) {
        webElements.quantity.get(0).clear();
        webElements.quantity.get(0).sendKeys(newProductAmount);
        webElements.updateButtons.get(0).click();
    }

    public void proceedToCheckout() {
        webElements.checkOutButton.click();
    }
}
