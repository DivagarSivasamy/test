Feature: Retrieve the ItemPguids from bucket page details
  As a user
  As a user I should be able to view the added PGUID records into my Bucket Page

  Scenario: "Get bucket page details" data should match with respective to master id
    When I call the get retrieve bulk details endpoint for specific user with master id as "belowJsonObjectAsInput"
    """
    {
      "master": ["clinicalTrials"],
      "masterId": "urn:asset:62",
      "pagination": [],
      "userEmail": "purushothaman.ponnurangam@clarivate.com"
    }
  """
    Then Bucket details should be retrieved for the given user
    And the data should match with the specification defined in "user_retrieve_bulk.json"

  Scenario: "Get bucket page details" default master should display based on sorting
    When I call the get retrieve bulk details endpoint for specific user without master id as "belowJsonObjectAsInput"
    """
    {
      "master": [],
      "masterId": "",
      "pagination": [],
      "userEmail": "purushothaman.ponnurangam@clarivate.com"
    }
  """
    Then Bucket details should be retrieved for the given user as master alphabetical order
    And the master ID should match with the default master as "urn:asset:62"
    Then the data should match with the default master value as "retrieve_bucket_details_based_on_sort.json"

  Scenario: "Get bucket page details" No record found for given user
    When I call the get retrieve bulk details endpoint for specific user with email as "belowJsonObjectAsInput"
    """
    {
      "master": [],
      "masterId": "urn:asset:62",
      "pagination": [],
      "userEmail": "testingDummy@clarivate.com"
    }
  """
    Then verify the status code as data exception as "400"
    And Response for empty bucket page as "No record found for given user"
