package com.clarivate.searchdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BucketData
{
	private @Getter @Setter Object key;
	private @Getter @Setter long count;
	private @Getter @Setter boolean checked;
}
