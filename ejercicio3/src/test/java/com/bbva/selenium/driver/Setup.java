package com.bbva.selenium.driver;

import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class Setup {

    public static WebDriver driver;

    @Before
    public void setWebDriver() throws Exception {

        final String capability;

        capability = System.getProperty("browser");
        switch (capability) {
            case "firefox":

                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                driver = new RemoteWebDriver(new URL("http://172.24.0.2:4444/wd/hub"), DesiredCapabilities.firefox());
                break;
            case "chrome":
                driver = new RemoteWebDriver(new URL("http://172.24.0.2:4444/wd/hub"), new ChromeOptions());
                break;

        }
    }
}
