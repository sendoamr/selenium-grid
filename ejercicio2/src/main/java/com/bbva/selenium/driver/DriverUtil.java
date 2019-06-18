package com.bbva.selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverUtil {

    public static WebDriver getDriver(final String browser) throws MalformedURLException {

        switch (browser) {
            case "firefox":
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                return new RemoteWebDriver(new URL(String.format("http://%s:4444/wd/hub", System.getenv("HOST_HUB"))), DesiredCapabilities.firefox());
            case "chrome":
                return new RemoteWebDriver(new URL(String.format("http://%s:4444/wd/hub", System.getenv("HOST_HUB"))), new ChromeOptions());

        }
        return null;
    }

}
