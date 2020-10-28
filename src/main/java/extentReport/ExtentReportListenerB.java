package extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListenerB {

    public static ExtentHtmlReporter report = null;
    public static ExtentReports extent = null;
    public static ExtentTest test = null;

    public static ExtentReports setUp() {
        String reportLocation = "./Reports/Extent_Report.html";
        report = new ExtentHtmlReporter(reportLocation);
        report.config().setDocumentTitle("API Automation Test Report");
        report.config().setReportName("Automation Test Report");
        report.config().setTheme(Theme.DARK);
        System.out.println("Extent Reprot location Initialized..");
        report.start();

        extent = new ExtentReports();
        extent.attachReporter(report);
        return extent;
    }

    public static void testStepHandle(String teststatus, ExtentTest extentTest, Throwable throwable) {
        switch (teststatus) {
            case "FAIL":
                extentTest.fail(MarkupHelper.createLabel("Test Case is Failed:", ExtentColor.RED));
                extentTest.error(throwable.fillInStackTrace());

                break;
            case "PASS":
                extentTest.pass(MarkupHelper.createLabel("Test Case is Passed :", ExtentColor.GREEN));
                break;

            default:
                break;

        }
    }
}
