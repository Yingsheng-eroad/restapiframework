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


public class AssignDashcamAPIStep {

    @When("the user invokes the AssignDashcam API")
    public void theUserInvokesTheInstallDashcamApi() throws ClassNotFoundException {
      // scenarioDef.createNode(new GherkinKeyword("Then"),"the user invokes the AssignDashcam API");


        RestAssuredResponseImpl response = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.CREATE_DASHCAM_RESPONSE);

        RestAssuredResponseImpl assignDashcamResponse = (RestAssuredResponseImpl) DashcamProvisioning_E2E
                .assignDashcam(DashcamProvisioning_E2E.getDeviceId(response.jsonPath()));

        FeatureSharedData.getINSTANCE().setSharedData(SharedDataName.ASSIGN_DASHCAM_RESPONSE, assignDashcamResponse);

    }

    @Then("the user validates the status code of AssignDashcam API")
    public void theUserValidatesTheResponseAndTheStatusCode() {

        RestAssuredResponseImpl assignDashcamResponse = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.ASSIGN_DASHCAM_RESPONSE);

        APIVerification.responseCodeValidation(assignDashcamResponse, 200);

    }

    @And("validate if the lifecycle state of the response is INSTALLED")
    public void validatesTheLifecycleStateOfTheResponse() {

        RestAssuredResponseImpl response = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.CREATE_DASHCAM_RESPONSE);

        RestAssuredResponseImpl getDashcamIdResponse = (RestAssuredResponseImpl) DashcamProvisioning_E2E
                .getDashcamIdAPI(DashcamProvisioning_E2E.getDeviceId(response.jsonPath()));

        Assert.assertEquals(DashcamProvisioning_E2E.assertGetDashcamLifeCycleState(getDashcamIdResponse.jsonPath()), "INSTALLED");

    }

}


