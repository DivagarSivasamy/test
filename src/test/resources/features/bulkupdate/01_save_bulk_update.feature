Feature: Bulk save the PGUID Records into Bucket Page
  As a user
  As a user I should be able to add PGUID records into my Bucket Page

  Scenario: Store the executed/added PGUID records in the bucket page when the user added into the Bucket Page
    When I click the bucket icon in search page selected the record pguid's for the master should save in DB "belowJsonObjectAsInput"
    """
	[
	  {
		"bulkUpdateType": "",
		"isSelected": "No",
		"masterId": "urn:asset:102",
		"masterTitle": "ChemistryMaster",
		"pguid": [
			"urn:chemstructure:224524"
		],
		"searchQueryName": "2-Chlorobenzoyl chloride",
		"totalCount": "",
		"userId": "6064774",
		"userMail": "divagar.s@clarivate.com"
	  }
	]
  """
    Then response after clicking the bucket icon should be as "save_successful"
    """
	{
        "message": "save successful"
    }
  """

  Scenario: Store the all PGUID records in the bucket page when the user clicks select all into the Bucket Page
    When I click the select all and then click the bucket page it should save all the records for respective masters "belowJsonObjectAsInput"
    """
     [
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
    ]
  """
    Then response after clicking the bucket icon should be as "save_successful" for select all pguids
    """
	{
        "message": "Save Sucessfully"
    }
  """