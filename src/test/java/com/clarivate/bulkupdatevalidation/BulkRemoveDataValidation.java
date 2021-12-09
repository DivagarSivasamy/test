package com.clarivate.bulkupdatevalidation;

import com.clarivate.bulkdto.BulkSearchResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;

public class BulkRemoveDataValidation {

    @Step("Verify that API response is {0}")
    public void validateDeleteResponseAndData(String spec, Response lastResponse) {
        SoftAssertions softly = new SoftAssertions();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            softly.assertThat(lastResponse.statusCode()).isEqualTo(200);
            String json = lastResponse.getBody().prettyPrint();
            BulkSearchResponse bulkResponsebody = objectMapper.readValue(json, BulkSearchResponse.class);
            softly.assertThat(bulkResponsebody.getData()).isEqualTo(spec);
            softly.assertAll();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
