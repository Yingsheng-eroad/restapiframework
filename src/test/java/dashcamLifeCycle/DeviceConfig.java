package dashcamLifeCycle;

import apiBuilder.PostAPIBuilder;
import apiConfig.APIPath;
import apiConfig.HeaderConfigs;
import baseTest.DeviceConfigBaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.OrganisationIdPojo;
import utils.JavaUtils;

import java.net.URI;
import java.net.URISyntaxException;
import utils.JavaUtils;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class DeviceConfig extends DeviceConfigBaseTest {

    public static Response getDeviceConfig(UUID deviceId) {
        HeaderConfigs headers = new HeaderConfigs();
        PostAPIBuilder builder = new PostAPIBuilder();
        //OrganisationIdPojo leaseDashcamPojo = new OrganisationIdPojo(organisationId);
        //  String body = "{\"organisationId\":\""+ organisationId + "\"}";
        Response deviceConfigResponse = given().spec(spec).when()
                                                   .headers(headers.defaultHeaders())
                                                   .when()
                                                   .get(APIPath.apiPath.GET_DEVICECONFIG + deviceId + "/configuration")
                .then().using().extract().response();

        return deviceConfigResponse;
    }
}
