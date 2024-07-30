package com.ndms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ndms.dto.PendingReqInfo;
import com.ndms.dto.RequestCount;
import com.ndms.service.NoDuesRequestService;

@Controller
@RequestMapping("/approved")
public class ApprovedRequestController {
	
	@Autowired
	private NoDuesRequestService reqService;
	
	@RequestMapping(value="/all",method = RequestMethod.GET)
	public String getAllApprovedRequest(Map<String,Object> mapAttributes) {
		Map<Long,String> deptNameMap=new HashMap();
		List<PendingReqInfo> approvedRequests=reqService.getApprovedRequest();
		approvedRequests.forEach(emp->{
			if(emp.getREQID()!=null) {
				deptNameMap.put(emp.getREQID(),reqService.getAllpendingDepartment(emp.getREQID()));
			}
			
		});
		
		mapAttributes.put("approvedRequests", approvedRequests);
		mapAttributes.put("reqDept", deptNameMap);		
		return "hr/approved-request";		
		
	}

	@ModelAttribute("counts")
	public RequestCount getIntiaiteCount() {

		RequestCount reqCount = new RequestCount();
		reqCount.setInitiateReqs(reqService.getAllResignationCount());
		reqCount.setPendingReqs(reqService.getPendingRequestCount());
		reqCount.setApproveReqs(reqService.getApprovedRequestCount());
		return reqCount;

	}
}
