package com.ndms.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.w3c.dom.ls.LSInput;

import com.ndms.dto.AuthorizedSection;
import com.ndms.dto.DuesDetailsDTO;
import com.ndms.dto.ITSpecificDueDTO;
import com.ndms.dto.ITSpecificDueDTOV2;
import com.ndms.dto.ItDepatmentDuesDetailsDTO;
import com.ndms.dto.LnerpDTO;
import com.ndms.dto.PendingReqInfo;
import com.ndms.dto.RequestCount;
import com.ndms.dto.SectionDuesDTO;
import com.ndms.excetion.NotDesiredInputException;
import com.ndms.service.CurrentUserService;
import com.ndms.service.EmployeeDetailsService;
import com.ndms.service.ITSepecDetailsService;
import com.ndms.service.NoDuesRequestService;
import com.ndms.service.SectionWiseNoduesService;
import com.ndms.utils.CommonUtils;


@Controller
@RequestMapping("/section")
public class SectionRequestsController {

	private static final Logger logger=LogManager.getLogger(SectionRequestsController.class);
	@Autowired
	private NoDuesRequestService reqService;
	@Autowired   
    private CurrentUserService currentUserService;

	@Autowired
	private EmployeeDetailsService empDetailsService;
	
	@Autowired
	private SectionWiseNoduesService sectionNoDuesService;

	@Autowired
	private ITSepecDetailsService itDetailsService;

	
	@RequestMapping(value="/all",method = RequestMethod.GET)
	public String getAllrequestes(Map<String, Object> mapAttributes) {	
		Map<Long,String>  deptNameMap=new HashMap();
		List<PendingReqInfo> resignedEmployee=reqService.getAlIResignedEmployee();
		List<PendingReqInfo> resignedEmployeFiltered=new ArrayList();
	   
		resignedEmployee.forEach(emp->{			
		if(emp.getREQID()!=null && emp.getHOD_APPROVAL_STATUS().intValue()==1) {
		  String sections=reqService.getAllSectionspending(emp.getREQID(),currentUserService.getCurrentUserId() );
			if(sections!=null&&!sections.equals(""))
			{
				deptNameMap.put(emp.getREQID(),sections);			
				resignedEmployeFiltered.add(emp);
			}
		}
	  });	
		

    mapAttributes.put("resigned", resignedEmployeFiltered);
	mapAttributes.put("reqDept", deptNameMap);	
	return "section/pending-requests"; 
	}
	
	
	@RequestMapping(value="/addDues",method = RequestMethod.POST)
 public String  addDues(@ModelAttribute DuesDetailsDTO dto,RedirectAttributes rd) {	
   try {
	  
	   
	   sectionNoDuesService.addDuesDetails(dto);
	   rd.addFlashAttribute("successAddDues","Due Added Successfully.");
   }
   catch(Exception ex) {
	   ex.printStackTrace();
	   rd.addFlashAttribute("errorAddDues",ex.getMessage());
   }
		
		return "redirect:/section/showDues?reqid="+dto.getReqid();
				
	}

	@RequestMapping(value="sectionApproved" ,method = RequestMethod.GET)
	public String getAllSectionApprovedRequests(Map<String, Object> mapAttributes) {
		Map<Long,String> deptNameMap=new HashMap();
		List<PendingReqInfo> resignedEmployee=reqService.getAlIResignedEmployee();
		List<PendingReqInfo> resignedEmployeFiltered=new ArrayList();
		
		resignedEmployee.forEach(emp->{
			if(emp.getREQID()!=null && emp.getHOD_APPROVAL_STATUS().intValue()==1) {
				
				String sections=reqService.getAllSectionsApproved(emp.getREQID(), currentUserService.getCurrentUserId());
				if(sections!=null&&!sections.equals("")) 
				{
					
					deptNameMap.put(emp.getREQID(),sections);
					resignedEmployeFiltered.add(emp);
				}
			}
			
		});
		
		   mapAttributes.put("resigned", resignedEmployeFiltered);
			mapAttributes.put("reqDept", deptNameMap);	
			
		return "section/section-approved-requests";
	}
	
	
	

	
	
