package com.bbva.selenium.basepage;

import com.bbva.selenium.driver.Setup;
import com.bbva.selenium.driver.Wait;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;
    protected Wait wait;

    public BasePage() {
        this.driver = Setup.driver;
        this.wait = new Wait(this.driver);
    }
}
