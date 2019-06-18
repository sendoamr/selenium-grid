package com.bbva.selenium.form;

import com.bbva.selenium.basepage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SeleniumGridPage extends BasePage {

    //private static final String HOME_PAGE_URL = "https://www.google.";

    @FindBy(css = ".hello")
    private WebElement form;

    @FindBy(css = "input[id=nombre]")
    private WebElement nameInput;

    @FindBy(css = "input[id=e-mail]")
    private WebElement emailInput;

    @FindBy(css = "button")
    private WebElement buttonSend;

    @FindBy(css = "input[name=Selenium]")
    private WebElement skillSelenium;
    @FindBy(css = "input[name=Tests]")
    private WebElement skillTests;
    @FindBy(css = "input[name=Cucumber]")
    private WebElement skillCucumber;
    @FindBy(css = ".combobox")
    private WebElement comboSkills;


    SeleniumGridPage() {
        PageFactory.initElements(driver, this);
    }

    void goToUrl(final String url) {
        driver.get(url);
        wait.forLoading(1);
    }


    void checkFormDisplay() {
        wait.forElementToBeDisplayed(5, form, "Form");
    }

    void fillFormData(final String name, final String email, final String skills) {
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        comboSkills.click();
        switch (skills) {
            case "Selenium":
                skillSelenium.click();
                break;
            case "Tests":
                skillTests.click();
                break;
            case "Cucumber":
                skillCucumber.click();
                break;
        }

    }

    void clickSend() {
        buttonSend.click();
    }

    void checkResponse(String response) {
        if (response.equalsIgnoreCase("OK")) {
            wait.forPresenceOfElements(5, By.cssSelector("p[id='yourName']"), "name");
        } else {
            Assert.assertTrue(buttonSend.isDisplayed());
        }
    }

}
