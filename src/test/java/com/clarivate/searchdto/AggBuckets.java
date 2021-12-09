package com.clarivate.searchdto;

import java.util.List;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AggBuckets {
	
	private @Getter @Setter String aggbucket_name;
	private @Getter @Setter List<BucketData> aggbucket_values;
}
