package features.ToBeDeleted;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.an.E;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;

import java.io.IOException;
import java.util.Arrays;

public class ExtentManagers {

    public ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    public ExtentTest test;

    public static ExtentReports createInstance(String fileName){

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);


    //public void setReport() {
      //  htmlReporter = new ExtentHtmlReporter("./reports/extent.html");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName);


        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Organisation", "EROAD");
        extent.setSystemInfo("Team", "Foundation Team");
        extent.setSystemInfo("Sprint", "Q2S5");

        return extent;

    }

    public void endReport() {
        extent.flush();
    }


    public void passTest() {
        test = extent.createTest("Passed Test");
        System.out.println("Executing Passed Test");
    }

    public void failTest() {
        test = extent.createTest("Failed Test");
        Assert.fail("Failed Test");
    }

    public void skippedTest() {
        test = extent.createTest("Skipped Test");
        throw new SkipException("Skpping the test case");
    }

//
//    public void tearDown(ITestResult result) {
//
//        if (result.getStatus() == ITestResult.FAILURE) {
//
//            String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
//            test.fail("<details>" + "<summary>" + "<b>" + "<fontcolor=" + "red>" + "Exception occured: Click to see"
//                    + "</font>" + "</b>" + "</summary>" + exceptionMessage.replaceAll(",", "<br>") +
//                    "</details>" + " \n");
//
//          /*  try {
//                ExtentManagers.captureScreenshot();
//                test.get().fail("<b>" + "<font colour=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
//                        MediaEntityBuilder.createScreenCaptureFromPath(ExtentManagers.screenshotName()).build());
//            } catch (IOException e) {
//
//            } */
//
//            String failureLog = "TEST CASE FAILED";
//            Markup markUp = MarkupHelper.createLabel(failureLog, ExtentColor.RED);
//            test.log(Status.FAIL, markUp);
//
//        } else if (result.getStatus() == ITestResult.SKIP) {
//
//            String methodName = result.getMethod().getMethodName();
//
//            String logText = "<b>" + "TEST CASE : - " + methodName.toUpperCase() + "  SKIPPED " + "</b>";
//
//            Markup markUp = MarkupHelper.createLabel(logText, ExtentColor.BLUE);
//
//            test.skip(markUp);
//
//        } else if (result.getStatus() == ITestResult.SUCCESS) {
//
//            String methodName = result.getMethod().getMethodName();
//
//            String logText = "<b>" + "TEST CASE : - " + methodName.toUpperCase() + "  PASSED " + "</b>";
//
//            Markup markUp = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
//
//            test.pass(markUp);
//
//        }

    }


