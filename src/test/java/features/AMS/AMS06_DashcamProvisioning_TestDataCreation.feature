
  Feature: DashcamProvisioning_TestDataCreation
  Scenario Outline: Create Dashcam Positive Testing
    Given The user invokes the CreateDashcam API by passing "<serialNumber>" , "<imsi>" , "<iccid>"  in the body of the response
    Then the user validates the response and the status code
    Then validate if the lifecycle state of the response is AVAILABLE

    Examples:
      | serialNumber     | imsi    | iccid  |
      | Foun-Samp-821356 | 9645877 | 938565 |