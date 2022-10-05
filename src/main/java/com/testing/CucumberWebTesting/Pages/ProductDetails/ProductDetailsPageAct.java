package com.testing.CucumberWebTesting.Pages.ProductDetails;

import com.testing.CucumberWebTesting.Utils.PriceCalculator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class ProductDetailsPageAct {

    @Autowired
    private ProductDetailsPageWebElements webElements;

    @Autowired
    private WebDriver webDriver;

    @Autowired
    private WebDriverWait webDriverWait;

    @Autowired
    private PriceCalculator priceCalculator;

    public ProductDetailsPageAct selectProductDetailsOptions(Map<String, String> options) {
        if (options.get("radioOption").equalsIgnoreCase("small"))
            webElements.smallSize.click();
        else if (options.get("radioOption").equalsIgnoreCase("large"))
            webElements.largeSize.click();

        List<String> checkboxes = List.of(options.get("checkBox").split(","));
        for (String checkbox : checkboxes) {
            if (checkbox.equalsIgnoreCase("1"))
                webElements.checkbox1.click();
            if (checkbox.equalsIgnoreCase("2"))
                webElements.checkbox2.click();
            if (checkbox.equalsIgnoreCase("3"))
                webElements.checkbox3.click();
            if (checkbox.equalsIgnoreCase("4"))
                webElements.checkbox4.click();
        }

        Select objSelect = new Select(webElements.selectDropBox);
        if (options.get("color").equalsIgnoreCase("Green"))
            objSelect.selectByValue("1");
        if (options.get("color").equalsIgnoreCase("Yellow"))
            objSelect.selectByValue("2");
        if (options.get("color").equalsIgnoreCase("Blue"))
            objSelect.selectByValue("3");
        if (options.get("color").equalsIgnoreCase("Red"))
            objSelect.selectByValue("4");

        webElements.textBar.sendKeys("Anything goes here");
        webElements.textBox.sendKeys("blah blah blah");

        ((JavascriptExecutor) webDriver).executeScript("document.getElementById('input-option222').setAttribute('type', 'text');");
        File uploadExec = new File("src/main/java/com/testing/CucumberWebTesting/Utils/FakeFileUpload.txt");
        webElements.uploadButton.sendKeys(uploadExec.getAbsolutePath());

//        Unused code to use AutoIt to upload a file using windows
//        webElements.uploadButton.click();
//        File uploadExec = new File("src/main/java/com/testing/CucumberWebTesting/Utils/FakeFileUpload.txt");
//        Runtime.getRuntime().exec(uploadExec.getAbsolutePath());
//        webDriverWait.until(ExpectedConditions.alertIsPresent());
//        webDriver.switchTo().alert().accept();

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        webElements.date.sendKeys(df.format(now));
        webElements.time.sendKeys(tf.format(now));
        webElements.dateTime.sendKeys(dtf.format(now));

        webElements.quantity.clear();
        webElements.quantity.sendKeys(options.get("quantity"));

        return this;
    }

    public void addProductToCart() {
        webElements.addToCart.click();
    }
}
