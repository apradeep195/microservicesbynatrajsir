package com.ndms.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

import javax.transaction.Transactional;

import org.apache.catalina.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndms.dto.AuthorizedSection;
import com.ndms.dto.CertificateDetailsDTO;
import com.ndms.dto.CertificateDuesDTO;
import com.ndms.dto.DuesDetailsDTO;
import com.ndms.dto.EmployeeRoleDTO;
import com.ndms.dto.LnerpDTO;
import com.ndms.dto.SectionDuesDTO;
import com.ndms.model.SectionWiseNoduesModel;
import com.ndms.repository.ITDeptRepository;
import com.ndms.repository.SectionWiseNoduesRepository;

@Service
public class SectionWiseNoduesService {

	@Autowired
	private SectionWiseNoduesRepository sectionWiseNoduesRepo;
	
	@Autowired
	private CurrentUserService currentUserService;
	

	
	public  List<SectionDuesDTO> sectionDuesDetails(Integer reqId){
		return sectionWiseNoduesRepo.fetchAllDuesDetails(currentUserService.getCurrentUserId(),reqId); 
	}
	
	
	public  List<SectionDuesDTO> sectionDuesDetailsView(Integer reqId){
		return sectionWiseNoduesRepo.fetchAllDuesDetailsView(currentUserService.getCurrentUserId(),reqId); 
	}
	
	public List<AuthorizedSection> fetchAuthorizedSections(){
		return sectionWiseNoduesRepo.fetchAuthorizedSections(currentUserService.getCurrentUserId()); 
	}
	
	
	
	public void addDuesDetails(DuesDetailsDTO dto) {		
		
		SectionWiseNoduesModel sectionwise=new SectionWiseNoduesModel();
		sectionwise.setRequestID(dto.getReqid());
		sectionwise.setDueDescription(dto.getDetails());
		sectionwise.setDueAmount(dto.getAmount());
		sectionwise.setSectionID(dto.getSectionid());
		sectionwise.setEnteredEmpCode(currentUserService.getCurrentUserId());
		sectionwise.setEnteredDate(new Date());		
		sectionWiseNoduesRepo.save(sectionwise);	 
		
		System.out.println("Record Saved Successfully");
		
	}
	
public void addAndSubmitDuesDetails(DuesDetailsDTO dto) {		
		
		SectionWiseNoduesModel sectionwise=new SectionWiseNoduesModel();
		sectionwise.setRequestID(dto.getReqid());
		sectionwise.setDueDescription(dto.getDetails());
		sectionwise.setDueAmount(dto.getAmount());
		sectionwise.setSectionID(dto.getSectionid());
		sectionwise.setEnteredEmpCode(currentUserService.getCurrentUserId());
		sectionwise.setEnteredDate(new Date());		
		sectionwise.setSubmittedDate(new Date());
		sectionwise.setStatus(1);
		sectionWiseNoduesRepo.save(sectionwise);
		System.out.println("Record Saved Successfully");
		
	}
	public Boolean checkIfAdmin() {
		 List<AuthorizedSection> authSections=fetchAuthorizedSections();
         Boolean flag=false;
         
         for(AuthorizedSection auth : authSections) {
        	 if(auth.getID().equals(3)) {
			      flag=true;
			 }
         }         
         return flag;
	}
	  public  Integer fetchCatcode(Long reqId) {
		  return sectionWiseNoduesRepo.fetchCatcode(reqId);
	  }
	   
	   
	public void checkRequiredEntries(Long reqId) throws Exception {
		List<String> requiredValues=new ArrayList<>();
		requiredValues.add("Bus");
		requiredValues.add("Mobile");
		requiredValues.add("Two/Four Wheeler");			
		
	   Integer cateCode=sectionWiseNoduesRepo.fetchCatcode(reqId);
		if(cateCode.equals(100))
		    requiredValues.add("Executive Mess");
		
		Integer count= sectionWiseNoduesRepo.checkRequiredValues(reqId,requiredValues);
		if(count<requiredValues.size()) {
			StringJoiner joiner=new StringJoiner(",");
			requiredValues.forEach(req->{
				joiner.add(req);
			});
		    	 throw new Exception("Dues Submission failed , Make Sure Required Dues [ "+joiner.toString()+" ] are filled.");
		}
	}
	
	@Transactional
	public void submitAllDues(Long reqId,List<Integer> secIds) throws Exception {
		if(this.checkIfAdmin()) {
			this.checkRequiredEntries(reqId);
			sectionWiseNoduesRepo.submitAllDues(reqId,currentUserService.getCurrentUserId(),new Date(),secIds);
		}else{
			sectionWiseNoduesRepo.submitAllDues(reqId,currentUserService.getCurrentUserId(),new Date(),secIds);
		}	
	}
	
	
	public CertificateDetailsDTO getEmployeeDetailsforCertificate(Long reqId) {
		return sectionWiseNoduesRepo.getEmployeeDetailsForCertificate(reqId);		
		
	}
	
	public List<CertificateDuesDTO> getAllDuesDetails(Long reqid){
		return sectionWiseNoduesRepo.getAllDuesforNoduceCertificate(reqid);				
	}
	
	

}
