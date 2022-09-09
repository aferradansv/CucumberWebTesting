package com.testing.CucumberWebTesting;

import com.testing.CucumberWebTesting.Utils.RegistrationEnum;
import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = CucumberTestApplication.class)
public class CucumberSpringConfiguration {

    @ParameterType(".*")
    public RegistrationEnum registrationEnum(String value){
        return RegistrationEnum.valueOf(value);
    }

    @DataTableType(replaceWithEmptyString = "[blank]")
    public String listOfStringListsType(String cell) {
        return cell;
    }
}
