package com.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/features",
        glue = { "com.steps" },
        tags = "@smoke",
        plugin = { "pretty", "html:test-output/cucumber-reports/cucumber-pretty","json:test-output/cucumber-reports/CucumberTestReport.json"},
        monochrome = true)

public class Runner {

}

