package com.ndms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ndms.dto.DeptEmpLeftInfo;
import com.ndms.dto.HODPendingReqInfo;
import com.ndms.dto.RequestCount;
import com.ndms.service.CurrentUserService;
import com.ndms.service.NoDuesRequestService;

@Controller
@RequestMapping("/hod")
public class HODRequestsController {

	@Autowired
	private NoDuesRequestService reqService;


	//All list employee which pending DEPT HOD
    @RequestMapping(value = "/all",method = RequestMethod.GET)
		public String getAllPendingRequest(Map<String,Object> mapAttributes ) {
			List<HODPendingReqInfo> pendinglist=reqService.getAllPendingReq();
		    mapAttributes.put("pendingRequests", pendinglist);		
			return "hod/all-requests";
		}
    
	//All list employee which Left Department
    @RequestMapping(value = "/leftEmployees",method = RequestMethod.GET)
		public String getAllLeftEmployeeRequest(Map<String,Object> mapAttributes ) {
			//List<HODPendingReqInfo> pendinglist=reqService.getAllPendingReq();    	
    		List<DeptEmpLeftInfo> leftEmployees=reqService.getDepartmentLeftEmployees();
		    mapAttributes.put("deptLeftEmployees", leftEmployees);		
			return "hod/left-employees";
		}
		

    @RequestMapping(value = "/approve",method = RequestMethod.POST)
	public String approveRequest(@RequestParam("reqId")  Long reqId,  Map<String,Object> mapAttributes ) {
			    reqService.approveRequest(reqId);
				return "redirect:/hod/all";
    }
	
    
	@ModelAttribute("counts")
	public RequestCount getIntiaiteCount() {

		RequestCount reqCount = new RequestCount();
		reqCount.setInitiateReqs(reqService.getAllResignationCount());
		reqCount.setPendingReqs(reqService.getPendingRequestCount());
		reqCount.setApproveReqs(reqService.getApprovedRequestCount());
		reqCount.setDeptLeftEmployeesReqs(reqService.getDeptHODReqCount());
		return reqCount;

	}
	
}
