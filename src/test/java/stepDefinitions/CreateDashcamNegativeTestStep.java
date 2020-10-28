package stepDefinitions;

import apiVerifications.APIVerification;
import baseTest.AmsBaseTest;
import dashcamLifeCycle.CreateDashcam_NegativeTest;
import dashcamLifeCycle.DashcamProvisioning_E2E;
import dashcamLifeCycle.DashcamProvisioning_Parameterized;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.internal.RestAssuredResponseImpl;
import sharedData.FeatureSharedData;
import sharedData.SharedDataName;

public class CreateDashcamNegativeTestStep extends AmsBaseTest {
    @Given("The user invokes the CreateDashcam API by passing {string} , {string} , {string}  in the body of the response")
    public void theUserInvokesTheCreateDashcamAPIByPassingInTheBodyOfTheResponse(String serialNumber, String imsi, String iccid) {

        RestAssuredResponseImpl response = (RestAssuredResponseImpl) DashcamProvisioning_Parameterized.createDashcam(serialNumber, imsi, iccid);
        FeatureSharedData.getINSTANCE().setSharedData(SharedDataName.CREATE_DASHCAM_RESPONSE, response);
    }

    @Then("the user validates if the status code is 400")
    public void theUserValidateTheRespnseAndTheStatusCode() {

        RestAssuredResponseImpl response = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.CREATE_DASHCAM_RESPONSE);

        //APIVerification.responseCodeValidation(response, 400);
        APIVerification.negativeResponseCodeValidation(response, 400, "HTTP/1.1 400 ");


    }

    @Then("the user validates if the dashcam is created using getDashcamAPI")
    public void theUserValidatesIfTheDashcamIsCreatedUsingGetDashcamAPI() {
        RestAssuredResponseImpl response = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.CREATE_DASHCAM_RESPONSE);
        RestAssuredResponseImpl getDashcamIdResponse = (RestAssuredResponseImpl) DashcamProvisioning_E2E
                .getDashcamIdAPI(DashcamProvisioning_E2E.getDeviceId(response.jsonPath()));

        APIVerification.responseCodeValidation(getDashcamIdResponse, 500);
    }

    @Given("the user invokes the CreateDashcam API with Invalid Endpoint")
    public void theUserInvokesTheCreateDashcamAPIWithInvalidEndpoint() {
        RestAssuredResponseImpl response = (RestAssuredResponseImpl) CreateDashcam_NegativeTest.createDashcamInvalidEndpoint();
        FeatureSharedData.getINSTANCE().setSharedData(SharedDataName.CREATE_DASHCAM_RESPONSE, response);

        DashcamProvisioning_E2E.getDeviceId(response.jsonPath());
    }

    @Then("the user validates {int} error code")
    public void theUserValidatesErrorCode(int arg0) {
        RestAssuredResponseImpl response = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.CREATE_DASHCAM_RESPONSE);
        //   Assert.assertFalse(response.asString().contains("Could not get any response"));
        APIVerification.responseCodeValidation(response, 404);

    }

    @Given("the user invokes the CreateDashcam API with Invalid Header")
    public void theUserInvokesTheCreateDashcamAPIWithInvalidHeader() {
        RestAssuredResponseImpl response = (RestAssuredResponseImpl) CreateDashcam_NegativeTest.createDashcamInvalidHeader();
        FeatureSharedData.getINSTANCE().setSharedData(SharedDataName.CREATE_DASHCAM_RESPONSE, response);

        DashcamProvisioning_E2E.getDeviceId(response.jsonPath());

    }

    @Then("the user validates the error code {int}")
    public void theUserValidatesTheErrorCode(int arg0) {
        RestAssuredResponseImpl response = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.CREATE_DASHCAM_RESPONSE);
        //   Assert.assertFalse(response.asString().contains("Could not get any response"));
        APIVerification.responseCodeValidation(response, 500);
    }

    @Given("the user invokes the CreateDashcam API with Null Content Type Header")
    public void theUserInvokesTheCreateDashcamAPIWithNullContentTypeHeader() {
        RestAssuredResponseImpl response = (RestAssuredResponseImpl) CreateDashcam_NegativeTest.createDashcamNullContentTypeHeader();
        FeatureSharedData.getINSTANCE().setSharedData(SharedDataName.CREATE_DASHCAM_RESPONSE, response);

        DashcamProvisioning_E2E.getDeviceId(response.jsonPath());
    }

    @Given("the user invokes the CreateDashcam API with Invalid Request Type")
    public void theUserInvokesTheCreateDashcamAPIWithInvalidRequestType() {
        RestAssuredResponseImpl response = (RestAssuredResponseImpl) CreateDashcam_NegativeTest.createDashcamInvalidRequestType();
        FeatureSharedData.getINSTANCE().setSharedData(SharedDataName.CREATE_DASHCAM_RESPONSE, response);

        DashcamProvisioning_E2E.getDeviceId(response.jsonPath());

    }

    @Given("the user invokes the CreateDashcam API with Null Accept Key Header")
    public void theUserInvokesTheCreateDashcamAPIWithNullAcceptKeyHeader() {
        RestAssuredResponseImpl response = (RestAssuredResponseImpl) CreateDashcam_NegativeTest.createDashcamNullAcceptKeyHeader();
        FeatureSharedData.getINSTANCE().setSharedData(SharedDataName.CREATE_DASHCAM_RESPONSE, response);

        DashcamProvisioning_E2E.getDeviceId(response.jsonPath());
    }


    @Given("the user invokes the CreateDashcam API with no Serial Number")
    public void theUserInvokesTheCreateDashcamAPIWithNoSerialNumber() {
        RestAssuredResponseImpl response = (RestAssuredResponseImpl) CreateDashcam_NegativeTest.createDashcamInvalidPostRequestBody();
        FeatureSharedData.getINSTANCE().setSharedData(SharedDataName.CREATE_DASHCAM_RESPONSE, response);

        DashcamProvisioning_E2E.getDeviceId(response.jsonPath());
    }


}

