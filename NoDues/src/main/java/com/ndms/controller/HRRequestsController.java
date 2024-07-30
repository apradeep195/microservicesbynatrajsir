package com.ndms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ndms.dto.CertificateDetailsDTO;
import com.ndms.dto.CertificateDuesDTO;
import com.ndms.dto.PendingReqInfo;
import com.ndms.dto.RequestCount;
import com.ndms.service.NoDuesRequestService;
import com.ndms.service.SectionWiseNoduesService;

@Controller
@RequestMapping("/hr")
public class HRRequestsController {

	@Autowired
	private NoDuesRequestService reqService;

	@Autowired
	private SectionWiseNoduesService secWiseService;
	
	//All list employee which pending DEPT HOD
	@RequestMapping(value = "/all",method = RequestMethod.GET)
	public String getAllHrHeadPendingReq(Map<String,Object> mapAttributes ) {
		
		Map<Long,String>  deptNameMap=new HashMap();
		
		List<PendingReqInfo> resignedEmployee=reqService.getAlIResignedEmployee();
		
		List<PendingReqInfo> filteredEmPendingReqInfos=new ArrayList<>();
		
		resignedEmployee.forEach(emp->{			
	
			if(emp.getREQID()!=null) {
				String pendingDept= reqService.getAllpendingDepartment(emp.getREQID());
				
				if(pendingDept==null || pendingDept.equals("") && emp.getHR_HEAD_APPROVA_STATUS().equals(0)) {
				 	 deptNameMap.put(emp.getREQID(),pendingDept);		
					 filteredEmPendingReqInfos.add(emp);
				}
			}
	  });		
	    mapAttributes.put("reqDept", deptNameMap);
	    mapAttributes.put("hrPendings", filteredEmPendingReqInfos);		
		return "hr/all-requests";
	}
	
	@RequestMapping(value = "/approve",method = RequestMethod.POST)
	public String approvehrRequest(@RequestParam("reqId")  Long reqId,  Map<String,Object> mapAttributes ) {
	    reqService.approvehrRequest(reqId);
		return "redirect:/hr/all";
		
	}
	
	
	@ModelAttribute("counts")
	public RequestCount getIntiaiteCount() {

		RequestCount reqCount = new RequestCount();
		reqCount.setInitiateReqs(reqService.getAllResignationCount());
		reqCount.setPendingReqs(reqService.getPendingRequestCount());
		reqCount.setApproveReqs(reqService.getApprovedRequestCount());
		return reqCount;

	}
	
	//View Status of NODUES 
	@RequestMapping(value = "/viewStatus",method = RequestMethod.POST)
	public String getDetailsNodues(@RequestParam("reqId") Integer reqId ,Map<String,Object> mapAttributes) {	
	
		List<CertificateDuesDTO> duesDetails= secWiseService.getAllDuesDetails(Long.parseLong(""+reqId));
		CertificateDetailsDTO cesEmpDetails= secWiseService.getEmployeeDetailsforCertificate(Long.parseLong(""+reqId));
		
		mapAttributes.put("dues", duesDetails);
		mapAttributes.put("empDetails", cesEmpDetails);
		
		return "hr/view-status";
	}	
	
}