	@RequestMapping(value="/showDues",method = RequestMethod.GET)
	public String  showDues(@RequestParam("reqid") Integer reqId ,Map<String,Object> mapAttributes) {
		try {
			 List<SectionDuesDTO> sectionDues= sectionNoDuesService.sectionDuesDetails(reqId);
			 List<AuthorizedSection> authSections=sectionNoDuesService.fetchAuthorizedSections();
			 PendingReqInfo empInfo= empDetailsService.getAllResignation(Long.parseLong(""+reqId));
			 ITSpecificDueDTO ITSpecDTO=null;
			 Long reqIdLong=Long.parseLong(""+reqId);
			 
			 ITSpecDTO=itDetailsService.getITSpecDetailsByReqId(reqIdLong);
			 
			 if(ITSpecDTO!=null) {
				 ITSpecDTO.setErpUser(ITSpecDTO.getErpLoginName());
				 ITSpecDTO.setIsSubmitted(1);
			 }
			 else {
			       ITSpecDTO=itDetailsService.getFlagInfo(reqIdLong);
			       ITSpecDTO.setIsSubmitted(0);
			 }
			 if(ITSpecDTO.getErpUser()==null) {
				 LnerpDTO lnrp= itDetailsService.getLnerpnDetails(reqIdLong);
				 if(lnrp!=null&&lnrp.getERPLOGIN()!=null&& !lnrp.getERPLOGIN().trim().equals(""))
				        ITSpecDTO.setErpUser(lnrp.getERPLOGIN());
			 }
			
			 
		     mapAttributes.put("itSpecDetails", ITSpecDTO );
			 mapAttributes.put("empInfo", empInfo);
			 mapAttributes.put("sectionDues", sectionDues);
			 mapAttributes.put("authSections", authSections);
			 mapAttributes.put("reqId", reqId);
			
			 authSections.forEach(auth->{
				 if(auth.getID().equals(3))
					 mapAttributes.put("admin",  true);
				 else if(auth.getID().equals(1))
					 mapAttributes.put("IT",  true);
			 });
			 
			
			 
			 if(sectionDues==null||sectionDues.size()<=0)
				   mapAttributes.put("isEmpty", true);
			 
			 if(sectionNoDuesService.fetchCatcode(reqIdLong).equals(100))
			     	       mapAttributes.put("isExcutive",true);
		}  
		catch(Exception ex) {
			ex.printStackTrace();
			 mapAttributes.put("error", ex.getMessage());

		}
		 
		return "section/add-dues";
	}
	
	
	
