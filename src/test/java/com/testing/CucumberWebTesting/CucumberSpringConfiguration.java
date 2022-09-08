package com.testing.CucumberWebTesting;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = CucumberTestApplication.class)
public class CucumberSpringConfiguration {
}
