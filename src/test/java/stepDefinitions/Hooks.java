package stepDefinitions;


import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import utils.TestContextSetup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;


public class Hooks {

    TestContextSetup testContextSetup;

    public Hooks(TestContextSetup testContextSetup) throws IOException, InterruptedException {

        this.testContextSetup = testContextSetup;


    }

    @After
    public void AfterScenario() throws IOException, InterruptedException {

        testContextSetup.testBase.WebDriverManager().quit();

    }

    @AfterAll
    public static void stopDocker() throws IOException, InterruptedException {
        boolean flag = false;
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("cmd /c start dockerDown.bat");

        Thread.sleep(4000);
        String f = System.getProperty("user.dir")+"//output.txt";

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, 45);
        long stopnow = cal.getTimeInMillis();

        while (System.currentTimeMillis() < stopnow) {

            if(flag){

                break;
            }

            BufferedReader reader = new BufferedReader(new FileReader(f));
            String currentLine = reader.readLine();

            while (currentLine != null && !flag) {

                if (currentLine.contains("selenium-hub exited")) {
                    System.out.println("found my text in output file to close!!");
                    flag = true;
                    break;
                }
                currentLine = reader.readLine();
            }
            reader.close();

        }
        Assert.assertTrue(flag);


    }

    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException, InterruptedException {
        WebDriver driver=testContextSetup.testBase.WebDriverManager();
        if(scenario.isFailed()){
            File sourcePath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent,"image/png", "image");


        }
    }


}
