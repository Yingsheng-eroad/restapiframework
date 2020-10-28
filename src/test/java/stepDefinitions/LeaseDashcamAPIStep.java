package stepDefinitions;

import apiVerifications.APIVerification;
import dashcamLifeCycle.DashcamProvisioning_E2E;
import sharedData.FeatureSharedData;
import sharedData.SharedDataName;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.internal.RestAssuredResponseImpl;
import org.testng.Assert;

import java.util.UUID;

public class LeaseDashcamAPIStep {

    @Given("the user stores the DeviceId from the CreateDashcam API response")
    public void storeDeviceIDFromResponse() {

        RestAssuredResponseImpl response = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.CREATE_DASHCAM_RESPONSE);

        UUID deviceId = DashcamProvisioning_E2E.getDeviceId(response.jsonPath());
        Assert.assertNotNull(deviceId);

    }

    @When("the user invokes the LeaseDashcam API")
    public void theUserInvokesTheLeashdashcamApi() {

        RestAssuredResponseImpl response = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.CREATE_DASHCAM_RESPONSE);

        RestAssuredResponseImpl leaseDashcamResponse = (RestAssuredResponseImpl) DashcamProvisioning_E2E
                .leaseDashcam(DashcamProvisioning_E2E.getDeviceId(response.jsonPath()));

        FeatureSharedData.getINSTANCE().setSharedData(SharedDataName.LEASE_DASHCAM_RESPONSE,leaseDashcamResponse);
    }

    @Then("the user validates the status code of LeaseDashcam API")
    public void theUserValidatesTheResponseAndTheStatusCode() {

        RestAssuredResponseImpl leaseDashcamResponse = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.LEASE_DASHCAM_RESPONSE);

        APIVerification.responseCodeValidation(leaseDashcamResponse, 200);
    }

    @And("validate if the lifecycle state of the response is PENDING_INSTALL")
    public void validatesTheLifecycleStateOfTheResponse() {

        RestAssuredResponseImpl response = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.CREATE_DASHCAM_RESPONSE);
        RestAssuredResponseImpl getDashcamIdResponse = (RestAssuredResponseImpl) DashcamProvisioning_E2E
                .getDashcamIdAPI(DashcamProvisioning_E2E.getDeviceId(response.jsonPath()));

        Assert.assertEquals(DashcamProvisioning_E2E.assertGetDashcamLifeCycleState(getDashcamIdResponse.jsonPath()), "PENDING_INSTALL");

    }
}

