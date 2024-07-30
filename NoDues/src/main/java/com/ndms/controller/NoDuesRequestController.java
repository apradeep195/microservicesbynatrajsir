package com.ndms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ndms.dto.PendingReqInfo;
import com.ndms.dto.RegisnationInfo;
import com.ndms.dto.RequestCount;
import com.ndms.service.NoDuesRequestService;

@Controller
@RequestMapping("/request")
public class NoDuesRequestController {

	@Autowired
	private NoDuesRequestService reqService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String getAllrequestes(Map<String, Object> mapAttributes) {
		Map<Long, String> deptNameMap = new HashMap();
		List<PendingReqInfo> resignedEmployee = null;
		resignedEmployee = reqService.getAlIResignedEmployee();
		resignedEmployee.forEach(emp -> {
			if (emp.getREQID() != null) {
				deptNameMap.put(emp.getREQID(), reqService.getAllpendingDepartment(emp.getREQID()));
			}
		});

		mapAttributes.put("resigned", resignedEmployee);
		mapAttributes.put("reqDept", deptNameMap);
		return "pending/all-requests";
	}

	@RequestMapping(value = "/approved", method = RequestMethod.GET)
	public String getAllrequestesApproved(
			@RequestParam(name = "rows", defaultValue = "10", required = false) Integer rowSize,
			@RequestParam(name = "searchBy", defaultValue = "0", required = false) Integer searchBy,
			@RequestParam(name = "searchQuery", defaultValue = "", required = false) String searchQuery,
			Map<String, Object> mapAttributes) {

		Map<Long, String> deptNameMap = new HashMap();

		// List<PendingReqInfo>
		// resignedEmployee=reqService.getAlIResignedEmployee(rowSize);

		List<PendingReqInfo> resignedEmployee = null;

		// List<RegisnationInfo> regList=null;

		resignedEmployee = reqService.getAlIResignedEmployee();

		resignedEmployee.forEach(emp -> {
			if (emp.getREQID() != null) {
				deptNameMap.put(emp.getREQID(), reqService.getAllpendingDepartment(emp.getREQID()));
			}
		});

		mapAttributes.put("resigned", resignedEmployee);
		mapAttributes.put("reqDept", deptNameMap);

		return "pending/all-requests-approved";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String getDatatableExample() {
		return "pending/DataTableTest";
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
