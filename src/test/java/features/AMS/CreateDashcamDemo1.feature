@demo1

Feature:Create Dashcam Demo

  Scenario: Create Dashcam and Validate Status Code and LifeCycle State
    Given user invokes the CreateDashcam API
    When  user validates the response and the status code
    Then user validate if the lifecycle state of the response is AVAILABLE
