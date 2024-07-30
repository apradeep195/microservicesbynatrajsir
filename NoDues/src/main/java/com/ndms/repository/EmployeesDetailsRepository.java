package com.ndms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ndms.dto.PendingReqInfo;
import com.ndms.model.NoDuesRequestModel;

@Repository
public interface EmployeesDetailsRepository extends JpaRepository<NoDuesRequestModel, Long> {

	//Query(Pending Department QUery Section Wise )
	@Query(nativeQuery = true, value = "Select  PER.T$EMPNO as EMPNO,PER.T$NAME AS EMPNAME,ND.ID as REQID,ND.RESIGN_DATE,ND.HR_HEAD_APPROVA_STATUS,ND.HOD_APPROVAL_STATUS,ND.REASON,ND.LAST_WORKING_DATE,ND.INITIATE_DATE,DEPT.T$DESC AS DEPT,DESG.T$DESC AS DESG from baan.thrper001804  PER Join NODUES_REQ_DETAILS ND  on PER.t$empno=Nd.EMPNO \r\n"
			+ "JOIN BAAN.THRMAS020804 DEPT on  PER.T$DEPTCD = DEPT.T$CODE JOIN BAAN.THRMAS007804 DESG on DESG.T$CODE=PER.T$DESGCD where ND.ID=:reqid\r\n"
			+ " UNION \r\n"
			+ " Select  PER.T$EMPNO as EMPNO,PER.T$NAME AS EMPNAME,ND.ID as REQID,ND.RESIGN_DATE,ND.HR_HEAD_APPROVA_STATUS,ND.HOD_APPROVAL_STATUS,ND.REASON,ND.LAST_WORKING_DATE,ND.INITIATE_DATE,DEPT.T$DESC AS DEPT,DESG.T$DESC AS DESG from baan.thrper001904  PER Join NODUES_REQ_DETAILS ND  on PER.t$empno=Nd.EMPNO \r\n"
			+ " JOIN BAAN.THRMAS020804 DEPT on  PER.T$DEPTCD = DEPT.T$CODE JOIN BAAN.THRMAS007804 DESG on DESG.T$CODE=PER.T$DESGCD where ND.ID=:reqid")		
	PendingReqInfo getEmployeeDetails(Long reqid);
	
}
