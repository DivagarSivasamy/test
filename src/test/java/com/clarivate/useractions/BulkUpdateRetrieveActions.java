package com.clarivate.useractions;


import com.clarivate.utilities.CommonRequestSpec;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class BulkUpdateRetrieveActions {

    @Step
    public Response retrieveBulk(String json) {
        return SerenityRest.given().spec(CommonRequestSpec.blogReqSpec())
                .basePath("v1/bulkupdatesearch/retrieve")
                .contentType(ContentType.JSON).body(json)
                .post().then().extract().response();
    }
    @Step
    public Response retrievedefaultBucketDetails(String json) {
        return SerenityRest.given().spec(CommonRequestSpec.blogReqSpec())
                .basePath("v1/bulkupdatesearch/retrieve")
                .contentType(ContentType.JSON).body(json)
                .post().then().extract().response();
    }
    @Step
    public Response retrieveNoBucketDetailsFound(String json) {
        return SerenityRest.given().spec(CommonRequestSpec.blogReqSpec())
                .basePath("v1/bulkupdatesearch/retrieve")
                .contentType(ContentType.JSON).body(json)
                .post().then().extract().response();
    }
}
