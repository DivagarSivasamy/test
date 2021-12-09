package com.clarivate.useractions;

import com.clarivate.utilities.CommonRequestSpec;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;


public class BulkRemoveBucketPageActions {

    @Step
    public Response bulkDelete(String json) {
        return SerenityRest.given().spec(CommonRequestSpec.blogReqSpec())
                .basePath("v1/bulkupdatesearch/bulkdelete")
                .contentType(ContentType.JSON).body(json)
                .delete().then().extract().response();
    }
}
