@devconftest1

Feature: Update assign on provision API to call Device Configuration API
#
#
  Scenario Outline: Invoke assign API and validate if gpsEnabled and sensorEnabled = true in Device Configuration API
    Given the user invokes the CreateDashcam API
    And the user stores the DeviceId from the CreateDashcam API response
    And the user invokes the LeaseDashcam API by passing the "<organisationId>"
    And the user invokes the InstallDashcam API
    And the user invokes the AssignDashcam API by passing the "<assetId>"
    When the user validates the Device Configuration Service
    Then the value of gpsEnabled and sensorEnabled keys in the DeviceConfig Service response should be set to true
    Examples:
      | assetId                              | organisationId                       |
      | f410f224-926c-4b7e-96bf-d968d02639a0 | fa598399-be2f-4a05-80b7-935cfc657f62 |

  Scenario Outline: Invoke unassign API and validate if gpsEnabled and sensorEnabled = false Device Configuration API
    Given the user invokes the CreateDashcam API
    And the user stores the DeviceId from the CreateDashcam API response
    And the user invokes the LeaseDashcam API by passing the "<organisationId>"
    And the user invokes the InstallDashcam API
    And the user invokes the AssignDashcam API by passing the "<assetId>"
    And the user invokes the UnAssignDashcam API by passing the "<assetId>" and "<organisationId>"
    When the user validates the Device Configuration Service
    Then the value of gpsEnabled and sensorEnabled keys in the response of DeviceConfig Service should be set to false
    Examples:
      | assetId                              | organisationId                       |
      | 67b0877b-ee2a-4817-9440-1e1296e3cf51 | c50db1c6-10c7-47f8-819b-57d0a3cdbca9 |



  Scenario Outline: Invoke unInstall API and validate if gpsEnabled and sensorEnabled = false in Device Configuration API
    Given the user invokes the CreateDashcam API
    And the user stores the DeviceId from the CreateDashcam API response
    And the user invokes the LeaseDashcam API by passing the "<organisationId>"
    And the user invokes the InstallDashcam API
    And the user invokes the AssignDashcam API by passing the "<assetId>"
    And the user invokes the UnInstallDashcam API by passing the "<assetId>" and "<organisationId>"
    When the user validates the Device Configuration Service
    Then the value of gpsEnabled and sensorEnabled keys in the response of DeviceConfig Service should be set to false
    Examples:
      | assetId                              | organisationId                       |
      | 67b0877b-ee2a-4817-9440-1e1296e3cf51 | c50db1c6-10c7-47f8-819b-57d0a3cdbca9 |