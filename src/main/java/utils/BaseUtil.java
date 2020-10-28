package utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseUtil {

    public ExtentReports extent;

    public static ExtentTest scenarioDef;

    public static ExtentTest features;

    public static String reportLocation = "target/extentreport/";

}