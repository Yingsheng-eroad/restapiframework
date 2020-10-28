package stepDefinitions;

import apiVerifications.APIVerification;
import dashcamLifeCycle.DashcamProvisioning_E2E;
import dashcamLifeCycle.DeviceConfig;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.internal.RestAssuredResponseImpl;
import sharedData.FeatureSharedData;
import sharedData.SharedDataName;

import java.util.UUID;

import static org.hamcrest.Matchers.*;

public class DeviceConfigSteps {

    @When("the user validates the Device Configuration Service")
    public void theUserValidatesTheDeviceConfigurationService() throws ClassNotFoundException, InterruptedException {

   //        RestAssuredResponseImpl response = (RestAssuredResponseImpl) DeviceConfig.getDeviceConfig(deviceId);
//        FeatureSharedData.getINSTANCE().setSharedData(SharedDataName.DEVICE_CONFIG_RESPONSE, response);

        RestAssuredResponseImpl response = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.CREATE_DASHCAM_RESPONSE);

        Thread.sleep(5000);

        RestAssuredResponseImpl deviceConfigDashcamResponse = (RestAssuredResponseImpl) DeviceConfig.getDeviceConfig
                (DashcamProvisioning_E2E.getDeviceId(response.jsonPath()));


        FeatureSharedData.getINSTANCE().setSharedData(SharedDataName.DEVICE_CONFIG_RESPONSE, deviceConfigDashcamResponse);
    }

    @Then("the value of gpsEnabled and sensorEnabled keys in the DeviceConfig Service response should be set to true")
    public void theValueOfGpsEnabledAndSensorEnabledKeysInTheDeviceConfigServiceResponseShouldBeSetToTrue()  {

        RestAssuredResponseImpl response = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.DEVICE_CONFIG_RESPONSE);
        APIVerification.responseCodeValidation(response, 200);

        response.then().assertThat().rootPath("desired").body("gpsEnabled",equalTo(true));

        Boolean gpsEnabled = response.getBody().jsonPath().get("desired.gpsEnabled");
        System.out.println("The value of gpsEnabled " + gpsEnabled);

        response.then().assertThat().rootPath("desired").body ("sensorEnabled",equalTo(true) );
        Boolean sensorEnabled = response.getBody().jsonPath().get("desired.sensorEnabled");
        System.out.println("The value of sensorEnabled " + sensorEnabled);

    }

    @Then("the value of gpsEnabled and sensorEnabled keys in the response of DeviceConfig Service should be set to false")
    public void theValueOfGpsEnabledAndSensorEnabledKeysInTheResponseOfDeviceConfigServiceShouldBeSetToFalse() {

        RestAssuredResponseImpl response = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.DEVICE_CONFIG_RESPONSE);
        APIVerification.responseCodeValidation(response, 200);
        //        JsonPath jp = response.jsonPath();
//        String sensorEnabled = jp.getString("desired.sensorEnabled");
//        Assert.assertEquals(sensorEnabled, "true");
        response.then().assertThat().rootPath("desired").body("gpsEnabled",equalTo(false));

        Boolean gpsEnabled = response.getBody().jsonPath().get("desired.gpsEnabled");
        System.out.println("The value of gpsEnabled " + gpsEnabled);

        response.then().assertThat().rootPath("desired").body ("sensorEnabled",equalTo(false) );

        Boolean sensorEnabled = response.getBody().jsonPath().get("desired.sensorEnabled");
        System.out.println("The value of sensorEnabled " + sensorEnabled);
    }

    @When("the user validates the Device Configuration Service by passing the deviceId")
    public void theUserValidatesTheDeviceConfigurationServiceByPassingTheDeviceId() {

        RestAssuredResponseImpl response = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.CREATE_DASHCAM_RESPONSE);

        RestAssuredResponseImpl leaseDashcamResponse = (RestAssuredResponseImpl) DashcamProvisioning_E2E
                .leaseDashcam(DashcamProvisioning_E2E.getDeviceId(response.jsonPath()));

    }


}
