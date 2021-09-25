package project.model;

import java.util.HashMap;
import java.util.Map;

public enum REIMBURSEMENT_STATUS {
	PENDING("PENDING"),
	APPROVED("APPROVED"),
	DENIED("DENIED");
	private final String value;
	
	private REIMBURSEMENT_STATUS(String value) {
		this.value = value;
	}
	
	public String toString() {
		return this.value;
	}
	
    private static final Map<String, REIMBURSEMENT_STATUS> lookup = new HashMap<>();
    
    static
    {
        for(REIMBURSEMENT_STATUS sta : REIMBURSEMENT_STATUS.values())
        {
            lookup.put(sta.toString(), sta);
        }
    }

    public static REIMBURSEMENT_STATUS get(String url) 
    {
        return lookup.get(url);
    }

}
