package stepDefinitions;

import apiVerifications.APIVerification;
import dashcamLifeCycle.Dashcam_NegativeTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.internal.RestAssuredResponseImpl;
import sharedData.FeatureSharedData;
import sharedData.SharedDataName;

import static io.restassured.RestAssured.given;

public class LeaseDashcamNegativeTestStep  {
        @Given("the user invokes the LeaseDashcam API with {string},{string},{string},{string}")
    public void theUserInvokesTheLeaseDashcamAPIWith(String DeviceId, String OrgId, String Header, String Endpoint) {

            RestAssuredResponseImpl response = (RestAssuredResponseImpl) Dashcam_NegativeTest.leaseDashcam_NegativeTemplate(DeviceId, OrgId, Header, Endpoint);
            FeatureSharedData.getINSTANCE().setSharedData(SharedDataName.LEASE_DASHCAM_NEGATIVE_RESPONSE, response);
        }



    @Then("the user validates if the negative testing status code is {int}")
    public void theUserValidatesIfTheNegativeTestingStatusCodeIs(int arg0) {

    RestAssuredResponseImpl negativeResponse = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
            .getSharedDataValue(SharedDataName.LEASE_DASHCAM_NEGATIVE_RESPONSE);
            APIVerification.responseCodeValidation(negativeResponse, 404);
    }


    @Then("the user validates {int} status code")
    public void theUserValidatesStatusCode(int arg0) {
        RestAssuredResponseImpl negativeResponse = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.LEASE_DASHCAM_NEGATIVE_RESPONSE);
        APIVerification.responseCodeValidation(negativeResponse, 500);
    }


    @Given("the user invokes the LeaseDashcam API with Invalid request type and {string},{string},{string},{string}")
    public void theUserInvokesTheLeaseDashcamAPIWithInvalidRequestTypeAnd(String DeviceId, String OrgId, String Header, String Endpoint) {

        RestAssuredResponseImpl response = (RestAssuredResponseImpl) Dashcam_NegativeTest.leaseDashcam_InvalidRequestType(DeviceId, OrgId, Header, Endpoint);
        FeatureSharedData.getINSTANCE().setSharedData(SharedDataName.LEASE_DASHCAM_NEGATIVE_RESPONSE, response);
    }

}