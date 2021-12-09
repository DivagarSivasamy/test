package com.clarivate.searchdto;

import lombok.*;

import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SummaryInfo {
	
	private String master;
	private int count;
	private Set<String> pguids;
	
	@Override
	public int hashCode()
	{
		int hash=12345;
		int l=master.length();
		int val=(int)master.charAt(l-1)*(int)master.charAt(l-2)*(int)master.charAt(l-3);
		hash=hash*val;
		return hash;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		SummaryInfo obj=(SummaryInfo)o;
		if(this.getMaster().equalsIgnoreCase(obj.getMaster()))
			return true;
		return false;
	}

}
