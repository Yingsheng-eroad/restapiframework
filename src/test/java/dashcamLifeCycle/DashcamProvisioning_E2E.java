package dashcamLifeCycle;

import apiBuilder.PostAPIBuilder;
import apiConfig.APIPath;
import apiConfig.HeaderConfigs;
import apiVerifications.APIVerification;
import baseTest.AmsBaseTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import pojo.AssetAndOrgIdPojo;
import pojo.AssetIdPojo;
import pojo.OrganisationIdPojo;
//import features.ToBeDeleted.ExtentReportListner;
import utils.JavaUtils;

import java.util.UUID;

import static io.restassured.RestAssured.given;


public class DashcamProvisioning_E2E extends AmsBaseTest {


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
        Response createDashcamresponse = given().spec(spec).when().headers(headers.defaultHeaders())
                .body(builder.postRequestBody(serialNumber, imsi, iccid)).when().post(APIPath.apiPath.CREATE_DASHCAMS);

        return createDashcamresponse;

    }

    //Retrieve the DeviceID from the Response
    public static UUID getDeviceId(JsonPath createdDashcam) {

        UUID deviceId = createdDashcam.getUUID("id");
        System.out.println("The Device Id is " + deviceId);
        return deviceId;

    }

    //Assert the LifeCycle State = AVAILABLE
    public static void assertLifeCycleState(JsonPath createdDashcam) {

        String lifeCycleState = createdDashcam.getString("lifeCycleState");
        System.out.println("The Life Cycle State is in " + lifeCycleState + " State");
        Assert.assertEquals(lifeCycleState, "AVAILABLE");

    }

    public static Response leaseDashcam(UUID deviceId) {

        HeaderConfigs headers = new HeaderConfigs();
        PostAPIBuilder builder = new PostAPIBuilder();
        OrganisationIdPojo leaseDashcamPojo = new OrganisationIdPojo("c50db1c6-10c7-47f8-819b-57d0a3cdbcaf");

        Response leaseDashcamResponse = given().spec(spec).when().headers(headers.defaultHeaders())
                .body(leaseDashcamPojo).when().
                        patch(APIPath.apiPath.LEASE_DASHCAMS + deviceId + "/lease")
                .then().using().extract().response();

        return leaseDashcamResponse;

    }

    public static Response getDashcamIdAPI(UUID deviceId) {

        HeaderConfigs headers = new HeaderConfigs();
        PostAPIBuilder builder = new PostAPIBuilder();

        Response getDashcamIDResponse = given().spec(spec).when().headers(headers.defaultHeaders())
                .when().get(APIPath.apiPath.GET_DASHCAMS + deviceId).then().using().extract().response();

        return getDashcamIDResponse;

    }

    public static String assertGetDashcamLifeCycleState(JsonPath getDashcamIDResponse) {

        String lifeCycleState = getDashcamIDResponse.getString("lifeCycleState");
        System.out.println("The Life Cycle State is in " + lifeCycleState + " State");
        return lifeCycleState;

    }

    public static Response installDashcam(UUID deviceId) {

        HeaderConfigs headers = new HeaderConfigs();
        PostAPIBuilder builder = new PostAPIBuilder();

        Response installDashcamResponse = given().spec(spec).when()
                .headers(headers.defaultHeaders()).when()
                .patch(APIPath.apiPath.INSTALL_DASHCAMS + deviceId + "/install");
        // System.out.println("The Status code of the response is " + installDashcamResponse.getStatusCode());

        return installDashcamResponse;

    }

    public static Response assignDashcam(UUID deviceId) {

        HeaderConfigs headers = new HeaderConfigs();
        PostAPIBuilder builder = new PostAPIBuilder();
        AssetIdPojo assetIdPojo = new AssetIdPojo("f410f224-926c-4b7e-96bf-d968d02639a0");

        //PostAPITests p1= new PostAPITests();

        Response assignDashcamResponse = given().spec(spec).when().headers(headers.defaultHeaders()).body(assetIdPojo).when().patch(APIPath.apiPath.ASSIGN_DASHCAMS + deviceId + "/assign");

        return assignDashcamResponse;

    }

    public static Response unAssignDashcam(UUID deviceId) {

        HeaderConfigs headers = new HeaderConfigs();
        PostAPIBuilder builder = new PostAPIBuilder();

        AssetAndOrgIdPojo assetAndOrgIdPojo = new AssetAndOrgIdPojo("f410f224-926c-4b7e-96bf-d968d02639a0", "c50db1c6-10c7-47f8-819b-57d0a3cdbcaf");

        Response unAssignDashcamResponse = given().spec(spec).when().headers(headers.defaultHeaders()).body(assetAndOrgIdPojo).when().patch(APIPath.apiPath.UNASSIGN_DASHCAMS + deviceId + "/unassign");

        return unAssignDashcamResponse;

    }

    public static Response unInstallDashcam(UUID deviceId) {

        HeaderConfigs headers = new HeaderConfigs();
        PostAPIBuilder builder = new PostAPIBuilder();

        AssetAndOrgIdPojo assetAndOrgIdPojo = new AssetAndOrgIdPojo("f410f224-926c-4b7e-96bf-d968d02639a0", "c50db1c6-10c7-47f8-819b-57d0a3cdbcaf");

        //PostAPITests p1= new PostAPITests();

        Response unInstallDashcamResponse = given().spec(spec).when().headers(headers.defaultHeaders()).body(assetAndOrgIdPojo).when().patch(APIPath.apiPath.UNINSTALL_DASHCAMS + deviceId + "/uninstall");

        // Response unInstallDashcamResponse = RestAssured.given().when().headers(headers.defaultHeaders()).body("{\n" + " \"assetId\": \"f410f224-926c-4b7e-96bf-d968d02639a0\",\n" + "  \"organisationId\": \"c50db1c6-10c7-47f8-819b-57d0a3cdbcaf\"}\n" + " ").when().patch(APIPath.apiPath.UNINSTALL_DASHCAMS + deviceId + "/uninstall");

        System.out.println(unInstallDashcamResponse.getBody().asString());
        System.out.println(unInstallDashcamResponse.getStatusCode());

        //Assert the response code and life cycle state
        APIVerification.responseCodeValidation(unInstallDashcamResponse, 200);

        System.out.println("The Status code of the response is " + unInstallDashcamResponse.getStatusCode());

        System.out.println("The Life Cycle State of the Dashcam is PENDING_INSTALL");

        //installDashcamResponse.then().assertThat().body("lifeCycleState", Is.is("PENDING_ASSIGNMENT"));

        return unInstallDashcamResponse;

    }


    private void rmaPendingDashcam(UUID deviceId) {

        HeaderConfigs headers = new HeaderConfigs();
        PostAPIBuilder builder = new PostAPIBuilder();

        //PostAPITests p1= new PostAPITests();

        Response rmaPendingDashcamResponse = given().spec(spec).when().when().patch(APIPath.apiPath.RMAPENDING_DASHCAMS + deviceId + "/rmaPending");

        System.out.println(rmaPendingDashcamResponse.getBody().asString());
        System.out.println(rmaPendingDashcamResponse.getStatusCode());

        //Assert the response code and life cycle state
        APIVerification.responseCodeValidation(rmaPendingDashcamResponse, 204);

        System.out.println("The Status code of the response is " + rmaPendingDashcamResponse.getStatusCode());

        System.out.println("The Life Cycle State of the Dashcam is RMA_PENDING");

        //installDashcamResponse.then().assertThat().body("lifeCycleState", Is.is("PENDING_ASSIGNMENT"));

    }

    private void rmaCloseDashcam(UUID deviceId) {

        HeaderConfigs headers = new HeaderConfigs();
        PostAPIBuilder builder = new PostAPIBuilder();

        //PostAPITests p1= new PostAPITests();

        Response rmaCloseDashcamResponse = given().spec(spec).when().when().patch(APIPath.apiPath.RMAPENDING_DASHCAMS + deviceId + "/rmaClose");

        System.out.println(rmaCloseDashcamResponse.getBody().asString());
        System.out.println(rmaCloseDashcamResponse.getStatusCode());

        //Assert the response code and life cycle state
        APIVerification.responseCodeValidation(rmaCloseDashcamResponse, 204);

        System.out.println("The Status code of the response is " + rmaCloseDashcamResponse.getStatusCode());

        System.out.println("The Life Cycle State of the Dashcam is DECOMMISSIONED");

        //installDashcamResponse.then().assertThat().body("lifeCycleState", Is.is("PENDING_ASSIGNMENT"));

    }

}


