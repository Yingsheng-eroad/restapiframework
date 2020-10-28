
Feature: Update assign

  Scenario Outline: Update assign api to call device config api
    Given the user invokes the CreateDashcam API
#    When the user validates the response and the status code
#    Then validate if the lifecycle state of the response is AVAILABLE
    And the user stores the DeviceId from the CreateDashcam API response
    When the user invokes the LeaseDashcam API by passing the "<organisationId>"
#    Then the user validates the status code of LeaseDashcam API
#    And validate if the lifecycle state of the response is PENDING_INSTALL
    When the user invokes the InstallDashcam API
#    Then the user validates the status code of InstallDashcam API
#    And validate if the lifecycle state of the response is PENDING_ASSIGNMENT
    When the user invokes the AssignDashcam API by passing the "<assetId>"
#    Then the user validates the status code of AssignDashcam API
#    And validate if the lifecycle state of the response is INSTALLED
    Examples:
      | assetId                              | organisationId                       |
      | f410f224-926c-4b7e-96bf-d968d02639a0 | c50db1c6-10c7-47f8-819b-57d0a3cdbcaf |
#Feature: Update assign api to call Device Config
#
#  Scenario Outline: Invoke assign api and verify Gen-3 configuration Service
#    Given the user invokes the CreateDashcam API
#    And the user stores the DeviceId from the CreateDashcam API response
#    When the user invokes the LeaseDashcam API by passing the "<organisationId>"
#    And the user invokes the InstallDashcam API
#    When the user invokes the AssignDashcam API by passing the "<assetId>"
#    When the user validates the Device Configuration Service
##    Then the value of gpsEnabled and sensorEnabled keys in the response of Gen-3 Service should be set to true
#
#    Examples:
#      | assetId                              | organisationId                       |
#      | f410f224-926c-4b7e-96bf-d968d02639a0 | c50db1c6-10c7-47f8-819b-57d0a3cdbcaf |

#  Scenario : Invoke /UnAssign api and verify Device configuration Service
#    Given the user invokes the CreateDashcam API
#    And the user stores the DeviceId from the CreateDashcam API response
#    When the user invokes the LeaseDashcam API by passing the "<organisationId>"
#    And the user invokes the InstallDashcam API
#    When the user invokes the AssignDashcam API by passing the "<assetId>"
#    When the user invokes the UnAssignDashcam API by passing the "<assetId>" and "<organisationId>"
#    When the user validates the Device Configuration Service
#    Then the value of gpsEnabled and sensorEnabled keys in the response of Gen-3 Service should be set to false
#
#  Scenario : Invoke /UnInstall api and verify Device configuration Service
#    Given the user invokes the CreateDashcam API
#    And the user stores the DeviceId from the CreateDashcam API response
#    When the user invokes the LeaseDashcam API by passing the "<organisationId>"
#    And the user invokes the InstallDashcam API
#    When the user invokes the AssignDashcam API by passing the "<assetId>"
#    And the user invokes the UnInstallDashcam API
#    When the user validates the Device Configuration Service
#    Then the value of gpsEnabled and sensorEnabled keys in the response of Gen-3 Service should be set to false