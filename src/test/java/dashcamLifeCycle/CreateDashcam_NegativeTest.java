package dashcamLifeCycle;

import apiBuilder.PostAPIBuilder;
import apiConfig.APIPath;
import apiConfig.HeaderConfigs;
import baseTest.AmsBaseTest;
import io.restassured.response.Response;
import utils.JavaUtils;

import static io.restassured.RestAssured.given;

public class CreateDashcam_NegativeTest extends AmsBaseTest {


    public static Response createDashcamInvalidEndpoint() {
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
        Response createDashcamresponse = given().spec(spec).when().headers(headers.defaultHeaders())
                .body(builder.postRequestBody(serialNumber, imsi, iccid)).when().post(APIPath.apiPath.INVALID_CREATE_DASHCAMS);

        return createDashcamresponse;
    }

    public static Response createDashcamInvalidHeader() {
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
        Response createDashcamresponse = given().spec(spec).when().headers(headers.invalidHeaders())
                .body(builder.postRequestBody(serialNumber, imsi, iccid)).when().post(APIPath.apiPath.CREATE_DASHCAMS);

        return createDashcamresponse;
    }
    public static Response createDashcamNullContentTypeHeader() {
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
        Response createDashcamresponse = given().spec(spec).when().headers(headers.nullContentTypeHeaders())
                .body(builder.postRequestBody(serialNumber, imsi, iccid)).when().post(APIPath.apiPath.CREATE_DASHCAMS);

        return createDashcamresponse;
    }
    public static Response createDashcamNullAcceptKeyHeader() {
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
        Response createDashcamresponse = given().spec(spec).when().headers(headers.nullContentTypeHeaders())
                .body(builder.postRequestBody(serialNumber, imsi, iccid)).when().post(APIPath.apiPath.CREATE_DASHCAMS);

        return createDashcamresponse;
    }

    public static Response createDashcamInvalidRequestType() {
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
        Response createDashcamresponse = given().spec(spec).when().headers(headers.defaultHeaders())
                .body(builder.postRequestBody(serialNumber, imsi, iccid)).when().patch(APIPath.apiPath.CREATE_DASHCAMS);

        return createDashcamresponse;
    }

    public static Response createDashcamInvalidPostRequestBody() {
        //Invoke API and Retrieve Device Id
        HeaderConfigs headers = new HeaderConfigs();
        PostAPIBuilder builder = new PostAPIBuilder();

        JavaUtils javaUtils = new JavaUtils();

        //Create random values to the body parameter
      //  String serialNumber = JavaUtils.randomString();
        String imsi = JavaUtils.randomString();
        String iccid = JavaUtils.randomString();

        //Print the body Parameters
       // System.out.println("Serial Number is " + serialNumber);
        System.out.println("imsi no is " + imsi);
        System.out.println("iccid no is " + iccid);

        //Post Method to create a dashcam
        Response createDashcamresponse = given().spec(spec).when().headers(headers.defaultHeaders())
                .body(builder.invalidPostRequestBody(imsi,iccid)).when().post(APIPath.apiPath.CREATE_DASHCAMS);

        return createDashcamresponse;
    }

//    public static Response createDashcam(String serialNumber, String imsi, String iccid) {
//
//        //Invoke API and Retrieve Device Id
//        HeaderConfigs headers = new HeaderConfigs();
//        PostAPIBuilder builder = new PostAPIBuilder();
//        CreateDashcamPojo createDashcamPojo = new CreateDashcamPojo(serialNumber, imsi, iccid);
//
//        //Post Method to create a dashcam
//        Response createDashcamresponse = RestAssured.given().when().headers(headers.defaultHeaders())
//                .body(createDashcamPojo).when().post(APIPath.apiPath.CREATE_DASHCAMS);
//
//        return createDashcamresponse;
//
//    }

//    public static Response createDashcamWithInvalidData() {
//        Map<String, String> postBody = new HashMap<String, String>();
//        List<HashMap<String, String>> gt;
//        List<HashMap<String, String>> dataSet;
//
//
//        dataSet = GetDataFromExcelUtil.readExcelDatafromFile("C://Selenium//TestData//AccountTransfer.xlsx", "Sheet1");
//        //Invoke API and Retrieve Device Id
//        HeaderConfigs headers = new HeaderConfigs();
//        PostAPIBuilder builder = new PostAPIBuilder();
//
//        JavaUtils javaUtils = new JavaUtils();
//
//        //Create random values to the body parameter
//        String serialNumber = JavaUtils.randomString();
//        String imsi = JavaUtils.randomString();
//        String iccid = JavaUtils.randomString();
//
//        //Print the body Parameters
//        System.out.println("Serial Number is " + serialNumber);
//        System.out.println("imsi no is " + imsi);
//        System.out.println("iccid no is " + iccid);
//
//
//        //Post Method to create a dashcam
//        Response createDashcamresponse = RestAssured.given().when().headers(headers.defaultHeaders())
//                .body(builder.postRequestBody(serialNumber, imsi, iccid)).when().post(APIPath.apiPath.CREATE_DASHCAMS);
//
//        return createDashcamresponse;
//    }

}