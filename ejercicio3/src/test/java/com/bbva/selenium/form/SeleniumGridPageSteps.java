package com.bbva.selenium.form;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class SeleniumGridPageSteps {

    private String baseUri = "";

    private final SeleniumGridPage seleniumPage;

    public SeleniumGridPageSteps() {
        seleniumPage = new SeleniumGridPage();
    }

    @Given("^User navigation to ([^\"]*)$")
    public void userNavigateTo(final String url) {
        seleniumPage.goToUrl(url);
        baseUri = url;
    }

    @Given("^user is on the form page$")
    public void userIsInHomePage() {
        seleniumPage.checkFormDisplay();
    }

    @And("^the user enters name ([^\"]*), email ([^\"]*) and Skills ([^\"]*)$")
    public void enterData(final String name, final String email, final String skills) {
        seleniumPage.fillFormData(name, email, skills);
    }

    @When("^user click on send$")
    public void userClickOnSend() {
        seleniumPage.clickSend();
    }

    @Then("^user gets ([^\"]*)$")
    public void usersGetResponse(final String response) {
        seleniumPage.checkResponse(response);
    }

}
