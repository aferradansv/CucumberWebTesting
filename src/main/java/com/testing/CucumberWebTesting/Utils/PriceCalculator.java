package com.testing.CucumberWebTesting.Utils;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class PriceCalculator {

    private double finalPrice;
    private double finalPriceBeforeTaxes;

    public void addToFinalPrice(double price){
        finalPrice += price;
    }

    public double getFinalPrice(){
        return finalPrice;
    }

    public void addToFinalPriceBeforeTaxes(double price){
        finalPriceBeforeTaxes += price;
    }

    public double getFinalPriceBeforeTaxes(){
        return finalPriceBeforeTaxes;
    }

}
