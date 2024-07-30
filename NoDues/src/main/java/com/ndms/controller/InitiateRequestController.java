package com.ndms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ndms.dto.ReginationReqDTO;
import com.ndms.dto.RegisnationInfo;
import com.ndms.dto.RequestCount;
import com.ndms.service.NoDuesRequestService;
import com.ndms.service.SectionWiseNoduesService;

@Controller
@RequestMapping("/initiate")
public class InitiateRequestController {

	@Autowired
	private NoDuesRequestService reqService;
	@Autowired
	private SectionWiseNoduesService sectionNoDuesService;

	// NEW CODE START HERE

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String getAllResignationEmployee(Map<String, Object> mapAttributes) {
		List<RegisnationInfo> regList = null;
		regList = reqService.getAllResignation();
		if (regList == null || regList.size() == 0)
			mapAttributes.put("isEmpty", true);
			mapAttributes.put("resignations", regList); 
			System.out.println("===============HELLO PRADEEP============");
			return "initiate/all-employees";
}
	
	
	@RequestMapping(value = "/request", method = RequestMethod.POST)
	public String addResignReq(@ModelAttribute ReginationReqDTO dto) {
		System.out.print("Pradeep Resignation dto Print here ===============" +dto);
		reqService.addResignationRequest(dto);
		
		
		return "redirect:/initiate/all";
	}

	// NEW CODE END HERE

	
	
	// for add Inisiate request by hr
	

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
