package features.ToBeDeleted;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.BaseUtil;

import java.io.File;
import java.io.IOException;
import java.util.Date;


public class ExtentReportUtil extends utils.BaseUtil {


    static Date date= new Date();
    static String fileName = BaseUtil.reportLocation + "Extent Report_" + date.toString().replace(" :","_").replace(" ", "_") + " .html";

  //  String fileName = BaseUtil.reportLocation + "extentreport.html";
  //  private Object Driver;


    public void ExtentReport() {
        //First is to create Extent Reports
        extent = new ExtentReports();

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("API TEST REPORT");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("API TEST AUTOMATION REPORT");


        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Organisation", "EROAD");
        extent.setSystemInfo("Team", "Foundation Team");
        extent.setSystemInfo("Sprint", "Q2S5");



    }

//    public void ExtentReportScreenshot() throws IOException {
//
//        File scr = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
//        Files.copy(scr.toPath(), new File(reportLocation + "screenshot.png").toPath());
//        scenarioDef.fail("details").addScreenCaptureFromPath(reportLocation + "screenshot.png");
//    }


    public void FlushReport(){
        extent.flush();
    }




}