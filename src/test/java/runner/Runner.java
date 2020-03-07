package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import utilities.ExtentReporter;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber", "json:target/report.json"},
        features = "src/test/resources/features",
        glue = "stepDef",
        tags = "@google",
        dryRun = false
)

public class Runner {

    @AfterClass
    public static void flush(){
        ExtentReporter.endTest();
    }

//  mvn test -Dcucumber.options=“-- tags @google”

}
