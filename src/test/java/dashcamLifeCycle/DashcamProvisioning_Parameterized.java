package dashcamLifeCycle;
import pojo.CreateDashcamPojo;
import apiBuilder.PostAPIBuilder;
import apiConfig.APIPath;
import apiConfig.HeaderConfigs;
import baseTest.AmsBaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.AssetAndOrgIdPojo;
import pojo.AssetIdPojo;
import pojo.OrganisationIdPojo;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class DashcamProvisioning_Parameterized extends AmsBaseTest {
    public static Response createDashcam(String serialNumber, String imsi, String iccid) {

        //Invoke API and Retrieve Device Id
        HeaderConfigs headers = new HeaderConfigs();
        PostAPIBuilder builder = new PostAPIBuilder();
        CreateDashcamPojo createDashcamPojo = new CreateDashcamPojo(serialNumber, imsi, iccid);

        //Post Method to create a dashcam
        Response createDashcamresponse = given().spec(spec).when().headers(headers.defaultHeaders())
                .body(createDashcamPojo).when().post(APIPath.apiPath.CREATE_DASHCAMS);

        return createDashcamresponse;

    }


    public static Response leaseDashcam(UUID deviceId, String organisationId) {

        HeaderConfigs headers = new HeaderConfigs();
        PostAPIBuilder builder = new PostAPIBuilder();
        OrganisationIdPojo leaseDashcamPojo = new OrganisationIdPojo(organisationId);
        //  String body = "{\"organisationId\":\""+ organisationId + "\"}";
        Response leaseDashcamResponse = given().spec(spec).when().headers(headers.defaultHeaders())
                .body(leaseDashcamPojo).when().
                        patch(APIPath.apiPath.LEASE_DASHCAMS + deviceId + "/lease")
                .then().using().extract().response();

        return leaseDashcamResponse;

    }

    public static Response assignDashcam(UUID deviceId, String assetId) {

        HeaderConfigs headers = new HeaderConfigs();
        PostAPIBuilder builder = new PostAPIBuilder();
        AssetIdPojo assetIdPojo = new AssetIdPojo(assetId);

        //PostAPITests p1= new PostAPITests();

        Response assignDashcamResponse = given().spec(spec).when().headers(headers.defaultHeaders()).
                body(assetIdPojo).when().patch(APIPath.apiPath.ASSIGN_DASHCAMS + deviceId + "/assign");

        return assignDashcamResponse;

    }

    public static Response unAssignDashcam(UUID deviceId,String assetId,String organisationId) {

        HeaderConfigs headers = new HeaderConfigs();
        PostAPIBuilder builder = new PostAPIBuilder();
//        AssetAndOrgIdPojo assetAndOrgIdPojo = new
//                AssetAndOrgIdPojo("f410f224-926c-4b7e-96bf-d968d02639a0", "c50db1c6-10c7-47f8-819b-57d0a3cdbcaf");

        AssetAndOrgIdPojo assetAndOrgIdPojo = new AssetAndOrgIdPojo(assetId , organisationId);

        Response unAssignDashcamResponse = given().spec(spec).when().headers(headers.defaultHeaders()).
                body(assetAndOrgIdPojo).when().patch(APIPath.apiPath.UNASSIGN_DASHCAMS + deviceId + "/unassign");

        return unAssignDashcamResponse;

    }
    public static Response unInstallDashcam(UUID deviceId,String assetId,String organisationId) {

        HeaderConfigs headers = new HeaderConfigs();
        PostAPIBuilder builder = new PostAPIBuilder();
//        AssetAndOrgIdPojo assetAndOrgIdPojo = new
//                AssetAndOrgIdPojo("f410f224-926c-4b7e-96bf-d968d02639a0", "c50db1c6-10c7-47f8-819b-57d0a3cdbcaf");

        AssetAndOrgIdPojo assetAndOrgIdPojo = new AssetAndOrgIdPojo(assetId , organisationId);

        Response unInstallDashcamResponse = given().spec(spec).when().headers(headers.defaultHeaders()).
                body(assetAndOrgIdPojo).when().patch(APIPath.apiPath.UNINSTALL_DASHCAMS + deviceId + "/uninstall");

        return unInstallDashcamResponse;

    }

}



