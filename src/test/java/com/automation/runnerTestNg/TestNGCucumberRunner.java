package com.automation.runnerTestNg;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.automation.stepDef",
        plugin = {"pretty", "html:target/cucumber-reports.html",}

)
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {


}
