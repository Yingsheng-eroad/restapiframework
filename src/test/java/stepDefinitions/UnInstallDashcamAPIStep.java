package stepDefinitions;

import apiVerifications.APIVerification;
import dashcamLifeCycle.DashcamProvisioning_E2E;
import io.cucumber.java.en.Given;
import sharedData.FeatureSharedData;
import sharedData.SharedDataName;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.internal.RestAssuredResponseImpl;

public class UnInstallDashcamAPIStep {

    @When("the user invokes the UnInstallDashcam API")
    public void theUserInvokesTheInstallDashcamApi() {

        RestAssuredResponseImpl response = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.CREATE_DASHCAM_RESPONSE);

        RestAssuredResponseImpl unInstallDashcam = (RestAssuredResponseImpl) DashcamProvisioning_E2E
                .unInstallDashcam(DashcamProvisioning_E2E.getDeviceId(response.jsonPath()));

        FeatureSharedData.getINSTANCE().setSharedData(SharedDataName.UNINSTALL_DASHCAM_RESPONSE, unInstallDashcam);

    }

    @Then("the user validates the status code of UnInstallDashcam API")
    public void theUserValidatesTheResponseAndTheStatusCode() {

        RestAssuredResponseImpl installDashcamResponse = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.UNINSTALL_DASHCAM_RESPONSE);
        APIVerification.responseCodeValidation(installDashcamResponse, 200);

    }


}
