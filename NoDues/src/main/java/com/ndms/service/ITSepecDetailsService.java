package com.ndms.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndms.dto.ITSpecificDueDTO;
import com.ndms.dto.ItDepatmentDuesDetailsDTO;
import com.ndms.dto.LnerpDTO;
import com.ndms.model.ITSpecificDueModel;
import com.ndms.model.NoDuesRequestModel;
import com.ndms.repository.ITDeptRepository;
import com.ndms.repository.ITSpecificDueRepository;
import com.ndms.utils.CommonUtils;

@Service
public class ITSepecDetailsService {

	private static final Logger logger=LogManager.getLogger(ITSepecDetailsService.class);
	
	@Autowired
	private ITSpecificDueRepository ITSpecRepo;
	@Autowired
	private NoDuesRequestService noDuesReqService;

	@Autowired
	private ITDeptRepository itDeptRepository;
	
	public void save(ITSpecificDueDTO dto) throws InstantiationException, IllegalAccessException {		
		
		logger.info("IT SPECIFIC DETAILS SAVE "+dto);
		
		NoDuesRequestModel noReqmodel=noDuesReqService.getRequestById(dto.getReqId());
		ITSpecificDueModel model=CommonUtils.copyProperties(dto, ITSpecificDueModel.class);
		model.setNoDuesReq(noReqmodel);
		ITSpecRepo.save(model);
		
	}
	
   public ITSpecificDueDTO getITSpecDetailsByReqId(Long reqId) throws InstantiationException, IllegalAccessException {
	ITSpecificDueModel model=ITSpecRepo.findByNoDuesReq_ID(reqId);
	ITSpecificDueDTO dto=CommonUtils.copyProperties(model, ITSpecificDueDTO.class);
	if(dto!=null)
	    dto.setReqId(reqId);
	return dto;
   }
	
   
   public ItDepatmentDuesDetailsDTO  ITSpecificDuesDetailsView(Long reqId) {
	 return   itDeptRepository.getItDuesDetailsEntered(reqId); 
	   
	   
   }

	
	public ITSpecificDueDTO getFlagInfo(Long reqid) {
		 int emailCount=0;
		 String email=null;
		 String emailType=null;
		ITSpecificDueDTO dto=new ITSpecificDueDTO();
		
		dto.setAutoMail(getAutomailCount(reqid));
		
		LnerpDTO erpDTO= getLnerpnDetails (reqid);
		if(erpDTO!=null) {
			if(erpDTO.getERPLOGIN()!=null && !erpDTO.getERPLOGIN().trim().equals("")) {
				dto.setErpLogin(1);
				dto.setErpUser(erpDTO.getERPLOGIN());
			}else {
				dto.setErpLogin(0);
				dto.setErpUser(null);
			}
		}
		else
		    dto.setErpLogin(0);
		
		 email=itDeptRepository.getMailInfoFromBAAN(reqid);
		 
		 if(email!=null && !email.trim().equals("")) {
			 if(email.toUpperCase().contains("@LNJBHILWARA.COM"))
				 emailType="EXTERNAL";
			 else
				 emailType="NA";
		 }else {
			 emailType=itDeptRepository.getMailInfoITResource(reqid);
			 if(emailType!=null && !emailType.equals("")) {
				 if(emailType.toUpperCase().contains("EXTERNAL")) {
					 emailType="EXTERNAL";
				 }else if(emailType.toUpperCase().contains("INTERNAL")) {
					 emailType="INTERNAL";
				 }else {
					 emailType="NA";
				 }
			 }
			 else
				 emailType="NA";
		
		 }
	   
		 if(emailType!=null && emailType.equals("EXTERNAL") ||emailType.equals("INTERNAL")  )
			 emailCount=1;
		 else
			 emailCount=0;
			 	
			 
		 dto.setMailId(emailCount);
		 dto.setMailType(emailType);
		 
		 logger.info("FLAG INFO "+dto);
		 
		 return dto;
		 
	}
	
public LnerpDTO  getLnerpnDetails (Long reqid) {
		
		return  itDeptRepository.getLnerpnDetails(reqid);		
		
	} 
	
	public int getAutomailCount(Long reqid) {
		return itDeptRepository.getAutomailcount(reqid);		
		
	}
	
	public int getEmailCount(Long reqid) {
		
		return itDeptRepository.getEmailCount(reqid);
	}
	
	public int getEmailCount2(Long reqid) {
		
		return itDeptRepository.getEmailCount2(reqid);
	}
}
