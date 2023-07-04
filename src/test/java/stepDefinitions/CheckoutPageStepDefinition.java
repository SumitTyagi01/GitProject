package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {

    //public WebDriver driver;
    public String productName;
    public String productNameFetched;
    CheckoutPage checkoutPage;
    TestContextSetup testContextSetup;

    public CheckoutPageStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
    }

    @Then("verify user has ability to enter promo code and place the order")
    public void verify_user_has_ability_to_enter_promo_code_and_place_the_order()
    {

        Assert.assertTrue(checkoutPage.verifyPromoBtn());
        Assert.assertTrue(checkoutPage.verifyPlaceOrderBtn());

    }

    @Then("^User proceed to checkout and validate the (.+) items in the checkout page$")
    public void User_proceed_to_checkout_and_validate(String name) throws InterruptedException {
        checkoutPage.checkOutItems();
        Thread.sleep(2000);

    }
}
