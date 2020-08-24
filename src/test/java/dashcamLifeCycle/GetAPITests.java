package dashcamLifeCycle;

import apiConfig.APIPath;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetAPITests extends BaseTest {
    @Test
    public void getAPITest() {
       // RestAssured.given().when().get(APIPath.apiPath.GET_DASHCAMS).then().log().all().statusCode(200);

        Response response = RestAssured.given().when().get(APIPath.apiPath.GET_DASHCAMS);
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getCookies());
        System.out.println(response.getTime());
    }
}