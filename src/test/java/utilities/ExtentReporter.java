package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

public class ExtentReporter {

    private static ExtentHtmlReporter reporter;
    private static ExtentReports reports;
    private static ExtentTest extentTest;

    static {
        reporter = new ExtentHtmlReporter("./extentReport/report.html");
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setDocumentTitle("Chicago B14 Extent Report");

        reports = new ExtentReports();
        reports.attachReporter(reporter);
        reports.setSystemInfo("OS", "Mac");
        reports.setSystemInfo("Host Name", "CI");
        reports.setSystemInfo("Environment", "QA");
        reports.setSystemInfo("username", "B14");
    }


    public static void startTest(String testName){
        extentTest = reports.createTest(testName);
    }

    public static void passTest(){
        extentTest.pass("Passed");
    }

    public static void fail(String path) throws IOException {

        System.out.println("\n" + path);

//        extentTest.log(Status.FAIL,"Attachment: " + extentTest.addScreenCaptureFromPath(path));
        extentTest.fail("Failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
    }

    public static void endTest(){
        reports.flush();
    }

}
