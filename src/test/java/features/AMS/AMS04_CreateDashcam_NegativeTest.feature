@test1
Feature: CreateDashcam_NegativeTest

  Scenario Outline: Create Dashcam with already existing serial number,imsi,iccid
    Given The user invokes the CreateDashcam API by passing "<serialNumber>" , "<imsi>" , "<iccid>"  in the body of the response
    Then the user validates if the status code is 400

    Examples:
      | serialNumber     | imsi    | iccid   |
      | Found-Samp-82136 | 8565767 | 8857665 |
      | Found-Samp-92136 | 8565767 | 8857665 |
      | Found-Samp-92136 | 8565767 | 8857665 |

#
  Scenario: Create Dashcam with Invalid Endpoint
    Given the user invokes the CreateDashcam API with Invalid Endpoint
    Then  the user validates 400 error code

  Scenario: Create Dashcam with Invalid Header
    Given the user invokes the CreateDashcam API with Invalid Header
    Then the user validates the error code 500

  Scenario: Create Dashcam with Null Content Type Header
    Given the user invokes the CreateDashcam API with Null Content Type Header
    Then the user validates the error code 500

  Scenario: Create Dashcam with Null Accept Key Header
    Given the user invokes the CreateDashcam API with Null Accept Key Header
    Then the user validates the error code 500

  Scenario: Create Dashcam with Invalid Request Type
    Given the user invokes the CreateDashcam API with Invalid Request Type
    Then the user validates the error code 500

    Scenario: Create Dashcam with a missing key in the request body
      Given the user invokes the CreateDashcam API with no Serial Number
      Then the user validates the error code 500

