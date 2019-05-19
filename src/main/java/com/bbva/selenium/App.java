package com.bbva.selenium;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private final static Logger LOG = LoggerFactory.getLogger(App.class);

    public static WebDriver driver;


    public static void openDriver() throws Exception {
        if (driver == null) {
            LOG.info("Init driver");
            setDriver();
            String width = System.getProperty("width");
            String height = System.getProperty("height");
            driver.manage().window().setSize(new Dimension((width == null ? 1440 : Integer.valueOf(width)), (height == null ? 900 : Integer.valueOf(height))));
        }
    }

    public static void closeDriver() {
        LOG.info("driver.quit");
        try {
            driver.quit();
            driver.close();
        } catch (Exception e) {
            LOG.error("Error closing Driver", e);
        } finally {
            driver = null;
        }
    }

    public static void launch()  {
        driver.navigate().to(System.getProperty("url"));
        Assert.assertEquals(driver.getCurrentUrl(), System.getProperty("url"));
    }

    private static void setDriver() throws MalformedURLException {

        String capability;
        DesiredCapabilities capabilities;

        capability = System.getProperty("browser");
        switch (capability) {
            case "firefox":
                capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
                FirefoxProfile ffProfile = new FirefoxProfile();
                ffProfile.setPreference("javascript.enabled", true);
                capabilities.setCapability(FirefoxDriver.PROFILE, ffProfile);
                capabilities.setCapability("marionette", true);
                capabilities.setCapability("acceptInsecureCerts", true);
                capabilities.setCapability("javascriptEnabled", true);

                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                driver = new RemoteWebDriver(new URL("http://172.17.0.3:4444/wd/hub"), DesiredCapabilities.firefox());
                break;
            case "chrome":
                driver = new RemoteWebDriver(new URL("http://172.17.0.3:4444/wd/hub"), new ChromeOptions());
                break;

        }
    }

}
