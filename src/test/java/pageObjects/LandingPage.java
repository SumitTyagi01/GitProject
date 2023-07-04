package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver=driver;

    }

    private By search = By.xpath("//input[@type='search']");
    private By productName = By.cssSelector("h4.product-name");
    private By topDeals = By.xpath("//a[@href='#/offers']");
    private By plusIcon = By.xpath("(//a[@class='increment'])[1]");
    private By addToCartBtn = By.xpath("(//button[text()='ADD TO CART'])[1]");

    public void searchItem(String searchName){
        driver.findElement(search).sendKeys(searchName);
    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }

    public void selectTopDealsPage(){
        driver.findElement(topDeals).click();
    }

    public String getTitleLandingPage()
    {
        return driver.getTitle();
    }

    public void AddIncrementItems(String quantity) throws InterruptedException {
        int i=1;
        while(i<Integer.parseInt(quantity))
        {
            driver.findElement(plusIcon).click();
            Thread.sleep(1000);
            i++;
        }

    }

    public void AddToCartBtn() {
        driver.findElement(addToCartBtn).click();
    }
}
