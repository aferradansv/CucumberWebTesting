package com.testing.CucumberWebTesting.StepDefinitions;

import com.testing.CucumberWebTesting.Pages.CommonPage.CommonPageAct;
import com.testing.CucumberWebTesting.Pages.ProductsPage.ProductsPageAct;
import com.testing.CucumberWebTesting.Pages.ShoppingCartPage.ShoppingCartAct;
import com.testing.CucumberWebTesting.Pages.ShoppingCartPage.ShoppingCartVerify;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class ShoppingCartStepDef {

    @Autowired
    private ProductsPageAct productsPageAct;

    @Autowired
    private CommonPageAct commonPageAct;

    @Autowired
    private ShoppingCartVerify shoppingCartVerify;

    @Autowired
    private ShoppingCartAct shoppingCartAct;

    @When("the user navigates to the Phones & PDAs product page")
    public void theUserNavigatesToThePhonesPDAsProductPage() {
        commonPageAct.navigateToPhonesPdaProducts();
    }

    @When("the customer removes {int} product")
    public void theCustomerRemovesProduct(int productAmount) {
        shoppingCartAct.removeProductsFromShoppingCart(productAmount);
    }

    @When("the customer changes the amount to {int}")
    public void theCustomerChangesTheAmountTo(int productAmount) {
        shoppingCartAct.changeProductAmount(String.valueOf(productAmount));
    }

    @And("the customer adds {int} product in the position {int} to the shopping cart")
    public void theCustomerAddsTheProductInThePositionToTheShoppingCart(int productAmount, int productPosition) throws InterruptedException {
        for (int i=0; i<productAmount;i++) {
            productsPageAct.addToCartProductFromList(productPosition);
        }
    }

    @Then("the shopping cart will show {int} product(s)")
    public void theShoppingCartWillShowProducts(int productAmount) {
        commonPageAct.navigateToShoppingCart();
        shoppingCartVerify.numberOfProducts(productAmount);
    }

    @And("the prices are calculated correctly")
    public void thePricesAreCalculatedCorrectly() {
        shoppingCartVerify.pricesMatch();
    }

    @Then("the shopping cart will still show the {int} product(s) selected")
    public void theShoppingCartWillStillShowTheProductSelected(int productAmount) {
        commonPageAct.navigateToShoppingCart();
        shoppingCartVerify.numberOfProducts(productAmount);
        shoppingCartVerify.pricesMatch();
    }


    @When("The customer clicks checkout Button")
    public void theCustomerClicksCheckoutButton() {
        shoppingCartAct.proceedToCheckout();
    }


}
