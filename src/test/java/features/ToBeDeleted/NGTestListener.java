//package runner;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import utils.BaseUtil;
//import features.ToBeDeleted.ExtentManagers;
//import features.ToBeDeleted.ExtentReportUtil;
//import com.aventstack.extentreports.gherkin.model.Feature;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//import com.aventstack.extentreports.markuputils.ExtentColor;
//import com.aventstack.extentreports.markuputils.Markup;
//import com.aventstack.extentreports.markuputils.MarkupHelper;
//
//import java.util.Arrays;
//import java.util.Date;
//
//import static utils.BaseUtil.features;
//
//
//public class NGTestListener implements ITestListener {
//
//
//    static Date date= new Date();
//    static String fileName = BaseUtil.reportLocation + "Extent Report_" + date.toString().replace(" :","_").replace(" ", "_") + " .html";
//
//    ExtentReportUtil extentReportUtil = new ExtentReportUtil();
//
//    private static ExtentReports extent = ExtentManagers.createInstance(System.getProperty("user.dir")+ "\\reports\\"+fileName);
//    public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
//
//
//    @Override
//    public void onTestStart(ITestResult iTestResult) {
//
//        ExtentTest features = extentReportUtil.extent.createTest(iTestResult.getTestClass().getName()
//                        + " @TestCase :" + iTestResult.getMethod().getMethodName());
//
//
//        testReport.set(features);
//
//        System.out.println("On test start");
//
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult iTestResult) {
//
//        String methodName = iTestResult.getMethod().getMethodName();
//        String logText = "<b>" + "TEST CASE : - " + methodName.toUpperCase() + "  PASSED " + "</b>";
//        Markup markUp = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
//        testReport.get().pass(markUp);
//
//        System.out.println("On test Success");
//    }
//
//    @Override
//    public void onTestFailure(ITestResult iTestResult) {
//        String exceptionMessage = Arrays.toString(iTestResult.getThrowable().getStackTrace());
//        testReport.get().fail("<details>" + "<summary>" + "<b>" + "<fontcolor=" + "red>" + "Exception occured: Click to see"
//                + "</font>" + "</b>" + "</summary>" + exceptionMessage.replaceAll(",", "<br>") +
//                "</details>" + " \n");
//        String failureLog = "TEST CASE FAILED";
//        Markup markUp = MarkupHelper.createLabel(failureLog, ExtentColor.RED);
//        testReport.get().log(Status.FAIL, markUp);
//        System.out.println("On test failure");
//
////        try{
////            extentReportUtil.ExtentReportScreenshot();
////        }catch (IOException e){
////            e.printStackTrace();
////        }
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult iTestResult) {
//        String methodName = iTestResult.getMethod().getMethodName();
//        String logText = "<b>" + "TEST CASE : - " + methodName.toUpperCase() + "  SKIPPED " + "</b>";
//        Markup markUp = MarkupHelper.createLabel(logText, ExtentColor.BLUE);
//        testReport.get().skip(markUp);
//
//        System.out.println("On test skipped");
//    }
//
//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
//        System.out.println("On test percentage");
//    }
//
//    @Override
//    public void onStart(ITestContext iTestContext) {
//        System.out.println("On start");
//
//        extentReportUtil.ExtentReport();
//
//        //ToDo: Feature - Hard coding the feature name
//        features = extentReportUtil.extent.createTest(Feature.class, "Dashcam Provisioning LifeCycle");
//
//
//    }
//
//    @Override
//    public void onFinish(ITestContext iTestContext) {
//        System.out.println("On finish");
//        extentReportUtil.FlushReport();
//    }
//}
