package stepDefinitions;

import apiVerifications.APIVerification;
import features.ToBeDeleted.CreateDashcamDemo1;
import dashcamLifeCycle.DashcamProvisioning_E2E;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.internal.RestAssuredResponseImpl;
import sharedData.FeatureSharedData;
import sharedData.SharedDataName;

public class CreateDashcamDemo1Step {
    @Given("user invokes the CreateDashcam API")
    public void userInvokesTheCreateDashcamAPI() {
        {
            RestAssuredResponseImpl response = (RestAssuredResponseImpl) CreateDashcamDemo1.createDashcam();
            FeatureSharedData.getINSTANCE().setSharedData(SharedDataName.CREATE_DASHCAM_RESPONSE, response);
        }
    }

    @When("user validates the response and the status code")
    public void userValidatesTheResponseAndTheStatusCode() {

        RestAssuredResponseImpl response = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.CREATE_DASHCAM_RESPONSE);

        APIVerification.responseCodeValidation(response, 201);
        
    }

    @Then("user validate if the lifecycle state of the response is AVAILABLE")
    public void userValidateIfTheLifecycleStateOfTheResponseIsAVAILABLE() {

        RestAssuredResponseImpl response = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.CREATE_DASHCAM_RESPONSE);

        DashcamProvisioning_E2E.assertLifeCycleState(response.jsonPath());

    }
}
