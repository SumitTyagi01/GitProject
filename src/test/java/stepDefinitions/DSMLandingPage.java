package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DSMLtd;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class DSMLandingPage {

    TestContextSetup testContextSetup;

    public DSMLandingPage(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    @Given("User is on DSM landing page")
    public void user_is_on_dsm_landing_page() {

    }
    @When("User clicks on About us drop down")
    public void user_clicks_on_about_us_drop_down() throws InterruptedException {

        DSMLtd dsmLtd = testContextSetup.pageObjectManager.DSMLandingPage();
        dsmLtd.clickOnAboutUS();
        Thread.sleep(2000);


    }

    @When("User clicks on Leadership drop down")
    public void user_clicks_on_leadership_drop_down() throws InterruptedException {

        DSMLtd dsmLtd = testContextSetup.pageObjectManager.DSMLandingPage();
        dsmLtd.clickOnLeaderShip();
        Thread.sleep(2000);

    }

    @When("User clicks on Our Business drop down")
    public void user_clicks_on_our_business_drop_down() throws InterruptedException {

        DSMLtd dsmLtd = testContextSetup.pageObjectManager.DSMLandingPage();
        dsmLtd.clickOnOurBusiness();
        Thread.sleep(2000);

    }


    @When("User clicks on Business facilities drop down")
    public void user_clicks_on_business_facilities_drop_down() throws InterruptedException {

        DSMLtd dsmLtd = testContextSetup.pageObjectManager.DSMLandingPage();
        dsmLtd.clickOnBusinessFacilities();
        Thread.sleep(2000);

    }

    @When("User clicks on Investors drop down")
    public void user_clicks_on_Investors_drop_down() throws InterruptedException {

        DSMLtd dsmLtd = testContextSetup.pageObjectManager.DSMLandingPage();
        dsmLtd.clickOnInvestors();
        Thread.sleep(2000);

    }

    @Then("Validate that the menus are displayed")
    public void validate_that_the_menus_are_displayed() throws InterruptedException {
        DSMLtd dsmLtd = testContextSetup.pageObjectManager.DSMLandingPage();
        dsmLtd.closeDriver();
    }
}
