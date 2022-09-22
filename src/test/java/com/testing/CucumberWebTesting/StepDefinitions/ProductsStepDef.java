package com.testing.CucumberWebTesting.StepDefinitions;

import com.testing.CucumberWebTesting.Pages.CommonPage.CommonPageAct;
import com.testing.CucumberWebTesting.Pages.ProductDetails.ProductDetailsPageAct;
import com.testing.CucumberWebTesting.Pages.ProductsPage.ProductsPageAct;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ProductsStepDef {

    @Autowired
    private CommonPageAct commonPageAct;

    @Autowired
    private ProductsPageAct productsPageAct;

    @Autowired
    private ProductDetailsPageAct productDetailsPageAct;

    @And("the user navigates to the monitors product page")
    public void theUserNavigatesToTheMonitorsProductPage() {
        commonPageAct.navigateToMonitorProducts();

    }

    @And("the customer selects the {string} monitor")
    public void theCustomerSelectsTheMonitor(String monitorType) {
        productsPageAct.selectMonitorAppleCinema();
    }

    @When("the customer chooses the following options")
    public void theCustomerChoosesTheFollowingOptions(DataTable table) throws IOException {
        productDetailsPageAct.selectProductDetailsOptions(table.asMaps().get(0)).addProductToCart();
    }

}
