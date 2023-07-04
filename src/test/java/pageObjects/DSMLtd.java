package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DSMLtd {

    public WebDriver driver;

    public DSMLtd(WebDriver driver) {
        this.driver=driver;

    }

    By menuToSelectAboutUs = By.xpath("(//ul[@class='menusWhole']//li[@class='arrowDown'][1])[1]");
    By menuToSelectLeadership = By.xpath("(//ul[@class='menusWhole']//li[@class='arrowDown'][2])[1]");
    By menuToSelectOurBusiness = By.xpath("(//ul[@class='menusWhole']//li[@class='arrowDown'][3])[1]");
    By menuToSelectBusinessFacilities = By.xpath("(//ul[@class='menusWhole']//li[@class='arrowDown'][4])[1]");
    By menuToSelectInvestors = By.xpath("(//ul[@class='menusWhole']//li[@class='arrowDown'][5])[1]");

    public void clickOnAboutUS() throws InterruptedException {
        driver.findElement(menuToSelectAboutUs).click();
        Thread.sleep(2000);

    }

    public void clickOnLeaderShip() throws InterruptedException {
        driver.findElement(menuToSelectLeadership).click();
        Thread.sleep(2000);

    }

    public void clickOnOurBusiness() throws InterruptedException {
        driver.findElement(menuToSelectOurBusiness).click();
        Thread.sleep(2000);

    }

    public void clickOnBusinessFacilities() throws InterruptedException {
        driver.findElement(menuToSelectBusinessFacilities).click();
        Thread.sleep(2000);

    }

    public void clickOnInvestors() throws InterruptedException {
        driver.findElement(menuToSelectInvestors).click();
        Thread.sleep(2000);

    }

    public void closeDriver(){
        driver.close();
    }



}
