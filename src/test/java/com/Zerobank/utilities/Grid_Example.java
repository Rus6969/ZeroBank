package com.Zerobank.utilities;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Grid_Example {

    public static void main(String[] args) throws MalformedURLException {
        //create url hub
        URL url= new URL("http://localhost:6969/wd/hub");
        // create options
        ChromeOptions chromeOptions = new ChromeOptions();

        /*
         FirefoxOptions firefoxOptions = new FirefoxOptions();
        // RemoteWebDriver--> used to open browser remotely using grid
        WebDriver driver = new RemoteWebDriver(url, firefoxOptions);
         */


        // RemoteWebdriver  class  use to open browser remotely using grid
        WebDriver driver= new RemoteWebDriver(url,chromeOptions);
        driver.get("https://selenium.dev");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
//http://localhost:4444/wd/hub