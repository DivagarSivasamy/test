Feature: Remove the ItemPguids from bucket page details
  As a user
  As a user I should be able to Remove the added PGUID records into my Bucket Page

  Scenario: "Get bucket page details" remove the PGUID records whichever its not needed in my Bucket Page
    When I call the get remove pguids in bucket page endpoint for specific user with master id as "belowJsonObjectAsInput"
    """
    {
        "bulkUpdateType": "",
        "isSelected": "all",
        "masterId": "urn:asset:62",
        "masterTitle": "ChemistryMaster",
        "pguid": [
          ""
        ],
        "searchQueryName": "test",
        "totalCount": "125",
        "userId": "6064774",
        "userMail": "divagar.s@clarivate.com"
  }
  """
    Then Response for Removed PguIds in bucket page as "Deleted itempguid's successful"