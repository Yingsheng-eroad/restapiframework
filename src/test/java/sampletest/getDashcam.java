package sampletest;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class getDashcam {

    @Test
    public void getAPI(){
        RestAssured.baseURI="http://ams.test.erdmg.com/asset-management-service-api/devices/dashcams";
        RestAssured.given().param("dashcams","52ac6754-7c74-4cef-96ea-3c0d1cb31378")
                .when()
                .get()
                .then()
                .assertThat()
                .log()
                .all()
                .statusCode(200);




    }

}

