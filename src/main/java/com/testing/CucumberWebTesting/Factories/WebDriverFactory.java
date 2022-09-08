package com.testing.CucumberWebTesting.Factories;

import io.cucumber.core.exception.CucumberException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class WebDriverFactory {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    @Value("${current.browser}")
    private String browser;

    @Value("${browser.headless}")
    private boolean headless;

    @Bean
    @Scope(SCOPE_CUCUMBER_GLUE)
    public WebDriver getDriver() {
        if (driver == null) {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless) {
                    chromeOptions.addArguments("--headless");
                }
                driver = new ChromeDriver(chromeOptions);
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (headless) {
                    firefoxOptions.addArguments("--headless");
                }
                driver = new FirefoxDriver(firefoxOptions);
            } else if (browser.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                driver = new EdgeDriver(edgeOptions);
            } else {
                throw new CucumberException("The driver should be one of the following Chrome, Firefox or Edge");
            }
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        }
        return driver;

    }

    @Bean
    @Scope(SCOPE_CUCUMBER_GLUE)
    public WebDriverWait getWebDriverWait () {
        if (webDriverWait == null) {
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        }
        return webDriverWait;
    }
}
