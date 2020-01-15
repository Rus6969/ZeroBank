package com.Zerobank.step_definitions;

import com.Zerobank.utilities.BrowserUtils;
import com.Zerobank.utilities.Driver;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before
    public void setUp(){
        System.out.println("\tThis runner before scenario");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void teatDown(Scenario scenario){
        System.out.println("This comming After scenario\n");
        if(scenario.isFailed()){
            final byte [] screenshoot=((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshoot,"image/png");

        }
        Driver.closeDriver();

    }

    @After("@sales_manager")
    public void tearDownSalesManager(){
        System.out.println("this comming after scenarion for sales manager\n");
    }

}


