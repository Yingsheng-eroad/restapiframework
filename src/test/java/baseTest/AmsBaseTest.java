package baseTest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utils.FileAndEnv;

//@Listeners(ExtentReportListner.class)
public class BaseTest {

    public static RequestSpecification spec = null;
    public static RestAssured restAssured = new RestAssured();
    static {
        spec = new RequestSpecBuilder().setBaseUri(FileAndEnv.getInstance().getServerUrl()).build();
    }

//    static{
//        RestAssured.baseURI= FileAndEnv.getDeviceConfigInstance().getDeviceConfigUrl();
//    }

//    @Test
//    public void utilsTest(){
//                test.log(LogStatus.INFO,"Test has be started...");
//                test.log(LogStatus.INFO,"Test is completed successfully...");
//    }

}
