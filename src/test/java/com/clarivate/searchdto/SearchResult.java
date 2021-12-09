package com.clarivate.searchdto;

import lombok.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchResult {
       
        private @Getter @Setter Map<String,Object> body;
        private @Getter @Setter String workbenchUrl;
        private @Getter @Setter String noSearchResultMessage;
        private @Getter @Setter double score;
        private @Getter @Setter Map<String,List<String>> highlight;
        private @Getter @Setter Set<SummaryInfo> summary;

    }

