package dashcamLifeCycle;

import baseTest.AmsBaseTest;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Dashcam_NegativeTest extends AmsBaseTest {
//
//    //   (dataProvider="leaseDashcamData")
//    public static void leaseDashcam_NegativeRequest(String Org_Id, String Header, String Endpoint, String Device_Id) {
//
//        JSONObject request = new JSONObject();
//
//        request.put("organisationId", Org_Id);
//
//        baseURI = "http://ams.test.erdmg.com/asset-management-service-api/provision/devices/" + Device_Id;
//        ResponseOptions response = (ResponseOptions) given().contentType(ContentType.JSON).
//                accept(ContentType.JSON).
//                headers("Content-Type", Header).
//                body(request.toJSONString()).
//                when().
//                patch(Endpoint);
////        then().
////                statusCode(200).log().all();
//    }


    public static Response leaseDashcam_NegativeTemplate(String DeviceId, String OrgId, String Header, String Endpoint) {

        JSONObject request = new JSONObject();

        request.put("organisationId", OrgId);

        baseURI = "http://ams.test.erdmg.com/asset-management-service-api/provision/devices/" + DeviceId;
        Response response =given().spec(spec).

                headers( "Content-Types",Header).
                body(request.toJSONString()).
                when().
                patch(Endpoint).then().using().extract().response();
        int statusCode = response.getStatusCode();

        return response;

    }
    public static Response leaseDashcam_InvalidRequestType(String DeviceId, String OrgId, String Header, String Endpoint) {

        JSONObject request = new JSONObject();

        request.put("organisationId", OrgId);

        baseURI = "http://ams.test.erdmg.com/asset-management-service-api/provision/devices/" + DeviceId;
        Response response = given().spec(spec)

                .headers( "Content-Types",Header).
                body(request.toJSONString()).
                when().
                post(Endpoint).then().using().extract().response();
        int statusCode = response.getStatusCode();

        return response;

    }
}


