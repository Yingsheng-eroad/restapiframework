package stepDefinitions;

import apiVerifications.APIVerification;
import dashcamLifeCycle.DashcamLifeCycleTestSuite;
import features.FeatureSharedData;
import features.SharedDataName;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.UUID;

public class LeaseDashcamAPIStep {

    @Given("the user stores the DeviceId from the CreateDashcam API response")
    public void storeDeviceIDFromResponse() {
        RestAssuredResponseImpl response = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.CREATE_DASHCAM_RESPONSE);
        UUID deviceId = DashcamLifeCycleTestSuite.getDeviceId(response.jsonPath());
        Assert.assertNotNull(deviceId);
    }

    @When("the user invokes the LeashDashcam API")
    public void theUserInvokesTheLeashdashcamApi() {
        RestAssuredResponseImpl response = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.CREATE_DASHCAM_RESPONSE);
        RestAssuredResponseImpl leaseDashcamResponse = (RestAssuredResponseImpl) DashcamLifeCycleTestSuite
                .leaseDashcam(DashcamLifeCycleTestSuite.getDeviceId(response.jsonPath()));
    }

    @Then("the user validates the status code of LeaseDashcam API")
    public void theUserValidatesTheResponseAndTheStatusCode() {
        RestAssuredResponseImpl response = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.CREATE_DASHCAM_RESPONSE);
        RestAssuredResponseImpl leaseDashcamResponse = (RestAssuredResponseImpl) DashcamLifeCycleTestSuite
                .leaseDashcam(DashcamLifeCycleTestSuite.getDeviceId(response.jsonPath()));
        APIVerification.responseCodeValidation(leaseDashcamResponse, 200);
    }

    @And("validate if the lifecycle state of the response is PENDING_INSTALL")
    public void validatesTheLifecycleStateOfTheResponse() {
        RestAssuredResponseImpl response = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.CREATE_DASHCAM_RESPONSE);
        RestAssuredResponseImpl getResponse = (RestAssuredResponseImpl) DashcamLifeCycleTestSuite
                .getDashcamIdAPI(DashcamLifeCycleTestSuite.getDeviceId(response.jsonPath()));
        Assert.assertEquals(DashcamLifeCycleTestSuite.assertGetDashcamLifeCycleState(getResponse.jsonPath()), "PENDING_INSTALL");

    }
}

