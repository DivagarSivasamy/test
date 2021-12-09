package com.clarivate.bulkupdatevalidation;

import com.clarivate.bulkdto.BulkSearchResponse;
import com.clarivate.searchdto.SearchResponse;
import com.clarivate.searchdto.SearchResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

public class BulkRetrieveResponseValidation {

    @Step("Verify that API response is {0}")
    public void responseCodeIs(int responseCode, Response lastResponse) {
        assertThat(lastResponse.statusCode()).isEqualTo(responseCode);
    }

    @Step("Verify response of given master ID with {1}")
    public void verifyResponseDetailsforGivenMasterId(Response lastResponse, String schemaJson) {
        SoftAssertions softly = new SoftAssertions();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile(this.getClass().getResource("/schema/" + schemaJson));
            final BulkSearchResponse bulkSearchResponse = objectMapper.readValue(file, BulkSearchResponse.class);
            final SearchResponse searchResponse = bulkSearchResponse.getSearchResponse();
            List<SearchResult> searchResultList = searchResponse.getSearchResults();
            SearchResult searchResultJson = searchResultList.get(0);
            String json = lastResponse.getBody().prettyPrint();
            BulkSearchResponse bulkResponsebody = objectMapper.readValue(json, BulkSearchResponse.class);
            SearchResponse searchResponsebody = bulkResponsebody.getSearchResponse();
            List<SearchResult> searchResultBodyLs = searchResponsebody.getSearchResults();
            SearchResult searchResultbody = searchResultBodyLs.get(0);
            softly.assertThat(searchResultbody.getBody().toString()).isEqualTo(searchResultJson.getBody().toString());
            softly.assertAll();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Step("Verify response of default master ID with {1}")
    public void verifyResponseDetailsforDefaultMasterId(Response lastResponse, String spec)  {
        SoftAssertions softly = new SoftAssertions();
        try {
          ObjectMapper objectMapper = new ObjectMapper();
          String json = lastResponse.getBody().prettyPrint();
          BulkSearchResponse bulkResponsebody = objectMapper.readValue(json, BulkSearchResponse.class);
          ArrayList<TreeMap<String, String>> selectedMasters = bulkResponsebody.getSelectedMasters();
          TreeMap<String, String> treeMap = selectedMasters.get(0);
          softly.assertThat(treeMap.get("masterId")).isEqualTo(spec);
          softly.assertAll();
        }catch (IOException ex){
          System.out.println(ex.getMessage());
        }
    }

    @Step("Verify response of no record details found for bucket page with {1}")
    public void verifyResponseDetailsforDataNotfound(Response lastResponse, String spec)  {
        SoftAssertions softly = new SoftAssertions();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = lastResponse.getBody().prettyPrint();
            BulkSearchResponse bulkResponsebody = objectMapper.readValue(json, BulkSearchResponse.class);
            String data = bulkResponsebody.getData();
            softly.assertThat(data).isEqualTo(spec);
            softly.assertAll();
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
