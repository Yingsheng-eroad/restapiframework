package stepDefinitions;

import apiVerifications.APIVerification;
import dashcamLifeCycle.DashcamProvisioning_E2E;
import sharedData.FeatureSharedData;
import sharedData.SharedDataName;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.internal.RestAssuredResponseImpl;

public class UnassignDashcamAPIStep {

    @When("the user invokes the UnAssignDashcam API")
    public void theUserInvokesTheInstallDashcamApi() {

        RestAssuredResponseImpl response = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.CREATE_DASHCAM_RESPONSE);

        RestAssuredResponseImpl unAssignDashcam = (RestAssuredResponseImpl) DashcamProvisioning_E2E
                .unAssignDashcam(DashcamProvisioning_E2E.getDeviceId(response.jsonPath()));

        FeatureSharedData.getINSTANCE().setSharedData(SharedDataName.UNASSIGN_DASHCAM_RESPONSE, unAssignDashcam);

    }

    @Then("the user validates the status code of UnAssignDashcam API")
    public void theUserValidatesTheResponseAndTheStatusCode() {

        RestAssuredResponseImpl installDashcamResponse = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.UNASSIGN_DASHCAM_RESPONSE);
        APIVerification.responseCodeValidation(installDashcamResponse, 204);

    }

}