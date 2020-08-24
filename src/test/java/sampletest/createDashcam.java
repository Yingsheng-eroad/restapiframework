package sampletest;

import io.restassured.RestAssured;
import org.testng.annotations.Test;


public class createDashcam {

    @Test
    public void createDashcampost(){

        RestAssured.baseURI="http://ams.test.erdmg.com/asset-management-service-api/devices/dashcams";

        RestAssured.given().body("{\n"+
                "\"serialNumber\": \"Talltst-1\",\n"+
                                  "\n"+"\"productType\": \"0\",\n"+
                "\n"+"\"lifeCycleState\": \"AVAILABLE\",\n"+
                "\n"+"\"model\": \"Dashcam model\",\n"+
                "\n"+"\"status\": \"AUTHORISED\",\n"+
                "\n"+"\"hardwareRevision\": \"1\",\n"+
                "\n"+"\"make\": \"Dashcam1\",\n"+
                "\n"+"\"rmaPending\": \"true\",\n"+
                "\n"+"\"imei\": \"India\",\n"+
                "\n"+"\"cpuType\": \"AghgD\",\n"+
                "\n"+"\"imei\": \"Indidfdf1\",\n"+
                "\n"+"\"dispatchDate\": \"2020-08-28T21:19:34.453Z\",\n"+
                "\n"+"\"imsi\": \"Tall-1\",\n"+
                "\n"+"\"iccid \": \"Tall-2\",\n"+
                "\n"+"\"msisdn\": \"0\" \n"+ "}" )
                .post()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(201);



    }

}
