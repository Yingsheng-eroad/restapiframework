@amstest1
Feature: Dashcam Provisioning_E2E

  Scenario: Create Dashcam and Validate Status Code and LifeCycle State
    Given the user invokes the CreateDashcam API
    When the user validates the response and the status code
    Then validate if the lifecycle state of the response is AVAILABLE

  Scenario: Lease Dashcam and Validate Status Code and LifeCycle State
    Given the user stores the DeviceId from the CreateDashcam API response
    When the user invokes the LeaseDashcam API
    Then the user validates the status code of LeaseDashcam API
    And validate if the lifecycle state of the response is PENDING_INSTALL

  Scenario:Install Dashcam and Validate Status Code and LifeCycle State
    Given the user stores the DeviceId from the CreateDashcam API response
    When the user invokes the InstallDashcam API
    Then the user validates the status code of InstallDashcam API
    And validate if the lifecycle state of the response is PENDING_ASSIGNMENT

  Scenario:Assign Dashcam and Validate Status Code and LifeCycle State
    Given the user stores the DeviceId from the CreateDashcam API response
    When the user invokes the AssignDashcam API
    Then the user validates the status code of AssignDashcam API
    And validate if the lifecycle state of the response is INSTALLED

  Scenario:UnAssign Dashcam and Validate Status Code and LifeCycle State
    Given the user stores the DeviceId from the CreateDashcam API response
    When the user invokes the UnAssignDashcam API
    Then the user validates the status code of UnAssignDashcam API
    And validate if the lifecycle state of the response is PENDING_ASSIGNMENT
#
#  Scenario:UnInstall Dashcam and Validate Status Code and LifeCycle State
#    Given the user stores the DeviceId from the CreateDashcam API response
#    When the user invokes the UnInstallDashcam API
#    Then the user validates the status code of UnInstallDashcam API
#    And validate if the lifecycle state of the response is PENDING_INSTALL


