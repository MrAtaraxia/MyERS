package project.model;

import java.util.HashMap;
import java.util.Map;

public enum REIMBURSEMENT_TYPE {
	LODGING("LODGING"),
	TRAVEL("TRAVEL"),
	FOOD("FOOD"),
	OTHER("OTHER");
	private final String value;
	
	private REIMBURSEMENT_TYPE(String value) {
		this.value = value;
	}
	
	public String toString() {
		return this.value;
	}
	
    private static final Map<String, REIMBURSEMENT_TYPE> lookup = new HashMap<>();
    
    static
    {
        for(REIMBURSEMENT_TYPE sta : REIMBURSEMENT_TYPE.values())
        {
            lookup.put(sta.toString(), sta);
        }
    }

    public static REIMBURSEMENT_TYPE get(String url) 
    {
        return lookup.get(url);
    }

}
