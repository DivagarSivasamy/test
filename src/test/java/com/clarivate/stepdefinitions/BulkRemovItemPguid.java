package com.clarivate.stepdefinitions;

import com.clarivate.bulkupdatevalidation.BulkRemoveDataValidation;
import com.clarivate.useractions.BulkRemoveBucketPageActions;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

@Slf4j
public class BulkRemovItemPguid {

    @Steps
    BulkRemoveBucketPageActions bulkRemoveBucketPageActions;
    @Steps
    BulkRemoveDataValidation bulkRemoveDataValidation;

    @When("I call the get remove pguids in bucket page endpoint for specific user with master id as {string}")
    public void i_call_the_remove_api_to_remove_selected_the_record_pguid(String master,String json){
        log.info("Master Name : "+ master);
        bulkRemoveBucketPageActions.bulkDelete(json);
    }

    @Then("Response for Removed PguIds in bucket page as \"(.*)\"")
    public void response_after_removing_itempguids_in_bucket_page(String spec) {
        bulkRemoveDataValidation.validateDeleteResponseAndData(spec,lastResponse());
    }
}
