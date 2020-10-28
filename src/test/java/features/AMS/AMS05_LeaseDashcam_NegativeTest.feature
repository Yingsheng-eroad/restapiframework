@test1
Feature: LeaseDashcam_NegativeTest

  Scenario Outline: Lease Dashcam with Invalid endpoint
    Given the user invokes the LeaseDashcam API with "<DeviceId>","<OrgId>","<Header>","<Endpoint>"
    Then the user validates if the negative testing status code is 404

    Examples:
      | DeviceId                             | OrgId                                | Header           | Endpoint |
      | 765fe236-3b36-49e4-b89c-a6dcc29fe232 | c50db1c6-10c7-47f8-819b-57d0a3cdbcaf | application/json | /leases  |

  Scenario Outline: Lease Dashcam with Invalid Header
    Given the user invokes the LeaseDashcam API with "<DeviceId>","<OrgId>","<Header>","<Endpoint>"
    Then the user validates 500 status code
    Examples:
      | DeviceId                             | OrgId                                | Header           | Endpoint |
      | 765fe236-3b36-49e4-b89c-a6dcc29fe232 | c50db1c6-10c7-47f8-819b-57d0a3cdbcaf | application/jsom | /lease   |

  Scenario Outline: Lease Dashcam with Null Content-Type Header
    Given the user invokes the LeaseDashcam API with "<DeviceId>","<OrgId>","<Header>","<Endpoint>"
    Then the user validates 500 status code
    Examples:
      | DeviceId                             | OrgId                                | Header | Endpoint |
      | 765fe236-3b36-49e4-b89c-a6dcc29fe232 | c50db1c6-10c7-47f8-819b-57d0a3cdbcaf |        | /lease   |

  Scenario Outline: Lease Dashcam with Invalid Request Type
    Given the user invokes the LeaseDashcam API with Invalid request type and "<DeviceId>","<OrgId>","<Header>","<Endpoint>"
    Then the user validates 500 status code
    Examples:
      | DeviceId                             | OrgId                                | Header           | Endpoint |
      | 765fe236-3b36-49e4-b89c-a6dcc29fe232 | c50db1c6-10c7-47f8-819b-57d0a3cdbcaf | application/json | /lease   |

  Scenario Outline: Lease Dashcam with a missing key in the request body
    Given the user invokes the LeaseDashcam API with Invalid request type and "<DeviceId>","<OrgId>","<Header>","<Endpoint>"
    Then the user validates 500 status code
    Examples:
      | DeviceId                             | OrgId | Header           | Endpoint |
      | 765fe236-3b36-49e4-b89c-a6dcc29fe232 |       | application/json | /lease   |

  Scenario Outline: Lease Dashcam with a missing DeviceId
    Given the user invokes the LeaseDashcam API with Invalid request type and "<DeviceId>","<OrgId>","<Header>","<Endpoint>"
    Then the user validates if the negative testing status code is 404
    Examples:
      | DeviceId | OrgId                                | Header           | Endpoint |
      |          | c50db1c6-10c7-47f8-819b-57d0a3cdbcaf | application/json | /lease   |

  Scenario Outline: Lease Dashcam with a Invalid DeviceId
    Given the user invokes the LeaseDashcam API with Invalid request type and "<DeviceId>","<OrgId>","<Header>","<Endpoint>"
    Then the user validates 500 status code
    Examples:
      | DeviceId                             | OrgId                                | Header           | Endpoint |
      | 765fe236-3b36-49e4-b89c-a6dcc29fe23g | c50db1c6-10c7-47f8-819b-57d0a3cdbcaf | application/json | /lease   |

  Scenario Outline: Lease Dashcam with a Invalid OrgId
    Given the user invokes the LeaseDashcam API with Invalid request type and "<DeviceId>","<OrgId>","<Header>","<Endpoint>"
    Then the user validates 500 status code
    Examples:
      | DeviceId                             | OrgId                                | Header           | Endpoint |
      | 765fe236-3b36-49e4-b89c-a6dcc29fe232 | c50db1c6-10c7-47f8-819b-57d0a3cdbc9f | application/json | /lease   |


#Scenario: Lease Dashcam with Null Accept Key Header
#Given the user invokes the LeaseDashcam API with Null Accept Key Header
#Then the user validates the error code 500
#

#

