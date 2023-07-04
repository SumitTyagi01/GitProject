package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefinition {

    public String productNameFetched;
    TestContextSetup testContextSetup;
    PageObjectManager pageObjectManager;

    // Factory Design Pattern
    public OfferPageStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup=testContextSetup;

    }

    @Then("^User searched for (.+) shortname in offers page$")
    public void user_searched_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {

        Thread.sleep(3000);
        switchToOffersPage();
        OffersPage offersPage =  testContextSetup.pageObjectManager.OffersPage();
        offersPage.searchItem(shortName);
        productNameFetched = offersPage.getProductName();
        System.out.println("Product name fetched from Offers Page:" + productNameFetched);
    }

    public void switchToOffersPage() throws InterruptedException {


        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.selectTopDealsPage();
        Thread.sleep(3000);
        testContextSetup.genericUtils.SwitchWindowToChild();

    }


    @Then("Validate product name in offer page matches with landing page")
    public void validate_product_name_in_offer_page_matches_with_landing_page() {

        Assert.assertEquals(testContextSetup.productName,productNameFetched,"Both the names are not same!!");
    }


}
