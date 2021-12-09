package com.clarivate.bulkdto;

import com.clarivate.searchdto.SearchResponse;
import lombok.*;

import java.util.ArrayList;
import java.util.TreeMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BulkSearchResponse {

    @Setter@Getter
    private SearchResponse searchResponse;
    @Setter@Getter
    private ArrayList<TreeMap<String, String>> selectedMasters;
    @Setter@Getter
    private String data;

}
