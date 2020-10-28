@amstest2
Feature: Dashcam Provisioning_Parameterization

  Scenario Outline: Create Dashcam and Validate Status Code and LifeCycle State
    Given the user invokes the CreateDashcam API
    When the user validates the response and the status code
    Then validate if the lifecycle state of the response is AVAILABLE
    And the user stores the DeviceId from the CreateDashcam API response
    When the user invokes the LeaseDashcam API by passing the "<organisationId>"
    Then the user validates the status code of LeaseDashcam API
    And validate if the lifecycle state of the response is PENDING_INSTALL
    When the user invokes the InstallDashcam API
    Then the user validates the status code of InstallDashcam API
    And validate if the lifecycle state of the response is PENDING_ASSIGNMENT
    When the user invokes the AssignDashcam API by passing the "<assetId>"
    Then the user validates the status code of AssignDashcam API
    And validate if the lifecycle state of the response is INSTALLED
    When the user invokes the UnAssignDashcam API by passing the "<assetId>" and "<organisationId>"
    Then the user validates the status code of UnAssignDashcam API
    And validate if the lifecycle state of the response is PENDING_ASSIGNMENT

    Examples:
      | assetId                              | organisationId                       |
      | f410f224-926c-4b7e-96bf-d968d02639a0 | c50db1c6-10c7-47f8-819b-57d0a3cdbcaf |

