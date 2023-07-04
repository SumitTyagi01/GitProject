package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    public WebDriver driver;
    public PageObjectManager(WebDriver driver){
        this.driver=driver;

    }

    public LandingPage landingPage;
    public OffersPage offersPage;
    public DSMLtd dsmLtd;
    public CheckoutPage checkoutPage;

    public DSMLtd DSMLandingPage(){
        dsmLtd=new DSMLtd(driver);
        return dsmLtd;

    }
    public LandingPage getLandingPage(){
        landingPage=new LandingPage(driver);
        return landingPage;

    }

    public OffersPage OffersPage(){
        offersPage=new OffersPage(driver);
        return offersPage;

    }

    public CheckoutPage getCheckoutPage(){
        checkoutPage=new CheckoutPage(driver);
        return checkoutPage;

    }

}
