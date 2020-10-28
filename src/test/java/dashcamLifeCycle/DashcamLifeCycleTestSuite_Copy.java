package dashcamLifeCycle;

import apiBuilder.PostAPIBuilder;
import apiConfig.APIPath;
import apiConfig.HeaderConfigs;
import apiVerifications.APIVerification;
import baseTest.AmsBaseTest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.core.Is;
import org.testng.annotations.Test;
import pojo.AssetAndOrgIdPojo;
import pojo.AssetIdPojo;
import pojo.OrganisationIdPojo;
import utils.JavaUtils;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class DashcamLifeCycleTestSuite_Copy extends AmsBaseTest {

    @Test
    public void dashcamProvisioning() {

        UUID createDashcam = createDashcam();
        leaseDashcam(createDashcam);
        installDashcam(createDashcam);
        assignDashcam(createDashcam);
        rmaPendingDashcam(createDashcam);
        rmaCloseDashcam(createDashcam);
        // unAssignDashcam(createDashcam);
        // unInstallDashcam(createDashcam);

    }

    private UUID createDashcam() {
        HeaderConfigs headers = new HeaderConfigs();
        PostAPIBuilder builder = new PostAPIBuilder();

        JavaUtils javaUtils = new JavaUtils();

        //Create random values to the body parameter
        String serialNumber = JavaUtils.randomString();
        String imsi = JavaUtils.randomString();
        String iccid = JavaUtils.randomString();

        System.out.println("Serial Number is " + serialNumber);
        System.out.println("imsi no is " + imsi);
        System.out.println("iccid no is " + iccid);

        //Post Method to create a dashcam
        Response createDashcamresponse = given().when().headers(headers.defaultHeaders()).body(builder.postRequestBody(serialNumber, imsi, iccid)).when().post(APIPath.apiPath.CREATE_DASHCAMS);


        //Assert the response
        APIVerification.responseCodeValidation(createDashcamresponse, 201);

        System.out.println("The Status code of the response is " + createDashcamresponse.getStatusCode());

        createDashcamresponse.then().assertThat().body("lifeCycleState", Is.is("AVAILABLE"));


        //Print the response
        APIVerification.responseKeyValidationFromObject(createDashcamresponse, "lifeCycleState");
        APIVerification.responseKeyValidationFromObject(createDashcamresponse, "id");

        //Parse the response and store it in a variable
        JsonPath jsonPath = new JsonPath(createDashcamresponse.getBody().asString());

        UUID deviceId = jsonPath.getUUID("id");
        System.out.println("The Device Id is " + deviceId);

        String lifeCycleState = jsonPath.getString("lifeCycleState");
        System.out.println("The lifeCycle state is " + lifeCycleState);

        return deviceId;

    }


    private void leaseDashcam(UUID deviceId) {


        HeaderConfigs headers = new HeaderConfigs();
        PostAPIBuilder builder = new PostAPIBuilder();
        OrganisationIdPojo leaseDashcamPojo = new OrganisationIdPojo("c50db1c6-10c7-47f8-819b-57d0a3cdbcaf");

        //PostAPITests p1= new PostAPITests();

        Response leaseDashcamResponse = given().spec(spec).when().headers(headers.defaultHeaders())
                .body(leaseDashcamPojo).when().patch(APIPath.apiPath.LEASE_DASHCAMS + deviceId + "/lease").then().using().extract().response();

        // Response leaseDashcamResponse = RestAssured.given().when().headers(headers.defaultHeaders()).body("{\n" + "\"organisationId\":\"c50db1c6-10c7-47f8-819b-57d0a3cdbcaf\"\n" + "}\n" + " ").when().patch(APIPath.apiPath.LEASE_DASHCAMS + deviceId + "/lease").then().using().extract().response();

        System.out.println(leaseDashcamResponse.getBody().asString());
        System.out.println(leaseDashcamResponse.getStatusCode());

        //Assert the response code and life cycle state
        APIVerification.responseCodeValidation(leaseDashcamResponse, 200);


        System.out.println("The Status code of the response is " + leaseDashcamResponse.getStatusCode());

        System.out.println("The current Life Cycle State is ");
        System.out.println("The Life Cycle State of the Dashcam is PENDING_INSTALL");


        // leaseDashcamResponse.then().assertThat().body("lifeCycleState", Is.is("PENDING_INSTALL"));

        //APIVerification.responseKeyValidationFromObject(leaseDashcamResponse, "lifeCycleState");

    }

    private void installDashcam(UUID deviceId) {

        HeaderConfigs headers = new HeaderConfigs();
        PostAPIBuilder builder = new PostAPIBuilder();

        //PostAPITests p1= new PostAPITests();

        Response installDashcamResponse = given().when().headers(headers.defaultHeaders()).when().patch(APIPath.apiPath.INSTALL_DASHCAMS + deviceId + "/install");

        System.out.println(installDashcamResponse.getBody().asString());
        System.out.println(installDashcamResponse.getStatusCode());

        //Assert the response code and life cycle state
        APIVerification.responseCodeValidation(installDashcamResponse, 204);

        System.out.println("The Status code of the response is " + installDashcamResponse.getStatusCode());

        System.out.println("The Life Cycle State of the Dashcam is PENDING_ASSIGNMENT");

        //installDashcamResponse.then().assertThat().body("lifeCycleState", Is.is("PENDING_ASSIGNMENT"));

    }

    private void assignDashcam(UUID deviceId) {

        HeaderConfigs headers = new HeaderConfigs();
        PostAPIBuilder builder = new PostAPIBuilder();
        AssetIdPojo assetIdPojo = new AssetIdPojo("f410f224-926c-4b7e-96bf-d968d02639a0");

        //PostAPITests p1= new PostAPITests();

        Response assignDashcamResponse = given().when().headers(headers.defaultHeaders()).body(assetIdPojo).when().patch(APIPath.apiPath.ASSIGN_DASHCAMS + deviceId + "/assign");

        // Response assignDashcamResponse = RestAssured.given().when().headers(headers.defaultHeaders()).body("{\n" + "\"assetId\":\"f410f224-926c-4b7e-96bf-d968d02639a0\"\n" + "}\n" + " ").when().patch(APIPath.apiPath.ASSIGN_DASHCAMS + deviceId + "/assign");

        System.out.println(assignDashcamResponse.getBody().asString());
        System.out.println(assignDashcamResponse.getStatusCode());

        //Assert the response code and life cycle state
        APIVerification.responseCodeValidation(assignDashcamResponse, 200);

        System.out.println("The Status code of the response is " + assignDashcamResponse.getStatusCode());

        System.out.println("The Life Cycle State of the Dashcam is INSTALLED");

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

    private void unAssignDashcam(UUID deviceId) {

        HeaderConfigs headers = new HeaderConfigs();
        PostAPIBuilder builder = new PostAPIBuilder();

        AssetAndOrgIdPojo assetAndOrgIdPojo = new AssetAndOrgIdPojo("f410f224-926c-4b7e-96bf-d968d02639a0", "c50db1c6-10c7-47f8-819b-57d0a3cdbcaf");

        Response unAssignDashcamResponse = given().spec(spec).when().headers(headers.defaultHeaders()).body(assetAndOrgIdPojo).when().patch(APIPath.apiPath.UNASSIGN_DASHCAMS + deviceId + "/unassign");

        // Response unAssignDashcamResponse = spec.given().when().headers(headers.defaultHeaders()).body("{\n" + " \"assetId\": \"f410f224-926c-4b7e-96bf-d968d02639a0\",\n" + "  \"organisationId\": \"c50db1c6-10c7-47f8-819b-57d0a3cdbcaf\"}\n" + " ").when().patch(APIPath.apiPath.UNASSIGN_DASHCAMS + deviceId + "/unassign");

        //Response unAssignDashcamResponse = spec.given().when().headers(headers.defaultHeaders()).body(bodyElements).when().patch(APIPath.apiPath.UNASSIGN_DASHCAMS + deviceId + "/unassign");

        //Response unAssignDashcamResponse = spec.given().when().headers(headers.defaultHeaders()).body(bodyConfigs.addBody()).when().patch(APIPath.apiPath.UNASSIGN_DASHCAMS + deviceId + "/unassign");

        System.out.println(unAssignDashcamResponse.getBody().asString());
        System.out.println(unAssignDashcamResponse.getStatusCode());

        //Assert the response code and life cycle state
        APIVerification.responseCodeValidation(unAssignDashcamResponse, 204);

        System.out.println("The Status code of the response is " + unAssignDashcamResponse.getStatusCode());

        System.out.println("The Life Cycle State of the Dashcam is PENDING_ASSIGNMENT");

        //installDashcamResponse.then().assertThat().body("lifeCycleState", Is.is("PENDING_ASSIGNMENT"));

    }

    private void unInstallDashcam(UUID deviceId) {

        HeaderConfigs headers = new HeaderConfigs();
        PostAPIBuilder builder = new PostAPIBuilder();

        AssetAndOrgIdPojo assetAndOrgIdPojo = new AssetAndOrgIdPojo("f410f224-926c-4b7e-96bf-d968d02639a0", "c50db1c6-10c7-47f8-819b-57d0a3cdbcaf");

        //PostAPITests p1= new PostAPITests();

        Response unInstallDashcamResponse = given().spec(spec).when().headers(headers.defaultHeaders()).body(assetAndOrgIdPojo).when().patch(APIPath.apiPath.UNINSTALL_DASHCAMS + deviceId + "/uninstall");

        // Response unInstallDashcamRFesponse = spec.given().when().headers(headers.defaultHeaders()).body("{\n" + " \"assetId\": \"f410f224-926c-4b7e-96bf-d968d02639a0\",\n" + "  \"organisationId\": \"c50db1c6-10c7-47f8-819b-57d0a3cdbcaf\"}\n" + " ").when().patch(APIPath.apiPath.UNINSTALL_DASHCAMS + deviceId + "/uninstall");

        System.out.println(unInstallDashcamResponse.getBody().asString());
        System.out.println(unInstallDashcamResponse.getStatusCode());

        //Assert the response code and life cycle state
        APIVerification.responseCodeValidation(unInstallDashcamResponse, 200);

        System.out.println("The Status code of the response is " + unInstallDashcamResponse.getStatusCode());

        System.out.println("The Life Cycle State of the Dashcam is PENDING_INSTALL");

        //installDashcamResponse.then().assertThat().body("lifeCycleState", Is.is("PENDING_ASSIGNMENT"));

    }

}


