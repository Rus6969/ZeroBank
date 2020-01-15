package com.Zerobank.utilities;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Grid_with_Desire {
    public static void main(String[] args) throws MalformedURLException {
        // Create URL for the hub
        URL url = new URL("http://localhost:6969/wd/hub");
        // create options
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName("chrome");
        desiredCapabilities.setPlatform(Platform.ANY);
        WebDriver driver = new RemoteWebDriver(url, desiredCapabilities);

        // RemoteWebDriver--> used to open browser remotely using grid
        driver.get("https://selenium.dev");
        System.out.println(driver.getTitle());
        BrowserUtils.waitFor(3);
        driver.quit();
    }
}