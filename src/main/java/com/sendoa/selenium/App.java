package com.sendoa.selenium;

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
            driver.manage().window().setSize(new Dimension(1440, 900));
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
        Assert.assertTrue(true);
    }

    private static void setDriver() throws MalformedURLException {
        String driverType = System.getProperty("driver");

        String capability;
        DesiredCapabilities capabilities;

        switch (driverType) {
            case "firefox":
                capabilities = DesiredCapabilities.firefox();
                System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver linux64");

                capabilities.setCapability("marionette", true);
                capabilities.setCapability("acceptInsecureCerts", true);

                driver = new FirefoxDriver(capabilities);
                break;
            case "chrome":
                System.setProperty("webdriver.gecko.driver", "./drivers/chromedriver_linux64");
                driver = new ChromeDriver(new ChromeOptions());
                break;
            case "hub":
                capability = System.getProperty("remote_browser");
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

                        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
                        driver = new RemoteWebDriver(new URL("http://hub:4444/wd/hub"), DesiredCapabilities.firefox());
                        break;
                    case "chrome":
                        driver = new RemoteWebDriver(new URL("http://hub:4444/wd/hub"), DesiredCapabilities.chrome());
                        break;

                }
        }
    }
}
