package com.clarivate.stepdefinitions;


import com.clarivate.bulkupdatevalidation.BulkSaveResponseValidation;
import com.clarivate.useractions.BulkSaveBucketPageActions;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

@Slf4j
public class SaveBulkupdateDetails {

    @Steps
    BulkSaveBucketPageActions BulkSaveBucketPageActions;

    @Steps
    BulkSaveResponseValidation bulkSaveResponseValidation;

    @When("I click the bucket icon in search page selected the record pguid's for the master should save in DB {string}")
    public void i_click_the_bucket_icon_selected_the_record_pguid_should_save_in_DB(String master,String json){
        log.info("Master Name : "+ master);
        BulkSaveBucketPageActions.bulkSave(json);
    }

    @Then("response after clicking the bucket icon should be as {string}")
    public void response_after_saving_bulk_details(String spec,String json) {
        bulkSaveResponseValidation.validateSaveRessponseAndData(json,lastResponse());
    }

    @When("I click the select all and then click the bucket page it should save all the records for respective masters {string}")
    public void i_click_the_select_all_then_click_bucketpage_all_pguids_save_in_db(String master,String json){
        log.info("Master Name : "+ master);
        BulkSaveBucketPageActions.bulkSave(json);
    }

    @Then("response after clicking the bucket icon should be as {string} for select all pguids")
    public void response_after_saving_bulk_details_for_select_all_pguids(String spec,String json) {
        bulkSaveResponseValidation.validateSaveRessponseAndData(json,lastResponse());
    }
}
