package com.clarivate.searchdto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchResponse {

	private @Getter @Setter long totalResults;
	private @Getter @Setter String totalhitsRelation;
	private @Getter @Setter String inputSearchQuery;
	private @Getter @Setter List<SearchResult> searchResults;
	private @Getter @Setter String noSearchResults;
	private @Getter @Setter List<AggBuckets> aggregator;
	private @Getter @Setter List<Object> pagination;

}
