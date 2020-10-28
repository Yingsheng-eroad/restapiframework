package stepDefinitions;

import apiVerifications.APIVerification;
import dashcamLifeCycle.DashcamProvisioning_E2E;
import sharedData.FeatureSharedData;
import sharedData.SharedDataName;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.internal.RestAssuredResponseImpl;
import org.testng.Assert;

public class InstallDashcamAPIStep {

    @When("the user invokes the InstallDashcam API")
    public void theUserInvokesTheInstallDashcamApi() {

        RestAssuredResponseImpl response = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.CREATE_DASHCAM_RESPONSE);

        RestAssuredResponseImpl installDashcamResponse = (RestAssuredResponseImpl) DashcamProvisioning_E2E
                .installDashcam(DashcamProvisioning_E2E.getDeviceId(response.jsonPath()));

        FeatureSharedData.getINSTANCE().setSharedData(SharedDataName.INSTALL_DASHCAM_RESPONSE, installDashcamResponse);

    }

    @Then("the user validates the status code of InstallDashcam API")
    public void theUserValidatesTheResponseAndTheStatusCode() {

        RestAssuredResponseImpl installDashcamResponse = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.INSTALL_DASHCAM_RESPONSE);
        APIVerification.responseCodeValidation(installDashcamResponse, 204);

    }

    @And("validate if the lifecycle state of the response is PENDING_ASSIGNMENT")
    public void validatesTheLifecycleStateOfTheResponse() {

        RestAssuredResponseImpl response = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.CREATE_DASHCAM_RESPONSE);

        RestAssuredResponseImpl getDashcamIdResponse = (RestAssuredResponseImpl) DashcamProvisioning_E2E
                .getDashcamIdAPI(DashcamProvisioning_E2E.getDeviceId(response.jsonPath()));

        Assert.assertEquals(DashcamProvisioning_E2E.assertGetDashcamLifeCycleState(getDashcamIdResponse.jsonPath()), "PENDING_ASSIGNMENT");

    }

}
