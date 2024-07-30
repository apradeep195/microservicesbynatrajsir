package com.ndms.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ndms.dto.AuthorizedSection;
import com.ndms.dto.CertificateDetailsDTO;
import com.ndms.dto.CertificateDuesDTO;
import com.ndms.dto.SectionDuesDTO;
import com.ndms.model.SectionWiseNoduesModel;

@Repository
public interface SectionWiseNoduesRepository  extends JpaRepository<SectionWiseNoduesModel, Long> {

	
	@Modifying
	@Query(nativeQuery = true,value="UPDATE NODUES_SECTIONWISE_ND_DETAILS set STATUS=1 , ENTERED_BY=:empCode, SUBMITTED_DATE= :currentDate    where REQ_ID=:reqId  and SEC_ID in(:secIDs)  and  ENTERED_BY = :empCode  or ENTERED_BY in (select emp_code from NODUES_USER_ROLES nur where nur.role like '%NO_SUBMIT')")
	public void submitAllDues(Long reqId,Long empCode,Date currentDate,List<Integer> secIDs) ;
	
	
	@Query("select count(*) from SectionWiseNoduesModel swnm where  swnm.dueDescription In (:reqValues) and swnm.requestID=:reqId")
	public Integer  checkRequiredValues(Long reqId,List<String> reqValues);

	
	@Query(nativeQuery = true,value="select NSND.*,(SELECT T$NAME from baan.thrper001804 WHERE T$EMPNO=:empCode) as ENTRD_BY_NAME from NODUES_SECTIONWISE_ND_DETAILS NSND\r\n"
			+ " where NSND.req_id=:reqId  and NSND.SEC_ID in (select SEC_ID from NODUES_SECTION_AUTHORITIES where EMP_CODE=:empCode) and NSND.status=0  order by   NSND.ENTERED_DATE desc")
	public  List<SectionDuesDTO>  fetchAllDuesDetails(Long empCode,Integer reqId);
	
	//entered dues details info
	@Query(nativeQuery = true,value="select NSND.*,(SELECT T$NAME from baan.thrper001804 WHERE T$EMPNO=:empCode) as ENTRD_BY_NAME from NODUES_SECTIONWISE_ND_DETAILS NSND\r\n"
			+ " where NSND.req_id=:reqId  and NSND.SEC_ID in (select SEC_ID from NODUES_SECTION_AUTHORITIES where EMP_CODE=:empCode) and NSND.status=1  order by   NSND.ENTERED_DATE desc")
	public  List<SectionDuesDTO>  fetchAllDuesDetailsView(Long empCode,Integer reqId);
	
	
	@Query(nativeQuery = true,value="select NSM.ID,NSM.SEC_DESC from NODUES_SECTION_AUTHORITIES  NSA join NODUES_SECTION_MASTER NSM\r\n"
			+ "on NSM.ID =  NSA.SEC_ID where NSA.EMP_CODE=:empCode")
	public List<AuthorizedSection> fetchAuthorizedSections(Long empCode);
	
	
	@Query(nativeQuery = true,value = "select T$CATCD from baan.thrper001804 where t$empno=(select EMPNO from NODUES_REQ_DETAILS where id=:reqid)\r\n"
			+ "union \r\n"
			+ "select T$CATCD from baan.thrper001904 where t$empno=(select EMPNO from NODUES_REQ_DETAILS where id=:reqid)")
	public Integer  fetchCatcode(Long reqid);
	
	
	
	
	
	
	
	//Query for getting a details of employee for certificate 
	@Query(nativeQuery = true,value = "Select  PER.T$EMPNO as EMPNO,PER.T$NAME AS EMPNAME,ND.RESIGN_DATE,(select T$DESC from baan.thrmas016804 where t$code=PER.T$LEAVCD) as reasondesc,ND.EXGRATIA,PER.T$LEAVDT as LAST_WORKING_DATE, ND.INITIATE_DATE,\r\n"
			+ "(select t$name from baan.thrper001804 where t$empno=ND.INITIATED_BY) as Initiatedby,(select t$name from baan.thrper001804 where t$empno=ND.HOD_CODE) as HODNAME, ND.HOD_APPROVAL_DATE as hoddate,\r\n"
			+ "(select t$name from baan.thrper001804 where t$empno=ND.HR_HEAD) as HRHODNAME,ND.HR_HEAD_APPROVA_DATE as hrhoddate,DEPT.T$DESC AS DEPT,DESG.T$DESC AS DESG from baan.thrper001804  PER Join NODUES_REQ_DETAILS ND \r\n"
			+ "on PER.t$empno=Nd.EMPNO  JOIN BAAN.THRMAS020804 DEPT on  PER.T$DEPTCD = DEPT.T$CODE JOIN BAAN.THRMAS007804 DESG on DESG.T$CODE=PER.T$DESGCD where ND.ID=:reqid\r\n"
			+ "UNION \r\n"
			+ "Select  PER.T$EMPNO as EMPNO,PER.T$NAME AS EMPNAME,ND.RESIGN_DATE,(select T$DESC from baan.thrmas016804 where t$code=PER.T$LEAVCD) as reasondesc,ND.EXGRATIA,PER.T$LEAVDT  as LAST_WORKING_DATE, ND.INITIATE_DATE,\r\n"
			+ "(select t$name from baan.thrper001804 where t$empno=ND.INITIATED_BY) as Initiatedby,(select t$name from baan.thrper001804 where t$empno=ND.HOD_CODE) as HODNAME, ND.HOD_APPROVAL_DATE as hoddate,\r\n"
			+ "(select t$name from baan.thrper001804 where t$empno=ND.HR_HEAD) as HRHODNAME,ND.HR_HEAD_APPROVA_DATE as hrhoddate,DEPT.T$DESC AS DEPT,DESG.T$DESC AS DESG from baan.thrper001904  PER Join NODUES_REQ_DETAILS ND \r\n"
			+ "on PER.t$empno=Nd.EMPNO  JOIN BAAN.THRMAS020804 DEPT on  PER.T$DEPTCD = DEPT.T$CODE JOIN BAAN.THRMAS007804 DESG on DESG.T$CODE=PER.T$DESGCD where ND.ID=:reqid")	
	public CertificateDetailsDTO  getEmployeeDetailsForCertificate(Long reqid);
	
	
	
	//Dues Details 
	@Query(nativeQuery = true,value = "select\r\n"
			+ "(select sec_desc from nodues_section_master where id=NSND.SEC_ID) as sectionname,\r\n"
			+ "(select t$name from baan.thrper001804 where t$empno=NSND.ENTERED_BY) as approvername,\r\n"
			+ "NSND.DUE_DETAIL,\r\n"
			+ "NSND.DUE_AMOUNT,\r\n"
			+ "NSND.ENTERED_DATE,\r\n"
			+ "NSND.SUBMITTED_DATE\r\n"
			+ "from NODUES_SECTIONWISE_ND_DETAILS NSND where NSND.REQ_ID=:reqid order by sectionname")
	public List<CertificateDuesDTO> getAllDuesforNoduceCertificate(Long reqid);
}
