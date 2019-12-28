package com.Zerobank.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",glue ="com/Zerobank/step_definitions",dryRun=false,
        tags = "@wip",
        plugin = {"json:target/cucumber.json",
                "html:target/default-cucumber-reports"})
public class CukeRunner {

}
