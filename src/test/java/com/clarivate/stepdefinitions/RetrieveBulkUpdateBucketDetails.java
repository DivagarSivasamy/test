package com.clarivate.stepdefinitions;

import com.clarivate.bulkupdatevalidation.BulkRetrieveResponseValidation;
import com.clarivate.useractions.BulkUpdateRetrieveActions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class RetrieveBulkUpdateBucketDetails {

    @Steps
    BulkUpdateRetrieveActions bulkUpdateUser;
    @Steps
    BulkRetrieveResponseValidation bulkRetrieveResponseValidation;

    @When("I call the get retrieve bulk details endpoint for specific user with master id as {string}")
    public void i_call_the_get_retrieve_bulk_details_endpoint_for_specific_user(String jsonName, String json) {
        bulkUpdateUser.retrieveBulk(json);
    }

    @Then("Bucket details should be retrieved for the given user")
    public void bucket_details_should_be_retrieved() {
        bulkRetrieveResponseValidation.responseCodeIs(200, lastResponse());
    }

    @And("the data should match with the specification defined in \"(.*)\"")
    public void the_data_should_match_with_the_specification(String spec) {
        bulkRetrieveResponseValidation.verifyResponseDetailsforGivenMasterId(lastResponse(), spec);
    }

    @When("I call the get retrieve bulk details endpoint for specific user without master id as {string}")
    public void i_call_the_get_retrieve_bulk_details_endpoint_for_specific_user_without_id(String jsonName, String json) {
        bulkUpdateUser.retrievedefaultBucketDetails(json);
    }

    @Then("Bucket details should be retrieved for the given user as master alphabetical order")
    public void bucket_details_should_be_retrieved_based_on_sorting() {
        bulkRetrieveResponseValidation.responseCodeIs(200, lastResponse());
    }

    @And("the master ID should match with the default master as \"(.*)\"")
    public void the_master_should_match_with_the_specification_default_master(String spec) {
        bulkRetrieveResponseValidation.verifyResponseDetailsforDefaultMasterId(lastResponse(), spec);
    }

    @Then("the data should match with the default master value as \"(.*)\"")
    public void the_data_should_match_with_the_specification_default_master(String spec) {
        bulkRetrieveResponseValidation.verifyResponseDetailsforGivenMasterId(lastResponse(), spec);
    }

    @When("I call the get retrieve bulk details endpoint for specific user with email as {string}")
    public void i_call_the_get_retrieve_bulk_details_endpoint_for_specific_user_with_email_id(String spec,String json) {
        bulkUpdateUser.retrieveNoBucketDetailsFound(json);
    }

    @Then("verify the status code as data exception as \"(.*)\"")
    public void verify_the_status_data_exception(String spec) {
        bulkRetrieveResponseValidation.responseCodeIs(400, lastResponse());
    }

    @And("Response for empty bucket page as \"(.*)\"")
    public void response_for_empty_bucket_page(String spec) {
        bulkRetrieveResponseValidation.verifyResponseDetailsforDataNotfound(lastResponse(), spec);
    }
}
