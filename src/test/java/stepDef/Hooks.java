package stepDef;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;
import utilities.ExtentReporter;
import utilities.Log;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class Hooks {


//    @Before(order = 1)
//    public void setUp(Scenario scenario){
//        PropertyConfigurator.configure(log4jConfPath);
//        Log.startLog("Starting testing");
//        System.out.println("Scenario: " + scenario.getName());
//    }

    @Before()
    public void test(Scenario scenario){

        Log.startLog(scenario.getName());
        ExtentReporter.startTest(scenario.getName());
    }

    @After
    public  void tearDown(Scenario scenario) throws IOException {
       // PropertyConfigurator.configure(log4jConfPath);


        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            File file = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
            String path = "extentReport/" + System.currentTimeMillis() + ".png";
            File destination = new File(path);
            FileUtils.copyFile(file, destination);

            scenario.embed(screenshot, "image/png");
            Log.error("Error detected");
            ExtentReporter.fail(path);

        }

        Driver.closeDriver();

    }

}
