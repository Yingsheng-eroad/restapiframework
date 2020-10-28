package features.ToBeDeleted;

import apiBuilder.PostAPIBuilder;
import apiConfig.APIPath;
import apiConfig.HeaderConfigs;
import baseTest.AmsBaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.JavaUtils;

public class CreateDashcamDemo1 extends AmsBaseTest {

    public static Response createDashcam() {


        //Invoke API and Retrieve Device Id
        HeaderConfigs headers = new HeaderConfigs();
        PostAPIBuilder builder = new PostAPIBuilder();

        JavaUtils javaUtils = new JavaUtils();

        //Create random values to the body parameter
        String serialNumber = JavaUtils.randomString();
        String imsi = JavaUtils.randomString();
        String iccid = JavaUtils.randomString();

        //Print the body Parameters
        System.out.println("Serial Number is " + serialNumber);
        System.out.println("imsi no is " + imsi);
        System.out.println("iccid no is " + iccid);

        //Post Method to create a dashcam
        Response createDashcamresponse = RestAssured.given().when().headers(headers.defaultHeaders())
                .body(builder.postRequestBody(serialNumber, imsi, iccid)).post(APIPath.apiPath.CREATE_DASHCAMS);

        return createDashcamresponse;

    }
}