	@RequestMapping(value="/viewDuesDetails",method = RequestMethod.GET)
	public String  viewDuesDetails(@RequestParam("reqid") Integer reqId ,Map<String,Object> mapAttributes) {
		try {
			 List<SectionDuesDTO> sectionDues= sectionNoDuesService.sectionDuesDetailsView(reqId);
			 List<AuthorizedSection> authSections=sectionNoDuesService.fetchAuthorizedSections();
			 PendingReqInfo empInfo= empDetailsService.getAllResignation(Long.parseLong(""+reqId));
			 ItDepatmentDuesDetailsDTO ITSpecDTO=null;
			 Long reqIdLong=Long.parseLong(""+reqId);
			 
			 ITSpecDTO=itDetailsService.ITSpecificDuesDetailsView(reqIdLong);			 
		     mapAttributes.put("itSpecDetails", ITSpecDTO );
			 mapAttributes.put("empInfo", empInfo);
			 mapAttributes.put("sectionDues", sectionDues);
			 mapAttributes.put("authSections", authSections);
			 mapAttributes.put("reqId", reqId);
			
			 authSections.forEach(auth->{
				 if(auth.getID().equals(3))
					 mapAttributes.put("admin",  true);
				 else if(auth.getID().equals(1))
					 mapAttributes.put("IT",  true);
			 });
			 
			
			 
			 if(sectionDues==null||sectionDues.size()<=0)
				   mapAttributes.put("isEmpty", true);
			 
			 if(sectionNoDuesService.fetchCatcode(reqIdLong).equals(100))
			     	       mapAttributes.put("isExcutive",true);
		}  
		catch(Exception ex) {
			ex.printStackTrace();
			 mapAttributes.put("error", ex.getMessage());

		}
		 
		return "section/view-dues-details";
	}
	
	
	@RequestMapping(value="/it-spec/save",method = RequestMethod.POST)
	public String  addITSpecDetails(@ModelAttribute ITSpecificDueDTOV2 itSpec,RedirectAttributes  rd) {	
	try {
		
		logger.info("IT  srgu "+itSpec);
		
		ITSpecificDueDTO dueDto=new ITSpecificDueDTO();
		
		dueDto.setId(itSpec.getId());
		dueDto.setAutoMail(CommonUtils.convertYESNOToInt(itSpec.getAutoMail()));
		dueDto.setErpLogin(CommonUtils.convertYESNOToInt(itSpec.getErpLogin()));
		dueDto.setPcPrinter(CommonUtils.convertYESNOToInt(itSpec.getPcPrinter()));		
		dueDto.setErpLoginAction(CommonUtils.convertYESNOToInt(itSpec.getErpLoginAction()));
		dueDto.setMailIdRemoved(CommonUtils.convertYESNOToInt(itSpec.getMailIdRemoved()));
		dueDto.setAutomailRemoved(CommonUtils.convertYESNOToInt(itSpec.getAutomailRemoved()));
		dueDto.setPcPrinterReturn(CommonUtils.convertYESNOToInt(itSpec.getPcPrinterReturn()));
		
		
		dueDto.setReqId(itSpec.getReqId());
		dueDto.setRemark(itSpec.getRemark());		
		
		dueDto.setMailType(itSpec.getMailType());
		dueDto.setErpLoginName(itSpec.getErpLoginName());

		
		logger.info("IT SPEC TO BE SAVED "+dueDto);
		itDetailsService.save(dueDto);
		 rd.addFlashAttribute("successITSpec","IT Sepecific Details saved.");
	}catch(NotDesiredInputException ex) {
		ex.printStackTrace();
		rd.addFlashAttribute("errorITSpec","Exception occurred while saving the data.");
	}catch(DataIntegrityViolationException ex) {
		ex.printStackTrace();
		rd.addFlashAttribute("errorITSpec","IT Specific details are already submitted for this Request.");
	}
	catch(Exception ex) {
		ex.printStackTrace();
		rd.addFlashAttribute("errorITSpec",ex.getMessage());
	}
	return "redirect:/section/showDues?reqid="+itSpec.getReqId();
				
	}
	
	@RequestMapping(value="/submit",method = RequestMethod.POST)
	public String  addDues(@RequestParam(value = "reqId",required = true) Long reqId,RedirectAttributes  rd) {	
	try {
		//Section ID Need Here 
	     List<AuthorizedSection> section =	sectionNoDuesService.fetchAuthorizedSections();
	     
	     List<Integer> secIds=section.stream().map(auth->auth.getID()).collect(Collectors.toList());
	     
	     
		 sectionNoDuesService.submitAllDues(reqId,secIds);
		 rd.addFlashAttribute("successDueSubmit","Dues Submitted Successfully.");
	}catch(Exception ex) {
		ex.printStackTrace();
		rd.addFlashAttribute("errorDueSubmit",ex.getMessage());
	}

	return "redirect:/section/showDues?reqid="+reqId;
				
	}
	

	
	@ModelAttribute("counts")
	public RequestCount getIntiaiteCount() {

		RequestCount reqCount = new RequestCount();		
		reqCount.setDeptLeftEmployeesReqs(reqService.getDeptHODReqCount());
		return reqCount;

	}
	
}
