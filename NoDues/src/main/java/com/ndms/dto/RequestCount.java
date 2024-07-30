package com.ndms.dto;

import lombok.Data;

@Data
public class RequestCount {

	public Integer InitiateReqs;
	public Integer ApproveReqs;
	public Integer pendingReqs;	
	public Integer deptLeftEmployeesReqs;
	
	
}
