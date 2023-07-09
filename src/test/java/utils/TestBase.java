package utils;


import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.*;
import java.net.URL;
import java.util.Properties;

public class TestBase {
    public static int counter = 0;

    public RemoteWebDriver driver;

    public RemoteWebDriver WebDriverManager() throws IOException, InterruptedException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
        Properties prop = new Properties();
        prop.load(fis);

        //String url = prop.getProperty("QAUrl");
        String browser_properties = prop.getProperty("browser");
        String browser_maven = System.getProperty("browser");

        String QAUrl_properties = prop.getProperty("QAUrl");
        String QAUrl_maven = System.getProperty("QAUrl");


        String browser = browser_maven!=null ? browser_maven : browser_properties;
        String url = QAUrl_maven!=null ? QAUrl_maven : QAUrl_properties;


        if(driver==null) {


            URL u=new URL("http://localhost:4444/wd/hub");
            Thread.sleep(10000);
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--window-position=0,0");
//            options.addArguments("--window-size=1840,1080");
//            options.addArguments("--no-sandbox");
//            options.addArguments("--disable-gpu");
            driver = new RemoteWebDriver(u,new ChromeOptions());
            //driver = new RemoteWebDriver(u,new FirefoxOptions());

            /*if(browser.equalsIgnoreCase("chrome"))
            {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//chromedriver.exe");
                driver = new ChromeDriver();
            }
            if(browser.equalsIgnoreCase("firefox"))
            {
               System.setProperty("webdriver.gecko.driver", "C://Users//Sumit//Downloads//geckodriver-v0.33.0-win32//geckodriver.exe");
//                DesiredCapabilities capabilities = new DesiredCapabilities();
//                capabilities. setCapability("marionette",true);
//                WebDriver driver= new FirefoxDriver();
//
                driver = new FirefoxDriver();
            }

            if(browser.equalsIgnoreCase("edge"))
            {
                System.setProperty("webdriver.edge.driver","C://Users//Sumit//Downloads//edgedriver_win64//msedgedriver.exe");
                driver=new EdgeDriver();
            }

 */
            driver.get(url);
            //driver.get("https://www.dhampursugar.com/");


            driver.manage().window().maximize();
        }

        return driver;
    }


}
