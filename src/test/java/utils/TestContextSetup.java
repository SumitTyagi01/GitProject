package utils;

import org.openqa.selenium.WebDriver;
import pageObjects.PageObjectManager;
import java.io.IOException;

public class TestContextSetup {

    public WebDriver driver;
    public String productName;
    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;
    public static startDockerContainer dockerContainer;


   public TestContextSetup() throws IOException, InterruptedException {

       if(dockerContainer==null) {
           dockerContainer = new startDockerContainer();
           dockerContainer.startFile();
       }
       testBase = new TestBase();
       pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
       genericUtils = new GenericUtils(testBase.WebDriverManager());
    }


}
