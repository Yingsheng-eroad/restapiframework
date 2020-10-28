package extentReport;

import com.aventstack.extentreports.ExtentReports;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerImpl extends ExtentReportListenerB implements ITestListener {

    private static ExtentReports extent;

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Pass");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Failed");

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("Execution Started");
        extent=setUp();

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        extent.flush();
        System.out.println("Generated Report");

    }
}
