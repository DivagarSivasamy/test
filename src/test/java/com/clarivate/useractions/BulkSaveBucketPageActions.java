package com.clarivate.useractions;

import com.clarivate.utilities.CommonRequestSpec;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class BulkSaveBucketPageActions {
    @Step
    public Response bulkSave(String json) {
        return SerenityRest.given().spec(CommonRequestSpec.blogReqSpec())
                .basePath("v1/bulkupdatesearch/bulksave")
                .contentType(ContentType.JSON).body(json)
                .post().then().extract().response();
    }
}
