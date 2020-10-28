package features.ToBeDeleted;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;
import java.util.Date;

public class ExtentListeners implements ITestListener {

    static Date date= new Date();
    static String fileName = "Extent_" + date.toString().replace(" :","_").replace(" ", "_") + " .html";

    private static ExtentReports extent = ExtentManagers.createInstance(System.getProperty("user.dir")+ "\\reports\\"+fileName);
    public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult iTestResult) {

//        ExtentTest test = extent.createTest(iTestResult.getTestClass().getName() + "   @TestCase : " + iTestResult.getMethod().getMethodName());
//        testReport.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        String methodName = iTestResult.getMethod().getMethodName();

        String logText = "<b>" + "TEST CASE : - " + methodName.toUpperCase() + "  PASSED " + "</b>";

        Markup markUp = MarkupHelper.createLabel(logText, ExtentColor.GREEN);

        testReport.get().pass(markUp);

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        String exceptionMessage = Arrays.toString(iTestResult.getThrowable().getStackTrace());
        testReport.get().fail("<details>" + "<summary>" + "<b>" + "<fontcolor=" + "red>" + "Exception occured: Click to see"
                + "</font>" + "</b>" + "</summary>" + exceptionMessage.replaceAll(",", "<br>") +
                "</details>" + " \n");
        String failureLog = "TEST CASE FAILED";
        Markup markUp = MarkupHelper.createLabel(failureLog, ExtentColor.RED);
        testReport.get().log(Status.FAIL, markUp);

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        String methodName = iTestResult.getMethod().getMethodName();

        String logText = "<b>" + "TEST CASE : - " + methodName.toUpperCase() + "  SKIPPED " + "</b>";

        Markup markUp = MarkupHelper.createLabel(logText, ExtentColor.BLUE);

        testReport.get().skip(markUp);

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
//
//    }
//
//    @Override
//    public void onStart(ITestContext iTestContext) {
//
//    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        if(extent !=null) {
            extent.flush();
        }

    }
}
