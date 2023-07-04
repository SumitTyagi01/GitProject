package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.LandingPage;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class LandingPageStepDefinition {

    //public WebDriver driver;
    public String productName;
    public String productNameFetched;
    TestContextSetup testContextSetup;
    LandingPage landingPage;

    public LandingPageStepDefinition(TestContextSetup testContextSetup)
    {
        this.testContextSetup = testContextSetup;
        landingPage = testContextSetup.pageObjectManager.getLandingPage();
    }

    @Given("User is on GreenCart Landing Page")
    public void user_is_on_green_cart_landing_page() {
        Assert.assertTrue(this.landingPage.getTitleLandingPage().contains("GreenKart"));

    }

    @When("^User search with shortname (.+) and extracted actual name of product$")
    public void user_search_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
        Thread.sleep(3000);
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.searchItem(shortName);
        Thread.sleep(2000);
        testContextSetup.productName = landingPage.getProductName().split("-")[0].trim();
        System.out.println("Product name extracted from home page: "+ testContextSetup.productName);

    }

    @When("Added {string} items of the selected product to the cart")
    public void Added_items_of_the_selected_product_to_the_cart(String quantity) throws InterruptedException {

            landingPage.AddIncrementItems(quantity);
            landingPage.AddToCartBtn();

    }


}
