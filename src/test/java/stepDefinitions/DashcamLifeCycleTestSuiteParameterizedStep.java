package stepDefinitions;

import dashcamLifeCycle.DashcamProvisioning_E2E;
import dashcamLifeCycle.DashcamProvisioning_Parameterized;
import sharedData.FeatureSharedData;
import sharedData.SharedDataName;
import io.cucumber.java.en.When;
import io.restassured.internal.RestAssuredResponseImpl;

public class DashcamLifeCycleTestSuiteParameterizedStep  {


    @When("the user invokes the LeaseDashcam API by passing the {string}")
    public void theUserInvokesTheLeaseDashcamAPIByPassingThe(String organisationId) {

        RestAssuredResponseImpl response = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.CREATE_DASHCAM_RESPONSE);

        RestAssuredResponseImpl leaseDashcamResponse = (RestAssuredResponseImpl) DashcamProvisioning_Parameterized
                .leaseDashcam(DashcamProvisioning_E2E.getDeviceId(response.jsonPath()),organisationId);

        FeatureSharedData.getINSTANCE().setSharedData(SharedDataName.LEASE_DASHCAM_RESPONSE,leaseDashcamResponse);

    }

    @When("the user invokes the AssignDashcam API by passing the {string}")
    public void theUserInvokesTheAssignDashcamAPIByPassingThe(String assetId) {

        RestAssuredResponseImpl response = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.CREATE_DASHCAM_RESPONSE);

        RestAssuredResponseImpl assignDashcamResponse = (RestAssuredResponseImpl) DashcamProvisioning_Parameterized
                .assignDashcam(DashcamProvisioning_E2E.getDeviceId(response.jsonPath()),assetId);

        FeatureSharedData.getINSTANCE().setSharedData(SharedDataName.ASSIGN_DASHCAM_RESPONSE, assignDashcamResponse);


    }

    @When("the user invokes the UnAssignDashcam API by passing the {string} and {string}")
    public void theUserInvokesTheUnAssignDashcamAPIByPassingTheAnd(String assetId ,String organisationId) {

        RestAssuredResponseImpl response = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.CREATE_DASHCAM_RESPONSE);

        RestAssuredResponseImpl unAssignDashcamResponse = (RestAssuredResponseImpl) DashcamProvisioning_Parameterized
                .unAssignDashcam(DashcamProvisioning_E2E.getDeviceId(response.jsonPath()),assetId,organisationId);

        FeatureSharedData.getINSTANCE().setSharedData(SharedDataName.UNASSIGN_DASHCAM_RESPONSE, unAssignDashcamResponse);
    }

    @When("the user invokes the UnInstallDashcam API by passing the {string} and {string}")
    public void theUserInvokesTheUnInstallDashcamAPIByPassingTheAnd(String assetId ,String organisationId) {

        RestAssuredResponseImpl response = (RestAssuredResponseImpl) FeatureSharedData.getINSTANCE()
                .getSharedDataValue(SharedDataName.CREATE_DASHCAM_RESPONSE);

        RestAssuredResponseImpl unInstallDashcamResponse = (RestAssuredResponseImpl) DashcamProvisioning_Parameterized
                .unAssignDashcam(DashcamProvisioning_E2E.getDeviceId(response.jsonPath()),assetId,organisationId);

        FeatureSharedData.getINSTANCE().setSharedData(SharedDataName.UNINSTALL_DASHCAM_RESPONSE, unInstallDashcamResponse);
    }


//    @Given("the user invokes the CreateDashcam API by passing {string},{string},{string}")
//    public void theUserInvokesTheCreateDashcamAPIByPassing(String serialNumber, String imsi, String iccid) {
//
//        RestAssuredResponseImpl response = (RestAssuredResponseImpl) DashcamLifeCycleTestSuite_Parameterized.createDashcam(serialNumber,imsi,iccid);
//        FeatureSharedData.getINSTANCE().setSharedData(SharedDataName.CREATE_DASHCAM_RESPONSE, response);
//
//        DashcamLifeCycleTestSuite_Parameterized.getDeviceId(response.jsonPath());
//    }


}
