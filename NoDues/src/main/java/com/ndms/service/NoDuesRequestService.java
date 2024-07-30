package com.ndms.service;

import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.ndms.dto.DeptEmpLeftInfo;
import com.ndms.dto.DuesDetailsDTO;
import com.ndms.dto.HODPendingReqInfo;
import com.ndms.dto.PendingReqInfo;
import com.ndms.dto.ReginationReqDTO;
import com.ndms.dto.RegisnationInfo;
import com.ndms.model.NoDuesRequestModel;
import com.ndms.repository.NoDuesRequestRepository;

@Service
@Scope("prototype")
public class NoDuesRequestService {

	@Autowired   
    private CurrentUserService currentUserService;
	
	@Autowired
	private NoDuesRequestRepository regRepo;
	
	@Autowired
	private SectionWiseNoduesService sectionNoDuesService;

	public NoDuesRequestModel getRequestById(Long reqId){	
		 return regRepo.findById(reqId).get();
	}
	
	
	//New Code START here 
	
	//All Employee List which Leave HEG Within 3 Month by rowNum
	public List<RegisnationInfo> getAllResignation(){	
		System.out.println(regRepo.getResignationInfo());
		 return regRepo.getResignationInfo();
	}
	
	
	//Inisiated No Dues Request 
	public void addResignationRequest(ReginationReqDTO dto) {		
			NoDuesRequestModel noReqModel=new NoDuesRequestModel();			
			noReqModel.setEmployeeId(dto.getEmpCode());
			noReqModel.setResignationDate(dto.getResignDate());
			noReqModel.setDeptHODStatus(0);
			noReqModel.setHrHODStatus(0);
			noReqModel.setNoduceInsiatedBy((long) currentUserService.getCurrentUserId());
			noReqModel.setNoduceInsiateDate(new Date());
			noReqModel.setExgratia(dto.getExgratia());
			int isExits=regRepo.checkEmployeeCompany(dto.getEmpCode());		
			noReqModel=regRepo.saveAndFlush(noReqModel);
			
	       if(isExits<=0) {
				
				DuesDetailsDTO det=new DuesDetailsDTO();
				det.setAmount(0d);
				det.setDetails("NOT MEMBER");
				det.setSectionid(8l);
				det.setReqid(noReqModel.getID());			
				sectionNoDuesService.addAndSubmitDuesDetails(det);
			}
			System.out.println("Record Saved");
		}
	
	//Count for Intiated Nodues
		
		
			
	public void approveRequest(Long reqId) {		
		NoDuesRequestModel model=regRepo.getById(reqId);	
		model.setDeptHODStatus(1);
		model.setDeptHODDate(new Date());
		model.setDeptHODId(currentUserService.getCurrentUserId());	
		regRepo.save(model);
		System.out.println(model);
		
	} 
	
	

	
	public List<PendingReqInfo> getAlIResignedEmployee(){
		return regRepo.getResignedEmployeeInfo();
	}
	
	
	public List<PendingReqInfo> getPendingRequests() {
		// TODO Auto-generated method stub
		return regRepo.getPendingRequests();
	}

	public List<PendingReqInfo> getApprovedRequest() {
		// TODO Auto-generated method stub
		return regRepo.getApprovedRequests();
	}



	//Count Code started here 


	public Integer getAllResignationCount(){	
		 return regRepo.getResignationCount();
	} 

	public Integer getPendingRequestCount(){
		int pendingCount=regRepo.getPendingRequests().size();
		//return regRepo.getResignedEmployeeCount();
		return pendingCount;
	}

	public Integer getApprovedRequestCount(){
		int approvedCount=regRepo.getApprovedRequests().size();
		//return regRepo.getResignedEmployeeCount();
		return approvedCount;
	}

	
	public Integer getDeptHODReqCount(){
		int deptLeftEmpCount=regRepo.getDeptLeftEmployees(currentUserService.getCurrentUserId()).size();	
		return deptLeftEmpCount;
	}
	
	
	public List<HODPendingReqInfo> getAllPendingReq(){
		return regRepo.hodPendingInfo(currentUserService.getCurrentUserId());
	}

	
	public List<DeptEmpLeftInfo> getDepartmentLeftEmployees(){
		
		return regRepo.getDeptLeftEmployees(currentUserService.getCurrentUserId());
	}
	
	//New Code END here 
	
	
	
	
	
	
	
	
	
	
	
	
	
	









//GET HR Approved Count 
public Integer getHrApprovalPendingcCount(){
	int count=0;
	List<PendingReqInfo> resignedEmployee=this.getAlIResignedEmployee();
	
	for(PendingReqInfo emp : resignedEmployee)
	{			
		if(emp.getREQID()!=null) {
			String pendingDept= this.getAllpendingDepartment(emp.getREQID());
			if(pendingDept==null || pendingDept.equals("") && emp.getHR_HEAD_APPROVA_STATUS().equals(0)) {
                  count++;
			}
		}
  }
	return count;
}





public boolean checkUserIsHOD(Long empCode){
	   int  count =regRepo.checkIfExist(empCode);
	   return count>0?true:false;
}


public String getAllpendingDepartment(Long reqId){
	
	StringJoiner sJoiner=new StringJoiner(" ,  ");
	regRepo.getAllPendingDept(reqId).forEach(dept->{
		if(dept!=null)
		    sJoiner.add(dept.toUpperCase());
	});
	return sJoiner.toString();
	
}


public String getAllSectionspending(Long reqId,Long empCode){
	
	StringJoiner sJoiner=new StringJoiner(" ,  ");
	regRepo.getAllSectionspending(reqId,empCode).forEach(dept->{
		if(dept!=null)
		    sJoiner.add(dept.toUpperCase());
	});
	return sJoiner.toString();
	
}


public String getAllSectionsApproved(Long reqId,Long empCode){
	
	StringJoiner sJoiner=new StringJoiner(" ,  ");
	regRepo.getAllSectionsApproved(reqId,empCode).forEach(dept->{
		if(dept!=null)
		    sJoiner.add(dept.toUpperCase());
	});
	return sJoiner.toString();
	
}


public void approvehrRequest(Long reqId) {
	
	NoDuesRequestModel model=regRepo.getById(reqId);
	
	model.setHrHODStatus(1);
	model.setHrHODDate(new Date());
	model.setHrHODId(currentUserService.getCurrentUserId());	
	regRepo.save(model);
	
}


public void sendSimpleEmail() {
	// TODO Auto-generated method stub
	
}




}
