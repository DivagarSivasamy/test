package com.clarivate.bulkupdatevalidation;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;

public class BulkSaveResponseValidation {

    @Step("Verify that API response is {0}")
    public void validateSaveRessponseAndData(String spec, Response lastResponse) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(lastResponse.statusCode()).isEqualTo(200);
        String json = lastResponse.getBody().prettyPrint();
        softly.assertThat(json.trim()).isEqualTo(spec.trim());
        softly.assertAll();

    }
}
