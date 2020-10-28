package stepDefinitions;

import apiVerifications.APIVerification;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import dashcamLifeCycle.DashcamProvisioning_E2E;
import extentReport.ExtentReportListenerB;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.internal.RestAssuredResponseImpl;
import sharedData.FeatureSharedData;
import sharedData.SharedDataName;


public class CreateDashcamAPIStep extends ExtentReportListenerB {

    @Given("the user invokes the CreateDashcam API")
    public void theUserInvokesTheCreatedashcamApi() {

        ExtentTest logInfo = null;
        try {
            test = extent.createTest(Feature.class, "Dashcam Provisioning_E2E");
            test = test.createNode(Scenario.class, "Create Dashcam and Validate Status Code and LifeCycle State");
            logInfo = test.createNode(new GherkinKeyword("Given"), "the user invokes the CreateDashcam API");

            RestAssuredResponseImpl response = (RestAssuredResponseImpl) DashcamProvisioning_E2E.createDashcam();
            FeatureSharedData.getINSTANCE().setSharedData(SharedDataName.CREATE_DASHCAM_RESPONSE, response);

            DashcamProvisioning_E2E.getDeviceId(response.jsonPath());

            logInfo.pass("The user Invoked the CreateDashcam API");

        } catch (Exception e) {
            testStepHandle("FAIL", logInfo, e);
        }
    }

    @When("the user validates the response and the status code")
    public void theUserValidateTheRespnseAndTheStatusCode() {
        ExtentTest logInfo = null;

        try {
            logInfo = test.createNode(new GherkinKeyword("When"), "the user validates the response and the status code");

            RestAssuredResponseImpl response = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                    .getSharedDataValue(SharedDataName.CREATE_DASHCAM_RESPONSE);

            APIVerification.responseCodeValidation(response, 201);

            logInfo.pass("The user validated the response and the status code");

        } catch (Exception e) {
            testStepHandle("FAIL", logInfo, e);
        }
    }

    @Then("validate if the lifecycle state of the response is AVAILABLE")
    public void theLifecycleStateShouldBeInAVAILABLE() {
        ExtentTest logInfo = null;

        try {
            logInfo = test.createNode(new GherkinKeyword("Then"), "validate if the lifecycle state of the response is AVAILABLE");

            RestAssuredResponseImpl response = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                    .getSharedDataValue(SharedDataName.CREATE_DASHCAM_RESPONSE);

            DashcamProvisioning_E2E.assertLifeCycleState(response.jsonPath());
            logInfo.pass("The user validated the lifecycle state");

        } catch (Exception e) {
            testStepHandle("FAIL", logInfo, e);
        }
    }
}